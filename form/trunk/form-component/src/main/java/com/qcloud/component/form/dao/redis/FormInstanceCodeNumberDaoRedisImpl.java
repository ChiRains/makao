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
import com.qcloud.component.form.dao.FormInstanceCodeNumberDao;
import com.qcloud.component.form.model.FormInstanceCodeNumber;
import com.qcloud.component.form.model.query.FormInstanceCodeNumberQuery;

@Repository
public class FormInstanceCodeNumberDaoRedisImpl implements FormInstanceCodeNumberDao {

	//@Resource(name = "redis-form")
	//private Redis redis;

	@Override
	public boolean add(FormInstanceCodeNumber formInstanceCodeNumber) {			
		throw new NotImplementedException();
	}

	@Override
	public FormInstanceCodeNumber get(Long id) {		
		throw new NotImplementedException();
	}
	
	@Override
	public boolean delete(Long id){
		throw new NotImplementedException();
	}
	
	@Override
	public boolean update(FormInstanceCodeNumber formInstanceCodeNumber){
		throw new NotImplementedException();
	}
	
	@Override
	public List<FormInstanceCodeNumber> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, FormInstanceCodeNumber> map(Set<Long> idSet){
		throw new NotImplementedException();
	}
		
	@Override
	public Page<FormInstanceCodeNumber> page(int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public Page<FormInstanceCodeNumber> page(FormInstanceCodeNumberQuery query, int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public List<FormInstanceCodeNumber> listAll(){	
		throw new NotImplementedException();
	}

    @Override
    public FormInstanceCodeNumber getByCode(String code) {
        throw new NotImplementedException();
    }
 
    @Override
    public boolean incr(Long id, long number) {
        throw new NotImplementedException();
    }
}

