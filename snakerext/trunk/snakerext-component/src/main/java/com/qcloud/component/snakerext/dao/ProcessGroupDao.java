package com.qcloud.component.snakerext.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.component.snakerext.model.ProcessGroup;
import com.qcloud.component.snakerext.model.query.ProcessGroupQuery;
		
public interface ProcessGroupDao extends ISimpleDao<ProcessGroup, Long> {

	public boolean add(ProcessGroup processGroup);	
	
	public ProcessGroup get(Long id);

	public boolean delete(Long id);
	
	public boolean update(ProcessGroup processGroup);
	
	public List<ProcessGroup> list(List<Long> idList);
	
	public Map<Long, ProcessGroup> map(Set<Long> idSet);
	
	public Page<ProcessGroup> page(ProcessGroupQuery query, int start, int size);

	public List<ProcessGroup> listAll();
	
	public List<ProcessGroup> listByName(String name);
	
	public ProcessGroup getByName(String name);
	
}
