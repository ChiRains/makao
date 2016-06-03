package com.qcloud.project.macaovehicle.service;

import java.util.List;

import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.model.IllegalPoliceRecord;
import com.qcloud.project.macaovehicle.model.query.IllegalPoliceRecordQuery;

public interface IllegalPoliceRecordService {
	
	public boolean add(IllegalPoliceRecord illegalPoliceRecord);	
	
	public IllegalPoliceRecord get(Long id);
	
	public	boolean delete(Long id);
	
	public	boolean update(IllegalPoliceRecord illegalPoliceRecord);

	public Page<IllegalPoliceRecord> page(IllegalPoliceRecordQuery query, int start, int count);
	
	public List<IllegalPoliceRecord> listAll();
}

