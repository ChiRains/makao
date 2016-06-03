package com.qcloud.project.macaovehicle.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.filesdk.FileSDKClient;
import com.qcloud.pirates.core.json.Json;
import com.qcloud.project.macaovehicle.web.handler.CarOwnerTalentHandler;
import com.qcloud.project.macaovehicle.model.CarOwnerTalent;
import com.qcloud.project.macaovehicle.web.vo.CarOwnerTalentVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminCarOwnerTalentVO;

@Component
public class CarOwnerTalentHandlerImpl implements CarOwnerTalentHandler {

    @Autowired
    private FileSDKClient fileSDKClient;

    @Override
    public List<CarOwnerTalentVO> toVOList(List<CarOwnerTalent> list) {

        List<CarOwnerTalentVO> voList = new ArrayList<CarOwnerTalentVO>();
        for (CarOwnerTalent carOwnerTalent : list) {
            voList.add(toVO(carOwnerTalent));
        }
        return voList;
    }

    @Override
    public CarOwnerTalentVO toVO(CarOwnerTalent carOwnerTalent) {

        String json = Json.toJson(carOwnerTalent);
        CarOwnerTalentVO vo = Json.toObject(json, CarOwnerTalentVO.class, true);
        vo.setWorkCertificateUid(fileSDKClient.urlToUid(vo.getWorkCertificate()));
        vo.setContractUrlUid(fileSDKClient.urlToUid(vo.getContractUrl()));
        vo.setInsuranceFeeUrlUid(fileSDKClient.urlToUid(vo.getInsuranceFeeUrl()));
        vo.setDeptCertificateUrlUid(fileSDKClient.urlToUid(vo.getDeptCertificateUrl()));
        return vo;
    }

    @Override
    public List<AdminCarOwnerTalentVO> toVOList4Admin(List<CarOwnerTalent> list) {

        List<AdminCarOwnerTalentVO> voList = new ArrayList<AdminCarOwnerTalentVO>();
        for (CarOwnerTalent adminCarOwnerTalent : list) {
            voList.add(toVO4Admin(adminCarOwnerTalent));
        }
        return voList;
    }

    @Override
    public AdminCarOwnerTalentVO toVO4Admin(CarOwnerTalent carOwnerTalent) {

        String json = Json.toJson(carOwnerTalent);
        return Json.toObject(json, AdminCarOwnerTalentVO.class, true);
    }
}
