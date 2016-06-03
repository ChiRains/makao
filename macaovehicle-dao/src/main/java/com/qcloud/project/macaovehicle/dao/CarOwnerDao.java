package com.qcloud.project.macaovehicle.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.project.macaovehicle.model.CarOwner;
import com.qcloud.project.macaovehicle.model.query.CarOwnerQuery;
		
public interface CarOwnerDao extends ISimpleDao<CarOwner, Long> {

	public boolean add(CarOwner carOwner);	
	
	public CarOwner get(Long id);

	public boolean delete(Long id);
	
	public boolean update(CarOwner carOwner);
	
	public List<CarOwner> list(List<Long> idList);
	
	public Map<Long, CarOwner> map(Set<Long> idSet);
	
	public Page<CarOwner> page(CarOwnerQuery query, int start, int size);

	public List<CarOwner> listAll();
	
	public CarOwner getByClerk(Long clerkId);

    public CarOwner getByIdcardNumber(String idcardNumber);
	
}
