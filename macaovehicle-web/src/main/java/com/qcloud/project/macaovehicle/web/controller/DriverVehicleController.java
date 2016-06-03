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
import com.qcloud.project.macaovehicle.service.CarOwnerService;
import com.qcloud.project.macaovehicle.service.DriverVehicleService;
import com.qcloud.project.macaovehicle.web.helper.CarOwnerHelper;

@Controller
@RequestMapping(value = DriverVehicleController.DIR)
public class DriverVehicleController {

    public static final String   DIR = "/driverVehicle";

    @Autowired
    private DriverVehicleService driverVehicleService;

    @Autowired
    private ClerkHelper          clerkHelper;

    @Autowired
    private CarOwnerService      carOwnerService;
}
