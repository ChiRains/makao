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
import com.qcloud.project.macaovehicle.dao.VehicleCancelDao;
import com.qcloud.project.macaovehicle.model.VehicleCancel;
import com.qcloud.project.macaovehicle.model.query.VehicleCancelQuery;

@Repository
public class VehicleCancelDaoRedisImpl implements VehicleCancelDao {

	//@Resource(name = "redis-macaovehicle")
	//private Redis redis;

	@Override
	public boolean add(VehicleCancel vehicleCancel) {			
		throw new NotImplementedException();
	}

	@Override
	public VehicleCancel get(Long id) {		
		throw new NotImplementedException();
	}
	
	@Override
	public boolean delete(Long id){
		throw new NotImplementedException();
	}
	
	@Override
	public boolean update(VehicleCancel vehicleCancel){
		throw new NotImplementedException();
	}
	
	@Override
	public List<VehicleCancel> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, VehicleCancel> map(Set<Long> idSet){
		throw new NotImplementedException();
	}
		
	@Override
	public Page<VehicleCancel> page(int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public Page<VehicleCancel> page(VehicleCancelQuery query, int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public List<VehicleCancel> listAll(){	
		throw new NotImplementedException();
	}
}

