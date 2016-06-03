package com.qcloud.project.macaovehicle.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.dao.VehicleCancelDao;
import com.qcloud.project.macaovehicle.model.VehicleCancel;
import com.qcloud.project.macaovehicle.model.query.VehicleCancelQuery;

@Repository
public class VehicleCancelDaoCacheImpl implements VehicleCancelDao {
	
	@Autowired
	private VehicleCancelDao vehicleCancelDaoMysqlImpl;
	
	@Autowired
	private VehicleCancelDao vehicleCancelDaoRedisImpl;

	@Override
	public boolean add(VehicleCancel vehicleCancel) {
		return vehicleCancelDaoMysqlImpl.add(vehicleCancel);
	}

	@Override
	public VehicleCancel get(Long id) {
	    return vehicleCancelDaoMysqlImpl.get(id);
//		return CacheLoader.get(vehicleCancelDaoRedisImpl, vehicleCancelDaoMysqlImpl, id);
	}

	@Override
	public boolean delete(Long id){
		return vehicleCancelDaoMysqlImpl.delete(id);
	}
	
	@Override
	public boolean update(VehicleCancel vehicleCancel){
		return vehicleCancelDaoMysqlImpl.update(vehicleCancel);
	}
	
	@Override
	public List<VehicleCancel> list(List<Long> idList) {
		return CacheLoader.list(vehicleCancelDaoRedisImpl, vehicleCancelDaoMysqlImpl, idList);
	}

	@Override
	public Map<Long, VehicleCancel> map(Set<Long> idSet){
		return CacheLoader.map(vehicleCancelDaoRedisImpl, vehicleCancelDaoMysqlImpl, idSet);
	}

	@Override
	public Page<VehicleCancel> page(int start, int count){
		return vehicleCancelDaoMysqlImpl.page(start, count);
	}
	
	@Override
	public Page<VehicleCancel> page(VehicleCancelQuery query, int start, int count){
		return vehicleCancelDaoMysqlImpl.page(query, start, count);
	}
	
	public List<VehicleCancel> listAll(){
		return vehicleCancelDaoMysqlImpl.listAll();
	}
}

