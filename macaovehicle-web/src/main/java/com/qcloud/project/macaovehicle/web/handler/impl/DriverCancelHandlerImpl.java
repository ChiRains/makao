package com.qcloud.project.macaovehicle.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.util.DateUtil;
import com.qcloud.project.macaovehicle.web.handler.DriverCancelHandler;
import com.qcloud.project.macaovehicle.model.DriverCancel;
import com.qcloud.project.macaovehicle.web.vo.DriverCancelVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminDriverCancelVO;

@Component
public class DriverCancelHandlerImpl implements DriverCancelHandler {

    @Override
    public List<DriverCancelVO> toVOList(List<DriverCancel> list) {

        List<DriverCancelVO> voList = new ArrayList<DriverCancelVO>();
        for (DriverCancel driverCancel : list) {
            voList.add(toVO(driverCancel));
        }
        return voList;
    }

    @Override
    public DriverCancelVO toVO(DriverCancel driverCancel) {

        String json = Json.toJson(driverCancel);
        DriverCancelVO vo = Json.toObject(json, DriverCancelVO.class, true);
        vo.setRecordTime(DateUtil.date2String(driverCancel.getRecordTime()));
        return vo;
    }

    @Override
    public List<AdminDriverCancelVO> toVOList4Admin(List<DriverCancel> list) {

        List<AdminDriverCancelVO> voList = new ArrayList<AdminDriverCancelVO>();
        for (DriverCancel adminDriverCancel : list) {
            voList.add(toVO4Admin(adminDriverCancel));
        }
        return voList;
    }

    @Override
    public AdminDriverCancelVO toVO4Admin(DriverCancel driverCancel) {

        String json = Json.toJson(driverCancel);
        return Json.toObject(json, AdminDriverCancelVO.class, true);
    }
}
