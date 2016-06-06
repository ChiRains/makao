package com.qcloud.component.publicservice.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.publicservice.dao.MessageTypeDao;
import com.qcloud.component.publicservice.model.MessageType;
import com.qcloud.component.publicservice.model.query.MessageTypeQuery;

@Repository
public class MessageTypeDaoCacheImpl implements MessageTypeDao {
	
	@Autowired
	private MessageTypeDao messageTypeDaoMysqlImpl;
	
	@Autowired
	private MessageTypeDao messageTypeDaoRedisImpl;

	@Override
	public boolean add(MessageType messageType) {
		return messageTypeDaoMysqlImpl.add(messageType);
	}

	@Override
	public MessageType get(Long id) {
		return CacheLoader.get(messageTypeDaoRedisImpl, messageTypeDaoMysqlImpl, id);
	}

	@Override
	public boolean delete(Long id){
		return messageTypeDaoMysqlImpl.delete(id);
	}
	
	@Override
	public boolean update(MessageType messageType){
		return messageTypeDaoMysqlImpl.update(messageType);
	}
	
	@Override
	public List<MessageType> list(List<Long> idList) {
		return CacheLoader.list(messageTypeDaoRedisImpl, messageTypeDaoMysqlImpl, idList);
	}

	@Override
	public Map<Long, MessageType> map(Set<Long> idSet){
		return CacheLoader.map(messageTypeDaoRedisImpl, messageTypeDaoMysqlImpl, idSet);
	}

	@Override
	public Page<MessageType> page(int start, int count){
		return messageTypeDaoMysqlImpl.page(start, count);
	}
	
	@Override
	public Page<MessageType> page(MessageTypeQuery query, int start, int count){
		return messageTypeDaoMysqlImpl.page(query, start, count);
	}
	
	public List<MessageType> listAll(){
		return messageTypeDaoMysqlImpl.listAll();
	}

    @Override
    public MessageType getByCode(String code) {
        return messageTypeDaoMysqlImpl.getByCode(code);
    }
}

