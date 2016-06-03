package com.qcloud.project.macaovehicle.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.filesdk.FileSDKClient;
import com.qcloud.pirates.core.json.Json;
import com.qcloud.project.macaovehicle.web.handler.CarOwnerWorkersHandler;
import com.qcloud.project.macaovehicle.model.CarOwnerWorkers;
import com.qcloud.project.macaovehicle.web.vo.CarOwnerWorkersVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminCarOwnerWorkersVO;

@Component
public class CarOwnerWorkersHandlerImpl implements CarOwnerWorkersHandler {

    @Autowired
    private FileSDKClient fileSDKClient;

    @Override
    public List<CarOwnerWorkersVO> toVOList(List<CarOwnerWorkers> list) {

        List<CarOwnerWorkersVO> voList = new ArrayList<CarOwnerWorkersVO>();
        for (CarOwnerWorkers carOwnerWorkers : list) {
            voList.add(toVO(carOwnerWorkers));
        }
        return voList;
    }

    @Override
    public CarOwnerWorkersVO toVO(CarOwnerWorkers carOwnerWorkers) {

        String json = Json.toJson(carOwnerWorkers);
        CarOwnerWorkersVO vo = Json.toObject(json, CarOwnerWorkersVO.class, true);
        vo.setWorkCertificateUid(fileSDKClient.urlToUid(vo.getWorkCertificate()));
        vo.setContractUrlUid(fileSDKClient.urlToUid(vo.getContractUrl()));
        vo.setInsuranceFeeUrlUid(fileSDKClient.urlToUid(vo.getInsuranceFeeUrl()));
        if (StringUtils.isNotEmpty(vo.getWorkCertificate())) {
            vo.setWorkCertificate(vo.getWorkCertificate());
        }
        return vo;
    }

    @Override
    public List<AdminCarOwnerWorkersVO> toVOList4Admin(List<CarOwnerWorkers> list) {

        List<AdminCarOwnerWorkersVO> voList = new ArrayList<AdminCarOwnerWorkersVO>();
        for (CarOwnerWorkers adminCarOwnerWorkers : list) {
            voList.add(toVO4Admin(adminCarOwnerWorkers));
        }
        return voList;
    }

    @Override
    public AdminCarOwnerWorkersVO toVO4Admin(CarOwnerWorkers carOwnerWorkers) {

        String json = Json.toJson(carOwnerWorkers);
        return Json.toObject(json, AdminCarOwnerWorkersVO.class, true);
    }
}
