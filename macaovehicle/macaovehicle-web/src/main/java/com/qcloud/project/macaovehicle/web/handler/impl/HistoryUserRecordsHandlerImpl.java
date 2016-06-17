package com.qcloud.project.macaovehicle.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.util.DateUtil;
import com.qcloud.project.macaovehicle.web.handler.HistoryUserRecordsHandler;
import com.qcloud.project.macaovehicle.model.HistoryUserRecords;
import com.qcloud.project.macaovehicle.web.vo.HistoryUserRecordsVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminHistoryUserRecordsVO;

@Component
public class HistoryUserRecordsHandlerImpl implements HistoryUserRecordsHandler {

    @Override
    public List<HistoryUserRecordsVO> toVOList(List<HistoryUserRecords> list) {

        List<HistoryUserRecordsVO> voList = new ArrayList<HistoryUserRecordsVO>();
        for (HistoryUserRecords historyUserRecords : list) {
            voList.add(toVO(historyUserRecords));
        }
        return voList;
    }

    @Override
    public HistoryUserRecordsVO toVO(HistoryUserRecords historyUserRecords) {

        String json = Json.toJson(historyUserRecords);
        HistoryUserRecordsVO vo = Json.toObject(json, HistoryUserRecordsVO.class, true);
        vo.setApplyTime(DateUtil.date2String(historyUserRecords.getApplyTime()));
        vo.setFinishTime(DateUtil.date2String(historyUserRecords.getFinishTime()));
        return vo;
    }

    @Override
    public List<AdminHistoryUserRecordsVO> toVOList4Admin(List<HistoryUserRecords> list) {

        List<AdminHistoryUserRecordsVO> voList = new ArrayList<AdminHistoryUserRecordsVO>();
        for (HistoryUserRecords adminHistoryUserRecords : list) {
            voList.add(toVO4Admin(adminHistoryUserRecords));
        }
        return voList;
    }

    @Override
    public AdminHistoryUserRecordsVO toVO4Admin(HistoryUserRecords historyUserRecords) {

        String json = Json.toJson(historyUserRecords);
        return Json.toObject(json, AdminHistoryUserRecordsVO.class, true);
    }
}
