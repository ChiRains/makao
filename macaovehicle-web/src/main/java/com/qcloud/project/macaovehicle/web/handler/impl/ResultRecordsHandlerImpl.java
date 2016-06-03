package com.qcloud.project.macaovehicle.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.qcloud.pirates.core.json.Json;
import com.qcloud.project.macaovehicle.web.handler.ResultRecordsHandler;
import com.qcloud.project.macaovehicle.model.ResultRecords;
import com.qcloud.project.macaovehicle.web.vo.ResultRecordsVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminResultRecordsVO;

@Component
public class ResultRecordsHandlerImpl implements ResultRecordsHandler {

	@Override
	public List<ResultRecordsVO> toVOList(List<ResultRecords> list){
		List<ResultRecordsVO> voList = new ArrayList<ResultRecordsVO>();
		for (ResultRecords resultRecords : list) {
			voList.add(toVO(resultRecords));
		}
		return voList;
	}

	@Override
	public ResultRecordsVO toVO(ResultRecords resultRecords){
		String json = Json.toJson(resultRecords);
		return Json.toObject(json, ResultRecordsVO.class, true);

	}

	@Override
	public List<AdminResultRecordsVO> toVOList4Admin(List<ResultRecords> list){
		List<AdminResultRecordsVO> voList = new ArrayList<AdminResultRecordsVO>();
		for (ResultRecords adminResultRecords : list) {
			voList.add(toVO4Admin(adminResultRecords));
		}
		return voList;
	}

	@Override
	public AdminResultRecordsVO toVO4Admin(ResultRecords resultRecords){
		String json = Json.toJson(resultRecords);
		return Json.toObject(json, AdminResultRecordsVO.class, true);
	}
}
