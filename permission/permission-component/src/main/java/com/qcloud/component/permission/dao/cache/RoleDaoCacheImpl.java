package com.qcloud.component.permission.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.permission.dao.RoleDao;
import com.qcloud.component.permission.model.Role;

@Repository
public class RoleDaoCacheImpl implements RoleDao {
	
	@Autowired
	private RoleDao roleDaoMysqlImpl;
	
	@Autowired
	private RoleDao roleDaoRedisImpl;

	@Override
	public boolean add(Role role) {
		return roleDaoMysqlImpl.add(role);
	}

	@Override
	public Role get(Long id) {
		return CacheLoader.get(roleDaoRedisImpl, roleDaoMysqlImpl, id);
	}

	@Override
	public boolean delete(Long id){
		return roleDaoMysqlImpl.delete(id);
	}
	
	@Override
	public boolean update(Role role){
		return roleDaoMysqlImpl.update(role);
	}
	
	@Override
	public List<Role> list(List<Long> idList) {
		return CacheLoader.list(roleDaoRedisImpl, roleDaoMysqlImpl, idList);
	}

	@Override
	public Map<Long, Role> map(Set<Long> idSet){
		return CacheLoader.map(roleDaoRedisImpl, roleDaoMysqlImpl, idSet);
	}

	@Override
	public Page<Role> page(int start, int count){
		return roleDaoMysqlImpl.page(start, count);
	}

	@Override
	public List<Role> list() {
		return roleDaoMysqlImpl.list();
	}
}

