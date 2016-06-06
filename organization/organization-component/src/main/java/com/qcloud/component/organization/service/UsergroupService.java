package com.qcloud.component.organization.service;

import java.util.List;

import com.qcloud.pirates.data.Page;
import com.qcloud.component.organization.model.Usergroup;
import com.qcloud.component.organization.model.query.UsergroupQuery;

public interface UsergroupService {
	
	public boolean add(Usergroup usergroup);	
	
	public Usergroup get(Long id);
	
	public	boolean delete(Long id);
	
	public	boolean update(Usergroup usergroup);

	public Page<Usergroup> page(UsergroupQuery query, int start, int count);
	
	public List<Usergroup> listAll();
}

