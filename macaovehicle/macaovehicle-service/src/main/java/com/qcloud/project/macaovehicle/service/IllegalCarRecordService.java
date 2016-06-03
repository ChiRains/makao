package com.qcloud.project.macaovehicle.service;

import java.util.List;

import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.model.IllegalCarRecord;
import com.qcloud.project.macaovehicle.model.query.IllegalCarRecordQuery;

public interface IllegalCarRecordService {
	
	public boolean add(IllegalCarRecord illegalCarRecord);	
	
	public IllegalCarRecord get(Long id);
	
	public	boolean delete(Long id);
	
	public	boolean update(IllegalCarRecord illegalCarRecord);

	public Page<IllegalCarRecord> page(IllegalCarRecordQuery query, int start, int count);
	
	public List<IllegalCarRecord> listAll();
}

