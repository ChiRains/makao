package com.qcloud.component.publicdata.service;

import java.util.List;

import com.qcloud.pirates.data.Page;
import com.qcloud.component.publicdata.model.Neighbourhood;
import com.qcloud.component.publicdata.model.query.NeighbourhoodQuery;

public interface NeighbourhoodService {
	
	public boolean add(Neighbourhood neighbourhood);	
	
	public Neighbourhood get(Long id);
	
	public	boolean delete(Long id);
	
	public	boolean update(Neighbourhood neighbourhood);

	public Page<Neighbourhood> page(NeighbourhoodQuery query, int start, int count);
	
	public List<Neighbourhood> listAll();
}

