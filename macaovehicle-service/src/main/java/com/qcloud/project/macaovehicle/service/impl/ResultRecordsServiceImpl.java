package com.qcloud.project.macaovehicle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.dao.ResultRecordsDao;
import com.qcloud.project.macaovehicle.model.ResultRecords;
import com.qcloud.project.macaovehicle.service.ResultRecordsService;
import com.qcloud.project.macaovehicle.model.query.ResultRecordsQuery;
		
@Service
public class ResultRecordsServiceImpl implements ResultRecordsService{
	
	@Autowired
	private ResultRecordsDao resultRecordsDao;
	
	@Autowired
	private AutoIdGenerator autoIdGenerator;
	
	private static final String ID_KEY = "macaovehicle_result_records";

	@Override
	public boolean add(ResultRecords resultRecords) {
		long id = autoIdGenerator.get(ID_KEY);
		resultRecords.setId(id);
		
		return resultRecordsDao.add(resultRecords);
	}

	@Override
	public ResultRecords get(Integer macaovehicleResultRecordsId) {	
		return resultRecordsDao.get(macaovehicleResultRecordsId);		
	}

	@Override
	public boolean delete(Integer macaovehicleResultRecordsId) {
		return resultRecordsDao.delete(macaovehicleResultRecordsId);
	}
	
	@Override
	public boolean update(ResultRecords resultRecords) {
		return resultRecordsDao.update(resultRecords);
	}
	
	@Override
	public Page<ResultRecords> page(ResultRecordsQuery query, int start, int count) {
		return resultRecordsDao.page(query, start, count);
	}
	
	public List<ResultRecords> listAll(){
		return resultRecordsDao.listAll();
	}
}

