package com.qcloud.component.permission.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qcloud.pirates.data.Page;
import com.qcloud.component.permission.dao.OrganizationDao;
import com.qcloud.component.permission.model.Organization;
import com.qcloud.component.permission.service.OrganizationService;
		
@Service
public class OrganizationServiceImpl implements OrganizationService{
	
	@Autowired
	private OrganizationDao organizationDao;

	@Override
	public boolean add(Organization organization) {
		return organizationDao.add(organization);
	}

	@Override
	public Organization get(Long id) {	
		return organizationDao.get(id);		
	}

	@Override
	public boolean delete(Long id) {
		return organizationDao.delete(id);
	}
	
	@Override
	public boolean update(Organization organization) {
		return organizationDao.update(organization);
	}
	
	@Override
	public Page<Organization> page(int start, int count) {
		return organizationDao.page(start, count);
	}
}

