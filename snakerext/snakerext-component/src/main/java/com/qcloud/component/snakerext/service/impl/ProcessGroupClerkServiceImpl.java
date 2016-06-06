package com.qcloud.component.snakerext.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.snakerext.dao.ProcessGroupClerkDao;
import com.qcloud.component.snakerext.model.ProcessGroupClerk;
import com.qcloud.component.snakerext.service.ProcessGroupClerkService;
import com.qcloud.component.snakerext.model.query.ProcessGroupClerkQuery;
		
@Service
public class ProcessGroupClerkServiceImpl implements ProcessGroupClerkService{
	
	@Autowired
	private ProcessGroupClerkDao processGroupClerkDao;
	
	@Autowired
	private AutoIdGenerator autoIdGenerator;
	
	private static final String ID_KEY = "snaker_ext_process_group_clerk";

	@Override
	public boolean add(ProcessGroupClerk processGroupClerk) {
		long id = autoIdGenerator.get(ID_KEY);
		processGroupClerk.setId(id);
		
		return processGroupClerkDao.add(processGroupClerk);
	}

	@Override
	public ProcessGroupClerk get(Long id) {	
		return processGroupClerkDao.get(id);		
	}

	@Override
	public boolean delete(Long id) {
		return processGroupClerkDao.delete(id);
	}
	
	@Override
	public boolean update(ProcessGroupClerk processGroupClerk) {
		return processGroupClerkDao.update(processGroupClerk);
	}
	
	@Override
	public Page<ProcessGroupClerk> page(ProcessGroupClerkQuery query, int start, int count) {
		return processGroupClerkDao.page(query, start, count);
	}
	
	public List<ProcessGroupClerk> listAll(){
		return processGroupClerkDao.listAll();
	}

    @Override
    public List<ProcessGroupClerk> listByGroup(Long groupId) {

        return processGroupClerkDao.listByGroup(groupId);
    }

    @Override
    public boolean deleteByGroupId(Long groupId) {

        return processGroupClerkDao.deleteByGroupId(groupId);
    }
}

