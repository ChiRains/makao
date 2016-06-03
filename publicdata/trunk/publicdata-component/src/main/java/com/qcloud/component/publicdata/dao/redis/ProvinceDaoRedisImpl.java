package com.qcloud.component.publicdata.dao.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang.NotImplementedException;
import org.springframework.stereotype.Repository;

import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.redis.Redis;
import com.qcloud.component.publicdata.dao.ProvinceDao;
import com.qcloud.component.publicdata.model.Province;
import com.qcloud.component.publicdata.model.query.ProvinceQuery;

@Repository
public class ProvinceDaoRedisImpl implements ProvinceDao {

	//@Resource(name = "redis-publicdata")
	//private Redis redis;

	@Override
	public boolean add(Province province) {			
		throw new NotImplementedException();
	}

	@Override
	public Province get(Long id) {		
		throw new NotImplementedException();
	}
	
	@Override
	public boolean delete(Long id){
		throw new NotImplementedException();
	}
	
	@Override
	public boolean update(Province province){
		throw new NotImplementedException();
	}
	
	@Override
	public List<Province> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, Province> map(Set<Long> idSet){
		throw new NotImplementedException();
	}
		
	@Override
	public Page<Province> page(int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public Page<Province> page(ProvinceQuery query, int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public List<Province> listAll(){	
		throw new NotImplementedException();
	}

    @Override
    public Province getByName(String name) {
        throw new NotImplementedException();
    }
}

