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
import com.qcloud.project.macaovehicle.dao.ApprovalOutsideDao;
import com.qcloud.project.macaovehicle.model.ApprovalOutside;
import com.qcloud.project.macaovehicle.model.query.ApprovalOutsideQuery;

@Repository
public class ApprovalOutsideDaoRedisImpl implements ApprovalOutsideDao {

	//@Resource(name = "redis-macaovehicle")
	//private Redis redis;

	@Override
	public boolean add(ApprovalOutside approvalOutside) {			
		throw new NotImplementedException();
	}

	@Override
	public ApprovalOutside get(Long id) {		
		throw new NotImplementedException();
	}
	
	@Override
	public boolean delete(Long id){
		throw new NotImplementedException();
	}
	
	@Override
	public boolean update(ApprovalOutside approvalOutside){
		throw new NotImplementedException();
	}
	
	@Override
	public List<ApprovalOutside> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, ApprovalOutside> map(Set<Long> idSet){
		throw new NotImplementedException();
	}
		
	@Override
	public Page<ApprovalOutside> page(int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public Page<ApprovalOutside> page(ApprovalOutsideQuery query, int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public List<ApprovalOutside> listAll(){	
		throw new NotImplementedException();
	}
}

