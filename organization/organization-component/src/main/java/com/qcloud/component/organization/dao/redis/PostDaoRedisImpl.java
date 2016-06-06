package com.qcloud.component.organization.dao.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang.NotImplementedException;
import org.springframework.stereotype.Repository;

import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.redis.Redis;
import com.qcloud.component.organization.dao.PostDao;
import com.qcloud.component.organization.model.Post;
import com.qcloud.component.organization.model.query.PostQuery;

@Repository
public class PostDaoRedisImpl implements PostDao {

	//@Resource(name = "redis-organization")
	//private Redis redis;

	@Override
	public boolean add(Post post) {			
		throw new NotImplementedException();
	}

	@Override
	public Post get(Long id) {		
		throw new NotImplementedException();
	}
	
	@Override
	public boolean delete(Long id){
		throw new NotImplementedException();
	}
	
	@Override
	public boolean update(Post post){
		throw new NotImplementedException();
	}
	
	@Override
	public List<Post> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, Post> map(Set<Long> idSet){
		throw new NotImplementedException();
	}
		
	@Override
	public Page<Post> page(int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public Page<Post> page(PostQuery query, int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public List<Post> listAll(){	
		throw new NotImplementedException();
	}
}

