package com.qcloud.project.macaovehicle.service;

import java.util.List;

import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.model.DvrArea;
import com.qcloud.project.macaovehicle.model.DvrDetail;
import com.qcloud.project.macaovehicle.model.query.DvrDetailQuery;

public interface DvrDetailService {
	
	public boolean add(DvrDetail dvrDetail);	
	
	public DvrDetail get(Long id);
	
	public	boolean delete(Long id);
	
	public	boolean update(DvrDetail dvrDetail);

	public Page<DvrDetail> page(DvrDetailQuery query, int start, int count);
	
	public List<DvrDetail> listAll();
	
	public List<DvrDetail> getByArea(long id);
}

