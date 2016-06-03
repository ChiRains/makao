package com.qcloud.project.macaovehicle.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.project.macaovehicle.model.VehicleCancel;
import com.qcloud.project.macaovehicle.model.query.VehicleCancelQuery;
		
public interface VehicleCancelDao extends ISimpleDao<VehicleCancel, Long> {

	public boolean add(VehicleCancel vehicleCancel);	
	
	public VehicleCancel get(Long id);

	public boolean delete(Long id);
	
	public boolean update(VehicleCancel vehicleCancel);
	
	public List<VehicleCancel> list(List<Long> idList);
	
	public Map<Long, VehicleCancel> map(Set<Long> idSet);
	
	public Page<VehicleCancel> page(VehicleCancelQuery query, int start, int size);

	public List<VehicleCancel> listAll();
	
}
