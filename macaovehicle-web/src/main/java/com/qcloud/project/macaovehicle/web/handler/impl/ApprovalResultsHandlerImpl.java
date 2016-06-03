package com.qcloud.project.macaovehicle.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.util.DateUtil;
import com.qcloud.project.macaovehicle.web.handler.ApprovalResultsHandler;
import com.qcloud.project.macaovehicle.model.ApprovalResults;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ApprovalCardType;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ApprovalResultState;
import com.qcloud.project.macaovehicle.web.vo.ApprovalResultsVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminApprovalResultsVO;

@Component
public class ApprovalResultsHandlerImpl implements ApprovalResultsHandler {

	@Override
	public List<ApprovalResultsVO> toVOList(List<ApprovalResults> list){
		List<ApprovalResultsVO> voList = new ArrayList<ApprovalResultsVO>();
		for (ApprovalResults approvalResults : list) {
			voList.add(toVO(approvalResults));
		}
		return voList;
	}

	@Override
	public ApprovalResultsVO toVO(ApprovalResults approvalResults){
		String json = Json.toJson(approvalResults);
		ApprovalResultsVO vo=Json.toObject(json, ApprovalResultsVO.class, true);
		//
		ApprovalResultState resultState[]=ApprovalResultState.values();
		for (ApprovalResultState state : resultState) {
            if(state.getKey()==vo.getState()){
                vo.setStateStr(state.getName());
            }
        }
		//
		ApprovalCardType cardType[]=ApprovalCardType.values();
		for (ApprovalCardType type : cardType) {
            if(type.getKey()==vo.getType()){
                vo.setTypeStr(type.getName());
            }
        }
		//
		vo.setTimeStr(DateUtil.date2String(vo.getTime()));
		return vo;

	}

	@Override
	public List<AdminApprovalResultsVO> toVOList4Admin(List<ApprovalResults> list){
		List<AdminApprovalResultsVO> voList = new ArrayList<AdminApprovalResultsVO>();
		for (ApprovalResults adminApprovalResults : list) {
			voList.add(toVO4Admin(adminApprovalResults));
		}
		return voList;
	}

	@Override
	public AdminApprovalResultsVO toVO4Admin(ApprovalResults approvalResults){
		String json = Json.toJson(approvalResults);
		return Json.toObject(json, AdminApprovalResultsVO.class, true);
	}
}
