package com.qcloud.project.macaovehicle.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import com.qcloud.component.filesdk.FileSDKClient;
import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.util.DateUtil;
import com.qcloud.project.macaovehicle.web.handler.CarOwnerHandler;
import com.qcloud.project.macaovehicle.model.CarOwner;
import com.qcloud.project.macaovehicle.model.key.TypeEnum;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.OwnerType;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.UserType;
import com.qcloud.project.macaovehicle.web.vo.CarOwnerVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminCarOwnerVO;

@Component
public class CarOwnerHandlerImpl implements CarOwnerHandler {

    @Autowired
    private FileSDKClient fileSDKClient;

    @Override
    public List<CarOwnerVO> toVOList(List<CarOwner> list) {

        List<CarOwnerVO> voList = new ArrayList<CarOwnerVO>();
        for (CarOwner carOwner : list) {
            voList.add(toVO(carOwner));
        }
        return voList;
    }

    @Override
    public CarOwnerVO toVO(CarOwner carOwner) {

        String json = Json.toJson(carOwner);
        CarOwnerVO vo = Json.toObject(json, CarOwnerVO.class, true);
        if (carOwner.getType() == 1) {
            UserType type[] = TypeEnum.UserType.values();
            for (UserType userType : type) {
                if (vo.getType() == userType.getKey()) {
                    vo.setTypeStr(userType.getName());
                }
            }
        }
        vo.setCertificateDateFormat(DateUtil.date2String(carOwner.getCertificateDate(), "yyyy-MM-dd"));
        vo.setHeadImageUid(fileSDKClient.urlToUid(vo.getHeadImage()));
        vo.setIdcardBackUid(fileSDKClient.urlToUid(vo.getIdcardBack()));
        vo.setIdcardFaceUid(fileSDKClient.urlToUid(vo.getIdcardFace()));
        vo.setHeadImage(vo.getHeadImage());
        vo.setIdcardBack(vo.getIdcardBack());
        vo.setIdcardFace(vo.getIdcardFace());
        List<String> certificateUrlUids = new ArrayList<String>();
        List<String> certificateUrls = new ArrayList<String>();
        if (!StringUtils.isEmpty(vo.getCertificateUrl())) {
            for (String certificateUrl : vo.getCertificateUrl().split(",")) {
                certificateUrls.add(certificateUrl);
                certificateUrlUids.add(fileSDKClient.urlToUid(certificateUrl));
            }
        }
        vo.setCertificateUrls(certificateUrls);
        vo.setCertificateUrlUids(certificateUrlUids);
        vo.setHeadImageUid(fileSDKClient.urlToUid(vo.getHeadImage()));
        // vo.setClerkTypeStr(TypeEnum.OwnerType);
        return vo;
    }

    @Override
    public List<AdminCarOwnerVO> toVOList4Admin(List<CarOwner> list) {

        List<AdminCarOwnerVO> voList = new ArrayList<AdminCarOwnerVO>();
        for (CarOwner adminCarOwner : list) {
            voList.add(toVO4Admin(adminCarOwner));
        }
        return voList;
    }

    @Override
    public AdminCarOwnerVO toVO4Admin(CarOwner carOwner) {

        String json = Json.toJson(carOwner);
        return Json.toObject(json, AdminCarOwnerVO.class, true);
    }
}
