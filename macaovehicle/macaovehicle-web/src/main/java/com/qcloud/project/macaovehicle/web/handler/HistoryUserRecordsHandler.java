package com.qcloud.project.macaovehicle.web.handler;

import java.util.List;

import com.qcloud.project.macaovehicle.model.HistoryUserRecords;
import com.qcloud.project.macaovehicle.web.vo.HistoryUserRecordsVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminHistoryUserRecordsVO;

public interface HistoryUserRecordsHandler {

	List<HistoryUserRecordsVO> toVOList(List<HistoryUserRecords> list);

	HistoryUserRecordsVO toVO(HistoryUserRecords historyUserRecords);

	List<AdminHistoryUserRecordsVO> toVOList4Admin(List<HistoryUserRecords> list);

	AdminHistoryUserRecordsVO toVO4Admin(HistoryUserRecords historyUserRecords);
}
