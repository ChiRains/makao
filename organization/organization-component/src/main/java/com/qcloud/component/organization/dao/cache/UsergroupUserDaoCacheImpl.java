package com.qcloud.component.organization.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.organization.dao.UsergroupUserDao;
import com.qcloud.component.organization.model.UsergroupUser;
import com.qcloud.component.organization.model.query.UsergroupUserQuery;

@Repository
public class UsergroupUserDaoCacheImpl implements UsergroupUserDao {
	
	@Autowired
	private UsergroupUserDao usergroupUserDaoMysqlImpl;
	
	@Autowired
	private UsergroupUserDao usergroupUserDaoRedisImpl;

	@Override
	public boolean add(UsergroupUser usergroupUser) {
		return usergroupUserDaoMysqlImpl.add(usergroupUser);
	}

	@Override
	public UsergroupUser get(Long id) {
		return usergroupUserDaoMysqlImpl.get(id);
	}

	@Override
	public boolean delete(Long id){
		return usergroupUserDaoMysqlImpl.delete(id);
	}
	
	@Override
	public boolean update(UsergroupUser usergroupUser){
		return usergroupUserDaoMysqlImpl.update(usergroupUser);
	}
	
	@Override
	public List<UsergroupUser> list(List<Long> idList) {
		return CacheLoader.list(usergroupUserDaoRedisImpl, usergroupUserDaoMysqlImpl, idList);
	}

	@Override
	public Map<Long, UsergroupUser> map(Set<Long> idSet){
		return CacheLoader.map(usergroupUserDaoRedisImpl, usergroupUserDaoMysqlImpl, idSet);
	}

	@Override
	public Page<UsergroupUser> page(int start, int count){
		return usergroupUserDaoMysqlImpl.page(start, count);
	}
	
	@Override
	public Page<UsergroupUser> page(UsergroupUserQuery query, int start, int count){
		return usergroupUserDaoMysqlImpl.page(query, start, count);
	}
	
	public List<UsergroupUser> listAll(){
		return usergroupUserDaoMysqlImpl.listAll();
	}

    @Override
    public List<UsergroupUser> getUserByGroupId(long groupId) {

        return usergroupUserDaoMysqlImpl.getUserByGroupId(groupId);
    }

    @Override
    public boolean deleteByGroupId(long groupId) {

        return usergroupUserDaoMysqlImpl.deleteByGroupId(groupId);
    }
}

