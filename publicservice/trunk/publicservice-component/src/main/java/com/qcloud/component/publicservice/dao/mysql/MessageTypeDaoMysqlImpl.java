package com.qcloud.component.publicservice.dao.mysql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.apache.commons.lang.NotImplementedException;

import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.sql.mybatis.SqlOperator;
import com.qcloud.component.publicservice.dao.MessageTypeDao;
import com.qcloud.component.publicservice.model.MessageType;
import com.qcloud.component.publicservice.model.query.MessageTypeQuery;
		
@Repository
public class MessageTypeDaoMysqlImpl implements MessageTypeDao {

	@Resource(name = "sqlOperator-publicservice")
	private SqlOperator sqlOperator;

	@Override
	public boolean add(MessageType messageType) {
		return sqlOperator.insert("com.qcloud.component.publicservice.dao.mysql.mapper.MessageTypeMapper.insert", messageType) == 1;
	}	
	
	@Override
	public MessageType get(Long id) {
		return sqlOperator.selectOne("com.qcloud.component.publicservice.dao.mysql.mapper.MessageTypeMapper.get", id);
	}	
	
	@Override
	public boolean delete(Long id){
		return sqlOperator.delete("com.qcloud.component.publicservice.dao.mysql.mapper.MessageTypeMapper.delete", id) > 0;
	}	
		
	@Override
	public boolean update(MessageType messageType){
		return sqlOperator.update("com.qcloud.component.publicservice.dao.mysql.mapper.MessageTypeMapper.update", messageType) > 0;
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
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		param.put("count", count);

		List<MessageType> list = sqlOperator.selectList(
				"com.qcloud.component.publicservice.dao.mysql.mapper.MessageTypeMapper.list4page",
				param);
		int total = sqlOperator.selectOne(
				"com.qcloud.component.publicservice.dao.mysql.mapper.MessageTypeMapper.count4page",
				param);
		Page<MessageType> page = new Page<MessageType>();
		page.setCount(total);
		page.setData(list);
		return page;
	}
	
	@Override
	public Page<MessageType> page(MessageTypeQuery query, int start, int count){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		param.put("count", count);

		List<MessageType> list = sqlOperator.selectList(
				"com.qcloud.component.publicservice.dao.mysql.mapper.MessageTypeMapper.list4query",
				param);
		int total = sqlOperator.selectOne(
				"com.qcloud.component.publicservice.dao.mysql.mapper.MessageTypeMapper.count4query",
				param);
		Page<MessageType> page = new Page<MessageType>();
		page.setCount(total);
		page.setData(list);
		return page;
	}
	
	@Override
	public List<MessageType> listAll(){	
		List<MessageType> list = sqlOperator.selectList(
				"com.qcloud.component.publicservice.dao.mysql.mapper.MessageTypeMapper.listAll");
		return list;
	}

    @Override
    public MessageType getByCode(String code) {
        return sqlOperator.selectOne("com.qcloud.component.publicservice.dao.mysql.mapper.MessageTypeMapper.getByCode", code);

    }
}

