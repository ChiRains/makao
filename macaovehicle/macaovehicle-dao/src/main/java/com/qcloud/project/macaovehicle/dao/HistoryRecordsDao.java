package com.qcloud.project.macaovehicle.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.project.macaovehicle.model.HistoryRecords;
import com.qcloud.project.macaovehicle.model.query.HistoryRecordsQuery;
		
public interface HistoryRecordsDao extends ISimpleDao<HistoryRecords, Long> {

	public boolean add(HistoryRecords historyRecords);	
	
	public HistoryRecords get(Long id);

	public boolean delete(Long id);
	
	public boolean update(HistoryRecords historyRecords);
	
	public List<HistoryRecords> list(List<Long> idList);
	
	public Map<Long, HistoryRecords> map(Set<Long> idSet);
	
	public Page<HistoryRecords> page(HistoryRecordsQuery query, int start, int size);

	public List<HistoryRecords> listAll();
	
}
