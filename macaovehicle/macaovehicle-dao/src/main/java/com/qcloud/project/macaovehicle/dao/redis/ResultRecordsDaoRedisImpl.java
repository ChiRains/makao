package com.qcloud.project.macaovehicle.dao.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang.NotImplementedException;
import org.springframework.stereotype.Repository;

import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.redis.Redis;
import com.qcloud.project.macaovehicle.dao.ResultRecordsDao;
import com.qcloud.project.macaovehicle.model.ResultRecords;
import com.qcloud.project.macaovehicle.model.query.ResultRecordsQuery;

@Repository
public class ResultRecordsDaoRedisImpl implements ResultRecordsDao {

	//@Resource(name = "redis-macaovehicle")
	//private Redis redis;

	@Override
	public boolean add(ResultRecords resultRecords) {			
		throw new NotImplementedException();
	}

	@Override
	public ResultRecords get(Integer macaovehicleResultRecordsId) {		
		throw new NotImplementedException();
	}
	
	@Override
	public boolean delete(Integer macaovehicleResultRecordsId){
		throw new NotImplementedException();
	}
	
	@Override
	public boolean update(ResultRecords resultRecords){
		throw new NotImplementedException();
	}
	
	@Override
	public List<ResultRecords> list(List<Integer> macaovehicleResultRecordsIdList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Integer, ResultRecords> map(Set<Integer> macaovehicleResultRecordsIdSet){
		throw new NotImplementedException();
	}
		
	@Override
	public Page<ResultRecords> page(int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public Page<ResultRecords> page(ResultRecordsQuery query, int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public List<ResultRecords> listAll(){	
		throw new NotImplementedException();
	}
}

