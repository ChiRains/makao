package com.qcloud.project.macaovehicle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.dao.CarCardDao;
import com.qcloud.project.macaovehicle.model.CarCard;
import com.qcloud.project.macaovehicle.service.CarCardService;
import com.qcloud.project.macaovehicle.model.query.CarCardQuery;
		
@Service
public class CarCardServiceImpl implements CarCardService{
	
	@Autowired
	private CarCardDao carCardDao;
	
	@Autowired
	private AutoIdGenerator autoIdGenerator;
	
	private static final String ID_KEY = "macaovehicle_car_card";

	@Override
	public boolean add(CarCard carCard) {
		long id = autoIdGenerator.get(ID_KEY);
		carCard.setId(id);
		
		return carCardDao.add(carCard);
	}

	@Override
	public CarCard get(Long id) {	
		return carCardDao.get(id);		
	}

	@Override
	public boolean delete(Long id) {
		return carCardDao.delete(id);
	}
	
	@Override
	public boolean update(CarCard carCard) {
		return carCardDao.update(carCard);
	}
	
	@Override
	public Page<CarCard> page(CarCardQuery query, int start, int count) {
		return carCardDao.page(query, start, count);
	}
	
	public List<CarCard> listAll(){
		return carCardDao.listAll();
	}
}

