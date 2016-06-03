package com.qcloud.project.macaovehicle.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.dao.HistoryRecordsDao;
import com.qcloud.project.macaovehicle.model.HistoryRecords;
import com.qcloud.project.macaovehicle.model.query.HistoryRecordsQuery;

@Repository
public class HistoryRecordsDaoCacheImpl implements HistoryRecordsDao {
	
	@Autowired
	private HistoryRecordsDao historyRecordsDaoMysqlImpl;
	
	@Autowired
	private HistoryRecordsDao historyRecordsDaoRedisImpl;

	@Override
	public boolean add(HistoryRecords historyRecords) {
		return historyRecordsDaoMysqlImpl.add(historyRecords);
	}

	@Override
	public HistoryRecords get(Long id) {
		return CacheLoader.get(historyRecordsDaoRedisImpl, historyRecordsDaoMysqlImpl, id);
	}

	@Override
	public boolean delete(Long id){
		return historyRecordsDaoMysqlImpl.delete(id);
	}
	
	@Override
	public boolean update(HistoryRecords historyRecords){
		return historyRecordsDaoMysqlImpl.update(historyRecords);
	}
	
	@Override
	public List<HistoryRecords> list(List<Long> idList) {
		return CacheLoader.list(historyRecordsDaoRedisImpl, historyRecordsDaoMysqlImpl, idList);
	}

	@Override
	public Map<Long, HistoryRecords> map(Set<Long> idSet){
		return CacheLoader.map(historyRecordsDaoRedisImpl, historyRecordsDaoMysqlImpl, idSet);
	}

	@Override
	public Page<HistoryRecords> page(int start, int count){
		return historyRecordsDaoMysqlImpl.page(start, count);
	}
	
	@Override
	public Page<HistoryRecords> page(HistoryRecordsQuery query, int start, int count){
		return historyRecordsDaoMysqlImpl.page(query, start, count);
	}
	
	public List<HistoryRecords> listAll(){
		return historyRecordsDaoMysqlImpl.listAll();
	}
}

