package com.qcloud.project.macaovehicle.service;

import java.util.List;

import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.model.IllegalOwnerRecord;
import com.qcloud.project.macaovehicle.model.query.IllegalOwnerRecordQuery;

public interface IllegalOwnerRecordService {
	
	public boolean add(IllegalOwnerRecord illegalOwnerRecord);	
	
	public IllegalOwnerRecord get(Long id);
	
	public	boolean delete(Long id);
	
	public	boolean update(IllegalOwnerRecord illegalOwnerRecord);

	public Page<IllegalOwnerRecord> page(IllegalOwnerRecordQuery query, int start, int count);
	
	public List<IllegalOwnerRecord> listAll();
}

