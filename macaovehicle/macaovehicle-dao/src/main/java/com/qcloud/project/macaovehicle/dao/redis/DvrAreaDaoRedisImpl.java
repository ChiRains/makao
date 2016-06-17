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
import com.qcloud.project.macaovehicle.dao.DvrAreaDao;
import com.qcloud.project.macaovehicle.model.DvrArea;
import com.qcloud.project.macaovehicle.model.query.DvrAreaQuery;

@Repository
public class DvrAreaDaoRedisImpl implements DvrAreaDao {

	//@Resource(name = "redis-macaovehicle")
	//private Redis redis;

	@Override
	public boolean add(DvrArea dvrArea) {			
		throw new NotImplementedException();
	}

	@Override
	public DvrArea get(Long id) {		
		throw new NotImplementedException();
	}
	
	@Override
	public boolean delete(Long id){
		throw new NotImplementedException();
	}
	
	@Override
	public boolean update(DvrArea dvrArea){
		throw new NotImplementedException();
	}
	
	@Override
	public List<DvrArea> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, DvrArea> map(Set<Long> idSet){
		throw new NotImplementedException();
	}
		
	@Override
	public Page<DvrArea> page(int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public Page<DvrArea> page(DvrAreaQuery query, int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public List<DvrArea> listAll(){	
		throw new NotImplementedException();
	}
}

