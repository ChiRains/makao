package com.qcloud.project.macaovehicle.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.dao.InstanceMessageDao;
import com.qcloud.project.macaovehicle.model.InstanceMessage;
import com.qcloud.project.macaovehicle.model.query.InstanceMessageQuery;

@Repository
public class InstanceMessageDaoCacheImpl implements InstanceMessageDao {
	
	@Autowired
	private InstanceMessageDao instanceMessageDaoMysqlImpl;
	
	@Autowired
	private InstanceMessageDao instanceMessageDaoRedisImpl;

	@Override
	public boolean add(InstanceMessage instanceMessage) {
		return instanceMessageDaoMysqlImpl.add(instanceMessage);
	}

	@Override
	public InstanceMessage get(Long id) {
		return CacheLoader.get(instanceMessageDaoRedisImpl, instanceMessageDaoMysqlImpl, id);
	}

	@Override
	public boolean delete(Long id){
		return instanceMessageDaoMysqlImpl.delete(id);
	}
	
	@Override
	public boolean update(InstanceMessage instanceMessage){
		return instanceMessageDaoMysqlImpl.update(instanceMessage);
	}
	
	@Override
	public List<InstanceMessage> list(List<Long> idList) {
		return CacheLoader.list(instanceMessageDaoRedisImpl, instanceMessageDaoMysqlImpl, idList);
	}

	@Override
	public Map<Long, InstanceMessage> map(Set<Long> idSet){
		return CacheLoader.map(instanceMessageDaoRedisImpl, instanceMessageDaoMysqlImpl, idSet);
	}
			
		public List<InstanceMessage> listByFormInstanceId(Long formInstanceId){
			return instanceMessageDaoMysqlImpl.listByFormInstanceId(formInstanceId);
		}
				
		public List<InstanceMessage> listByMessageCerkId(Long messageCerkId){
			return instanceMessageDaoMysqlImpl.listByMessageCerkId(messageCerkId);
		}
	
	@Override
	public Page<InstanceMessage> page(int start, int count){
		return instanceMessageDaoMysqlImpl.page(start, count);
	}
	
	@Override
	public Page<InstanceMessage> page(InstanceMessageQuery query, int start, int count){
		return instanceMessageDaoMysqlImpl.page(query, start, count);
	}
	
	public List<InstanceMessage> listAll(){
		return instanceMessageDaoMysqlImpl.listAll();
	}
}

