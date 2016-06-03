package com.qcloud.component.organization.dao.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang.NotImplementedException;
import org.springframework.stereotype.Repository;

import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.redis.Redis;
import com.qcloud.component.organization.dao.UsergroupDao;
import com.qcloud.component.organization.model.Usergroup;
import com.qcloud.component.organization.model.query.UsergroupQuery;

@Repository
public class UsergroupDaoRedisImpl implements UsergroupDao {

	//@Resource(name = "redis-organization")
	//private Redis redis;

	@Override
	public boolean add(Usergroup usergroup) {			
		throw new NotImplementedException();
	}

	@Override
	public Usergroup get(Long id) {		
		throw new NotImplementedException();
	}
	
	@Override
	public boolean delete(Long id){
		throw new NotImplementedException();
	}
	
	@Override
	public boolean update(Usergroup usergroup){
		throw new NotImplementedException();
	}
	
	@Override
	public List<Usergroup> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, Usergroup> map(Set<Long> idSet){
		throw new NotImplementedException();
	}
		
	@Override
	public Page<Usergroup> page(int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public Page<Usergroup> page(UsergroupQuery query, int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public List<Usergroup> listAll(){	
		throw new NotImplementedException();
	}
}

