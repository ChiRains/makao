package com.qcloud.project.macaovehicle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.dao.ApprovalOutsideDao;
import com.qcloud.project.macaovehicle.model.ApprovalOutside;
import com.qcloud.project.macaovehicle.service.ApprovalOutsideService;
import com.qcloud.project.macaovehicle.model.query.ApprovalOutsideQuery;
		
@Service
public class ApprovalOutsideServiceImpl implements ApprovalOutsideService{
	
	@Autowired
	private ApprovalOutsideDao approvalOutsideDao;
	
	@Autowired
	private AutoIdGenerator autoIdGenerator;
	
	private static final String ID_KEY = "macaovehicle_approval_outside";

	@Override
	public boolean add(ApprovalOutside approvalOutside) {
		long id = autoIdGenerator.get(ID_KEY);
		approvalOutside.setId(id);
		
		return approvalOutsideDao.add(approvalOutside);
	}

	@Override
	public ApprovalOutside get(Long id) {	
		return approvalOutsideDao.get(id);		
	}

	@Override
	public boolean delete(Long id) {
		return approvalOutsideDao.delete(id);
	}
	
	@Override
	public boolean update(ApprovalOutside approvalOutside) {
		return approvalOutsideDao.update(approvalOutside);
	}
	
	@Override
	public Page<ApprovalOutside> page(ApprovalOutsideQuery query, int start, int count) {
		return approvalOutsideDao.page(query, start, count);
	}
	
	public List<ApprovalOutside> listAll(){
		return approvalOutsideDao.listAll();
	}
}

