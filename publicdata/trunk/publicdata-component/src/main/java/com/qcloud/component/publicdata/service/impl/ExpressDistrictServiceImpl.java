package com.qcloud.component.publicdata.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.publicdata.dao.ExpressDistrictDao;
import com.qcloud.component.publicdata.model.ExpressDistrict;
import com.qcloud.component.publicdata.service.ExpressDistrictService;
import com.qcloud.component.publicdata.model.query.ExpressDistrictQuery;
		
@Service
public class ExpressDistrictServiceImpl implements ExpressDistrictService{
	
	@Autowired
	private ExpressDistrictDao expressDistrictDao;
	
	@Autowired
	private AutoIdGenerator autoIdGenerator;
	
	private static final String ID_KEY = "publicdata_express_district";

	@Override
	public boolean add(ExpressDistrict expressDistrict) {
		long id = autoIdGenerator.get(ID_KEY);
		expressDistrict.setId(id);
		
		return expressDistrictDao.add(expressDistrict);
	}

	@Override
	public ExpressDistrict get(Long id) {	
		return expressDistrictDao.get(id);		
	}

	@Override
	public boolean delete(Long id) {
		return expressDistrictDao.delete(id);
	}
	
	@Override
	public boolean update(ExpressDistrict expressDistrict) {
		return expressDistrictDao.update(expressDistrict);
	}
	
	@Override
	public Page<ExpressDistrict> page(ExpressDistrictQuery query, int start, int count) {
		return expressDistrictDao.page(query, start, count);
	}
	
	public List<ExpressDistrict> listAll(){
		return expressDistrictDao.listAll();
	}
	
	@Override
	public List<ExpressDistrict> listByExpressId(Long expressId){
	    return expressDistrictDao.listByExpressId(expressId);
	}
}

