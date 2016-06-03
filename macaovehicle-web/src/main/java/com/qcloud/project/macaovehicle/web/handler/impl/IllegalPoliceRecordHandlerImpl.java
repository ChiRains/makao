package com.qcloud.project.macaovehicle.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.organization.OrganizationClient;
import com.qcloud.component.organization.QClerk;
import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.DateUtil;
import com.qcloud.project.macaovehicle.web.handler.IllegalPoliceRecordHandler;
import com.qcloud.project.macaovehicle.model.IllegalPoliceRecord;
import com.qcloud.project.macaovehicle.web.vo.IllegalPoliceRecordVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminIllegalPoliceRecordVO;

@Component
public class IllegalPoliceRecordHandlerImpl implements IllegalPoliceRecordHandler {

    @Autowired
    private OrganizationClient organizationClient;

    @Override
    public List<IllegalPoliceRecordVO> toVOList(List<IllegalPoliceRecord> list) {

        List<IllegalPoliceRecordVO> voList = new ArrayList<IllegalPoliceRecordVO>();
        for (IllegalPoliceRecord illegalPoliceRecord : list) {
            voList.add(toVO(illegalPoliceRecord));
        }
        return voList;
    }

    @Override
    public IllegalPoliceRecordVO toVO(IllegalPoliceRecord illegalPoliceRecord) {

        String json = Json.toJson(illegalPoliceRecord);
        IllegalPoliceRecordVO vo = Json.toObject(json, IllegalPoliceRecordVO.class, true);
        vo.setViolationTime(DateUtil.date2String(illegalPoliceRecord.getViolationTime()));
        vo.setCreateTime(DateUtil.date2String(illegalPoliceRecord.getCreateTime()));
        QClerk qClerk = organizationClient.getClerk(illegalPoliceRecord.getClerkId());
        AssertUtil.assertNotNull(qClerk, "职工不存在." + illegalPoliceRecord.getClerkId());
        vo.setClerkName(qClerk.getName());
        return vo;
    }

    @Override
    public List<AdminIllegalPoliceRecordVO> toVOList4Admin(List<IllegalPoliceRecord> list) {

        List<AdminIllegalPoliceRecordVO> voList = new ArrayList<AdminIllegalPoliceRecordVO>();
        for (IllegalPoliceRecord adminIllegalPoliceRecord : list) {
            voList.add(toVO4Admin(adminIllegalPoliceRecord));
        }
        return voList;
    }

    @Override
    public AdminIllegalPoliceRecordVO toVO4Admin(IllegalPoliceRecord illegalPoliceRecord) {

        String json = Json.toJson(illegalPoliceRecord);
        return Json.toObject(json, AdminIllegalPoliceRecordVO.class, true);
    }
}
