package com.qcloud.project.macaovehicle.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.project.macaovehicle.model.PeccancyCar;
import com.qcloud.project.macaovehicle.model.query.PeccancyCarQuery;
		
public interface PeccancyCarDao extends ISimpleDao<PeccancyCar, Long> {

	public boolean add(PeccancyCar peccancyCar);	
	
	public PeccancyCar get(Long id);

	public boolean delete(Long id);
	
	public boolean update(PeccancyCar peccancyCar);
	
	public List<PeccancyCar> list(List<Long> idList);
	
	public Map<Long, PeccancyCar> map(Set<Long> idSet);
	
	public Page<PeccancyCar> page(PeccancyCarQuery query, int start, int size);

	public List<PeccancyCar> listAll();
	
}
