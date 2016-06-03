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
import com.qcloud.project.macaovehicle.dao.InstanceMessageDao;
import com.qcloud.project.macaovehicle.model.InstanceMessage;
import com.qcloud.project.macaovehicle.model.query.InstanceMessageQuery;

@Repository
public class InstanceMessageDaoRedisImpl implements InstanceMessageDao {

	//@Resource(name = "redis-macaovehicle")
	//private Redis redis;

	@Override
	public boolean add(InstanceMessage instanceMessage) {			
		throw new NotImplementedException();
	}

	@Override
	public InstanceMessage get(Long id) {		
		throw new NotImplementedException();
	}
	
	@Override
	public boolean delete(Long id){
		throw new NotImplementedException();
	}
	
	@Override
	public boolean update(InstanceMessage instanceMessage){
		throw new NotImplementedException();
	}
	
	@Override
	public List<InstanceMessage> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, InstanceMessage> map(Set<Long> idSet){
		throw new NotImplementedException();
	}
			
																					public List<InstanceMessage> listByFormInstanceId(Long formInstanceId){
					throw new NotImplementedException();
				}

						
																					public List<InstanceMessage> listByMessageCerkId(Long messageCerkId){
					throw new NotImplementedException();
				}

					
	@Override
	public Page<InstanceMessage> page(int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public Page<InstanceMessage> page(InstanceMessageQuery query, int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public List<InstanceMessage> listAll(){	
		throw new NotImplementedException();
	}
}

