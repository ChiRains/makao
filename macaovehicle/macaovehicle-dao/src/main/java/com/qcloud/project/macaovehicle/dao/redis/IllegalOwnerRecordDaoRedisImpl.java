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
import com.qcloud.project.macaovehicle.dao.IllegalOwnerRecordDao;
import com.qcloud.project.macaovehicle.model.IllegalOwnerRecord;
import com.qcloud.project.macaovehicle.model.query.IllegalOwnerRecordQuery;

@Repository
public class IllegalOwnerRecordDaoRedisImpl implements IllegalOwnerRecordDao {

	//@Resource(name = "redis-macaovehicle")
	//private Redis redis;

	@Override
	public boolean add(IllegalOwnerRecord illegalOwnerRecord) {			
		throw new NotImplementedException();
	}

	@Override
	public IllegalOwnerRecord get(Long id) {		
		throw new NotImplementedException();
	}
	
	@Override
	public boolean delete(Long id){
		throw new NotImplementedException();
	}
	
	@Override
	public boolean update(IllegalOwnerRecord illegalOwnerRecord){
		throw new NotImplementedException();
	}
	
	@Override
	public List<IllegalOwnerRecord> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, IllegalOwnerRecord> map(Set<Long> idSet){
		throw new NotImplementedException();
	}
		
	@Override
	public Page<IllegalOwnerRecord> page(int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public Page<IllegalOwnerRecord> page(IllegalOwnerRecordQuery query, int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public List<IllegalOwnerRecord> listAll(){	
		throw new NotImplementedException();
	}
}

