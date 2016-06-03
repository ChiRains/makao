package com.qcloud.project.macaovehicle.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.pirates.core.json.Json;
import com.qcloud.project.macaovehicle.service.VehicleService;
import com.qcloud.project.macaovehicle.web.handler.OnestopCarRecordHandler;
import com.qcloud.project.macaovehicle.model.OnestopCarRecord;
import com.qcloud.project.macaovehicle.model.Vehicle;
import com.qcloud.project.macaovehicle.web.vo.OnestopCarRecordVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminOnestopCarRecordVO;

@Component
public class OnestopCarRecordHandlerImpl implements OnestopCarRecordHandler {

    @Autowired
    private VehicleService vehicleService;

    @Override
    public List<OnestopCarRecordVO> toVOList(List<OnestopCarRecord> list) {

        List<OnestopCarRecordVO> voList = new ArrayList<OnestopCarRecordVO>();
        for (OnestopCarRecord onestopCarRecord : list) {
            voList.add(toVO(onestopCarRecord));
        }
        return voList;
    }

    @Override
    public OnestopCarRecordVO toVO(OnestopCarRecord onestopCarRecord) {

        String json = Json.toJson(onestopCarRecord);
        OnestopCarRecordVO vo = Json.toObject(json, OnestopCarRecordVO.class, true);
        Vehicle vehicle = vehicleService.getByRic(onestopCarRecord.getVCardid());
        vo.setPlateNumber(vehicle != null ? vehicle.getPlateNumber() : "-");
        vo.setSpecification(vehicle != null ? vehicle.getModels() : "-");
        vo.setTemporaryplate(vehicle != null ? vehicle.getTemporaryplate() : "-");
        return vo;
    }

    @Override
    public List<AdminOnestopCarRecordVO> toVOList4Admin(List<OnestopCarRecord> list) {

        List<AdminOnestopCarRecordVO> voList = new ArrayList<AdminOnestopCarRecordVO>();
        for (OnestopCarRecord adminOnestopCarRecord : list) {
            voList.add(toVO4Admin(adminOnestopCarRecord));
        }
        return voList;
    }

    @Override
    public AdminOnestopCarRecordVO toVO4Admin(OnestopCarRecord onestopCarRecord) {

        String json = Json.toJson(onestopCarRecord);
        return Json.toObject(json, AdminOnestopCarRecordVO.class, true);
    }
}
