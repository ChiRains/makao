package com.qcloud.project.macaovehicle.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.organization.OrganizationClient;
import com.qcloud.component.organization.QClerk;
import com.qcloud.component.organization.QDepartment;
import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.util.DateUtil;
import com.qcloud.project.macaovehicle.web.handler.IllegalOwnerRecordHandler;
import com.qcloud.project.macaovehicle.model.IllegalOwnerRecord;
import com.qcloud.project.macaovehicle.web.vo.IllegalOwnerRecordVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminIllegalOwnerRecordVO;

@Component
public class IllegalOwnerRecordHandlerImpl implements IllegalOwnerRecordHandler {

    @Autowired
    private OrganizationClient organizationClient;

    @Override
    public List<IllegalOwnerRecordVO> toVOList(List<IllegalOwnerRecord> list) {

        List<IllegalOwnerRecordVO> voList = new ArrayList<IllegalOwnerRecordVO>();
        for (IllegalOwnerRecord illegalOwnerRecord : list) {
            voList.add(toVO(illegalOwnerRecord));
        }
        return voList;
    }

    @Override
    public IllegalOwnerRecordVO toVO(IllegalOwnerRecord illegalOwnerRecord) {

        String json = Json.toJson(illegalOwnerRecord);
        IllegalOwnerRecordVO vo = Json.toObject(json, IllegalOwnerRecordVO.class, true);
        QClerk qClerk = organizationClient.getClerk(illegalOwnerRecord.getClerkId());
        vo.setClerkName(qClerk != null ? qClerk.getName() : "");
        QDepartment qDepartment = organizationClient.getDepartment(qClerk.getDepartmentId());
        vo.setDepartmentName(qDepartment != null ? qDepartment.getName() : "");
        vo.setCreateTimeStr(DateUtil.date2String(illegalOwnerRecord.getCreateTime(), "yyyy-MM-dd"));
        return vo;
    }

    @Override
    public List<AdminIllegalOwnerRecordVO> toVOList4Admin(List<IllegalOwnerRecord> list) {

        List<AdminIllegalOwnerRecordVO> voList = new ArrayList<AdminIllegalOwnerRecordVO>();
        for (IllegalOwnerRecord adminIllegalOwnerRecord : list) {
            voList.add(toVO4Admin(adminIllegalOwnerRecord));
        }
        return voList;
    }

    @Override
    public AdminIllegalOwnerRecordVO toVO4Admin(IllegalOwnerRecord illegalOwnerRecord) {

        String json = Json.toJson(illegalOwnerRecord);
        return Json.toObject(json, AdminIllegalOwnerRecordVO.class, true);
    }
}
