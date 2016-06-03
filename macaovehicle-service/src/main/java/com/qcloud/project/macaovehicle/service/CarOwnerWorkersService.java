package com.qcloud.project.macaovehicle.service;

import java.util.List;

import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.model.CarOwnerWorkers;
import com.qcloud.project.macaovehicle.model.query.CarOwnerWorkersQuery;

public interface CarOwnerWorkersService {
	
	public boolean add(CarOwnerWorkers carOwnerWorkers);	
	
	public CarOwnerWorkers get(Long id);
	
	public	boolean delete(Long id);
	
	public	boolean update(CarOwnerWorkers carOwnerWorkers);

	public Page<CarOwnerWorkers> page(CarOwnerWorkersQuery query, int start, int count);
	
	public List<CarOwnerWorkers> listAll();
	
	public CarOwnerWorkers getByCarOwner(Long carOwnerId);
}

