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
import com.qcloud.project.macaovehicle.model.CarOwnerWorkers;
import com.qcloud.project.macaovehicle.service.CarOwnerService;
import com.qcloud.project.macaovehicle.service.CarOwnerWorkersService;
import com.qcloud.project.macaovehicle.web.handler.CarOwnerWorkersHandler;
import com.qcloud.project.macaovehicle.web.vo.CarOwnerWorkersVO;

@Controller
@RequestMapping(value = CarOwnerWorkersController.DIR)
public class CarOwnerWorkersController {

    public static final String     DIR = "/carOwnerWorkers";

    @Autowired
    private CarOwnerWorkersService carOwnerWorkersService;

    @Autowired
    private ClerkHelper            clerkHelper;

    @Autowired
    private CarOwnerService        carOwnerService;

    @Autowired
    private CarOwnerWorkersHandler carOwnerWorkersHandler;
    
    @RequestMapping
    public AceAjaxView add(HttpServletRequest request, CarOwnerWorkers carOwnerWorkers) {

        QClerk user = clerkHelper.getClerkModel(request);
        CarOwner carOwner = carOwnerService.getByClerk(user.getId());
        AssertUtil.assertNotNull(carOwner, "用户信息不完整." + user.getId());
        AssertUtil.assertNotNull(carOwnerWorkersService.getByCarOwner(carOwner.getId()), "不能重复添加信息");
        //
        carOwnerWorkers.setCarOwnerId(carOwner.getId());
        carOwnerWorkersService.add(carOwnerWorkers);
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
        CarOwnerWorkers carOwnerWorkers = carOwnerWorkersService.getByCarOwner(carOwner.getId());
        CarOwnerWorkersVO vo = carOwnerWorkersHandler.toVO(carOwnerWorkers);
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("添加成功");
        view.addObject("result", vo);
        return view;
    }

    @RequestMapping
    public AceAjaxView edit(HttpServletRequest request, CarOwnerWorkers carOwnerWorkers) {

        QClerk user = clerkHelper.getClerkModel(request);
        CarOwner carOwner = carOwnerService.getByClerk(user.getId());
        AssertUtil.assertNotNull(carOwner, "用户信息不完整." + user.getId());
        CarOwnerWorkers temp = carOwnerWorkersService.get(carOwnerWorkers.getId());
        AssertUtil.assertNotNull(temp, "企业信息不存在." + carOwnerWorkers.getId());
        AssertUtil.assertTrue(temp.getCarOwnerId() == carOwner.getId(), "不能修改不属于自己的信息");
        //
        carOwnerWorkers.setCarOwnerId(carOwner.getId());
        carOwnerWorkersService.update(carOwnerWorkers);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("编辑成功");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }
}
