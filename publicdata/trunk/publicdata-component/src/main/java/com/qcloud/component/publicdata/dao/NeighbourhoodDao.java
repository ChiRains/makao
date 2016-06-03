package com.qcloud.component.publicdata.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.component.publicdata.model.Neighbourhood;
import com.qcloud.component.publicdata.model.query.NeighbourhoodQuery;
		
public interface NeighbourhoodDao extends ISimpleDao<Neighbourhood, Long> {

	public boolean add(Neighbourhood neighbourhood);	
	
	public Neighbourhood get(Long id);

	public boolean delete(Long id);
	
	public boolean update(Neighbourhood neighbourhood);
	
	public List<Neighbourhood> list(List<Long> idList);
	
	public Map<Long, Neighbourhood> map(Set<Long> idSet);
	
	public Page<Neighbourhood> page(NeighbourhoodQuery query, int start, int size);

	public List<Neighbourhood> listAll();
	
}
