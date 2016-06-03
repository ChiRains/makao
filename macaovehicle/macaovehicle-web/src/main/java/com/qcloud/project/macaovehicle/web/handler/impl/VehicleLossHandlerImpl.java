package com.qcloud.project.macaovehicle.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.DateUtil;
import com.qcloud.project.macaovehicle.service.VehicleService;
import com.qcloud.project.macaovehicle.web.handler.VehicleLossHandler;
import com.qcloud.project.macaovehicle.common.Constant;
import com.qcloud.project.macaovehicle.model.Vehicle;
import com.qcloud.project.macaovehicle.model.VehicleLoss;
import com.qcloud.project.macaovehicle.web.vo.VehicleLossVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminVehicleLossVO;

@Component
public class VehicleLossHandlerImpl implements VehicleLossHandler {

    @Autowired
    private VehicleService vehicleService;

    @Override
    public List<VehicleLossVO> toVOList(List<VehicleLoss> list) {

        List<VehicleLossVO> voList = new ArrayList<VehicleLossVO>();
        for (VehicleLoss vehicleLoss : list) {
            voList.add(toVO(vehicleLoss));
        }
        return voList;
    }

    @Override
    public VehicleLossVO toVO(VehicleLoss vehicleLoss) {

        String json = Json.toJson(vehicleLoss);
        VehicleLossVO vo = Json.toObject(json, VehicleLossVO.class, true);
        Vehicle vehicle = vehicleService.get(vehicleLoss.getVehicleId());
        AssertUtil.assertNotNull(vehicle, "车辆不存在." + vehicleLoss.getVehicleId());
        vo.setPlateNumber(vehicle.getPlateNumber());
        vo.setTemporaryplate(vehicle.getTemporaryplate());
        vo.setEndDateStr(DateUtil.date2String(DateUtil.addDate(vehicle.getApproveTime(), Constant.VEHICLE_VALID_TIME)));
        vo.setLossTimeStr(DateUtil.date2String(vehicleLoss.getLossTime()));
        return vo;
    }

    @Override
    public List<AdminVehicleLossVO> toVOList4Admin(List<VehicleLoss> list) {

        List<AdminVehicleLossVO> voList = new ArrayList<AdminVehicleLossVO>();
        for (VehicleLoss adminVehicleLoss : list) {
            voList.add(toVO4Admin(adminVehicleLoss));
        }
        return voList;
    }

    @Override
    public AdminVehicleLossVO toVO4Admin(VehicleLoss vehicleLoss) {

        String json = Json.toJson(vehicleLoss);
        return Json.toObject(json, AdminVehicleLossVO.class, true);
    }
}
