package com.qcloud.component.piratesship.service;

import java.util.List;

import com.qcloud.pirates.data.Page;
import com.qcloud.component.piratesship.model.CallMe;
import com.qcloud.component.piratesship.model.query.CallMeQuery;

public interface CallMeService {
	
	public boolean add(CallMe callMe);	
	
	public CallMe get(Long id);
	
	public	boolean delete(Long id);
	
	public	boolean update(CallMe callMe);

	public Page<CallMe> page(CallMeQuery query, int start, int count);
	
	public List<CallMe> listAll();
	
	public List<String> listCallMember();
}

