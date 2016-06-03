package com.qcloud.component.permission.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.permission.dao.PermissionDao;
import com.qcloud.component.permission.model.Permission;

@Repository
public class PermissionDaoCacheImpl implements PermissionDao {
	
	@Autowired
	private PermissionDao permissionDaoMysqlImpl;
//	
//	@Autowired
//	private PermissionDao permissionDaoRedisImpl;

	@Override
	public boolean add(Permission permission) {
		return permissionDaoMysqlImpl.add(permission);
	}

	@Override
	public Permission get(Long id) {
		return permissionDaoMysqlImpl.get(id);
//		return CacheLoader.get(permissionDaoRedisImpl, permissionDaoMysqlImpl, id);
	}

	@Override
	public boolean delete(Long id){
		return permissionDaoMysqlImpl.delete(id);
	}
	
	@Override
	public boolean update(Permission permission){
		return permissionDaoMysqlImpl.update(permission);
	}
	
	@Override
	public List<Permission> list(List<Long> idList) {
		return CacheLoader.list(permissionDaoMysqlImpl, idList);
	}

	@Override
	public Map<Long, Permission> map(Set<Long> idSet){
		return CacheLoader.map(permissionDaoMysqlImpl, idSet);
	}

	@Override
	public Page<Permission> page(int start, int count){
		return permissionDaoMysqlImpl.page(start, count);
	}
}

