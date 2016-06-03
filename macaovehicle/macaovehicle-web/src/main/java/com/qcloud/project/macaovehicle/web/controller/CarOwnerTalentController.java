package com.qcloud.project.macaovehicle.web.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qcloud.component.organization.QClerk;
import com.qcloud.component.organization.web.helper.ClerkHelper;
import com.qcloud.pirates.mvc.AceAjaxView;
import com.qcloud.pirates.mvc.FrontAjaxView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.project.macaovehicle.model.CarOwner;
import com.qcloud.project.macaovehicle.model.CarOwnerTalent;
import com.qcloud.project.macaovehicle.service.CarOwnerService;
import com.qcloud.project.macaovehicle.service.CarOwnerTalentService;
import com.qcloud.project.macaovehicle.web.handler.CarOwnerTalentHandler;
import com.qcloud.project.macaovehicle.web.vo.CarOwnerTalentVO;

@Controller
@RequestMapping(value = CarOwnerTalentController.DIR)
public class CarOwnerTalentController {

    public static final String    DIR = "/carOwnerTalent";

    @Autowired
    private CarOwnerTalentService carOwnerTalentService;

    @Autowired
    private ClerkHelper           clerkHelper;

    @Autowired
    private CarOwnerService       carOwnerService;

    @Autowired
    private CarOwnerTalentHandler carOwnerTalentHandler;

    @RequestMapping
    public AceAjaxView add(HttpServletRequest request, CarOwnerTalent carOwnerTalent) {

        QClerk user = clerkHelper.getClerkModel(request);
        CarOwner carOwner = carOwnerService.getByClerk(user.getId());
        AssertUtil.assertNotNull(carOwner, "用户信息不完整." + user.getId());
        AssertUtil.assertNotNull(carOwnerTalentService.getByCarOwner(carOwner.getId()), "不能重复添加信息");
        //
        carOwnerTalent.setCarOwnerId(carOwner.getId());
        carOwnerTalentService.add(carOwnerTalent);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("添加成功");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }

    @RequestMapping
    public FrontAjaxView get(HttpServletRequest request) {

        QClerk user = clerkHelper.getClerkModel(request);
        CarOwner carOwner = carOwnerService.getByClerk(user.getId());
        AssertUtil.assertNotNull(carOwner, "用户信息不完整." + user.getId());
        CarOwnerTalent carOwnerTalent = carOwnerTalentService.getByCarOwner(carOwner.getId());
        CarOwnerTalentVO vo = carOwnerTalentHandler.toVO(carOwnerTalent);
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("添加成功");
        view.addObject("result", vo);
        return view;
    }

    @RequestMapping
    public AceAjaxView edit(HttpServletRequest request, CarOwnerTalent carOwnerTalent) {

        QClerk user = clerkHelper.getClerkModel(request);
        CarOwner carOwner = carOwnerService.getByClerk(user.getId());
        AssertUtil.assertNotNull(carOwner, "用户信息不完整." + user.getId());
        CarOwnerTalent temp = carOwnerTalentService.get(carOwnerTalent.getId());
        AssertUtil.assertNotNull(temp, "企业信息不存在." + carOwnerTalent.getId());
        AssertUtil.assertTrue(temp.getCarOwnerId() == carOwner.getId(), "不能修改不属于自己的信息");
        //
        carOwnerTalent.setCarOwnerId(carOwner.getId());
        carOwnerTalentService.update(carOwnerTalent);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("编辑成功");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }
}
