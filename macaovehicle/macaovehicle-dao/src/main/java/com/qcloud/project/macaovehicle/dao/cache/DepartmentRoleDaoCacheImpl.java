package com.qcloud.project.macaovehicle.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.dao.DepartmentRoleDao;
import com.qcloud.project.macaovehicle.model.DepartmentRole;
import com.qcloud.project.macaovehicle.model.query.DepartmentRoleQuery;

@Repository
public class DepartmentRoleDaoCacheImpl implements DepartmentRoleDao {
	
	@Autowired
	private DepartmentRoleDao departmentRoleDaoMysqlImpl;
	
	@Autowired
	private DepartmentRoleDao departmentRoleDaoRedisImpl;

	@Override
	public boolean add(DepartmentRole departmentRole) {
		return departmentRoleDaoMysqlImpl.add(departmentRole);
	}

	@Override
	public DepartmentRole get(Long id) {
		return CacheLoader.get(departmentRoleDaoRedisImpl, departmentRoleDaoMysqlImpl, id);
	}

	@Override
	public boolean delete(Long id){
		return departmentRoleDaoMysqlImpl.delete(id);
	}
	
	@Override
	public boolean update(DepartmentRole departmentRole){
		return departmentRoleDaoMysqlImpl.update(departmentRole);
	}
	
	@Override
	public List<DepartmentRole> list(List<Long> idList) {
		return CacheLoader.list(departmentRoleDaoRedisImpl, departmentRoleDaoMysqlImpl, idList);
	}

	@Override
	public Map<Long, DepartmentRole> map(Set<Long> idSet){
		return CacheLoader.map(departmentRoleDaoRedisImpl, departmentRoleDaoMysqlImpl, idSet);
	}

	@Override
	public Page<DepartmentRole> page(int start, int count){
		return departmentRoleDaoMysqlImpl.page(start, count);
	}
	
	@Override
	public Page<DepartmentRole> page(DepartmentRoleQuery query, int start, int count){
		return departmentRoleDaoMysqlImpl.page(query, start, count);
	}
	
	public List<DepartmentRole> listAll(){
		return departmentRoleDaoMysqlImpl.listAll();
	}
}

