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
import com.qcloud.project.macaovehicle.model.CarOwnerPurchase;
import com.qcloud.project.macaovehicle.service.CarOwnerPurchaseService;
import com.qcloud.project.macaovehicle.service.CarOwnerService;
import com.qcloud.project.macaovehicle.web.handler.CarOwnerPurchaseHandler;
import com.qcloud.project.macaovehicle.web.vo.CarOwnerPurchaseVO;

@Controller
@RequestMapping(value = CarOwnerPurchaseController.DIR)
public class CarOwnerPurchaseController {

    public static final String      DIR = "/carOwnerPurchase";

    @Autowired
    private CarOwnerPurchaseService carOwnerPurchaseService;

    @Autowired
    private ClerkHelper             clerkHelper;

    @Autowired
    private CarOwnerService         carOwnerService;

    @Autowired
    private CarOwnerPurchaseHandler carOwnerPurchaseHandler;

    @RequestMapping
    public AceAjaxView add(HttpServletRequest request, CarOwnerPurchase carOwnerPurchase) {

        QClerk user = clerkHelper.getClerkModel(request);
        CarOwner carOwner = carOwnerService.getByClerk(user.getId());
        AssertUtil.assertNotNull(carOwner, "用户信息不完整." + user.getId());
        AssertUtil.assertNotNull(carOwnerPurchaseService.getByCarOwner(carOwner.getId()), "不能重复添加信息");
        //
        carOwnerPurchase.setCarOwnerId(carOwner.getId());
        carOwnerPurchaseService.add(carOwnerPurchase);
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
        CarOwnerPurchase carOwnerPurchase = carOwnerPurchaseService.getByCarOwner(carOwner.getId());
        CarOwnerPurchaseVO vo = carOwnerPurchaseHandler.toVO(carOwnerPurchase);
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("添加成功");
        view.addObject("result", vo);
        return view;
    }

    @RequestMapping
    public AceAjaxView edit(HttpServletRequest request, CarOwnerPurchase carOwnerPurchase) {

        QClerk user = clerkHelper.getClerkModel(request);
        CarOwner carOwner = carOwnerService.getByClerk(user.getId());
        AssertUtil.assertNotNull(carOwner, "用户信息不完整." + user.getId());
        CarOwnerPurchase temp = carOwnerPurchaseService.get(carOwnerPurchase.getId());
        AssertUtil.assertNotNull(temp, "企业信息不存在." + carOwnerPurchase.getId());
        AssertUtil.assertTrue(temp.getCarOwnerId() == carOwner.getId(), "不能修改不属于自己的信息");
        //
        carOwnerPurchase.setCarOwnerId(carOwner.getId());
        carOwnerPurchaseService.update(carOwnerPurchase);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("编辑成功");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }
}
