package com.qcloud.project.macaovehicle.service;

import java.util.List;

import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.model.VehicleCancel;
import com.qcloud.project.macaovehicle.model.query.VehicleCancelQuery;

public interface VehicleCancelService {
	
	public boolean add(VehicleCancel vehicleCancel);	
	
	public VehicleCancel get(Long id);
	
	public	boolean delete(Long id);
	
	public	boolean update(VehicleCancel vehicleCancel);

	public Page<VehicleCancel> page(VehicleCancelQuery query, int start, int count);
	
	public List<VehicleCancel> listAll();
}

