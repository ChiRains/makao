package com.qcloud.project.macaovehicle.dao.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang.NotImplementedException;
import org.springframework.stereotype.Repository;

import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.redis.Redis;
import com.qcloud.project.macaovehicle.dao.DepartmentRoleDao;
import com.qcloud.project.macaovehicle.model.DepartmentRole;
import com.qcloud.project.macaovehicle.model.query.DepartmentRoleQuery;

@Repository
public class DepartmentRoleDaoRedisImpl implements DepartmentRoleDao {

	//@Resource(name = "redis-macaovehicle")
	//private Redis redis;

	@Override
	public boolean add(DepartmentRole departmentRole) {			
		throw new NotImplementedException();
	}

	@Override
	public DepartmentRole get(Long id) {		
		throw new NotImplementedException();
	}
	
	@Override
	public boolean delete(Long id){
		throw new NotImplementedException();
	}
	
	@Override
	public boolean update(DepartmentRole departmentRole){
		throw new NotImplementedException();
	}
	
	@Override
	public List<DepartmentRole> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, DepartmentRole> map(Set<Long> idSet){
		throw new NotImplementedException();
	}
		
	@Override
	public Page<DepartmentRole> page(int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public Page<DepartmentRole> page(DepartmentRoleQuery query, int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public List<DepartmentRole> listAll(){	
		throw new NotImplementedException();
	}
}

