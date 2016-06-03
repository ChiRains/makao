package com.qcloud.component.publicdata.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.component.publicdata.model.ExpressDistrict;
import com.qcloud.component.publicdata.model.query.ExpressDistrictQuery;
		
public interface ExpressDistrictDao extends ISimpleDao<ExpressDistrict, Long> {

	public boolean add(ExpressDistrict expressDistrict);	
	
	public ExpressDistrict get(Long id);

	public boolean delete(Long id);
	
	public boolean update(ExpressDistrict expressDistrict);
	
	public List<ExpressDistrict> list(List<Long> idList);
	
	public Map<Long, ExpressDistrict> map(Set<Long> idSet);
	
	public Page<ExpressDistrict> page(ExpressDistrictQuery query, int start, int size);

	public List<ExpressDistrict> listAll();
	
	public List<ExpressDistrict> listByExpressId(Long expressId);
	
}
