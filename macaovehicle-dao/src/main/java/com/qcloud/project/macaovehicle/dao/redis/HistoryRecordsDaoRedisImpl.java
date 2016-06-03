package com.qcloud.project.macaovehicle.dao.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang.NotImplementedException;
import org.springframework.stereotype.Repository;

import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.redis.Redis;
import com.qcloud.project.macaovehicle.dao.HistoryRecordsDao;
import com.qcloud.project.macaovehicle.model.HistoryRecords;
import com.qcloud.project.macaovehicle.model.query.HistoryRecordsQuery;

@Repository
public class HistoryRecordsDaoRedisImpl implements HistoryRecordsDao {

	//@Resource(name = "redis-macaovehicle")
	//private Redis redis;

	@Override
	public boolean add(HistoryRecords historyRecords) {			
		throw new NotImplementedException();
	}

	@Override
	public HistoryRecords get(Long id) {		
		throw new NotImplementedException();
	}
	
	@Override
	public boolean delete(Long id){
		throw new NotImplementedException();
	}
	
	@Override
	public boolean update(HistoryRecords historyRecords){
		throw new NotImplementedException();
	}
	
	@Override
	public List<HistoryRecords> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, HistoryRecords> map(Set<Long> idSet){
		throw new NotImplementedException();
	}
		
	@Override
	public Page<HistoryRecords> page(int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public Page<HistoryRecords> page(HistoryRecordsQuery query, int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public List<HistoryRecords> listAll(){	
		throw new NotImplementedException();
	}
}

