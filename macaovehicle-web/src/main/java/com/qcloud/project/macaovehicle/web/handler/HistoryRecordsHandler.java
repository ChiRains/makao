package com.qcloud.project.macaovehicle.web.handler;

import java.util.List;

import com.qcloud.project.macaovehicle.model.HistoryRecords;
import com.qcloud.project.macaovehicle.web.vo.HistoryRecordsVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminHistoryRecordsVO;

public interface HistoryRecordsHandler {

	List<HistoryRecordsVO> toVOList(List<HistoryRecords> list);

	HistoryRecordsVO toVO(HistoryRecords historyRecords);

	List<AdminHistoryRecordsVO> toVOList4Admin(List<HistoryRecords> list);

	AdminHistoryRecordsVO toVO4Admin(HistoryRecords historyRecords);
}
