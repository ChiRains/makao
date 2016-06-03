package com.qcloud.project.macaovehicle.service;

import java.util.List;

import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.model.PeccancyCar;
import com.qcloud.project.macaovehicle.model.query.PeccancyCarQuery;

public interface PeccancyCarService {
	
	public boolean add(PeccancyCar peccancyCar);	
	
	public PeccancyCar get(Long id);
	
	public	boolean delete(Long id);
	
	public	boolean update(PeccancyCar peccancyCar);

	public Page<PeccancyCar> page(PeccancyCarQuery query, int start, int count);
	
	public List<PeccancyCar> listAll();
}

