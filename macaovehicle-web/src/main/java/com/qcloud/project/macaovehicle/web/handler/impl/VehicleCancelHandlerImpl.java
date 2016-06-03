package com.qcloud.project.macaovehicle.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.util.DateUtil;
import com.qcloud.project.macaovehicle.web.handler.VehicleCancelHandler;
import com.qcloud.project.macaovehicle.model.VehicleCancel;
import com.qcloud.project.macaovehicle.web.vo.VehicleCancelVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminVehicleCancelVO;

@Component
public class VehicleCancelHandlerImpl implements VehicleCancelHandler {

    @Override
    public List<VehicleCancelVO> toVOList(List<VehicleCancel> list) {

        List<VehicleCancelVO> voList = new ArrayList<VehicleCancelVO>();
        for (VehicleCancel vehicleCancel : list) {
            voList.add(toVO(vehicleCancel));
        }
        return voList;
    }

    @Override
    public VehicleCancelVO toVO(VehicleCancel vehicleCancel) {

        String json = Json.toJson(vehicleCancel);
        VehicleCancelVO vo = Json.toObject(json, VehicleCancelVO.class, true);
        vo.setRecordTime(DateUtil.date2String(vehicleCancel.getRecordTime()));
        return vo;
    }

    @Override
    public List<AdminVehicleCancelVO> toVOList4Admin(List<VehicleCancel> list) {

        List<AdminVehicleCancelVO> voList = new ArrayList<AdminVehicleCancelVO>();
        for (VehicleCancel adminVehicleCancel : list) {
            voList.add(toVO4Admin(adminVehicleCancel));
        }
        return voList;
    }

    @Override
    public AdminVehicleCancelVO toVO4Admin(VehicleCancel vehicleCancel) {

        String json = Json.toJson(vehicleCancel);
        return Json.toObject(json, AdminVehicleCancelVO.class, true);
    }
}
