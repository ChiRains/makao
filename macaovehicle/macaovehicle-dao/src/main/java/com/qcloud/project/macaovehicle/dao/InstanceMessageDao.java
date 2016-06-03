package com.qcloud.project.macaovehicle.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.project.macaovehicle.model.InstanceMessage;
import com.qcloud.project.macaovehicle.model.query.InstanceMessageQuery;
		
public interface InstanceMessageDao extends ISimpleDao<InstanceMessage, Long> {

	public boolean add(InstanceMessage instanceMessage);	
	
	public InstanceMessage get(Long id);

	public boolean delete(Long id);
	
	public boolean update(InstanceMessage instanceMessage);
	
	public List<InstanceMessage> list(List<Long> idList);
	
	public Map<Long, InstanceMessage> map(Set<Long> idSet);
	
	public Page<InstanceMessage> page(InstanceMessageQuery query, int start, int size);

	public List<InstanceMessage> listAll();
	
	public List<InstanceMessage> listByFormInstanceId(Long formInstanceId);

	public List<InstanceMessage> listByMessageCerkId(Long messageCerkId);

}
