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
import com.qcloud.project.macaovehicle.model.CarOwnerEnterprisers;
import com.qcloud.project.macaovehicle.model.CarOwnerHousers;
import com.qcloud.project.macaovehicle.service.CarOwnerHousersService;
import com.qcloud.project.macaovehicle.service.CarOwnerService;
import com.qcloud.project.macaovehicle.web.handler.CarOwnerHousersHandler;
import com.qcloud.project.macaovehicle.web.vo.CarOwnerHousersVO;

@Controller
@RequestMapping(value = CarOwnerHousersController.DIR)
public class CarOwnerHousersController {

    public static final String     DIR = "/carOwnerHousers";

    @Autowired
    private CarOwnerHousersService carOwnerHousersService;

    @Autowired
    private ClerkHelper            clerkHelper;

    @Autowired
    private CarOwnerService        carOwnerService;

    @Autowired
    private CarOwnerHousersHandler carOwnerHousersHandler;

    @RequestMapping
    public AceAjaxView add(HttpServletRequest request, CarOwnerHousers carOwnerHousers) {

        QClerk user = clerkHelper.getClerkModel(request);
        CarOwner carOwner = carOwnerService.getByClerk(user.getId());
        AssertUtil.assertNotNull(carOwner, "用户信息不完整." + user.getId());
        AssertUtil.assertNotNull(carOwnerHousersService.getByCarOwner(carOwner.getId()), "不能重复添加信息");
        carOwnerHousers.setCarOwnerId(carOwner.getId());
        carOwnerHousersService.add(carOwnerHousers);
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
        CarOwnerHousers carOwnerHousers = carOwnerHousersService.getByCarOwner(carOwner.getId());
        CarOwnerHousersVO vo = carOwnerHousersHandler.toVO(carOwnerHousers);
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("添加成功");
        view.addObject("result", vo);
        return view;
    }

    @RequestMapping
    public AceAjaxView edit(HttpServletRequest request, CarOwnerHousers carOwnerHousers) {

        QClerk user = clerkHelper.getClerkModel(request);
        CarOwner carOwner = carOwnerService.getByClerk(user.getId());
        AssertUtil.assertNotNull(carOwner, "用户信息不完整." + user.getId());
        CarOwnerHousers temp = carOwnerHousersService.get(carOwnerHousers.getId());
        AssertUtil.assertNotNull(temp, "企业信息不存在." + carOwnerHousers.getId());
        AssertUtil.assertTrue(temp.getCarOwnerId() == carOwner.getId(), "不能修改不属于自己的信息");
        //
        carOwnerHousers.setCarOwnerId(carOwner.getId());
        carOwnerHousersService.update(carOwnerHousers);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("编辑成功");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }
}
