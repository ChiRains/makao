package com.qcloud.component.publicdata.service;

import java.util.List;

import com.qcloud.pirates.data.Page;
import com.qcloud.component.publicdata.model.Express;
import com.qcloud.component.publicdata.model.query.ExpressQuery;

public interface ExpressService {
	
	public Long add(Express express);	
	
	public Express get(Long id);
	
	public	boolean delete(Long id);
	
	public	boolean update(Express express);

	public Page<Express> page(ExpressQuery query, int start, int count);
	
	public List<Express> listAll();
	
	public Express getByCode(String code);
}

