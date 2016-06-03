package com.qcloud.project.macaovehicle.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.filesdk.FileSDKClient;
import com.qcloud.pirates.core.json.Json;
import com.qcloud.project.macaovehicle.web.handler.DriverHandler;
import com.qcloud.project.macaovehicle.model.Driver;
import com.qcloud.project.macaovehicle.web.vo.DriverVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminDriverVO;

@Component
public class DriverHandlerImpl implements DriverHandler {

    @Autowired
    private FileSDKClient fileSDKClient;

    @Override
    public List<DriverVO> toVOList(List<Driver> list) {

        List<DriverVO> voList = new ArrayList<DriverVO>();
        for (Driver driver : list) {
            voList.add(toVO(driver));
        }
        return voList;
    }

    @Override
    public DriverVO toVO(Driver driver) {

        String json = Json.toJson(driver);
        DriverVO vo = Json.toObject(json, DriverVO.class, true);
        vo.setIdcardBackUid(fileSDKClient.urlToUid(vo.getIdcardBack()));
        vo.setIdcardFaceUid(fileSDKClient.urlToUid(vo.getIdcardFace()));
        vo.setInchImageUid(fileSDKClient.urlToUid(vo.getInchImage()));
        vo.setLicenseImageUid(fileSDKClient.urlToUid(vo.getLicenseImage()));
        vo.setCertificateUid(fileSDKClient.urlToUid(vo.getCertificateUrl()));
        vo.setHealthCardImgUid(fileSDKClient.urlToUid(vo.getHealthCardImg()));
        //
        if (StringUtils.isNotEmpty(vo.getIdcardBack())) {
            vo.setIdcardBack(vo.getIdcardBack());
        }
        if (StringUtils.isNotEmpty(vo.getIdcardFace())) {
            vo.setIdcardFace(vo.getIdcardFace());
        }
        if (StringUtils.isNotEmpty(vo.getInchImage())) {
            vo.setInchImage(vo.getInchImage());
        }
        if (StringUtils.isNotEmpty(vo.getLicenseImage())) {
            vo.setLicenseImage(vo.getLicenseImage());
        }
        if (StringUtils.isNotEmpty(vo.getCertificateUrl())) {
            vo.setCertificateUrl(vo.getCertificateUrl());
        }
        if (StringUtils.isNotEmpty(vo.getHealthCardImg())) {
            vo.setHealthCardImg(vo.getHealthCardImg());
        }
        return vo;
    }

    @Override
    public List<AdminDriverVO> toVOList4Admin(List<Driver> list) {

        List<AdminDriverVO> voList = new ArrayList<AdminDriverVO>();
        for (Driver adminDriver : list) {
            voList.add(toVO4Admin(adminDriver));
        }
        return voList;
    }

    @Override
    public AdminDriverVO toVO4Admin(Driver driver) {

        String json = Json.toJson(driver);
        return Json.toObject(json, AdminDriverVO.class, true);
    }
}
