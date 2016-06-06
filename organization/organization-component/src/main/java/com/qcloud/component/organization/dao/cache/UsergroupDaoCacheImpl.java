package com.qcloud.component.organization.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.organization.dao.UsergroupDao;
import com.qcloud.component.organization.model.Usergroup;
import com.qcloud.component.organization.model.query.UsergroupQuery;

@Repository
public class UsergroupDaoCacheImpl implements UsergroupDao {
	
	@Autowired
	private UsergroupDao usergroupDaoMysqlImpl;
	
	@Autowired
	private UsergroupDao usergroupDaoRedisImpl;

	@Override
	public boolean add(Usergroup usergroup) {
		return usergroupDaoMysqlImpl.add(usergroup);
	}

	@Override
	public Usergroup get(Long id) {
		return usergroupDaoMysqlImpl.get(id);
	}

	@Override
	public boolean delete(Long id){
		return usergroupDaoMysqlImpl.delete(id);
	}
	
	@Override
	public boolean update(Usergroup usergroup){
		return usergroupDaoMysqlImpl.update(usergroup);
	}
	
	@Override
	public List<Usergroup> list(List<Long> idList) {
		return CacheLoader.list(usergroupDaoRedisImpl, usergroupDaoMysqlImpl, idList);
	}

	@Override
	public Map<Long, Usergroup> map(Set<Long> idSet){
		return CacheLoader.map(usergroupDaoRedisImpl, usergroupDaoMysqlImpl, idSet);
	}

	@Override
	public Page<Usergroup> page(int start, int count){
		return usergroupDaoMysqlImpl.page(start, count);
	}
	
	@Override
	public Page<Usergroup> page(UsergroupQuery query, int start, int count){
		return usergroupDaoMysqlImpl.page(query, start, count);
	}
	
	public List<Usergroup> listAll(){
		return usergroupDaoMysqlImpl.listAll();
	}
}

