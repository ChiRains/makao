package com.qcloud.project.macaovehicle.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.util.DateUtil;
import com.qcloud.project.macaovehicle.web.handler.DriverLossHandler;
import com.qcloud.project.macaovehicle.model.DriverLoss;
import com.qcloud.project.macaovehicle.web.vo.DriverLossVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminDriverLossVO;

@Component
public class DriverLossHandlerImpl implements DriverLossHandler {

    @Override
    public List<DriverLossVO> toVOList(List<DriverLoss> list) {

        List<DriverLossVO> voList = new ArrayList<DriverLossVO>();
        for (DriverLoss driverLoss : list) {
            voList.add(toVO(driverLoss));
        }
        return voList;
    }

    @Override
    public DriverLossVO toVO(DriverLoss driverLoss) {

        String json = Json.toJson(driverLoss);
        DriverLossVO vo = Json.toObject(json, DriverLossVO.class, true);
        vo.setLossTimeStr(DateUtil.date2String(driverLoss.getLossTime()));
        if (driverLoss.getOldDriverIc() == null) {
            vo.setOldDriverIc("-");
        }
        return vo;
    }

    @Override
    public List<AdminDriverLossVO> toVOList4Admin(List<DriverLoss> list) {

        List<AdminDriverLossVO> voList = new ArrayList<AdminDriverLossVO>();
        for (DriverLoss adminDriverLoss : list) {
            voList.add(toVO4Admin(adminDriverLoss));
        }
        return voList;
    }

    @Override
    public AdminDriverLossVO toVO4Admin(DriverLoss driverLoss) {

        String json = Json.toJson(driverLoss);
        return Json.toObject(json, AdminDriverLossVO.class, true);
    }
}
