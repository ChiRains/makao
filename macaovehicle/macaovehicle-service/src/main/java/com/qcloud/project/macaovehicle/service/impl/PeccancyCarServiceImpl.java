package com.qcloud.project.macaovehicle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.dao.PeccancyCarDao;
import com.qcloud.project.macaovehicle.model.PeccancyCar;
import com.qcloud.project.macaovehicle.service.PeccancyCarService;
import com.qcloud.project.macaovehicle.model.query.PeccancyCarQuery;
		
@Service
public class PeccancyCarServiceImpl implements PeccancyCarService{
	
	@Autowired
	private PeccancyCarDao peccancyCarDao;
	
	@Autowired
	private AutoIdGenerator autoIdGenerator;
	
	private static final String ID_KEY = "macaovehicle_peccancy_car";

	@Override
	public boolean add(PeccancyCar peccancyCar) {
		long id = autoIdGenerator.get(ID_KEY);
		peccancyCar.setId(id);
		
		return peccancyCarDao.add(peccancyCar);
	}

	@Override
	public PeccancyCar get(Long id) {	
		return peccancyCarDao.get(id);		
	}

	@Override
	public boolean delete(Long id) {
		return peccancyCarDao.delete(id);
	}
	
	@Override
	public boolean update(PeccancyCar peccancyCar) {
		return peccancyCarDao.update(peccancyCar);
	}
	
	@Override
	public Page<PeccancyCar> page(PeccancyCarQuery query, int start, int count) {
		return peccancyCarDao.page(query, start, count);
	}
	
	public List<PeccancyCar> listAll(){
		return peccancyCarDao.listAll();
	}
}

