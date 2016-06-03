package com.qcloud.project.macaovehicle.service;

import java.util.List;

import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.model.CarOwnerHousers;
import com.qcloud.project.macaovehicle.model.query.CarOwnerHousersQuery;

public interface CarOwnerHousersService {
	
	public boolean add(CarOwnerHousers carOwnerHousers);	
	
	public CarOwnerHousers get(Long id);
	
	public	boolean delete(Long id);
	
	public	boolean update(CarOwnerHousers carOwnerHousers);

	public Page<CarOwnerHousers> page(CarOwnerHousersQuery query, int start, int count);
	
	public List<CarOwnerHousers> listAll();
	
	public CarOwnerHousers getByCarOwner(Long userId);
}

