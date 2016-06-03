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
import com.qcloud.project.macaovehicle.dao.CarOwnerDao;
import com.qcloud.project.macaovehicle.model.CarOwner;
import com.qcloud.project.macaovehicle.model.query.CarOwnerQuery;

@Repository
public class CarOwnerDaoRedisImpl implements CarOwnerDao {

	//@Resource(name = "redis-macaovehicle")
	//private Redis redis;

	@Override
	public boolean add(CarOwner carOwner) {			
		throw new NotImplementedException();
	}

	@Override
	public CarOwner get(Long id) {		
		throw new NotImplementedException();
	}
	
	@Override
	public boolean delete(Long id){
		throw new NotImplementedException();
	}
	
	@Override
	public boolean update(CarOwner carOwner){
		throw new NotImplementedException();
	}
	
	@Override
	public List<CarOwner> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, CarOwner> map(Set<Long> idSet){
		throw new NotImplementedException();
	}
		
	@Override
	public Page<CarOwner> page(int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public Page<CarOwner> page(CarOwnerQuery query, int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public List<CarOwner> listAll(){	
		throw new NotImplementedException();
	}

    @Override
    public CarOwner getByClerk(Long clerkId) {

        throw new NotImplementedException();
    }

    @Override
    public CarOwner getByIdcardNumber(String idcardNumber) {

        throw new NotImplementedException();
    }
}

