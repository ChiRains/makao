package com.qcloud.component.organization.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.component.organization.model.Usergroup;
import com.qcloud.component.organization.model.query.UsergroupQuery;
		
public interface UsergroupDao extends ISimpleDao<Usergroup, Long> {

	public boolean add(Usergroup usergroup);	
	
	public Usergroup get(Long id);

	public boolean delete(Long id);
	
	public boolean update(Usergroup usergroup);
	
	public List<Usergroup> list(List<Long> idList);
	
	public Map<Long, Usergroup> map(Set<Long> idSet);
	
	public Page<Usergroup> page(UsergroupQuery query, int start, int size);

	public List<Usergroup> listAll();
	
}
