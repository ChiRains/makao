package com.qcloud.project.macaovehicle.web.handler.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.template.core.util.string.StringUtils;
import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.DateUtil;
import com.qcloud.project.macaovehicle.common.Constant;
import com.qcloud.project.macaovehicle.model.Driver;
import com.qcloud.project.macaovehicle.model.DriverVehicle;
import com.qcloud.project.macaovehicle.model.Vehicle;
import com.qcloud.project.macaovehicle.service.DriverService;
import com.qcloud.project.macaovehicle.service.DriverVehicleService;
import com.qcloud.project.macaovehicle.service.VehicleService;
import com.qcloud.project.macaovehicle.web.handler.DriverVehicleHandler;
import com.qcloud.project.macaovehicle.web.vo.DriverVehicleVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminDriverVehicleVO;

@Component
public class DriverVehicleHandlerImpl implements DriverVehicleHandler {

    @Autowired
    private VehicleService       vehicleService;

    @Autowired
    private DriverService        driverService;

    @Autowired
    private DriverVehicleService driverVehicleService;

    @Override
    public List<DriverVehicleVO> toVehicleVOList(List<DriverVehicle> list) {

        List<DriverVehicleVO> voList = new ArrayList<DriverVehicleVO>();
        for (DriverVehicle driverVehicle : list) {
            voList.add(toVehicleVO(driverVehicle));
        }
        return voList;
    }

    @Override
    public DriverVehicleVO toVehicleVO(DriverVehicle driverVehicle) {

        String json = Json.toJson(driverVehicle);
        DriverVehicleVO vo = Json.toObject(json, DriverVehicleVO.class, true);
        String formInstCode = vo.getFormInstCode();
        List<DriverVehicle> driverVehicleList = driverVehicleService.getListByFormInstCode(formInstCode);
        String vehicleInfo = "";
        String driverInfo = "";
        String ownName = "";
        String validDateStr = null;
        int dayCount = 0;
        for (DriverVehicle dv : driverVehicleList) {
            Vehicle vehicle = vehicleService.get(dv.getVehicleId());
            Driver driver = driverService.get(dv.getDriverId());
            AssertUtil.assertNotNull(vehicle, "车辆不存在." + vehicle.getId());
            AssertUtil.assertNotNull(driver, "司机不存在." + driver.getId());
            vehicleInfo = vehicle.getPlateNumber() + "," + vehicle.getColor() + "," + vehicle.getBrand() + "," + vehicle.getSpecification();
            driverInfo = driver.getDriverName() + ",";
            if (StringUtils.isEmpty(ownName)) {
                ownName = vehicle.getOwnerName();
            }
            // 180天时效
            if (validDateStr == null) {
                Date validDate = DateUtils.addDays(vehicle.getApproveTime(), Constant.VEHICLE_VALID_TIME);
                validDateStr = DateUtil.date2String(validDate, "yyyy-MM-dd");
                dayCount = DateUtil.getDayCount(validDate, new Date());
            }
        }
        if (driverInfo.length() > 0) {
            driverInfo = driverInfo.substring(0, driverInfo.length() - 1);
        }
        Map<String, Object> returnMap = new HashMap<String, Object>();
        returnMap.put("vehicleInfo", vehicleInfo);
        returnMap.put("ownName", ownName);
        returnMap.put("validDateStr", validDateStr);
        returnMap.put("dayCount", dayCount);
        returnMap.put("driverInfo", driverInfo);
        returnMap.put("type", vo.getType());
        returnMap.put("vehicleId", vo.getVehicleId());
        vo.setReturnMap(returnMap);
        return vo;
    }

    @Override
    public List<AdminDriverVehicleVO> toVOList4Admin(List<DriverVehicle> list) {

        List<AdminDriverVehicleVO> voList = new ArrayList<AdminDriverVehicleVO>();
        for (DriverVehicle adminDriverVehicle : list) {
            voList.add(toVO4Admin(adminDriverVehicle));
        }
        return voList;
    }

    @Override
    public AdminDriverVehicleVO toVO4Admin(DriverVehicle driverVehicle) {

        String json = Json.toJson(driverVehicle);
        return Json.toObject(json, AdminDriverVehicleVO.class, true);
    }

    @Override
    public List<DriverVehicleVO> toDriverVOList(List<DriverVehicle> list) {

        List<DriverVehicleVO> voList = new ArrayList<DriverVehicleVO>();
        for (DriverVehicle driverVehicle : list) {
            voList.add(toDriverVO(driverVehicle));
        }
        return voList;
    }

    public DriverVehicleVO toDriverVO(DriverVehicle driverVehicle) {

        String json = Json.toJson(driverVehicle);
        DriverVehicleVO vo = Json.toObject(json, DriverVehicleVO.class, true);
        Driver driver = driverService.get(driverVehicle.getDriverId());
        Map<String, Object> returnMap = new HashMap<String, Object>();
        returnMap.put("driverName", driver.getDriverName());
        returnMap.put("sex", driver.getSex());
        returnMap.put("licenseNumber", driver.getLicenseNumber());
        returnMap.put("driverPhone", driver.getDriverPhone());
        vo.setReturnMap(returnMap);
        return vo;
    }
}
