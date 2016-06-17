package com.qcloud.project.macaovehicle.service;

import java.util.List;

import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.model.DvrArea;
import com.qcloud.project.macaovehicle.model.query.DvrAreaQuery;

public interface DvrAreaService {
	
	public boolean add(DvrArea dvrArea);	
	
	public DvrArea get(Long id);
	
	public	boolean delete(Long id);
	
	public	boolean update(DvrArea dvrArea);

	public Page<DvrArea> page(DvrAreaQuery query, int start, int count);
	
	public List<DvrArea> listAll();
	
	
}

