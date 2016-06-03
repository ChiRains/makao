package com.qcloud.project.macaovehicle.service;

import java.util.List;

import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.model.PersonnelWarehouse;
import com.qcloud.project.macaovehicle.model.query.PersonnelWarehouseQuery;

public interface PersonnelWarehouseService {
	
	public boolean add(PersonnelWarehouse personnelWarehouse);	
	
	public PersonnelWarehouse get(Long id);
	
	public	boolean delete(Long id);
	
	public	boolean update(PersonnelWarehouse personnelWarehouse);

	public Page<PersonnelWarehouse> page(PersonnelWarehouseQuery query, int start, int count);
	
	public List<PersonnelWarehouse> listAll();

	public PersonnelWarehouse getByRegister(String name,String mobile,String idcardNumber);
}

