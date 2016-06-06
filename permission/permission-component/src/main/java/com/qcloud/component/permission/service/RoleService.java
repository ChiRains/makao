package com.qcloud.component.permission.service;

import java.util.List;

import com.qcloud.component.permission.model.Role;
import com.qcloud.pirates.data.Page;

public interface RoleService {
	
	public boolean add(Role role);	
	
	public Role get(Long id);
	
	public	boolean delete(Long id);
	
	public	boolean update(Role role);

	public Page<Role> page(int start, int count);
	
	List<Role> list();
	
	List<Role> list(List<Long> keys);
}

