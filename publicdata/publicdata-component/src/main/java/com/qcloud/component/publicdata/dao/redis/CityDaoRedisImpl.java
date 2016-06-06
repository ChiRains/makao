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
import com.qcloud.component.publicdata.dao.CityDao;
import com.qcloud.component.publicdata.model.City;
import com.qcloud.component.publicdata.model.query.CityQuery;

@Repository
public class CityDaoRedisImpl implements CityDao {

	//@Resource(name = "redis-publicdata")
	//private Redis redis;

	@Override
	public boolean add(City city) {			
		throw new NotImplementedException();
	}

	@Override
	public City get(Long id) {		
		throw new NotImplementedException();
	}
	
	@Override
	public boolean delete(Long id){
		throw new NotImplementedException();
	}
	
	@Override
	public boolean update(City city){
		throw new NotImplementedException();
	}
	
	@Override
	public List<City> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, City> map(Set<Long> idSet){
		throw new NotImplementedException();
	}
		
	@Override
	public Page<City> page(int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public Page<City> page(CityQuery query, int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public List<City> listAll(){	
		throw new NotImplementedException();
	}

    @Override
    public City getByName(String name) {
        throw new NotImplementedException();
    }

    @Override
    public List<City> listByProvince(long provinceId) {
        throw new NotImplementedException();
    }
}

