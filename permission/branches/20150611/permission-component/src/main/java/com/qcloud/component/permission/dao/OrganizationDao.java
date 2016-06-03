package com.qcloud.component.permission.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.component.permission.model.Organization;
		
public interface OrganizationDao extends ISimpleDao<Organization, Long> {

	public boolean add(Organization organization);	
	
	public Organization get(Long id);

	public boolean delete(Long id);
	
	public boolean update(Organization organization);
	
	public List<Organization> list(List<Long> idList);
	
	public Map<Long, Organization> map(Set<Long> idSet);
	
	public Page<Organization> page(int start, int size);

}
