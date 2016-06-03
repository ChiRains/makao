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
import com.qcloud.project.macaovehicle.dao.CarCardDao;
import com.qcloud.project.macaovehicle.model.CarCard;
import com.qcloud.project.macaovehicle.model.query.CarCardQuery;

@Repository
public class CarCardDaoRedisImpl implements CarCardDao {

	//@Resource(name = "redis-macaovehicle")
	//private Redis redis;

	@Override
	public boolean add(CarCard carCard) {			
		throw new NotImplementedException();
	}

	@Override
	public CarCard get(Long id) {		
		throw new NotImplementedException();
	}
	
	@Override
	public boolean delete(Long id){
		throw new NotImplementedException();
	}
	
	@Override
	public boolean update(CarCard carCard){
		throw new NotImplementedException();
	}
	
	@Override
	public List<CarCard> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, CarCard> map(Set<Long> idSet){
		throw new NotImplementedException();
	}
		
	@Override
	public Page<CarCard> page(int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public Page<CarCard> page(CarCardQuery query, int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public List<CarCard> listAll(){	
		throw new NotImplementedException();
	}
}

