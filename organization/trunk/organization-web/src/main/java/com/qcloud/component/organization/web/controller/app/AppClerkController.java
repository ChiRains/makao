package com.qcloud.component.organization.web.controller.app;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.qcloud.component.filesdk.FileSDKClient;
import com.qcloud.component.organization.model.Clerk;
import com.qcloud.component.organization.model.ClerkPost;
import com.qcloud.component.organization.model.Post;
import com.qcloud.component.organization.service.ClerkPostService;
import com.qcloud.component.organization.service.PostService;
import com.qcloud.component.organization.web.controller.ClerkController;
import com.qcloud.component.organization.web.helper.ClerkHelper;
import com.qcloud.pirates.mvc.FrontAjaxView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.web.filter.user.UserFilterService;

@Controller
@RequestMapping(value = AppClerkController.DIR)
public class AppClerkController {

    public static final String DIR = "/app/clerk";

    @Autowired
    private ClerkController    clerkController;

    @Autowired
    private ClerkPostService   clerkPostService;

    @Autowired
    private PostService        postService;

    @Autowired
    private ClerkHelper        clerkHelper;

    @Autowired
    private UserFilterService  userFilterService;

    @Autowired
    private FileSDKClient      fileSDKClient;

    /**
     * 帐号登录
     * @param request
     * @param username
     * @param pwd
     * @return
     */
    @RequestMapping
    public FrontAjaxView login(HttpServletRequest request, String username, String pwd) {

        String token = clerkController.doLogin(request, username, pwd, null, userFilterService);
        FrontAjaxView fontAjaxView = new FrontAjaxView();
        fontAjaxView.setMessage("登录成功");
        fontAjaxView.addObject("token", token);
        Clerk clerk = clerkHelper.getClerk(request);
        List<ClerkPost> cpList = clerkPostService.listByClerk(clerk.getId());
        if (cpList != null && cpList.size() > 0) {
            ClerkPost cp = cpList.get(0);
            Post post = postService.get(cp.getPostId());
            AssertUtil.assertNotNull(post, "岗位不存在." + cp.getPostId());
            fontAjaxView.addObject("postId", post.getId());
            fontAjaxView.addObject("postName", post.getName());
            fontAjaxView.addObject("name", clerk.getName());
            fontAjaxView.addObject("headImage", StringUtils.isNotEmpty(clerk.getHeadImage()) ? fileSDKClient.getFileServerUrl() + clerk.getHeadImage() : "");
        } else {
            fontAjaxView.addObject("postId", String.valueOf(-1));
            fontAjaxView.addObject("postName", String.valueOf(-1));
            fontAjaxView.addObject("name", String.valueOf(-1));
            fontAjaxView.addObject("headImage", "");
        }
        return fontAjaxView;
    }

    @RequestMapping
    public FrontAjaxView logout(HttpServletRequest request) {

        return clerkController.logout(request);
    }

    // 为了注册,发送短信, 一个号码,一分钟只能发送一条,一个号码一天最多只能连续发10条(参数控制)
    /**
     * 发送短信，收到验证码
     * @param mobile
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public FrontAjaxView sendMsgForCode(String mobile) {

        return clerkController.sendMsgForCode(mobile);
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

        return clerkController.validateCode(mobile, code);
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

        return clerkController.updatePwd(mobile, code, pwd);
    }

    /**
     * 查看个人信息
     * @param request
     * @return
     */
    @RequestMapping
    public FrontAjaxView getClerk(HttpServletRequest request) {

        return clerkController.getClerk(request);
    }

    /**
     * 重置更新密码
     * @param request
     * @param pwd1
     * @param pwd2
     * @return
     */
    @RequestMapping
    public FrontAjaxView resetPwd(HttpServletRequest request, String pwd, String pwd1, String pwd2) {

        return clerkController.resetPwd(request, pwd, pwd1, pwd2);
    }

    /**
     * 更新头像
     * @param request
     * @param clerk
     * @return
     */
    @RequestMapping
    public FrontAjaxView updateClerk(MultipartHttpServletRequest request, Clerk clerk) {

        return clerkController.updateClerk(request, clerk);
    }

    /**
     * 修改信息
     * @param request
     * @param clerk
     * @return
     */
    @RequestMapping
    public FrontAjaxView updateClerkInfo(HttpServletRequest request, Clerk clerk) {

        return clerkController.updateClerkInfo(request, clerk);
    }
}
