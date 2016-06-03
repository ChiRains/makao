package com.qcloud.project.macaovehicle.service;

import java.util.List;

import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.model.HistoryRecords;
import com.qcloud.project.macaovehicle.model.query.HistoryRecordsQuery;

public interface HistoryRecordsService {
	
	public boolean add(HistoryRecords historyRecords);	
	
	public HistoryRecords get(Long id);
	
	public	boolean delete(Long id);
	
	public	boolean update(HistoryRecords historyRecords);

	public Page<HistoryRecords> page(HistoryRecordsQuery query, int start, int count);
	
	public List<HistoryRecords> listAll();
}

