package com.qcloud.project.macaovehicle.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.organization.OrganizationClient;
import com.qcloud.component.organization.QClerk;
import com.qcloud.component.organization.QDepartment;
import com.qcloud.component.permission.model.Organization;
import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.util.DateUtil;
import com.qcloud.project.macaovehicle.web.handler.IllegalCarRecordHandler;
import com.qcloud.project.macaovehicle.model.IllegalCarRecord;
import com.qcloud.project.macaovehicle.web.vo.IllegalCarRecordVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminIllegalCarRecordVO;

@Component
public class IllegalCarRecordHandlerImpl implements IllegalCarRecordHandler {

    @Autowired
    private OrganizationClient organizationClient;

    @Override
    public List<IllegalCarRecordVO> toVOList(List<IllegalCarRecord> list) {

        List<IllegalCarRecordVO> voList = new ArrayList<IllegalCarRecordVO>();
        for (IllegalCarRecord illegalCarRecord : list) {
            voList.add(toVO(illegalCarRecord));
        }
        return voList;
    }

    @Override
    public IllegalCarRecordVO toVO(IllegalCarRecord illegalCarRecord) {

        String json = Json.toJson(illegalCarRecord);
        IllegalCarRecordVO vo = Json.toObject(json, IllegalCarRecordVO.class, true);
        QClerk qClerk = organizationClient.getClerk(illegalCarRecord.getClerkId());
        vo.setClerkName(qClerk != null ? qClerk.getName() : "");
        QDepartment qDepartment = organizationClient.getDepartment(qClerk.getDepartmentId());
        vo.setDepartmentName(qDepartment != null ? qDepartment.getName() : "");
        vo.setCreateTimeStr(DateUtil.date2String(illegalCarRecord.getCreateTime(), "yyyy-MM-dd"));
        return vo;
    }

    @Override
    public List<AdminIllegalCarRecordVO> toVOList4Admin(List<IllegalCarRecord> list) {

        List<AdminIllegalCarRecordVO> voList = new ArrayList<AdminIllegalCarRecordVO>();
        for (IllegalCarRecord adminIllegalCarRecord : list) {
            voList.add(toVO4Admin(adminIllegalCarRecord));
        }
        return voList;
    }

    @Override
    public AdminIllegalCarRecordVO toVO4Admin(IllegalCarRecord illegalCarRecord) {

        String json = Json.toJson(illegalCarRecord);
        return Json.toObject(json, AdminIllegalCarRecordVO.class, true);
    }
}
