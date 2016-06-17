package com.qcloud.project.macaovehicle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.dao.HistoryUserRecordsDao;
import com.qcloud.project.macaovehicle.model.HistoryUserRecords;
import com.qcloud.project.macaovehicle.service.HistoryUserRecordsService;
import com.qcloud.project.macaovehicle.model.query.HistoryUserRecordsQuery;
		
@Service
public class HistoryUserRecordsServiceImpl implements HistoryUserRecordsService{
	
	@Autowired
	private HistoryUserRecordsDao historyUserRecordsDao;
	
	@Autowired
	private AutoIdGenerator autoIdGenerator;
	
	private static final String ID_KEY = "macaovehicle_history_user_records";

	@Override
	public boolean add(HistoryUserRecords historyUserRecords) {
		long id = autoIdGenerator.get(ID_KEY);
		historyUserRecords.setId(id);
		
		return historyUserRecordsDao.add(historyUserRecords);
	}

	@Override
	public HistoryUserRecords get(Long id) {	
		return historyUserRecordsDao.get(id);		
	}

	@Override
	public boolean delete(Long id) {
		return historyUserRecordsDao.delete(id);
	}
	
	@Override
	public boolean update(HistoryUserRecords historyUserRecords) {
		return historyUserRecordsDao.update(historyUserRecords);
	}
			
	public List<HistoryUserRecords> listByVehicleId(Long vehicleId){
		return historyUserRecordsDao.listByVehicleId(vehicleId);
	}
	
	@Override
	public Page<HistoryUserRecords> page(HistoryUserRecordsQuery query, int start, int count) {
		return historyUserRecordsDao.page(query, start, count);
	}
	
	public List<HistoryUserRecords> listAll(){
		return historyUserRecordsDao.listAll();
	}
}

