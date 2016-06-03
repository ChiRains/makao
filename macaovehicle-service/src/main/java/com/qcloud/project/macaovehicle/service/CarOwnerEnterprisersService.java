package com.qcloud.project.macaovehicle.service;

import java.util.List;

import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.model.CarOwnerEnterprisers;
import com.qcloud.project.macaovehicle.model.query.CarOwnerEnterprisersQuery;

public interface CarOwnerEnterprisersService {
	
	public boolean add(CarOwnerEnterprisers carOwnerEnterprisers);	
	
	public CarOwnerEnterprisers get(Long id);
	
	public	boolean delete(Long id);
	
	public	boolean update(CarOwnerEnterprisers carOwnerEnterprisers);

	public Page<CarOwnerEnterprisers> page(CarOwnerEnterprisersQuery query, int start, int count);
	
	public List<CarOwnerEnterprisers> listAll();
	
	public CarOwnerEnterprisers getByCarOwner(Long carOwnerId);
}

