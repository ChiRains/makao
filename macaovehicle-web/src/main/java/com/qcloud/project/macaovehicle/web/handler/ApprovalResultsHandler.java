package com.qcloud.project.macaovehicle.web.handler;

import java.util.List;

import com.qcloud.project.macaovehicle.model.ApprovalResults;
import com.qcloud.project.macaovehicle.web.vo.ApprovalResultsVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminApprovalResultsVO;

public interface ApprovalResultsHandler {

	List<ApprovalResultsVO> toVOList(List<ApprovalResults> list);

	ApprovalResultsVO toVO(ApprovalResults approvalResults);

	List<AdminApprovalResultsVO> toVOList4Admin(List<ApprovalResults> list);

	AdminApprovalResultsVO toVO4Admin(ApprovalResults approvalResults);
}
