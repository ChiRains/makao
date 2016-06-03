package com.qcloud.project.macaovehicle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.dao.HistoryRecordsDao;
import com.qcloud.project.macaovehicle.model.HistoryRecords;
import com.qcloud.project.macaovehicle.service.HistoryRecordsService;
import com.qcloud.project.macaovehicle.model.query.HistoryRecordsQuery;
		
@Service
public class HistoryRecordsServiceImpl implements HistoryRecordsService{
	
	@Autowired
	private HistoryRecordsDao historyRecordsDao;
	
	@Autowired
	private AutoIdGenerator autoIdGenerator;
	
	private static final String ID_KEY = "macaovehicle_history_records";

	@Override
	public boolean add(HistoryRecords historyRecords) {
		long id = autoIdGenerator.get(ID_KEY);
		historyRecords.setId(id);
		
		return historyRecordsDao.add(historyRecords);
	}

	@Override
	public HistoryRecords get(Long id) {	
		return historyRecordsDao.get(id);		
	}

	@Override
	public boolean delete(Long id) {
		return historyRecordsDao.delete(id);
	}
	
	@Override
	public boolean update(HistoryRecords historyRecords) {
		return historyRecordsDao.update(historyRecords);
	}
	
	@Override
	public Page<HistoryRecords> page(HistoryRecordsQuery query, int start, int count) {
		return historyRecordsDao.page(query, start, count);
	}
	
	public List<HistoryRecords> listAll(){
		return historyRecordsDao.listAll();
	}
}

