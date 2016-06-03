package com.qcloud.project.macaovehicle.service;

import java.util.List;

import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.model.CarOwnerPurchase;
import com.qcloud.project.macaovehicle.model.query.CarOwnerPurchaseQuery;

public interface CarOwnerPurchaseService {
	
	public boolean add(CarOwnerPurchase carOwnerPurchase);	
	
	public CarOwnerPurchase get(Long id);
	
	public	boolean delete(Long id);
	
	public	boolean update(CarOwnerPurchase carOwnerPurchase);

	public Page<CarOwnerPurchase> page(CarOwnerPurchaseQuery query, int start, int count);
	
	public List<CarOwnerPurchase> listAll();
	
	public CarOwnerPurchase getByCarOwner(Long carOwnerId);
}

