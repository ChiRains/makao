package com.qcloud.component.publicdata.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;
import com.qcloud.component.publicdata.model.City;
import com.qcloud.component.publicdata.model.query.CityQuery;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
		
public interface CityDao extends ISimpleDao<City, Long> {

	public boolean add(City city);	
	
	public City get(Long id);

	public boolean delete(Long id);
	
	public boolean update(City city);
	
	public List<City> list(List<Long> idList);
	
	public Map<Long, City> map(Set<Long> idSet);
	
	public Page<City> page(CityQuery query, int start, int size);

	public List<City> listAll();
	
	public City getByName(String name);  
	
	public List<City> listByProvince(long provinceId);
}
