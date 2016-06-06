package com.qcloud.project.macaovehicle.service;

import java.util.List;

import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.model.DepartmentRole;
import com.qcloud.project.macaovehicle.model.query.DepartmentRoleQuery;

public interface DepartmentRoleService {
	
	public boolean add(DepartmentRole departmentRole);	
	
	public DepartmentRole get(Long id);
	
	public	boolean delete(Long id);
	
	public	boolean update(DepartmentRole departmentRole);

	public Page<DepartmentRole> page(DepartmentRoleQuery query, int start, int count);
	
	public List<DepartmentRole> listAll();
}

