package com.qcloud.component.organization.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.qcloud.component.admin.exception.AdminException;
import com.qcloud.component.filesdk.FileSDKClient;
import com.qcloud.component.filesdk.QFile;
import com.qcloud.component.filesdk.exception.FileClientException;
import com.qcloud.component.organization.exception.OrganizationException;
import com.qcloud.component.organization.model.Clerk;
import com.qcloud.component.organization.model.DepartmentClerk;
import com.qcloud.component.organization.service.ClerkService;
import com.qcloud.component.organization.service.DepartmentClerkService;
import com.qcloud.component.organization.service.DepartmentService;
import com.qcloud.component.organization.web.handler.ClerkHandler;
import com.qcloud.component.organization.web.helper.ClerkHelper;
import com.qcloud.component.organization.web.vo.ClerkVO;
import com.qcloud.component.parameter.ParameterClient;
import com.qcloud.component.publicdata.KeyValueVO;
import com.qcloud.component.publicservice.LoginLogClient;
import com.qcloud.component.publicservice.QLoginLog;
import com.qcloud.component.publicservice.SmsClient;
import com.qcloud.component.publicservice.SmsMessageLimitClient;
import com.qcloud.component.publicservice.SmsMessageLimitClient.SmsMessageStateType;
import com.qcloud.component.publicservice.VerificationCodeClient;
import com.qcloud.component.publicservice.model.key.TypeEnum.LoginLogConsumerType;
import com.qcloud.component.publicservice.model.key.TypeEnum.LoginLogOperateType;
import com.qcloud.component.token.TokenClient;
import com.qcloud.pirates.mvc.FrontAjaxView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.web.filter.admin.AdminFilterService;
import com.qcloud.pirates.web.filter.user.UserFilterService;

@Controller
@RequestMapping(value = ClerkController.DIR)
public class ClerkController {

    public static final String     DIR                          = "/clerk";

    @Autowired
    private ClerkService           clerkService;

    @Autowired
    private ClerkHelper            clerkHelper;

    @Autowired
    private ClerkHandler           clerkHandler;

    @Autowired
    private AdminFilterService     adminFilterService;

    @Autowired
    private UserFilterService      userFilterService;

    @Autowired
    private TokenClient            tokenClient;

    @Autowired
    private SmsMessageLimitClient  smsMessageLimitClient;

    @Autowired
    private ParameterClient        parameterClient;

    @Autowired
    private VerificationCodeClient verificationCodeClient;

    @Autowired
    private SmsClient              smsClient;

    @Autowired
    private FileSDKClient          fileSDKClient;

    @Autowired
    private DepartmentClerkService departmentClerkService;

    @Autowired
    private DepartmentService      departmentService;

    private static final Logger    log                          = LoggerFactory.getLogger(ClerkController.class);

    public static final String     USER_REGIST_SMS_TEMPLATE_KEY = "personalcenter-user-sms-template";

    @Autowired
    public LoginLogClient          loginLogClient;

    /**
     * 帐号登录
     * @param request
     * @param username
     * @param pwd
     * @return
     */
    @RequestMapping
    public FrontAjaxView login(HttpServletRequest request, String username, String pwd) {

        doLogin(request, username, pwd, adminFilterService, null);
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("登录成功");
        Clerk clerk = clerkService.getByAccount(username);
        DepartmentClerk departmentClerk = departmentClerkService.getBelongsDepartment(clerk.getId());
        view.addObject("department", departmentClerk != null ? departmentService.get(departmentClerk.getDepartmentId()) : null);
        view.addObject("clerk", clerk);
        loginLogClient.loginInLog(clerk.getId(), LoginLogConsumerType.Clerk.getKey(), "");
        return view;
    }

    public String doLogin(HttpServletRequest request, String username, String pwd, AdminFilterService adminFilterService, UserFilterService userFilterService) {

        AssertUtil.assertNotEmpty(username, "账号不能为空.");
        AssertUtil.assertNotEmpty(pwd, "密码不能为空.");
        String[] accounts = null;
        String identificationKey = null;
        if (clerkService.isClerk(username, pwd)) {
            Clerk clerk = clerkService.getByAccount(username);
            identificationKey = String.valueOf(clerk.getId());
            accounts = new String[] { clerkService.getClerkPermissionAccountCode(username)};
        } else {
            throw new OrganizationException("账号或密码有误.");
        }
        String tokenId = null;
        if (adminFilterService != null) {
            tokenId = adminFilterService.doLogin(request, accounts);
        } else if (userFilterService != null) {
            tokenId = userFilterService.doLogin(request);
        } else {
            throw new OrganizationException("系统内部错误.");
        }
        boolean ok = tokenClient.reg(tokenId, identificationKey);
        if (!ok) {
            throw new AdminException("系统服务出现异常,token添加失败.");
        }
        log.info("职工登录成功." + username);
        return tokenId;
    }

    @RequestMapping
    public FrontAjaxView clerkKeyValue() {// clerk的id为key，name为value

        List<Clerk> clerkList = clerkService.listAll();
        List<KeyValueVO> list = new ArrayList<KeyValueVO>();
        for (Clerk clerk : clerkList) {
            if (!list.contains(clerk.getName()) && clerk.getEnable() == 1) {
                KeyValueVO vo = new KeyValueVO();
                vo.setKey(String.valueOf(clerk.getId()));
                vo.setValue(clerk.getName());
                list.add(vo);
            }
        }
        FrontAjaxView view = new FrontAjaxView();
        view.addObject("clerkKeyValue", list);
        return view;
    }

    // 为了注册,发送短信, 一个号码,一分钟只能发送一条,一个号码一天最多只能连续发10条(参数控制)
    /**
     * 发送短信，收到验证码
     * @param mobile
     * @return
     */
    // @RequestMapping(method = RequestMethod.POST)
    @RequestMapping
    public FrontAjaxView sendMsgForCode(String mobile) {

        AssertUtil.assertNotNull(mobile, "电话不能为空!");
        SmsMessageStateType type = smsMessageLimitClient.canSend(mobile, USER_REGIST_SMS_TEMPLATE_KEY);
        if (SmsMessageStateType.NUMBER_LIMIT.equals(type)) {
            throw new OrganizationException("短信发送失败,已经超出今天发送最大数量.");
        }
        if (SmsMessageStateType.TIME_LIMIT.equals(type)) {
            throw new OrganizationException("短信发送失败,发送太频繁,请稍等.");
        }
        String content = parameterClient.get(USER_REGIST_SMS_TEMPLATE_KEY);
        String code = verificationCodeClient.create(mobile, 30);
        content = content.replaceAll("\\{code\\}", code);
        // TODO 30
        content = content.replaceAll("\\{minute\\}", "30");
        boolean[] result = smsClient.send(content, mobile);
        if (result[0]) {
            smsMessageLimitClient.send(mobile, USER_REGIST_SMS_TEMPLATE_KEY, 1);
            FrontAjaxView view = new FrontAjaxView();
            view.setMessage("发送短信成功");
            return view;
        } else {
            throw new OrganizationException("发送短信失败." + mobile);
        }
    }

    /**
     * 验证码是否正确
     * @param request
     * @param mobile
     * @param code
     * @return
     */
    @RequestMapping
    public FrontAjaxView validateCode(String mobile, String code) {

        Clerk clerk = clerkService.getByAccount(mobile);
        if (clerk == null) {
            throw new OrganizationException("该手机号不存在!");
        }
        // 验证码是否有效
        boolean verification = verificationCodeClient.verification(mobile, code);
        AssertUtil.assertTrue(verification, "验证码不正确,请重新获取.");
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("验证码有效!");
        return view;
    }

    /**
     * 忘记密码，根据短信修改密码
     * @param request
     * @param mobile
     * @param code
     * @param pwd
     * @return
     */
    @RequestMapping
    public FrontAjaxView updatePwd(String mobile, String code, String pwd) {

        if (StringUtils.isEmpty(mobile) || StringUtils.isEmpty(pwd)) {
            throw new OrganizationException("帐号或密码不能为空!");
        }
        Clerk clerk = clerkService.getByAccount(mobile);
        if (clerk == null) {
            throw new OrganizationException("该手机号不存在!");
        }
        // 验证码是否有效
        boolean verification = verificationCodeClient.verification(mobile, code);
        AssertUtil.assertTrue(verification, "验证码不正确,请重新获取.");
        verificationCodeClient.remove(mobile, code);
        boolean result = clerkService.changePwd(clerk.getId(), pwd);
        AssertUtil.assertTrue(result, "密码修改失败.");
        // 返回一个单次有效的code,六十分钟 ,如果添加成功,并且用户是激活的,则客户端模拟一次登录
        String perTimesCode = verificationCodeClient.create(mobile, 60);
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("密码修改成功!");
        view.addObject("code", perTimesCode);
        return view;
    }

    /**
     * 查看个人信息
     * @param request
     * @return
     */
    @RequestMapping
    public FrontAjaxView getClerk(HttpServletRequest request) {

        Clerk clerk = clerkHelper.getClerk(request);
        ClerkVO clerkVO = clerkHandler.toVO(clerk);
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("个人信息获取成功.");
        view.addObject("clerk", clerkVO);
        return view;
    }

    public FrontAjaxView getClerk(String token) {

        Clerk clerk = clerkHelper.getClerk(token);
        ClerkVO clerkVO = clerkHandler.toVO(clerk);
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("个人信息获取成功.");
        view.addObject("clerk", clerkVO);
        return view;
    }

    /**
     * 重置更新密码
     * @param request
     * @param pwd  原始密码
     * @param pwd1 新密码
     * @param pwd2 确认密码
     * @return
     */
    @RequestMapping
    public FrontAjaxView resetPwd(HttpServletRequest request, String pwd, String pwd1, String pwd2) {

        Clerk clerk = clerkHelper.getClerk(request);
        if (!pwd1.equals(pwd2)) {
            throw new OrganizationException("确认密码不一致，请重新输入!");
        }
        AssertUtil.assertNotNull(clerkService.isClerk(clerk.getId(), pwd), "原密码不正确.");
        boolean result = clerkService.changePwd(clerk.getId(), pwd1);
        AssertUtil.assertTrue(result, "密码修改失败.");
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("密码修改成功!");
        return view;
    }

    /**
     * 更新头像
     * @param request
     * @param clerk
     * @return
     */
    @RequestMapping
    public FrontAjaxView updateClerk(MultipartHttpServletRequest request, Clerk clerk) {

        Clerk c = clerkHelper.getClerk(request);
        String url = null;
        try {
            Iterator<String> names = request.getFileNames();
            while (names.hasNext()) {
                String name = names.next();
                List<MultipartFile> multipartFiles = request.getFiles(name);
                for (MultipartFile multipartFile : multipartFiles) {
                    QFile file = new QFile();
                    file.setName(multipartFile.getOriginalFilename());
                    file.setContent(multipartFile.getBytes());
                    url = fileSDKClient.saveToUrl(file);
                    break;
                }
            }
        } catch (IOException e) {
            throw new FileClientException("上传文件出错.", e);
        }
        c.setHeadImage(url);
        boolean result = clerkService.update(c);
        AssertUtil.assertTrue(result, "操作成功.");
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("操作成功!");
        return view;
    }

    @RequestMapping
    public FrontAjaxView logout(HttpServletRequest request) {

        adminFilterService.doLogout(request);
        userFilterService.doLogout(request);
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("已经退出系统.");
        return view;
    }

    @RequestMapping
    public FrontAjaxView updateClerkInfo(HttpServletRequest request, Clerk clerk) {

        Clerk c = clerkHelper.getClerk(request);
        clerkService.updateClerkInfo(c, clerk);
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("个人设置成功.");
        return view;
    }

    @RequestMapping
    public FrontAjaxView listLoginLog(HttpServletRequest request) {

        Clerk clerk = clerkHelper.getClerk(request);
        List<QLoginLog> logList = loginLogClient.list(clerk.getId(), LoginLogConsumerType.Clerk.getKey(), LoginLogOperateType.LOGIN_IN);
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("获取登录日志.");
        view.addObject("result", logList);
        return view;
    }
}
