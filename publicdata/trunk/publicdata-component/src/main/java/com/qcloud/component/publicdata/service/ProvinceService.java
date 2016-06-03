package com.qcloud.component.publicdata.service;

import java.util.List;
import com.qcloud.component.publicdata.model.Province;
import com.qcloud.component.publicdata.model.query.ProvinceQuery;
import com.qcloud.pirates.data.Page;

public interface ProvinceService {
	
	public boolean add(Province province);	
	
	public Province get(Long id);
	
	public	boolean delete(Long id);
	
	public	boolean update(Province province);

	public Page<Province> page(ProvinceQuery query, int start, int count);
	
	public List<Province> listAll();
	
	Province getByName(String name);
}

