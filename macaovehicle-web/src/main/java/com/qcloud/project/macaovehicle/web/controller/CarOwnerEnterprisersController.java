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
import com.qcloud.project.macaovehicle.service.CarOwnerEnterprisersService;
import com.qcloud.project.macaovehicle.service.CarOwnerService;
import com.qcloud.project.macaovehicle.web.handler.CarOwnerEnterprisersHandler;
import com.qcloud.project.macaovehicle.web.vo.CarOwnerEnterprisersVO;

@Controller
@RequestMapping(value = CarOwnerEnterprisersController.DIR)
public class CarOwnerEnterprisersController {

    public static final String          DIR = "/carOwnerEnterprisers";

    @Autowired
    private CarOwnerEnterprisersService carOwnerEnterprisersService;

    @Autowired
    private CarOwnerEnterprisersHandler carOwnerEnterprisersHandler;

    @Autowired
    private ClerkHelper                 clerkHelper;

    @Autowired
    private CarOwnerService             carOwnerService;

    @RequestMapping
    public FrontAjaxView add(HttpServletRequest request, CarOwnerEnterprisers carOwnerEnterprisers) {

        QClerk user = clerkHelper.getClerkModel(request);
        CarOwner carOwner = carOwnerService.getByClerk(user.getId());
        AssertUtil.assertNotNull(carOwner, "用户信息不完整." + user.getId());
        //
        FrontAjaxView view = new FrontAjaxView();
        CarOwnerEnterprisers carOwnerEnterprisers2=carOwnerEnterprisersService.getByCarOwner(carOwner.getId());
        if(carOwnerEnterprisers2==null)
        {
        carOwnerEnterprisers.setCarOwnerId(carOwner.getId());
        carOwnerEnterprisersService.add(carOwnerEnterprisers);
        view.setMessage("添加成功");
        }
        else if(carOwnerEnterprisers2!=null)
        {
        	view.setMessage("该数据已经添加");
        }
        return view;
    }

    @RequestMapping
    public FrontAjaxView get(HttpServletRequest request) {

        QClerk user = clerkHelper.getClerkModel(request);
        CarOwner carOwner = carOwnerService.getByClerk(user.getId());
        AssertUtil.assertNotNull(carOwner, "用户信息不完整." + user.getId());
        CarOwnerEnterprisers enterprisers = carOwnerEnterprisersService.getByCarOwner(carOwner.getId());
        CarOwnerEnterprisersVO vo = carOwnerEnterprisersHandler.toVO(enterprisers);
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("查询成功");
        view.addObject("result", vo);
        return view;
    }

    @RequestMapping
    public FrontAjaxView edit(HttpServletRequest request, CarOwnerEnterprisers carOwnerEnterprisers) {

        QClerk user = clerkHelper.getClerkModel(request);
        CarOwner carOwner = carOwnerService.getByClerk(user.getId());
        AssertUtil.assertNotNull(carOwner, "用户信息不完整." + user.getId());
        CarOwnerEnterprisers temp = carOwnerEnterprisersService.get(carOwnerEnterprisers.getId());
        AssertUtil.assertNotNull(temp, "企业信息不存在." + carOwnerEnterprisers.getId());
        AssertUtil.assertTrue(temp.getCarOwnerId() == carOwner.getId(), "不能修改不属于自己的信息");
        //
        carOwnerEnterprisers.setCarOwnerId(carOwner.getId());
        carOwnerEnterprisersService.update(carOwnerEnterprisers);
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("编辑成功");
        return view;
    }
}
