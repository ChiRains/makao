package com.qcloud.project.macaovehicle.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.project.macaovehicle.model.PersonnelWarehouse;
import com.qcloud.project.macaovehicle.model.query.PersonnelWarehouseQuery;
		
public interface PersonnelWarehouseDao extends ISimpleDao<PersonnelWarehouse, Long> {

	public boolean add(PersonnelWarehouse personnelWarehouse);	
	
	public PersonnelWarehouse get(Long id);

	public boolean delete(Long id);
	
	public boolean update(PersonnelWarehouse personnelWarehouse);
	
	public List<PersonnelWarehouse> list(List<Long> idList);
	
	public Map<Long, PersonnelWarehouse> map(Set<Long> idSet);
	
	public Page<PersonnelWarehouse> page(PersonnelWarehouseQuery query, int start, int size);

	public List<PersonnelWarehouse> listAll();
	
	public PersonnelWarehouse getByRegister(String name,String mobile,String idcardNumber);
	
}
