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
import com.qcloud.project.macaovehicle.dao.CarOwnerHousersDao;
import com.qcloud.project.macaovehicle.model.CarOwnerHousers;
import com.qcloud.project.macaovehicle.model.query.CarOwnerHousersQuery;

@Repository
public class CarOwnerHousersDaoRedisImpl implements CarOwnerHousersDao {

	//@Resource(name = "redis-macaovehicle")
	//private Redis redis;

	@Override
	public boolean add(CarOwnerHousers carOwnerHousers) {			
		throw new NotImplementedException();
	}

	@Override
	public CarOwnerHousers get(Long id) {		
		throw new NotImplementedException();
	}
	
	@Override
	public boolean delete(Long id){
		throw new NotImplementedException();
	}
	
	@Override
	public boolean update(CarOwnerHousers carOwnerHousers){
		throw new NotImplementedException();
	}
	
	@Override
	public List<CarOwnerHousers> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, CarOwnerHousers> map(Set<Long> idSet){
		throw new NotImplementedException();
	}
		
	@Override
	public Page<CarOwnerHousers> page(int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public Page<CarOwnerHousers> page(CarOwnerHousersQuery query, int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public List<CarOwnerHousers> listAll(){	
		throw new NotImplementedException();
	}

    @Override
    public CarOwnerHousers getByCarOwner(Long userId) {
        throw new NotImplementedException();
    }
}

