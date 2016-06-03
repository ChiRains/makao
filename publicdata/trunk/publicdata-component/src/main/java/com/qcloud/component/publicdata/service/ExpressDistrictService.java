package com.qcloud.component.publicdata.service;

import java.util.List;

import com.qcloud.pirates.data.Page;
import com.qcloud.component.publicdata.model.ExpressDistrict;
import com.qcloud.component.publicdata.model.query.ExpressDistrictQuery;

public interface ExpressDistrictService {
	
	public boolean add(ExpressDistrict expressDistrict);	
	
	public ExpressDistrict get(Long id);
	
	public	boolean delete(Long id);
	
	public	boolean update(ExpressDistrict expressDistrict);

	public Page<ExpressDistrict> page(ExpressDistrictQuery query, int start, int count);
	
	public List<ExpressDistrict> listAll();
	
	public List<ExpressDistrict> listByExpressId(Long expressId);
}

