package com.qcloud.project.macaovehicle.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.project.macaovehicle.model.CarCard;
import com.qcloud.project.macaovehicle.model.query.CarCardQuery;
		
public interface CarCardDao extends ISimpleDao<CarCard, Long> {

	public boolean add(CarCard carCard);	
	
	public CarCard get(Long id);

	public boolean delete(Long id);
	
	public boolean update(CarCard carCard);
	
	public List<CarCard> list(List<Long> idList);
	
	public Map<Long, CarCard> map(Set<Long> idSet);
	
	public Page<CarCard> page(CarCardQuery query, int start, int size);

	public List<CarCard> listAll();
	
}
