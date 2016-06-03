package com.qcloud.component.form.dao.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang.NotImplementedException;
import org.springframework.stereotype.Repository;

import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.redis.Redis;
import com.qcloud.component.form.dao.FormInstanceHistDao;
import com.qcloud.component.form.model.FormInstanceHist;
import com.qcloud.component.form.model.query.FormInstanceHistQuery;

@Repository
public class FormInstanceHistDaoRedisImpl implements FormInstanceHistDao {

	//@Resource(name = "redis-form")
	//private Redis redis;

	@Override
	public boolean add(FormInstanceHist formInstanceHist) {			
		throw new NotImplementedException();
	}

	@Override
	public FormInstanceHist get(Long id) {		
		throw new NotImplementedException();
	}
	
	@Override
	public boolean delete(Long id){
		throw new NotImplementedException();
	}
	
	@Override
	public boolean update(FormInstanceHist formInstanceHist){
		throw new NotImplementedException();
	}
	
	@Override
	public List<FormInstanceHist> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, FormInstanceHist> map(Set<Long> idSet){
		throw new NotImplementedException();
	}
		
	@Override
	public Page<FormInstanceHist> page(int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public Page<FormInstanceHist> page(FormInstanceHistQuery query, int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public List<FormInstanceHist> listAll(){	
		throw new NotImplementedException();
	}
}

