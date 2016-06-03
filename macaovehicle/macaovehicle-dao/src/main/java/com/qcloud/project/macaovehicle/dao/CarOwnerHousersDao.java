package com.qcloud.project.macaovehicle.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.project.macaovehicle.model.CarOwnerHousers;
import com.qcloud.project.macaovehicle.model.query.CarOwnerHousersQuery;
		
public interface CarOwnerHousersDao extends ISimpleDao<CarOwnerHousers, Long> {

	public boolean add(CarOwnerHousers carOwnerHousers);	
	
	public CarOwnerHousers get(Long id);

	public boolean delete(Long id);
	
	public boolean update(CarOwnerHousers carOwnerHousers);
	
	public List<CarOwnerHousers> list(List<Long> idList);
	
	public Map<Long, CarOwnerHousers> map(Set<Long> idSet);
	
	public Page<CarOwnerHousers> page(CarOwnerHousersQuery query, int start, int size);

	public List<CarOwnerHousers> listAll();
	
	public CarOwnerHousers getByCarOwner(Long userId);
	
}
