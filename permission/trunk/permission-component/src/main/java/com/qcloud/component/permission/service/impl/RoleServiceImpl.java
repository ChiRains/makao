package com.qcloud.component.permission.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qcloud.pirates.data.Page;
import com.qcloud.component.permission.dao.RoleDao;
import com.qcloud.component.permission.model.Role;
import com.qcloud.component.permission.service.RoleService;
		
@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	private RoleDao roleDao;

	@Override
	public boolean add(Role role) {
		return roleDao.add(role);
	}

	@Override
	public Role get(Long id) {	
		return roleDao.get(id);		
	}

	@Override
	public boolean delete(Long id) {
		return roleDao.delete(id);
	}
	
	@Override
	public boolean update(Role role) {
		return roleDao.update(role);
	}
	
	@Override
	public Page<Role> page(int start, int count) {
		return roleDao.page(start, count);
	}

	@Override
	public List<Role> list(List<Long> keys) {
		return roleDao.list(keys);
	}

	@Override
	public List<Role> list() {
		return roleDao.list();
	}
}

