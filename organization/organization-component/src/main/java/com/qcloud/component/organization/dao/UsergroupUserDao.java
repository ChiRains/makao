package com.qcloud.component.organization.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.component.organization.model.UsergroupUser;
import com.qcloud.component.organization.model.query.UsergroupUserQuery;
		
public interface UsergroupUserDao extends ISimpleDao<UsergroupUser, Long> {

	public boolean add(UsergroupUser usergroupUser);	
	
	public UsergroupUser get(Long id);

	public boolean delete(Long id);
	
	public boolean update(UsergroupUser usergroupUser);
	
	public List<UsergroupUser> list(List<Long> idList);
	
	public Map<Long, UsergroupUser> map(Set<Long> idSet);
	
	public Page<UsergroupUser> page(UsergroupUserQuery query, int start, int size);

	public List<UsergroupUser> listAll();
	
	public List<UsergroupUser> getUserByGroupId(long groupId);
	
	public boolean deleteByGroupId(long groupId);
	
}
