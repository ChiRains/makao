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
import com.qcloud.component.organization.dao.UsergroupUserDao;
import com.qcloud.component.organization.model.UsergroupUser;
import com.qcloud.component.organization.model.query.UsergroupUserQuery;

@Repository
public class UsergroupUserDaoRedisImpl implements UsergroupUserDao {

	//@Resource(name = "redis-organization")
	//private Redis redis;

	@Override
	public boolean add(UsergroupUser usergroupUser) {			
		throw new NotImplementedException();
	}

	@Override
	public UsergroupUser get(Long id) {		
		throw new NotImplementedException();
	}
	
	@Override
	public boolean delete(Long id){
		throw new NotImplementedException();
	}
	
	@Override
	public boolean update(UsergroupUser usergroupUser){
		throw new NotImplementedException();
	}
	
	@Override
	public List<UsergroupUser> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, UsergroupUser> map(Set<Long> idSet){
		throw new NotImplementedException();
	}
		
	@Override
	public Page<UsergroupUser> page(int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public Page<UsergroupUser> page(UsergroupUserQuery query, int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public List<UsergroupUser> listAll(){	
		throw new NotImplementedException();
	}

    @Override
    public List<UsergroupUser> getUserByGroupId(long groupId) {

        throw new NotImplementedException();
    }

    @Override
    public boolean deleteByGroupId(long groupId) {

        throw new NotImplementedException();
    }
}

