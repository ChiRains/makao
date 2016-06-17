package com.qcloud.project.macaovehicle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.dao.DvrAreaDao;
import com.qcloud.project.macaovehicle.model.DvrArea;
import com.qcloud.project.macaovehicle.service.DvrAreaService;
import com.qcloud.project.macaovehicle.model.query.DvrAreaQuery;
		
@Service
public class DvrAreaServiceImpl implements DvrAreaService{
	
	@Autowired
	private DvrAreaDao dvrAreaDao;
	
	@Autowired
	private AutoIdGenerator autoIdGenerator;
	
	private static final String ID_KEY = "macaovehicle_dvr_area";

	@Override
	public boolean add(DvrArea dvrArea) {
		long id = autoIdGenerator.get(ID_KEY);
		dvrArea.setId(id);
		
		return dvrAreaDao.add(dvrArea);
	}

	@Override
	public DvrArea get(Long id) {	
		return dvrAreaDao.get(id);		
	}

	@Override
	public boolean delete(Long id) {
		return dvrAreaDao.delete(id);
	}
	
	@Override
	public boolean update(DvrArea dvrArea) {
		return dvrAreaDao.update(dvrArea);
	}
	
	@Override
	public Page<DvrArea> page(DvrAreaQuery query, int start, int count) {
		return dvrAreaDao.page(query, start, count);
	}
	
	public List<DvrArea> listAll(){
		return dvrAreaDao.listAll();
	}
	
	
}

