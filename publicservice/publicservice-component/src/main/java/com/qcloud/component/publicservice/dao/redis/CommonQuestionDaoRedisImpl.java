package com.qcloud.component.publicservice.dao.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang.NotImplementedException;
import org.springframework.stereotype.Repository;

import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.redis.Redis;
import com.qcloud.component.publicservice.dao.CommonQuestionDao;
import com.qcloud.component.publicservice.model.CommonQuestion;
import com.qcloud.component.publicservice.model.query.CommonQuestionQuery;

@Repository
public class CommonQuestionDaoRedisImpl implements CommonQuestionDao {

	//@Resource(name = "redis-publicservice")
	//private Redis redis;

	@Override
	public boolean add(CommonQuestion commonQuestion) {			
		throw new NotImplementedException();
	}

	@Override
	public CommonQuestion get(Long id) {		
		throw new NotImplementedException();
	}
	
	@Override
	public boolean delete(Long id){
		throw new NotImplementedException();
	}
	
	@Override
	public boolean update(CommonQuestion commonQuestion){
		throw new NotImplementedException();
	}
	
	@Override
	public List<CommonQuestion> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, CommonQuestion> map(Set<Long> idSet){
		throw new NotImplementedException();
	}
		
	@Override
	public Page<CommonQuestion> page(int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public Page<CommonQuestion> page(CommonQuestionQuery query, int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public List<CommonQuestion> listAll(){	
		throw new NotImplementedException();
	}

	@Override
	public CommonQuestion listBySortNo(int sortNo) {
		throw new NotImplementedException();
	}
}

