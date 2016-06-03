package com.qcloud.project.macaovehicle.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.project.macaovehicle.model.CarOwnerHousers;
import com.qcloud.project.macaovehicle.model.CarOwnerWorkers;
import com.qcloud.project.macaovehicle.model.query.CarOwnerWorkersQuery;
		
public interface CarOwnerWorkersDao extends ISimpleDao<CarOwnerWorkers, Long> {

	public boolean add(CarOwnerWorkers carOwnerWorkers);	
	
	public CarOwnerWorkers get(Long id);

	public boolean delete(Long id);
	
	public boolean update(CarOwnerWorkers carOwnerWorkers);
	
	public List<CarOwnerWorkers> list(List<Long> idList);
	
	public Map<Long, CarOwnerWorkers> map(Set<Long> idSet);
	
	public Page<CarOwnerWorkers> page(CarOwnerWorkersQuery query, int start, int size);

	public List<CarOwnerWorkers> listAll();
	
	public CarOwnerWorkers getByCarOwner(Long userId);
	
}
