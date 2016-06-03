package com.qcloud.project.macaovehicle.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.dao.ResultRecordsDao;
import com.qcloud.project.macaovehicle.model.ResultRecords;
import com.qcloud.project.macaovehicle.model.query.ResultRecordsQuery;

@Repository
public class ResultRecordsDaoCacheImpl implements ResultRecordsDao {
	
	@Autowired
	private ResultRecordsDao resultRecordsDaoMysqlImpl;
	
	@Autowired
	private ResultRecordsDao resultRecordsDaoRedisImpl;

	@Override
	public boolean add(ResultRecords resultRecords) {
		return resultRecordsDaoMysqlImpl.add(resultRecords);
	}

	@Override
	public ResultRecords get(Integer macaovehicleResultRecordsId) {
		return resultRecordsDaoMysqlImpl.get(macaovehicleResultRecordsId);
	}

	@Override
	public boolean delete(Integer macaovehicleResultRecordsId){
		return resultRecordsDaoMysqlImpl.delete(macaovehicleResultRecordsId);
	}
	
	@Override
	public boolean update(ResultRecords resultRecords){
		return resultRecordsDaoMysqlImpl.update(resultRecords);
	}
	
	@Override
	public List<ResultRecords> list(List<Integer> macaovehicleResultRecordsIdList) {
		return CacheLoader.list(resultRecordsDaoRedisImpl, resultRecordsDaoMysqlImpl, macaovehicleResultRecordsIdList);
	}

	@Override
	public Map<Integer, ResultRecords> map(Set<Integer> macaovehicleResultRecordsIdSet){
		return CacheLoader.map(resultRecordsDaoRedisImpl, resultRecordsDaoMysqlImpl, macaovehicleResultRecordsIdSet);
	}

	@Override
	public Page<ResultRecords> page(int start, int count){
		return resultRecordsDaoMysqlImpl.page(start, count);
	}
	
	@Override
	public Page<ResultRecords> page(ResultRecordsQuery query, int start, int count){
		return resultRecordsDaoMysqlImpl.page(query, start, count);
	}
	
	public List<ResultRecords> listAll(){
		return resultRecordsDaoMysqlImpl.listAll();
	}
}

