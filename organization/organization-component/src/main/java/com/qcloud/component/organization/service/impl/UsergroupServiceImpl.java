package com.qcloud.component.organization.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.organization.dao.UsergroupDao;
import com.qcloud.component.organization.model.Usergroup;
import com.qcloud.component.organization.service.UsergroupService;
import com.qcloud.component.organization.model.query.UsergroupQuery;
		
@Service
public class UsergroupServiceImpl implements UsergroupService{
	
	@Autowired
	private UsergroupDao usergroupDao;
	
	@Autowired
	private AutoIdGenerator autoIdGenerator;
	
	private static final String ID_KEY = "organization_usergroup";

	@Override
	public boolean add(Usergroup usergroup) {
		long id = autoIdGenerator.get(ID_KEY);
		usergroup.setId(id);
		
		return usergroupDao.add(usergroup);
	}

	@Override
	public Usergroup get(Long id) {	
		return usergroupDao.get(id);		
	}

	@Override
	public boolean delete(Long id) {
		return usergroupDao.delete(id);
	}
	
	@Override
	public boolean update(Usergroup usergroup) {
		return usergroupDao.update(usergroup);
	}
	
	@Override
	public Page<Usergroup> page(UsergroupQuery query, int start, int count) {
		return usergroupDao.page(query, start, count);
	}
	
	public List<Usergroup> listAll(){
		return usergroupDao.listAll();
	}
}

