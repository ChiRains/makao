package com.qcloud.component.snakerext.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.component.snakerext.model.ProcessGroupClerk;
import com.qcloud.component.snakerext.model.query.ProcessGroupClerkQuery;
		
public interface ProcessGroupClerkDao extends ISimpleDao<ProcessGroupClerk, Long> {

	public boolean add(ProcessGroupClerk processGroupClerk);	
	
	public ProcessGroupClerk get(Long id);

	public boolean delete(Long id);
	
	public boolean update(ProcessGroupClerk processGroupClerk);
	
	public List<ProcessGroupClerk> list(List<Long> idList);
	
	public Map<Long, ProcessGroupClerk> map(Set<Long> idSet);
	
	public Page<ProcessGroupClerk> page(ProcessGroupClerkQuery query, int start, int size);

	public List<ProcessGroupClerk> listAll();
	
	public List<ProcessGroupClerk> listByGroup(Long groupId);
	
	public boolean deleteByGroupId(Long groupId);
	
}
