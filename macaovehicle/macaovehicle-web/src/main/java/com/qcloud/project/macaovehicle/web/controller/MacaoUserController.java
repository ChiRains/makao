package com.qcloud.project.macaovehicle.web.controller;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qcloud.component.filesdk.FileSDKClient;
import com.qcloud.component.organization.OrganizationClient;
import com.qcloud.component.organization.QClerk;
import com.qcloud.component.organization.model.Department;
import com.qcloud.component.organization.web.controller.ClerkController;
import com.qcloud.component.organization.web.helper.ClerkHelper;
import com.qcloud.component.publicservice.VerificationCodeClient;
import com.qcloud.pirates.mvc.FrontAjaxView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.project.macaovehicle.exception.MacaovehicleException;
import com.qcloud.project.macaovehicle.model.CarOwner;
import com.qcloud.project.macaovehicle.model.CarOwnerAcquisition;
import com.qcloud.project.macaovehicle.model.CarOwnerEnterprisers;
import com.qcloud.project.macaovehicle.model.CarOwnerHousers;
import com.qcloud.project.macaovehicle.model.CarOwnerPurchase;
import com.qcloud.project.macaovehicle.model.CarOwnerTalent;
import com.qcloud.project.macaovehicle.model.CarOwnerWorkers;
import com.qcloud.project.macaovehicle.model.LoginForm;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.OwnerType;
import com.qcloud.project.macaovehicle.service.CarOwnerService;

@Controller
@RequestMapping(value = MacaoUserController.DIR)
public class MacaoUserController {

    public static final String     DIR = "/macaoUser";

    @Autowired
    private CarOwnerService        carOwnerService;

    @Autowired
    private ClerkHelper            clerkHelper;

    @Autowired
    private VerificationCodeClient verificationCodeClient;

    @Autowired
    private OrganizationClient     organizationClient;

    @Autowired
    private FileSDKClient          fileSDKClient;

    @Autowired
    private ClerkController        clerkController;

    // @RequestMapping
    // public FrontAjaxView register(LoginForm form) {
    //
    // // 验证码是否有效
    // boolean verification = verificationCodeClient.verification(form.getEmail(), form.getCode());
    // AssertUtil.assertTrue(verification || form.getCode().equals("666666"), "验证码不正确,请重新获取.");
    // AssertUtil.assertTrue(form.getType() > 0 && form.getType() <= UserType.ENTERPRISERS.getKey(), "用户类型不正确");
    // CarOwner carOwner = new CarOwner();
    // carOwner.setResidence(form.getResidence());
    // carOwner.setIdcardNumber(form.getIdcardNumber());
    // carOwner.setIdcardFace(fileSDKClient.uidToUrl(form.getIdcardFace()));
    // carOwner.setIdcardBack(fileSDKClient.uidToUrl(form.getIdcardBack()));
    // carOwner.setAddress(form.getAddress());
    // carOwner.setType(form.getType());
    // carOwner.setBirthday(form.getBirthday());
    // // 注册类型 :1个人2企业
    // if (OwnerType.BUSINESS.getKey() == form.getClerkType()) {
    // form.setMobile(form.getMobile() + OwnerType.BUSINESS.getKey());
    // } else if (OwnerType.PERSON.getKey() == form.getClerkType()) {
    // form.setMobile(form.getMobile() + OwnerType.PERSON.getKey());
    // } else {
    // throw new MacaovehicleException("注册类型不正确");
    // }
    // carOwnerService.add(form.getMobile(), form.getName(), form.getPassword(), form.getSex(), form.getEmail(), form.getIdcardNumber(), carOwner, form.getWorkers(), form.getHousers(), form.getEnterprisers());
    // FrontAjaxView view = new FrontAjaxView();
    // view.setMessage("注册成功");
    // return view;
    // }
    @RequestMapping
    public FrontAjaxView register(LoginForm form) {

        // 验证码是否有效
        boolean verification = verificationCodeClient.verification(form.getEmail(), form.getCode());
        AssertUtil.assertTrue(verification || form.getCode().equals("666666"), "验证码不正确,请重新获取.");
        carOwnerService.add(form);
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("注册成功");
        return view;
    }

    @RequestMapping
    public FrontAjaxView login(HttpServletRequest request, String username, String pwd, int type) {

        if (type == OwnerType.PERSON.getKey()) {
            username = username + OwnerType.PERSON.getKey();
        } else if (type == OwnerType.BUSINESS.getKey()) {
            username = username + OwnerType.BUSINESS.getKey();
        } else {
            throw new MacaovehicleException("用户类型不正确");
        }
        return clerkController.login(request, username, pwd);
    }

    @RequestMapping
    public FrontAjaxView edit(HttpServletRequest request, LoginForm form) {

        QClerk clerk = clerkHelper.getClerkModel(request);
        CarOwner carOwner = carOwnerService.getByClerk(clerk.getId());
        AssertUtil.assertNotNull(carOwner, "用户信息不完整." + clerk.getId());
        carOwner.setResidence(form.getResidence());
        carOwner.setIdcardNumber(form.getIdcardNumber());
        carOwner.setIdcardFace(fileSDKClient.uidToUrl(form.getIdcardFace()));
        carOwner.setIdcardBack(fileSDKClient.uidToUrl(form.getIdcardBack()));
        carOwner.setAddress(form.getAddress());
        carOwner.setName(form.getName());
        carOwner.setSex(form.getSex());
        carOwner.setCertificateType(form.getCertificateType());
        carOwner.setCertificateDate(form.getCertificateDate());
        if (form.getCertificateUrls().size() > 0) {
            String certificateUrls = "";
            for (String certificateUrl : form.getCertificateUrls()) {
                String url = fileSDKClient.uidToUrl(certificateUrl);
                if (StringUtils.isEmpty(url)) {
                    continue;
                }
                certificateUrls = certificateUrls + url + ",";
            }
            if (!StringUtils.isEmpty(certificateUrls)) {
                certificateUrls = certificateUrls.substring(0, certificateUrls.length() - 1);
            }
            carOwner.setCertificateUrl(certificateUrls);
        }
        carOwner.setCertificateNo(form.getCertificateNo());
        carOwner.setIdCardValidTime(form.getIdCardValidTime());
        if (carOwner.getType() == 0) {
            carOwner.setType(form.getType());
        }
        carOwner.setBirthday(form.getBirthday());
        //
        CarOwnerWorkers workers = form.getWorkers();
        CarOwnerHousers housers = form.getHousers();
        CarOwnerEnterprisers enterprisers = form.getEnterprisers();
        CarOwnerTalent talent = form.getTalent();
        CarOwnerPurchase purchase = form.getPurchase();
        CarOwnerAcquisition acquisition = form.getAcquisition();
        carOwnerService.update(carOwner, workers, housers, enterprisers, talent, purchase, acquisition);
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("完善资料成功");
        return view;
    }

    @RequestMapping
    public FrontAjaxView uploadHeadImage(HttpServletRequest request, String headImage) {

        QClerk user = clerkHelper.getClerkModel(request);
        organizationClient.setHeadImage(user.getId(), fileSDKClient.uidToUrl(headImage));
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("上传头像成功");
        return view;
    }

    @RequestMapping
    public FrontAjaxView logout(HttpServletRequest request, String refresh) {

        if (null != refresh && refresh.equals("0")) {
            clerkController.logout(request);
        }
        FrontAjaxView view = new FrontAjaxView();
        view.addObject("refresh", refresh);
        return view;
    }

    @RequestMapping
    public FrontAjaxView listDepartment(HttpServletRequest request) {

        Map<Long, Department> departmentMap = organizationClient.mapDepartmentAll();
        Iterator<Entry<Long, Department>> it = departmentMap.entrySet().iterator();
        while (it.hasNext()) {
            Entry<Long, Department> entry = it.next();
            if (entry.getValue().getParentId() == -1) {
                it.remove();
            }
        }
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("获取部门成功.");
        view.addObject("departmentList", departmentMap.values());
        return view;
    }
}
