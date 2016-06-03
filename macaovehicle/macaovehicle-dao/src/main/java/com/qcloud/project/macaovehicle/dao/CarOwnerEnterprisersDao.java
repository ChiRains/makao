package com.qcloud.project.macaovehicle.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.project.macaovehicle.model.CarOwnerEnterprisers;
import com.qcloud.project.macaovehicle.model.CarOwnerHousers;
import com.qcloud.project.macaovehicle.model.query.CarOwnerEnterprisersQuery;
		
public interface CarOwnerEnterprisersDao extends ISimpleDao<CarOwnerEnterprisers, Long> {

	public boolean add(CarOwnerEnterprisers carOwnerEnterprisers);	
	
	public CarOwnerEnterprisers get(Long id);

	public boolean delete(Long id);
	
	public boolean update(CarOwnerEnterprisers carOwnerEnterprisers);
	
	public List<CarOwnerEnterprisers> list(List<Long> idList);
	
	public Map<Long, CarOwnerEnterprisers> map(Set<Long> idSet);
	
	public Page<CarOwnerEnterprisers> page(CarOwnerEnterprisersQuery query, int start, int size);

	public List<CarOwnerEnterprisers> listAll();
	
	public CarOwnerEnterprisers getByCarOwner(Long userId);
	
}
