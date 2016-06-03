package com.qcloud.project.macaovehicle.service;

import java.util.List;

import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.model.ResultRecords;
import com.qcloud.project.macaovehicle.model.query.ResultRecordsQuery;

public interface ResultRecordsService {
	
	public boolean add(ResultRecords resultRecords);	
	
	public ResultRecords get(Integer macaovehicleResultRecordsId);
	
	public	boolean delete(Integer macaovehicleResultRecordsId);
	
	public	boolean update(ResultRecords resultRecords);

	public Page<ResultRecords> page(ResultRecordsQuery query, int start, int count);
	
	public List<ResultRecords> listAll();
}

