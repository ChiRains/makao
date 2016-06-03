package com.qcloud.component.permission.service;

import com.qcloud.pirates.data.Page;
import com.qcloud.component.permission.model.Organization;

public interface OrganizationService {
	
	public boolean add(Organization organization);	
	
	public Organization get(Long id);
	
	public	boolean delete(Long id);
	
	public	boolean update(Organization organization);

	public Page<Organization> page(int start, int count);
}

