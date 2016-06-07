package com.qcloud.component.piratesship.dao.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang.NotImplementedException;
import org.springframework.stereotype.Repository;

import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.redis.Redis;
import com.qcloud.component.piratesship.dao.CallMeDao;
import com.qcloud.component.piratesship.model.CallMe;
import com.qcloud.component.piratesship.model.query.CallMeQuery;

@Repository
public class CallMeDaoRedisImpl implements CallMeDao {

	//@Resource(name = "redis-piratesship")
	//private Redis redis;

	@Override
	public boolean add(CallMe callMe) {			
		throw new NotImplementedException();
	}

	@Override
	public CallMe get(Long id) {		
		throw new NotImplementedException();
	}
	
	@Override
	public boolean delete(Long id){
		throw new NotImplementedException();
	}
	
	@Override
	public boolean update(CallMe callMe){
		throw new NotImplementedException();
	}
	
	@Override
	public List<CallMe> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, CallMe> map(Set<Long> idSet){
		throw new NotImplementedException();
	}
		
	@Override
	public Page<CallMe> page(int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public Page<CallMe> page(CallMeQuery query, int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public List<CallMe> listAll(){	
		throw new NotImplementedException();
	}
}

