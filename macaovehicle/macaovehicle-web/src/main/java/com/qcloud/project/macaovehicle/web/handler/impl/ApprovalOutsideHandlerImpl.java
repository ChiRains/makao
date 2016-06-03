package com.qcloud.project.macaovehicle.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.qcloud.pirates.core.json.Json;
import com.qcloud.project.macaovehicle.web.handler.ApprovalOutsideHandler;
import com.qcloud.project.macaovehicle.model.ApprovalOutside;
import com.qcloud.project.macaovehicle.web.vo.ApprovalOutsideVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminApprovalOutsideVO;

@Component
public class ApprovalOutsideHandlerImpl implements ApprovalOutsideHandler {

	@Override
	public List<ApprovalOutsideVO> toVOList(List<ApprovalOutside> list){
		List<ApprovalOutsideVO> voList = new ArrayList<ApprovalOutsideVO>();
		for (ApprovalOutside approvalOutside : list) {
			voList.add(toVO(approvalOutside));
		}
		return voList;
	}

	@Override
	public ApprovalOutsideVO toVO(ApprovalOutside approvalOutside){
		String json = Json.toJson(approvalOutside);
		return Json.toObject(json, ApprovalOutsideVO.class, true);

	}

	@Override
	public List<AdminApprovalOutsideVO> toVOList4Admin(List<ApprovalOutside> list){
		List<AdminApprovalOutsideVO> voList = new ArrayList<AdminApprovalOutsideVO>();
		for (ApprovalOutside adminApprovalOutside : list) {
			voList.add(toVO4Admin(adminApprovalOutside));
		}
		return voList;
	}

	@Override
	public AdminApprovalOutsideVO toVO4Admin(ApprovalOutside approvalOutside){
		String json = Json.toJson(approvalOutside);
		return Json.toObject(json, AdminApprovalOutsideVO.class, true);
	}
}
