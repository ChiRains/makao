package com.qcloud.component.organization.service;

import java.util.List;

import com.qcloud.pirates.data.Page;
import com.qcloud.component.organization.model.UsergroupUser;
import com.qcloud.component.organization.model.query.UsergroupUserQuery;

public interface UsergroupUserService {
	
	public boolean add(UsergroupUser usergroupUser);	
	
	public UsergroupUser get(Long id);
	
	public	boolean delete(Long id);
	
	public	boolean update(UsergroupUser usergroupUser);

	public Page<UsergroupUser> page(UsergroupUserQuery query, int start, int count);
	
	public List<UsergroupUser> listAll();
	
	 public List<UsergroupUser> getUserByGroupId(long groupId);
	 
	 public boolean deleteByGroupId(long groupId);
}

