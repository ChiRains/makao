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
import com.qcloud.project.macaovehicle.dao.IllegalPoliceRecordDao;
import com.qcloud.project.macaovehicle.model.IllegalPoliceRecord;
import com.qcloud.project.macaovehicle.model.query.IllegalPoliceRecordQuery;

@Repository
public class IllegalPoliceRecordDaoRedisImpl implements IllegalPoliceRecordDao {

	//@Resource(name = "redis-macaovehicle")
	//private Redis redis;

	@Override
	public boolean add(IllegalPoliceRecord illegalPoliceRecord) {			
		throw new NotImplementedException();
	}

	@Override
	public IllegalPoliceRecord get(Long id) {		
		throw new NotImplementedException();
	}
	
	@Override
	public boolean delete(Long id){
		throw new NotImplementedException();
	}
	
	@Override
	public boolean update(IllegalPoliceRecord illegalPoliceRecord){
		throw new NotImplementedException();
	}
	
	@Override
	public List<IllegalPoliceRecord> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, IllegalPoliceRecord> map(Set<Long> idSet){
		throw new NotImplementedException();
	}
		
	@Override
	public Page<IllegalPoliceRecord> page(int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public Page<IllegalPoliceRecord> page(IllegalPoliceRecordQuery query, int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public List<IllegalPoliceRecord> listAll(){	
		throw new NotImplementedException();
	}
}

