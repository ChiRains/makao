package com.qcloud.project.macaovehicle.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.project.macaovehicle.model.DepartmentRole;
import com.qcloud.project.macaovehicle.model.query.DepartmentRoleQuery;
		
public interface DepartmentRoleDao extends ISimpleDao<DepartmentRole, Long> {

	public boolean add(DepartmentRole departmentRole);	
	
	public DepartmentRole get(Long id);

	public boolean delete(Long id);
	
	public boolean update(DepartmentRole departmentRole);
	
	public List<DepartmentRole> list(List<Long> idList);
	
	public Map<Long, DepartmentRole> map(Set<Long> idSet);
	
	public Page<DepartmentRole> page(DepartmentRoleQuery query, int start, int size);

	public List<DepartmentRole> listAll();
	
}
