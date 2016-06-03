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
import com.qcloud.project.macaovehicle.web.handler.HistoryRecordsHandler;
import com.qcloud.project.macaovehicle.model.HistoryRecords;
import com.qcloud.project.macaovehicle.web.vo.HistoryRecordsVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminHistoryRecordsVO;

@Component
public class HistoryRecordsHandlerImpl implements HistoryRecordsHandler {

    @Autowired
    private OrganizationClient organizationClient;

    @Override
    public List<HistoryRecordsVO> toVOList(List<HistoryRecords> list) {

        List<HistoryRecordsVO> voList = new ArrayList<HistoryRecordsVO>();
        for (HistoryRecords historyRecords : list) {
            voList.add(toVO(historyRecords));
        }
        return voList;
    }

    @Override
    public HistoryRecordsVO toVO(HistoryRecords historyRecords) {

        String json = Json.toJson(historyRecords);
        HistoryRecordsVO vo = Json.toObject(json, HistoryRecordsVO.class, true);
        QClerk qClerk = organizationClient.getClerk(historyRecords.getClerkId());
        AssertUtil.assertNotNull(qClerk, "职工不存在." + historyRecords.getClerkId());
        vo.setClerkName(qClerk.getName());
        vo.setUpdateTimeStr(DateUtil.date2String(historyRecords.getUpdateTime()));
        return vo;
    }

    @Override
    public List<AdminHistoryRecordsVO> toVOList4Admin(List<HistoryRecords> list) {

        List<AdminHistoryRecordsVO> voList = new ArrayList<AdminHistoryRecordsVO>();
        for (HistoryRecords adminHistoryRecords : list) {
            voList.add(toVO4Admin(adminHistoryRecords));
        }
        return voList;
    }

    @Override
    public AdminHistoryRecordsVO toVO4Admin(HistoryRecords historyRecords) {

        String json = Json.toJson(historyRecords);
        return Json.toObject(json, AdminHistoryRecordsVO.class, true);
    }
}
