package com.qcloud.project.macaovehicle.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.project.macaovehicle.model.ResultRecords;
import com.qcloud.project.macaovehicle.model.query.ResultRecordsQuery;
		
public interface ResultRecordsDao extends ISimpleDao<ResultRecords, Integer> {

	public boolean add(ResultRecords resultRecords);	
	
	public ResultRecords get(Integer macaovehicleResultRecordsId);

	public boolean delete(Integer macaovehicleResultRecordsId);
	
	public boolean update(ResultRecords resultRecords);
	
	public List<ResultRecords> list(List<Integer> macaovehicleResultRecordsIdList);
	
	public Map<Integer, ResultRecords> map(Set<Integer> macaovehicleResultRecordsIdSet);
	
	public Page<ResultRecords> page(ResultRecordsQuery query, int start, int size);

	public List<ResultRecords> listAll();
	
}
