package com.qcloud.project.macaovehicle.web.handler;

import java.util.List;

import com.qcloud.project.macaovehicle.model.ResultRecords;
import com.qcloud.project.macaovehicle.web.vo.ResultRecordsVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminResultRecordsVO;

public interface ResultRecordsHandler {

	List<ResultRecordsVO> toVOList(List<ResultRecords> list);

	ResultRecordsVO toVO(ResultRecords resultRecords);

	List<AdminResultRecordsVO> toVOList4Admin(List<ResultRecords> list);

	AdminResultRecordsVO toVO4Admin(ResultRecords resultRecords);
}
