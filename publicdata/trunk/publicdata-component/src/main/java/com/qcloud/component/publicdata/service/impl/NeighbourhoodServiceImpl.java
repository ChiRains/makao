package com.qcloud.component.publicdata.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.publicdata.dao.NeighbourhoodDao;
import com.qcloud.component.publicdata.model.Neighbourhood;
import com.qcloud.component.publicdata.service.NeighbourhoodService;
import com.qcloud.component.publicdata.model.query.NeighbourhoodQuery;
		
@Service
public class NeighbourhoodServiceImpl implements NeighbourhoodService{
	
	@Autowired
	private NeighbourhoodDao neighbourhoodDao;
	
	@Autowired
	private AutoIdGenerator autoIdGenerator;
	
	private static final String ID_KEY = "publicdata_neighbourhood";

	@Override
	public boolean add(Neighbourhood neighbourhood) {
		long id = autoIdGenerator.get(ID_KEY);
		neighbourhood.setId(id);
		
		return neighbourhoodDao.add(neighbourhood);
	}

	@Override
	public Neighbourhood get(Long id) {	
		return neighbourhoodDao.get(id);		
	}

	@Override
	public boolean delete(Long id) {
		return neighbourhoodDao.delete(id);
	}
	
	@Override
	public boolean update(Neighbourhood neighbourhood) {
		return neighbourhoodDao.update(neighbourhood);
	}
	
	@Override
	public Page<Neighbourhood> page(NeighbourhoodQuery query, int start, int count) {
		return neighbourhoodDao.page(query, start, count);
	}
	
	public List<Neighbourhood> listAll(){
		return neighbourhoodDao.listAll();
	}
}

