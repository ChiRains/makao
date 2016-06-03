package com.qcloud.component.organization.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.organization.dao.UsergroupUserDao;
import com.qcloud.component.organization.model.UsergroupUser;
import com.qcloud.component.organization.service.UsergroupUserService;
import com.qcloud.component.organization.model.query.UsergroupUserQuery;
		
@Service
public class UsergroupUserServiceImpl implements UsergroupUserService{
	
	@Autowired
	private UsergroupUserDao usergroupUserDao;
	
	@Autowired
	private AutoIdGenerator autoIdGenerator;
	
	private static final String ID_KEY = "organization_usergroup_user";

	@Override
	public boolean add(UsergroupUser usergroupUser) {
		long id = autoIdGenerator.get(ID_KEY);
		usergroupUser.setId(id);
		
		return usergroupUserDao.add(usergroupUser);
	}

	@Override
	public UsergroupUser get(Long id) {	
		return usergroupUserDao.get(id);		
	}

	@Override
	public boolean delete(Long id) {
		return usergroupUserDao.delete(id);
	}
	
	@Override
	public boolean update(UsergroupUser usergroupUser) {
		return usergroupUserDao.update(usergroupUser);
	}
	
	@Override
	public Page<UsergroupUser> page(UsergroupUserQuery query, int start, int count) {
		return usergroupUserDao.page(query, start, count);
	}
	
	public List<UsergroupUser> listAll(){
		return usergroupUserDao.listAll();
	}

    @Override
    public List<UsergroupUser> getUserByGroupId(long groupId) {

        return usergroupUserDao.getUserByGroupId(groupId);
    }

    @Override
    public boolean deleteByGroupId(long groupId) {

        return usergroupUserDao.deleteByGroupId(groupId);
    }
}

