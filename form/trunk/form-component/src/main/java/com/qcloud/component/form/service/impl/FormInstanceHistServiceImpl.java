package com.qcloud.component.form.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.form.dao.FormInstanceHistDao;
import com.qcloud.component.form.model.FormInstanceHist;
import com.qcloud.component.form.service.FormInstanceHistService;
import com.qcloud.component.form.model.query.FormInstanceHistQuery;
		
@Service
public class FormInstanceHistServiceImpl implements FormInstanceHistService{
	
	@Autowired
	private FormInstanceHistDao formInstanceHistDao;
	
	@Autowired
	private AutoIdGenerator autoIdGenerator;
	
	private static final String ID_KEY = "form_form_instance_hist";

	@Override
	public boolean add(FormInstanceHist formInstanceHist) {
		long id = autoIdGenerator.get(ID_KEY);
		formInstanceHist.setId(id);
		
		return formInstanceHistDao.add(formInstanceHist);
	}

	@Override
	public FormInstanceHist get(Long id) {	
		return formInstanceHistDao.get(id);		
	}

	@Override
	public boolean delete(Long id) {
		return formInstanceHistDao.delete(id);
	}
	
	@Override
	public boolean update(FormInstanceHist formInstanceHist) {
		return formInstanceHistDao.update(formInstanceHist);
	}
	
	@Override
	public Page<FormInstanceHist> page(FormInstanceHistQuery query, int start, int count) {
		return formInstanceHistDao.page(query, start, count);
	}
	
	public List<FormInstanceHist> listAll(){
		return formInstanceHistDao.listAll();
	}
}

