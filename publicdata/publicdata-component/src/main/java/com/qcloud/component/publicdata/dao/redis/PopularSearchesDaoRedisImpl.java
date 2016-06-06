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
import com.qcloud.component.publicdata.dao.PopularSearchesDao;
import com.qcloud.component.publicdata.model.PopularSearches;
import com.qcloud.component.publicdata.model.query.PopularSearchesQuery;

@Repository
public class PopularSearchesDaoRedisImpl implements PopularSearchesDao {

	//@Resource(name = "redis-publicdata")
	//private Redis redis;

	@Override
	public boolean add(PopularSearches popularSearches) {			
		throw new NotImplementedException();
	}

	@Override
	public PopularSearches get(Long id) {		
		throw new NotImplementedException();
	}
	
	@Override
	public boolean delete(Long id){
		throw new NotImplementedException();
	}
	
	@Override
	public boolean update(PopularSearches popularSearches){
		throw new NotImplementedException();
	}
	
	@Override
	public List<PopularSearches> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, PopularSearches> map(Set<Long> idSet){
		throw new NotImplementedException();
	}
		
	@Override
	public Page<PopularSearches> page(int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public Page<PopularSearches> page(PopularSearchesQuery query, int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public List<PopularSearches> listAll(){	
		throw new NotImplementedException();
	}

    @Override
    public List<PopularSearches> listTop(int type, int number) {
        throw new NotImplementedException();
    }

    @Override
    public PopularSearches get(int type, String keywords) {
        throw new NotImplementedException();
    }
}

