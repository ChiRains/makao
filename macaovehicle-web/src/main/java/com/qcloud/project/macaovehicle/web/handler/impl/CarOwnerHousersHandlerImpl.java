package com.qcloud.project.macaovehicle.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.filesdk.FileSDKClient;
import com.qcloud.pirates.core.json.Json;
import com.qcloud.project.macaovehicle.web.handler.CarOwnerHousersHandler;
import com.qcloud.project.macaovehicle.model.CarOwnerHousers;
import com.qcloud.project.macaovehicle.web.vo.CarOwnerHousersVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminCarOwnerHousersVO;

@Component
public class CarOwnerHousersHandlerImpl implements CarOwnerHousersHandler {

    @Autowired
    private FileSDKClient fileSDKClient;

    @Override
    public List<CarOwnerHousersVO> toVOList(List<CarOwnerHousers> list) {

        List<CarOwnerHousersVO> voList = new ArrayList<CarOwnerHousersVO>();
        for (CarOwnerHousers carOwnerHousers : list) {
            voList.add(toVO(carOwnerHousers));
        }
        return voList;
    }

    @Override
    public CarOwnerHousersVO toVO(CarOwnerHousers carOwnerHousers) {

        String json = Json.toJson(carOwnerHousers);
        CarOwnerHousersVO vo = Json.toObject(json, CarOwnerHousersVO.class, true);
        vo.setLicenseUrlUid(fileSDKClient.urlToUid(carOwnerHousers.getLicenseUrl()));
        return vo;
    }

    @Override
    public List<AdminCarOwnerHousersVO> toVOList4Admin(List<CarOwnerHousers> list) {

        List<AdminCarOwnerHousersVO> voList = new ArrayList<AdminCarOwnerHousersVO>();
        for (CarOwnerHousers adminCarOwnerHousers : list) {
            voList.add(toVO4Admin(adminCarOwnerHousers));
        }
        return voList;
    }

    @Override
    public AdminCarOwnerHousersVO toVO4Admin(CarOwnerHousers carOwnerHousers) {

        String json = Json.toJson(carOwnerHousers);
        return Json.toObject(json, AdminCarOwnerHousersVO.class, true);
    }
}
