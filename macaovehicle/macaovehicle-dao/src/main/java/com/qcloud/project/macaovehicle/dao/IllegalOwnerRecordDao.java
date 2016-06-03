package com.qcloud.project.macaovehicle.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.project.macaovehicle.model.IllegalOwnerRecord;
import com.qcloud.project.macaovehicle.model.query.IllegalOwnerRecordQuery;
		
public interface IllegalOwnerRecordDao extends ISimpleDao<IllegalOwnerRecord, Long> {

	public boolean add(IllegalOwnerRecord illegalOwnerRecord);	
	
	public IllegalOwnerRecord get(Long id);

	public boolean delete(Long id);
	
	public boolean update(IllegalOwnerRecord illegalOwnerRecord);
	
	public List<IllegalOwnerRecord> list(List<Long> idList);
	
	public Map<Long, IllegalOwnerRecord> map(Set<Long> idSet);
	
	public Page<IllegalOwnerRecord> page(IllegalOwnerRecordQuery query, int start, int size);

	public List<IllegalOwnerRecord> listAll();
	
}
