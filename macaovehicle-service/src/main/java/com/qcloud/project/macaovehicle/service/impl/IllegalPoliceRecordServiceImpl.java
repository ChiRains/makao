package com.qcloud.project.macaovehicle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.dao.IllegalPoliceRecordDao;
import com.qcloud.project.macaovehicle.model.IllegalPoliceRecord;
import com.qcloud.project.macaovehicle.service.IllegalPoliceRecordService;
import com.qcloud.project.macaovehicle.model.query.IllegalPoliceRecordQuery;
		
@Service
public class IllegalPoliceRecordServiceImpl implements IllegalPoliceRecordService{
	
	@Autowired
	private IllegalPoliceRecordDao illegalPoliceRecordDao;
	
	@Autowired
	private AutoIdGenerator autoIdGenerator;
	
	private static final String ID_KEY = "macaovehicle_illegal_police_record";

	@Override
	public boolean add(IllegalPoliceRecord illegalPoliceRecord) {
		long id = autoIdGenerator.get(ID_KEY);
		illegalPoliceRecord.setId(id);
		
		return illegalPoliceRecordDao.add(illegalPoliceRecord);
	}

	@Override
	public IllegalPoliceRecord get(Long id) {	
		return illegalPoliceRecordDao.get(id);		
	}

	@Override
	public boolean delete(Long id) {
		return illegalPoliceRecordDao.delete(id);
	}
	
	@Override
	public boolean update(IllegalPoliceRecord illegalPoliceRecord) {
		return illegalPoliceRecordDao.update(illegalPoliceRecord);
	}
	
	@Override
	public Page<IllegalPoliceRecord> page(IllegalPoliceRecordQuery query, int start, int count) {
		return illegalPoliceRecordDao.page(query, start, count);
	}
	
	public List<IllegalPoliceRecord> listAll(){
		return illegalPoliceRecordDao.listAll();
	}
}

