package com.qcloud.project.macaovehicle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.dao.DvrDetailDao;
import com.qcloud.project.macaovehicle.model.DvrArea;
import com.qcloud.project.macaovehicle.model.DvrDetail;
import com.qcloud.project.macaovehicle.service.DvrDetailService;
import com.qcloud.project.macaovehicle.model.query.DvrDetailQuery;

@Service
public class DvrDetailServiceImpl implements DvrDetailService{
	
	@Autowired
	private DvrDetailDao dvrDetailDao;
	
	@Autowired
	private AutoIdGenerator autoIdGenerator;
	
	private static final String ID_KEY = "macaovehicle_dvr_detail";

	@Override
	public boolean add(DvrDetail dvrDetail) {
		long id = autoIdGenerator.get(ID_KEY);
		dvrDetail.setId(id);
		
		return dvrDetailDao.add(dvrDetail);
	}

	@Override
	public DvrDetail get(Long id) {	
		return dvrDetailDao.get(id);		
	}

	@Override
	public boolean delete(Long id) {
		return dvrDetailDao.delete(id);
	}
	
	@Override
	public boolean update(DvrDetail dvrDetail) {
		return dvrDetailDao.update(dvrDetail);
	}
	
	@Override
	public Page<DvrDetail> page(DvrDetailQuery query, int start, int count) {
		return dvrDetailDao.page(query, start, count);
	}
	
	public List<DvrDetail> listAll(){
		return dvrDetailDao.listAll();
	}
	
	@Override
	public List<DvrDetail> getByArea(long id){
		return dvrDetailDao.getByArea(id);
	}
}

