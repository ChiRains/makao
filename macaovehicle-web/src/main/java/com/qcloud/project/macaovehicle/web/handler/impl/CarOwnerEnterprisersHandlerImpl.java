package com.qcloud.project.macaovehicle.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.filesdk.FileSDKClient;
import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.util.DateUtil;
import com.qcloud.project.macaovehicle.web.handler.CarOwnerEnterprisersHandler;
import com.qcloud.project.macaovehicle.model.CarOwnerEnterprisers;
import com.qcloud.project.macaovehicle.web.vo.CarOwnerEnterprisersVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminCarOwnerEnterprisersVO;

@Component
public class CarOwnerEnterprisersHandlerImpl implements CarOwnerEnterprisersHandler {

    @Autowired
    private FileSDKClient fileSDKClient;

    @Override
    public List<CarOwnerEnterprisersVO> toVOList(List<CarOwnerEnterprisers> list) {

        List<CarOwnerEnterprisersVO> voList = new ArrayList<CarOwnerEnterprisersVO>();
        for (CarOwnerEnterprisers carOwnerEnterprisers : list) {
            voList.add(toVO(carOwnerEnterprisers));
        }
        return voList;
    }

    @Override
    public CarOwnerEnterprisersVO toVO(CarOwnerEnterprisers carOwnerEnterprisers) {

        String json = Json.toJson(carOwnerEnterprisers);
        CarOwnerEnterprisersVO vo = Json.toObject(json, CarOwnerEnterprisersVO.class, true);
        if (StringUtils.isNotEmpty(vo.getLicense())) {
        	vo.setLicenseUid(fileSDKClient.urlToUid(vo.getLicense()));
        }
        if (StringUtils.isNotEmpty(vo.getOppositeUrl())) {
        vo.setOppositeUrlUid(fileSDKClient.urlToUid(vo.getOppositeUrl()));
        }
        if (StringUtils.isNotEmpty(vo.getPositiveUrl())) {

        vo.setPositiveUrlUid(fileSDKClient.urlToUid(vo.getPositiveUrl()));
        }
        if (StringUtils.isNotEmpty(vo.getPaymentUrl())) {

        vo.setPaymentUrlUid(fileSDKClient.urlToUid(vo.getPaymentUrl()));
        }
        if (StringUtils.isNotEmpty(vo.getCommitmentUrl())) {

        vo.setCommitmentUrlUid(fileSDKClient.urlToUid(vo.getCommitmentUrl()));
        }
        vo.setOperatingPeriodFormat(DateUtil.date2String(vo.getOperatingPeriod(), "yyyy-MM-dd"));
        return vo;
    }

    @Override
    public List<AdminCarOwnerEnterprisersVO> toVOList4Admin(List<CarOwnerEnterprisers> list) {

        List<AdminCarOwnerEnterprisersVO> voList = new ArrayList<AdminCarOwnerEnterprisersVO>();
        for (CarOwnerEnterprisers adminCarOwnerEnterprisers : list) {
            voList.add(toVO4Admin(adminCarOwnerEnterprisers));
        }
        return voList;
    }

    @Override
    public AdminCarOwnerEnterprisersVO toVO4Admin(CarOwnerEnterprisers carOwnerEnterprisers) {

        String json = Json.toJson(carOwnerEnterprisers);
        return Json.toObject(json, AdminCarOwnerEnterprisersVO.class, true);
    }
}
