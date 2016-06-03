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
import com.qcloud.component.publicservice.dao.MessageTypeDao;
import com.qcloud.component.publicservice.model.MessageType;
import com.qcloud.component.publicservice.model.query.MessageTypeQuery;

@Repository
public class MessageTypeDaoRedisImpl implements MessageTypeDao {

	//@Resource(name = "redis-publicservice")
	//private Redis redis;

	@Override
	public boolean add(MessageType messageType) {			
		throw new NotImplementedException();
	}

	@Override
	public MessageType get(Long id) {		
		throw new NotImplementedException();
	}
	
	@Override
	public boolean delete(Long id){
		throw new NotImplementedException();
	}
	
	@Override
	public boolean update(MessageType messageType){
		throw new NotImplementedException();
	}
	
	@Override
	public List<MessageType> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, MessageType> map(Set<Long> idSet){
		throw new NotImplementedException();
	}
		
	@Override
	public Page<MessageType> page(int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public Page<MessageType> page(MessageTypeQuery query, int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public List<MessageType> listAll(){	
		throw new NotImplementedException();
	}

    @Override
    public MessageType getByCode(String code) {
        throw new NotImplementedException();
    }
}

