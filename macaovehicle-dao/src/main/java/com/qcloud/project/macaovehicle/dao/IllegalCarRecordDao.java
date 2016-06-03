package com.qcloud.project.macaovehicle.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.project.macaovehicle.model.IllegalCarRecord;
import com.qcloud.project.macaovehicle.model.query.IllegalCarRecordQuery;
		
public interface IllegalCarRecordDao extends ISimpleDao<IllegalCarRecord, Long> {

	public boolean add(IllegalCarRecord illegalCarRecord);	
	
	public IllegalCarRecord get(Long id);

	public boolean delete(Long id);
	
	public boolean update(IllegalCarRecord illegalCarRecord);
	
	public List<IllegalCarRecord> list(List<Long> idList);
	
	public Map<Long, IllegalCarRecord> map(Set<Long> idSet);
	
	public Page<IllegalCarRecord> page(IllegalCarRecordQuery query, int start, int size);

	public List<IllegalCarRecord> listAll();
	
}
