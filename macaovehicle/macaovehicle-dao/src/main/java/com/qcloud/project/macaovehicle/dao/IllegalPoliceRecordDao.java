package com.qcloud.project.macaovehicle.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.project.macaovehicle.model.IllegalPoliceRecord;
import com.qcloud.project.macaovehicle.model.query.IllegalPoliceRecordQuery;
		
public interface IllegalPoliceRecordDao extends ISimpleDao<IllegalPoliceRecord, Long> {

	public boolean add(IllegalPoliceRecord illegalPoliceRecord);	
	
	public IllegalPoliceRecord get(Long id);

	public boolean delete(Long id);
	
	public boolean update(IllegalPoliceRecord illegalPoliceRecord);
	
	public List<IllegalPoliceRecord> list(List<Long> idList);
	
	public Map<Long, IllegalPoliceRecord> map(Set<Long> idSet);
	
	public Page<IllegalPoliceRecord> page(IllegalPoliceRecordQuery query, int start, int size);

	public List<IllegalPoliceRecord> listAll();
	
}
