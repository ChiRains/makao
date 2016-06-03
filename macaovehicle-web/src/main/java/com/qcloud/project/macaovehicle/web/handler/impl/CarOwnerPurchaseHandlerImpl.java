package com.qcloud.project.macaovehicle.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.filesdk.FileSDKClient;
import com.qcloud.pirates.core.json.Json;
import com.qcloud.project.macaovehicle.web.handler.CarOwnerPurchaseHandler;
import com.qcloud.project.macaovehicle.model.CarOwnerPurchase;
import com.qcloud.project.macaovehicle.web.vo.CarOwnerPurchaseVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminCarOwnerPurchaseVO;

@Component
public class CarOwnerPurchaseHandlerImpl implements CarOwnerPurchaseHandler {

    @Autowired
    private FileSDKClient fileSDKClient;

    @Override
    public List<CarOwnerPurchaseVO> toVOList(List<CarOwnerPurchase> list) {

        List<CarOwnerPurchaseVO> voList = new ArrayList<CarOwnerPurchaseVO>();
        for (CarOwnerPurchase carOwnerPurchase : list) {
            voList.add(toVO(carOwnerPurchase));
        }
        return voList;
    }

    @Override
    public CarOwnerPurchaseVO toVO(CarOwnerPurchase carOwnerPurchase) {

        String json = Json.toJson(carOwnerPurchase);
        CarOwnerPurchaseVO vo = Json.toObject(json, CarOwnerPurchaseVO.class, true);
        vo.setLicenseUid(fileSDKClient.urlToUid(vo.getLicense()));
        if (StringUtils.isNotEmpty(vo.getLicense())) {
            vo.setLicense(vo.getLicense());
        }
        
        //
        return vo;
    }

    @Override
    public List<AdminCarOwnerPurchaseVO> toVOList4Admin(List<CarOwnerPurchase> list) {

        List<AdminCarOwnerPurchaseVO> voList = new ArrayList<AdminCarOwnerPurchaseVO>();
        for (CarOwnerPurchase adminCarOwnerPurchase : list) {
            voList.add(toVO4Admin(adminCarOwnerPurchase));
        }
        return voList;
    }

    @Override
    public AdminCarOwnerPurchaseVO toVO4Admin(CarOwnerPurchase carOwnerPurchase) {

        String json = Json.toJson(carOwnerPurchase);
        return Json.toObject(json, AdminCarOwnerPurchaseVO.class, true);
    }
}
