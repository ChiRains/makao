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
import com.qcloud.project.macaovehicle.dao.PeccancyCarDao;
import com.qcloud.project.macaovehicle.model.PeccancyCar;
import com.qcloud.project.macaovehicle.model.query.PeccancyCarQuery;

@Repository
public class PeccancyCarDaoRedisImpl implements PeccancyCarDao {

	//@Resource(name = "redis-macaovehicle")
	//private Redis redis;

	@Override
	public boolean add(PeccancyCar peccancyCar) {			
		throw new NotImplementedException();
	}

	@Override
	public PeccancyCar get(Long id) {		
		throw new NotImplementedException();
	}
	
	@Override
	public boolean delete(Long id){
		throw new NotImplementedException();
	}
	
	@Override
	public boolean update(PeccancyCar peccancyCar){
		throw new NotImplementedException();
	}
	
	@Override
	public List<PeccancyCar> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, PeccancyCar> map(Set<Long> idSet){
		throw new NotImplementedException();
	}
		
	@Override
	public Page<PeccancyCar> page(int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public Page<PeccancyCar> page(PeccancyCarQuery query, int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public List<PeccancyCar> listAll(){	
		throw new NotImplementedException();
	}
}

