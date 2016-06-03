package com.qcloud.project.macaovehicle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.dao.IllegalOwnerRecordDao;
import com.qcloud.project.macaovehicle.model.IllegalOwnerRecord;
import com.qcloud.project.macaovehicle.service.IllegalOwnerRecordService;
import com.qcloud.project.macaovehicle.model.query.IllegalOwnerRecordQuery;
		
@Service
public class IllegalOwnerRecordServiceImpl implements IllegalOwnerRecordService{
	
	@Autowired
	private IllegalOwnerRecordDao illegalOwnerRecordDao;
	
	@Autowired
	private AutoIdGenerator autoIdGenerator;
	
	private static final String ID_KEY = "macaovehicle_illegal_owner_record";

	@Override
	public boolean add(IllegalOwnerRecord illegalOwnerRecord) {
		long id = autoIdGenerator.get(ID_KEY);
		illegalOwnerRecord.setId(id);
		
		return illegalOwnerRecordDao.add(illegalOwnerRecord);
	}

	@Override
	public IllegalOwnerRecord get(Long id) {	
		return illegalOwnerRecordDao.get(id);		
	}

	@Override
	public boolean delete(Long id) {
		return illegalOwnerRecordDao.delete(id);
	}
	
	@Override
	public boolean update(IllegalOwnerRecord illegalOwnerRecord) {
		return illegalOwnerRecordDao.update(illegalOwnerRecord);
	}
	
	@Override
	public Page<IllegalOwnerRecord> page(IllegalOwnerRecordQuery query, int start, int count) {
		return illegalOwnerRecordDao.page(query, start, count);
	}
	
	public List<IllegalOwnerRecord> listAll(){
		return illegalOwnerRecordDao.listAll();
	}
}

