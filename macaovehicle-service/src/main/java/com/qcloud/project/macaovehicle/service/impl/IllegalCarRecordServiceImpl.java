package com.qcloud.project.macaovehicle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.dao.IllegalCarRecordDao;
import com.qcloud.project.macaovehicle.model.IllegalCarRecord;
import com.qcloud.project.macaovehicle.service.IllegalCarRecordService;
import com.qcloud.project.macaovehicle.model.query.IllegalCarRecordQuery;
		
@Service
public class IllegalCarRecordServiceImpl implements IllegalCarRecordService{
	
	@Autowired
	private IllegalCarRecordDao illegalCarRecordDao;
	
	@Autowired
	private AutoIdGenerator autoIdGenerator;
	
	private static final String ID_KEY = "macaovehicle_illegal_car_record";

	@Override
	public boolean add(IllegalCarRecord illegalCarRecord) {
		long id = autoIdGenerator.get(ID_KEY);
		illegalCarRecord.setId(id);
		
		return illegalCarRecordDao.add(illegalCarRecord);
	}

	@Override
	public IllegalCarRecord get(Long id) {	
		return illegalCarRecordDao.get(id);		
	}

	@Override
	public boolean delete(Long id) {
		return illegalCarRecordDao.delete(id);
	}
	
	@Override
	public boolean update(IllegalCarRecord illegalCarRecord) {
		return illegalCarRecordDao.update(illegalCarRecord);
	}
	
	@Override
	public Page<IllegalCarRecord> page(IllegalCarRecordQuery query, int start, int count) {
		return illegalCarRecordDao.page(query, start, count);
	}
	
	public List<IllegalCarRecord> listAll(){
		return illegalCarRecordDao.listAll();
	}
}

