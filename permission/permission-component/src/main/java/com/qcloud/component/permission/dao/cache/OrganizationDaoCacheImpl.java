package com.qcloud.component.permission.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.permission.dao.OrganizationDao;
import com.qcloud.component.permission.model.Organization;

@Repository
public class OrganizationDaoCacheImpl implements OrganizationDao {
	
	@Autowired
	private OrganizationDao organizationDaoMysqlImpl;
	
	@Autowired
	private OrganizationDao organizationDaoRedisImpl;

	@Override
	public boolean add(Organization organization) {
		return organizationDaoMysqlImpl.add(organization);
	}

	@Override
	public Organization get(Long id) {
		return CacheLoader.get(organizationDaoRedisImpl, organizationDaoMysqlImpl, id);
	}

	@Override
	public boolean delete(Long id){
		return organizationDaoMysqlImpl.delete(id);
	}
	
	@Override
	public boolean update(Organization organization){
		return organizationDaoMysqlImpl.update(organization);
	}
	
	@Override
	public List<Organization> list(List<Long> idList) {
		return CacheLoader.list(organizationDaoRedisImpl, organizationDaoMysqlImpl, idList);
	}

	@Override
	public Map<Long, Organization> map(Set<Long> idSet){
		return CacheLoader.map(organizationDaoRedisImpl, organizationDaoMysqlImpl, idSet);
	}

	@Override
	public Page<Organization> page(int start, int count){
		return organizationDaoMysqlImpl.page(start, count);
	}
}

