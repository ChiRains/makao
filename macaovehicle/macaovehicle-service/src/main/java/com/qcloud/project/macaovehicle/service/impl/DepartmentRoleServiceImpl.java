package com.qcloud.project.macaovehicle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.dao.DepartmentRoleDao;
import com.qcloud.project.macaovehicle.model.DepartmentRole;
import com.qcloud.project.macaovehicle.service.DepartmentRoleService;
import com.qcloud.project.macaovehicle.model.query.DepartmentRoleQuery;
		
@Service
public class DepartmentRoleServiceImpl implements DepartmentRoleService{
	
	@Autowired
	private DepartmentRoleDao departmentRoleDao;
	
	@Autowired
	private AutoIdGenerator autoIdGenerator;
	
	private static final String ID_KEY = "macaovehicle_department_role";

	@Override
	public boolean add(DepartmentRole departmentRole) {
		long id = autoIdGenerator.get(ID_KEY);
		departmentRole.setId(id);
		
		return departmentRoleDao.add(departmentRole);
	}

	@Override
	public DepartmentRole get(Long id) {	
		return departmentRoleDao.get(id);		
	}

	@Override
	public boolean delete(Long id) {
		return departmentRoleDao.delete(id);
	}
	
	@Override
	public boolean update(DepartmentRole departmentRole) {
		return departmentRoleDao.update(departmentRole);
	}
	
	@Override
	public Page<DepartmentRole> page(DepartmentRoleQuery query, int start, int count) {
		return departmentRoleDao.page(query, start, count);
	}
	
	public List<DepartmentRole> listAll(){
		return departmentRoleDao.listAll();
	}
}

