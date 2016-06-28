package com.qcloud.project.macaovehicle.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.filesdk.FileSDKClient;
import com.qcloud.pirates.core.json.Json;
import com.qcloud.project.macaovehicle.service.CarOwnerService;
import com.qcloud.project.macaovehicle.service.ProfilesSuccessService;
import com.qcloud.project.macaovehicle.web.handler.VehicleHandler;
import com.qcloud.project.macaovehicle.model.CarOwner;
import com.qcloud.project.macaovehicle.model.Vehicle;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.VehicleState;
import com.qcloud.project.macaovehicle.web.vo.VehicleListVO;
import com.qcloud.project.macaovehicle.web.vo.VehicleVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminVehicleVO;

@Component
public class VehicleHandlerImpl implements VehicleHandler {

    @Autowired
    private FileSDKClient   fileSDKClient;

    @Autowired
    private CarOwnerService carOwnerService;

    @Override
    public List<VehicleListVO> listToVOList(List<Vehicle> list) {

        List<VehicleListVO> voList = new ArrayList<VehicleListVO>();
        for (Vehicle vehicle : list) {
            String json = Json.toJson(vehicle);
            VehicleListVO vo = Json.toObject(json, VehicleListVO.class, true);
            CarOwner carOwner = carOwnerService.get(vehicle.getCarOwnerId());
            vo.setIdcardNumber(carOwner.getIdcardNumber());
            voList.add(vo);
        }
        return voList;
    }

    @Override
    public List<VehicleVO> toVOList(List<Vehicle> list) {

        List<VehicleVO> voList = new ArrayList<VehicleVO>();
        for (Vehicle vehicle : list) {
            voList.add(toVO(vehicle));
        }
        return voList;
    }

    @Override
    public VehicleVO toVO(Vehicle vehicle) {

        String json = Json.toJson(vehicle);
        VehicleVO vo = Json.toObject(json, VehicleVO.class, true);
        vo.setLicenseImageUid(fileSDKClient.urlToUid(vo.getLicenseImage()));
        vo.setFaceImageUid(fileSDKClient.urlToUid(vo.getFaceImage()));
        vo.setLeftbackImageUid(fileSDKClient.urlToUid(vo.getLeftbackImage()));
        vo.setLeftfaceImageUid(fileSDKClient.urlToUid(vo.getLeftfaceImage()));
        vo.setRightbackImageUid(fileSDKClient.urlToUid(vo.getRightbackImage()));
        vo.setRightfaceImageUid(fileSDKClient.urlToUid(vo.getRightfaceImage()));
        vo.setInsuranceUrlUid(fileSDKClient.urlToUid(vo.getInsuranceUrl()));
        //
        if (StringUtils.isNotEmpty(vo.getLeftbackImage())) {
            vo.setLicenseImage(vo.getLeftbackImage());
        }
        //
        if (StringUtils.isNotEmpty(vo.getFaceImage())) {
            vo.setFaceImage(vo.getFaceImage());
        }
        //
        if (StringUtils.isNotEmpty(vo.getLeftbackImage())) {
            vo.setLeftbackImage(vo.getLeftbackImage());
        }
        //
        if (StringUtils.isNotEmpty(vo.getLeftfaceImage())) {
            vo.setLeftfaceImage(vo.getLeftfaceImage());
        }
        //
        if (StringUtils.isNotEmpty(vo.getRightbackImage())) {
            vo.setRightbackImage(vo.getRightbackImage());
        }
        //
        if (StringUtils.isNotEmpty(vo.getRightfaceImage())) {
            vo.setRightfaceImage(vo.getRightfaceImage());
        }
        //
        if (StringUtils.isNotEmpty(vo.getInsuranceUrl())) {
            vo.setInsuranceUrl(vo.getInsuranceUrl());
        }
        for (VehicleState vehicleState : VehicleState.values()) {
            if (vehicleState.getKey() == vehicle.getState()) {
                vo.setStateStr(vehicleState.getName());
            }
        }
        return vo;
    }

    @Override
    public List<AdminVehicleVO> toVOList4Admin(List<Vehicle> list) {

        List<AdminVehicleVO> voList = new ArrayList<AdminVehicleVO>();
        for (Vehicle adminVehicle : list) {
            voList.add(toVO4Admin(adminVehicle));
        }
        return voList;
    }

    @Override
    public AdminVehicleVO toVO4Admin(Vehicle vehicle) {

        String json = Json.toJson(vehicle);
        return Json.toObject(json, AdminVehicleVO.class, true);
    }
}
