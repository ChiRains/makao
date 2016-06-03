package com.qcloud.project.macaovehicle.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.util.DateUtil;
import com.qcloud.project.macaovehicle.web.handler.CarOwnerIndicatorsHandler;
import com.qcloud.project.macaovehicle.model.CarOwnerIndicators;
import com.qcloud.project.macaovehicle.web.vo.CarOwnerIndicatorsVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminCarOwnerIndicatorsVO;

@Component
public class CarOwnerIndicatorsHandlerImpl implements CarOwnerIndicatorsHandler {

    @Override
    public List<CarOwnerIndicatorsVO> toVOList(List<CarOwnerIndicators> list) {

        List<CarOwnerIndicatorsVO> voList = new ArrayList<CarOwnerIndicatorsVO>();
        for (CarOwnerIndicators carOwnerIndicators : list) {
            voList.add(toVO(carOwnerIndicators));
        }
        return voList;
    }

    @Override
    public CarOwnerIndicatorsVO toVO(CarOwnerIndicators carOwnerIndicators) {

        String json = Json.toJson(carOwnerIndicators);
        CarOwnerIndicatorsVO vo = Json.toObject(json, CarOwnerIndicatorsVO.class, true);
        vo.setValidityPeriod(DateUtil.date2String(carOwnerIndicators.getValidityPeriod(), "yyyy-MM-dd HH:mm:ss"));
        return vo;
    }

    @Override
    public List<AdminCarOwnerIndicatorsVO> toVOList4Admin(List<CarOwnerIndicators> list) {

        List<AdminCarOwnerIndicatorsVO> voList = new ArrayList<AdminCarOwnerIndicatorsVO>();
        for (CarOwnerIndicators adminCarOwnerIndicators : list) {
            voList.add(toVO4Admin(adminCarOwnerIndicators));
        }
        return voList;
    }

    @Override
    public AdminCarOwnerIndicatorsVO toVO4Admin(CarOwnerIndicators carOwnerIndicators) {

        String json = Json.toJson(carOwnerIndicators);
        return Json.toObject(json, AdminCarOwnerIndicatorsVO.class, true);
    }
}
