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
import com.qcloud.project.macaovehicle.dao.IllegalCarRecordDao;
import com.qcloud.project.macaovehicle.model.IllegalCarRecord;
import com.qcloud.project.macaovehicle.model.query.IllegalCarRecordQuery;

@Repository
public class IllegalCarRecordDaoRedisImpl implements IllegalCarRecordDao {

	//@Resource(name = "redis-macaovehicle")
	//private Redis redis;

	@Override
	public boolean add(IllegalCarRecord illegalCarRecord) {			
		throw new NotImplementedException();
	}

	@Override
	public IllegalCarRecord get(Long id) {		
		throw new NotImplementedException();
	}
	
	@Override
	public boolean delete(Long id){
		throw new NotImplementedException();
	}
	
	@Override
	public boolean update(IllegalCarRecord illegalCarRecord){
		throw new NotImplementedException();
	}
	
	@Override
	public List<IllegalCarRecord> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, IllegalCarRecord> map(Set<Long> idSet){
		throw new NotImplementedException();
	}
		
	@Override
	public Page<IllegalCarRecord> page(int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public Page<IllegalCarRecord> page(IllegalCarRecordQuery query, int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public List<IllegalCarRecord> listAll(){	
		throw new NotImplementedException();
	}
}

