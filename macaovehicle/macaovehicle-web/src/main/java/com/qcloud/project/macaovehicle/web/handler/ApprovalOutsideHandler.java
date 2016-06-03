package com.qcloud.project.macaovehicle.web.handler;

import java.util.List;

import com.qcloud.project.macaovehicle.model.ApprovalOutside;
import com.qcloud.project.macaovehicle.web.vo.ApprovalOutsideVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminApprovalOutsideVO;

public interface ApprovalOutsideHandler {

	List<ApprovalOutsideVO> toVOList(List<ApprovalOutside> list);

	ApprovalOutsideVO toVO(ApprovalOutside approvalOutside);

	List<AdminApprovalOutsideVO> toVOList4Admin(List<ApprovalOutside> list);

	AdminApprovalOutsideVO toVO4Admin(ApprovalOutside approvalOutside);
}
