package com.qcloud.project.macaovehicle.service;

import java.util.List;

import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.model.ApprovalOutside;
import com.qcloud.project.macaovehicle.model.query.ApprovalOutsideQuery;

public interface ApprovalOutsideService {
	
	public boolean add(ApprovalOutside approvalOutside);	
	
	public ApprovalOutside get(Long id);
	
	public	boolean delete(Long id);
	
	public	boolean update(ApprovalOutside approvalOutside);

	public Page<ApprovalOutside> page(ApprovalOutsideQuery query, int start, int count);
	
	public List<ApprovalOutside> listAll();
}

