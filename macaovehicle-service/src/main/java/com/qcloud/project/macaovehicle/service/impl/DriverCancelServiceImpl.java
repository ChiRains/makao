package com.qcloud.project.macaovehicle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.dao.DriverCancelDao;
import com.qcloud.project.macaovehicle.model.DriverCancel;
import com.qcloud.project.macaovehicle.service.DriverCancelService;
import com.qcloud.project.macaovehicle.model.query.DriverCancelQuery;
		
@Service
public class DriverCancelServiceImpl implements DriverCancelService{
	
	@Autowired
	private DriverCancelDao driverCancelDao;
	
	@Autowired
	private AutoIdGenerator autoIdGenerator;
	
	private static final String ID_KEY = "macaovehicle_driver_cancel";

	@Override
	public boolean add(DriverCancel driverCancel) {
		long id = autoIdGenerator.get(ID_KEY);
		driverCancel.setId(id);
		
		return driverCancelDao.add(driverCancel);
	}

	@Override
	public DriverCancel get(Long id) {	
		return driverCancelDao.get(id);		
	}

	@Override
	public boolean delete(Long id) {
		return driverCancelDao.delete(id);
	}
	
	@Override
	public boolean update(DriverCancel driverCancel) {
		return driverCancelDao.update(driverCancel);
	}
	
	@Override
	public Page<DriverCancel> page(DriverCancelQuery query, int start, int count) {
		return driverCancelDao.page(query, start, count);
	}
	
	public List<DriverCancel> listAll(){
		return driverCancelDao.listAll();
	}
}

