package com.qcloud.project.macaovehicle.service;

import java.util.List;

import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.model.CarCard;
import com.qcloud.project.macaovehicle.model.query.CarCardQuery;

public interface CarCardService {
	
	public boolean add(CarCard carCard);	
	
	public CarCard get(Long id);
	
	public	boolean delete(Long id);
	
	public	boolean update(CarCard carCard);

	public Page<CarCard> page(CarCardQuery query, int start, int count);
	
	public List<CarCard> listAll();
}

