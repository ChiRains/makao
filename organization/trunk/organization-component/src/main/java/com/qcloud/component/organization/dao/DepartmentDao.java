package com.qcloud.component.organization.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.component.organization.model.Department;
import com.qcloud.component.organization.model.query.DepartmentQuery;
		
public interface DepartmentDao extends ISimpleDao<Department, Long> {

	public boolean add(Department department);	
	
	public Department get(Long id);

	public boolean delete(Long id);
	
	public boolean update(Department department);
	
	public List<Department> list(List<Long> idList);
	
	public Map<Long, Department> map(Set<Long> idSet);
	
	public Page<Department> page(DepartmentQuery query, int start, int size);

	public List<Department> listAll();
	
}
