package com.qcloud.component.form.service;

import java.util.List;

import com.qcloud.pirates.data.Page;
import com.qcloud.component.form.model.FormInstanceHist;
import com.qcloud.component.form.model.query.FormInstanceHistQuery;

public interface FormInstanceHistService {
	
	public boolean add(FormInstanceHist formInstanceHist);	
	
	public FormInstanceHist get(Long id);
	
	public	boolean delete(Long id);
	
	public	boolean update(FormInstanceHist formInstanceHist);

	public Page<FormInstanceHist> page(FormInstanceHistQuery query, int start, int count);
	
	public List<FormInstanceHist> listAll();
}

