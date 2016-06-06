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
import com.qcloud.component.publicdata.dao.NeighbourhoodDao;
import com.qcloud.component.publicdata.model.Neighbourhood;
import com.qcloud.component.publicdata.model.query.NeighbourhoodQuery;

@Repository
public class NeighbourhoodDaoRedisImpl implements NeighbourhoodDao {

	//@Resource(name = "redis-publicdata")
	//private Redis redis;

	@Override
	public boolean add(Neighbourhood neighbourhood) {			
		throw new NotImplementedException();
	}

	@Override
	public Neighbourhood get(Long id) {		
		throw new NotImplementedException();
	}
	
	@Override
	public boolean delete(Long id){
		throw new NotImplementedException();
	}
	
	@Override
	public boolean update(Neighbourhood neighbourhood){
		throw new NotImplementedException();
	}
	
	@Override
	public List<Neighbourhood> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, Neighbourhood> map(Set<Long> idSet){
		throw new NotImplementedException();
	}
		
	@Override
	public Page<Neighbourhood> page(int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public Page<Neighbourhood> page(NeighbourhoodQuery query, int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public List<Neighbourhood> listAll(){	
		throw new NotImplementedException();
	}
}

