package com.qcloud.project.macaovehicle.web.controller;

import java.util.Date;
import java.util.HashMap;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qcloud.component.autoid.UniqueCodeGenerator;
import com.qcloud.pirates.mvc.FrontAjaxView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.DateUtil;
import com.qcloud.project.macaovehicle.model.ApprovalResults;
import com.qcloud.project.macaovehicle.model.CarOwner;
import com.qcloud.project.macaovehicle.model.CarOwnerEnterprisers;
import com.qcloud.project.macaovehicle.model.CarOwnerIndicators;
import com.qcloud.project.macaovehicle.model.Vehicle;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.OwnerType;
import com.qcloud.project.macaovehicle.service.CarOwnerEnterprisersService;
import com.qcloud.project.macaovehicle.service.CarOwnerIndicatorsService;
import com.qcloud.project.macaovehicle.service.CarOwnerService;
import com.qcloud.project.macaovehicle.service.VehicleService;
import com.qcloud.project.macaovehicle.web.handler.CarOwnerIndicatorsHandler;

@Controller
@RequestMapping(value = CarOwnerIndicatorsController.DIR)
public class CarOwnerIndicatorsController {

    public static final String          DIR = "/carOwnerIndicators";

    @Autowired
    private CarOwnerIndicatorsService   carOwnerIndicatorsService;

    @Autowired
    private CarOwnerIndicatorsHandler   carOwnerIndicatorsHandler;

    @Autowired
    private CarOwnerService             carOwnerService;

    @Autowired
    private UniqueCodeGenerator         uniqueCodeGenerator;

    @Autowired
    private CarOwnerEnterprisersService carOwnerEnterprisersService;

    @Autowired
    private VehicleService              vehicleService;

    @RequestMapping
    public FrontAjaxView add(CarOwnerIndicators carOwnerIndicators) {

        // 还未进行角色权限限制, 管委会窗口可以生成指标号
        long vehicleId = carOwnerIndicators.getVehicleId();
        AssertUtil.greatZero(vehicleId, "vehicleId不能为空!");
        Vehicle vehicle = vehicleService.get(vehicleId);
        AssertUtil.assertNotNull(vehicle, "车辆不存在." + vehicleId);
        CarOwnerIndicators indicators = carOwnerIndicatorsService.getByVehicleId(vehicleId);
        if (indicators == null) {
            indicators = new CarOwnerIndicators();
            indicators.setVehicleId(vehicleId);
            indicators.setIndicatorsNo(uniqueCodeGenerator.generate("pirates-form-indicators-code", new HashMap<String, String>()));
            indicators.setUserName(vehicle.getOwnerName());
            indicators.setValidityPeriod(DateUtils.addMonths(new Date(), 3));
            carOwnerIndicatorsService.add(indicators);
        } else {
            // 更新后面加限制,不能随意修改更新~~
            indicators.setVehicleId(vehicleId);
            indicators.setIndicatorsNo(uniqueCodeGenerator.generate("pirates-form-indicators-code", new HashMap<String, String>()));
            indicators.setUserName(vehicle.getOwnerName());
            indicators.setValidityPeriod(DateUtils.addMonths(new Date(), 3));
            carOwnerIndicatorsService.update(indicators);
        }
        FrontAjaxView view = new FrontAjaxView();
        view.addObject("indicators", carOwnerIndicatorsHandler.toVO(indicators));
        view.setMessage("获取指标号成功!");
        return view;
    }

    @RequestMapping
    public FrontAjaxView get(CarOwnerIndicators carOwnerIndicators) {

        // 还未进行角色权限限制, 管委会窗口可以生成指标号
        long vehicleId = carOwnerIndicators.getVehicleId();
        AssertUtil.greatZero(vehicleId, "vehicleId不能为空!");
        Vehicle vehicle = vehicleService.get(carOwnerIndicators.getVehicleId());
        AssertUtil.assertNotNull(vehicle, "车辆不存在." + carOwnerIndicators.getVehicleId());
        CarOwnerIndicators indicators = carOwnerIndicatorsService.getByVehicleId(carOwnerIndicators.getVehicleId());
        FrontAjaxView view = new FrontAjaxView();
        view.addObject("indicators", carOwnerIndicatorsHandler.toVO(indicators));
        view.setMessage("获取指标号成功!");
        return view;
    }
}
