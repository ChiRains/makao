package com.qcloud.project.macaovehicle.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.filesdk.FileSDKClient;
import com.qcloud.pirates.core.json.Json;
import com.qcloud.project.macaovehicle.web.handler.DriverTemplateHandler;
import com.qcloud.project.macaovehicle.model.DriverTemplate;
import com.qcloud.project.macaovehicle.web.vo.DriverTemplateVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminDriverTemplateVO;

@Component
public class DriverTemplateHandlerImpl implements DriverTemplateHandler {

    @Autowired
    private FileSDKClient fileSDKClient;

    @Override
    public List<DriverTemplateVO> toVOList(List<DriverTemplate> list) {

        List<DriverTemplateVO> voList = new ArrayList<DriverTemplateVO>();
        for (DriverTemplate driverTemplate : list) {
            voList.add(toVO(driverTemplate));
        }
        return voList;
    }

    @Override
    public DriverTemplateVO toVO(DriverTemplate driverTemplate) {

        String json = Json.toJson(driverTemplate);
        DriverTemplateVO vo = Json.toObject(json, DriverTemplateVO.class, true);
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
    public List<AdminDriverTemplateVO> toVOList4Admin(List<DriverTemplate> list) {

        List<AdminDriverTemplateVO> voList = new ArrayList<AdminDriverTemplateVO>();
        for (DriverTemplate adminDriverTemplate : list) {
            voList.add(toVO4Admin(adminDriverTemplate));
        }
        return voList;
    }

    @Override
    public AdminDriverTemplateVO toVO4Admin(DriverTemplate driverTemplate) {

        String json = Json.toJson(driverTemplate);
        return Json.toObject(json, AdminDriverTemplateVO.class, true);
    }
}
