package com.qcloud.component.permission.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qcloud.pirates.data.Page;
import com.qcloud.component.permission.dao.PermissionDao;
import com.qcloud.component.permission.model.Permission;
import com.qcloud.component.permission.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	private PermissionDao permissionDao;

	@Override
	public boolean add(Permission permission) {
		return permissionDao.add(permission);
	}

	@Override
	public Permission get(Long id) {
		return permissionDao.get(id);
	}

	@Override
	public boolean delete(Long id) {
		return permissionDao.delete(id);
	}

	@Override
	public boolean update(Permission permission) {
		return permissionDao.update(permission);
	}

	@Override
	public Page<Permission> page(int start, int count) {
		return permissionDao.page(start, count);
	}

	@Override
	public List<Permission> list(List<Long> keys) {
		return permissionDao.list(keys);
	}
}
