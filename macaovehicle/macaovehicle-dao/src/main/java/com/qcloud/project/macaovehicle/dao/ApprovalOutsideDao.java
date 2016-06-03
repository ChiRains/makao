package com.qcloud.project.macaovehicle.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.project.macaovehicle.model.ApprovalOutside;
import com.qcloud.project.macaovehicle.model.query.ApprovalOutsideQuery;
		
public interface ApprovalOutsideDao extends ISimpleDao<ApprovalOutside, Long> {

	public boolean add(ApprovalOutside approvalOutside);	
	
	public ApprovalOutside get(Long id);

	public boolean delete(Long id);
	
	public boolean update(ApprovalOutside approvalOutside);
	
	public List<ApprovalOutside> list(List<Long> idList);
	
	public Map<Long, ApprovalOutside> map(Set<Long> idSet);
	
	public Page<ApprovalOutside> page(ApprovalOutsideQuery query, int start, int size);

	public List<ApprovalOutside> listAll();
	
}
