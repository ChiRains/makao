package com.qcloud.component.permission.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.permission.dao.RolePermissionDao;
import com.qcloud.component.permission.model.RolePermission;

@Repository
public class RolePermissionDaoCacheImpl implements RolePermissionDao {

	@Autowired
	private RolePermissionDao rolePermissionDaoMysqlImpl;

	@Autowired
	private RolePermissionDao rolePermissionDaoRedisImpl;

	@Override
	public boolean add(RolePermission rolePermission) {
		return rolePermissionDaoMysqlImpl.add(rolePermission);
	}

	@Override
	public RolePermission get(Long id) {
		return CacheLoader.get(rolePermissionDaoRedisImpl,
				rolePermissionDaoMysqlImpl, id);
	}

	@Override
	public boolean delete(Long id) {
		return rolePermissionDaoMysqlImpl.delete(id);
	}

	@Override
	public boolean update(RolePermission rolePermission) {
		return rolePermissionDaoMysqlImpl.update(rolePermission);
	}

	@Override
	public List<RolePermission> list(List<Long> idList) {
		return CacheLoader.list(rolePermissionDaoRedisImpl,
				rolePermissionDaoMysqlImpl, idList);
	}

	@Override
	public Map<Long, RolePermission> map(Set<Long> idSet) {
		return CacheLoader.map(rolePermissionDaoRedisImpl,
				rolePermissionDaoMysqlImpl, idSet);
	}

	@Override
	public Page<RolePermission> page(int start, int count) {
		return rolePermissionDaoMysqlImpl.page(start, count);
	}

	@Override
	public List<RolePermission> list(Long roleId) {
		return rolePermissionDaoMysqlImpl.list(roleId);
	}
}
