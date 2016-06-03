package com.qcloud.project.macaovehicle.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import jodd.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.filesdk.FileSDKClient;
import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.util.DateUtil;
import com.qcloud.project.macaovehicle.web.handler.CarOwnerAcquisitionHandler;
import com.qcloud.project.macaovehicle.model.CarOwnerAcquisition;
import com.qcloud.project.macaovehicle.web.vo.CarOwnerAcquisitionVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminCarOwnerAcquisitionVO;

@Component
public class CarOwnerAcquisitionHandlerImpl implements CarOwnerAcquisitionHandler {

    @Autowired
    private FileSDKClient fileSDKClient;

    @Override
    public List<CarOwnerAcquisitionVO> toVOList(List<CarOwnerAcquisition> list) {

        List<CarOwnerAcquisitionVO> voList = new ArrayList<CarOwnerAcquisitionVO>();
        for (CarOwnerAcquisition carOwnerAcquisition : list) {
            voList.add(toVO(carOwnerAcquisition));
        }
        return voList;
    }

    @Override
    public CarOwnerAcquisitionVO toVO(CarOwnerAcquisition carOwnerAcquisition) {

        String json = Json.toJson(carOwnerAcquisition);
        CarOwnerAcquisitionVO carOwnerAcquisitionVO = Json.toObject(json, CarOwnerAcquisitionVO.class, true);
        carOwnerAcquisitionVO.setBuyTimeFormat(carOwnerAcquisitionVO.getBuyTime());
        List<String> urls = new ArrayList<String>();
        List<String> uids = new ArrayList<String>();
        if (!StringUtil.isEmpty(carOwnerAcquisition.getContractUrl())) {
            for (String contractUrl : carOwnerAcquisition.getContractUrl().split(",")) {
                urls.add(contractUrl);
                uids.add(fileSDKClient.urlToUid(contractUrl));
            }
        }
        carOwnerAcquisitionVO.setContractUrls(urls);
        carOwnerAcquisitionVO.setContractUrlUids(uids);
        return carOwnerAcquisitionVO;
    }

    @Override
    public List<AdminCarOwnerAcquisitionVO> toVOList4Admin(List<CarOwnerAcquisition> list) {

        List<AdminCarOwnerAcquisitionVO> voList = new ArrayList<AdminCarOwnerAcquisitionVO>();
        for (CarOwnerAcquisition adminCarOwnerAcquisition : list) {
            voList.add(toVO4Admin(adminCarOwnerAcquisition));
        }
        return voList;
    }

    @Override
    public AdminCarOwnerAcquisitionVO toVO4Admin(CarOwnerAcquisition carOwnerAcquisition) {

        String json = Json.toJson(carOwnerAcquisition);
        return Json.toObject(json, AdminCarOwnerAcquisitionVO.class, true);
    }
}
