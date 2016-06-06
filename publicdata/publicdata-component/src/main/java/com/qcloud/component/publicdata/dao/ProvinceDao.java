package com.qcloud.component.publicdata.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.component.publicdata.model.Province;
import com.qcloud.component.publicdata.model.query.ProvinceQuery;
		
public interface ProvinceDao extends ISimpleDao<Province, Long> {

	public boolean add(Province province);	
	
	public Province get(Long id);

	public boolean delete(Long id);
	
	public boolean update(Province province);
	
	public List<Province> list(List<Long> idList);
	
	public Map<Long, Province> map(Set<Long> idSet);
	
	public Page<Province> page(ProvinceQuery query, int start, int size);

	public List<Province> listAll();
	
	public Province getByName(String name);	
}
