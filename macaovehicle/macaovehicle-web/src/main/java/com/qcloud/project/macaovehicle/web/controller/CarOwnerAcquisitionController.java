package com.qcloud.project.macaovehicle.web.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qcloud.component.organization.QClerk;
import com.qcloud.component.organization.web.helper.ClerkHelper;
import com.qcloud.pirates.mvc.FrontAjaxView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.project.macaovehicle.model.CarOwner;
import com.qcloud.project.macaovehicle.model.CarOwnerAcquisition;
import com.qcloud.project.macaovehicle.model.CarOwnerEnterprisers;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.UserType;
import com.qcloud.project.macaovehicle.service.CarOwnerAcquisitionService;
import com.qcloud.project.macaovehicle.service.CarOwnerEnterprisersService;
import com.qcloud.project.macaovehicle.service.CarOwnerService;
import com.qcloud.project.macaovehicle.web.handler.CarOwnerAcquisitionHandler;
import com.qcloud.project.macaovehicle.web.handler.CarOwnerEnterprisersHandler;
import com.qcloud.project.macaovehicle.web.vo.CarOwnerAcquisitionVO;
import com.qcloud.project.macaovehicle.web.vo.CarOwnerEnterprisersVO;

@Controller
@RequestMapping(value = CarOwnerAcquisitionController.DIR)
public class CarOwnerAcquisitionController {

    public static final String          DIR = "/carOwnerAcquisition";

    @Autowired
    private CarOwnerAcquisitionService  carOwnerAcquisitionService;

    @Autowired
    private CarOwnerAcquisitionHandler  carOwnerAcquisitionHandler;

    @Autowired
    private ClerkHelper                 clerkHelper;

    @Autowired
    private CarOwnerService             carOwnerService;

    @Autowired
    private CarOwnerEnterprisersService carOwnerEnterprisersService;

    @Autowired
    private CarOwnerEnterprisersHandler carOwnerEnterprisersHandler;

    @RequestMapping
    public FrontAjaxView add(HttpServletRequest request, CarOwnerAcquisition carOwnerAcquisition, CarOwnerEnterprisers carOwnerEnterprisers) {

        QClerk user = clerkHelper.getClerkModel(request);
        CarOwner carOwner = carOwnerService.getByClerk(user.getId());
        AssertUtil.assertNotNull(carOwner, "用户信息不完整." + user.getId());
        //
        FrontAjaxView view = new FrontAjaxView();
        CarOwnerEnterprisers carOwnerEnterprisers2 = carOwnerEnterprisersService.getByCarOwner(carOwner.getId());
        CarOwnerAcquisition carOwnerAcquisition2 = carOwnerAcquisitionService.getByCarOwner(carOwner.getId());
        if (carOwner.getType() != UserType.ACQUISITION.getKey() && carOwner.getClerkType() == 2) {
            if (carOwnerAcquisition2 == null && carOwnerEnterprisers2 == null) {
                carOwnerEnterprisers.setCarOwnerId(carOwner.getId());
                carOwnerEnterprisersService.add(carOwnerEnterprisers);
                carOwnerAcquisition.setCarOwnerId(carOwner.getId());
                carOwnerAcquisitionService.add(carOwnerAcquisition);
                view.setMessage("添加成功");
            } else if (carOwnerAcquisition2 != null || carOwnerEnterprisers2 != null) {
                view.setMessage("该数据已经添加");
            }
        } else if (carOwner.getType() == UserType.ACQUISITION.getKey() && carOwner.getClerkType() == 1) {
            carOwnerAcquisition.setCarOwnerId(carOwner.getId());
            carOwnerAcquisitionService.add(carOwnerAcquisition);
            view.setMessage("添加成功");
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
        CarOwnerAcquisition carOwnerAcquisition = carOwnerAcquisitionService.getByCarOwner(carOwner.getId());
        AssertUtil.assertNotNull(carOwnerAcquisition, "企业用户不存在." + carOwner.getId());
        CarOwnerAcquisitionVO carOwnerAcquisitionVO = carOwnerAcquisitionHandler.toVO(carOwnerAcquisition);
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("查询成功");
        view.addObject("result", vo);
        view.addObject("result2", carOwnerAcquisitionVO);
        return view;
    }

    @RequestMapping
    public FrontAjaxView edit(HttpServletRequest request, CarOwnerEnterprisers carOwnerEnterprisers, CarOwnerAcquisition carOwnerAcquisition) {

        QClerk user = clerkHelper.getClerkModel(request);
        CarOwner carOwner = carOwnerService.getByClerk(user.getId());
        AssertUtil.assertNotNull(carOwner, "用户信息不完整." + user.getId());
        //
        carOwnerEnterprisers.setCarOwnerId(carOwner.getId());
        carOwnerEnterprisersService.update(carOwnerEnterprisers);
        carOwnerAcquisition.setCarOwnerId(carOwner.getId());
        carOwnerAcquisitionService.update(carOwnerAcquisition);
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("编辑成功");
        return view;
    }
}
