package com.qcloud.component.piratesship.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.component.piratesship.model.CallMe;
import com.qcloud.component.piratesship.model.query.CallMeQuery;
		
public interface CallMeDao extends ISimpleDao<CallMe, Long> {

	public boolean add(CallMe callMe);	
	
	public CallMe get(Long id);

	public boolean delete(Long id);
	
	public boolean update(CallMe callMe);
	
	public List<CallMe> list(List<Long> idList);
	
	public Map<Long, CallMe> map(Set<Long> idSet);
	
	public Page<CallMe> page(CallMeQuery query, int start, int size);

	public List<CallMe> listAll();
	
}
