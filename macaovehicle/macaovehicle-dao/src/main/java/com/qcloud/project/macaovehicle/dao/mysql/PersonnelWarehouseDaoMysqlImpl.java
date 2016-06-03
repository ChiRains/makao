package com.qcloud.project.macaovehicle.dao.mysql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.apache.commons.lang.NotImplementedException;

import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.sql.mybatis.SqlOperator;
import com.qcloud.project.macaovehicle.dao.PersonnelWarehouseDao;
import com.qcloud.project.macaovehicle.model.PersonnelWarehouse;
import com.qcloud.project.macaovehicle.model.query.PersonnelWarehouseQuery;
		
@Repository
public class PersonnelWarehouseDaoMysqlImpl implements PersonnelWarehouseDao {

	@Resource(name = "sqlOperator-macaovehicle")
	private SqlOperator sqlOperator;

	@Override
	public boolean add(PersonnelWarehouse personnelWarehouse) {
		return sqlOperator.insert("com.qcloud.project.macaovehicle.dao.mysql.mapper.PersonnelWarehouseMapper.insert", personnelWarehouse) == 1;
	}	
	
	@Override
	public PersonnelWarehouse get(Long id) {
		return sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.PersonnelWarehouseMapper.get", id);
	}	
	
	@Override
	public boolean delete(Long id){
		return sqlOperator.delete("com.qcloud.project.macaovehicle.dao.mysql.mapper.PersonnelWarehouseMapper.delete", id) > 0;
	}	
		
	@Override
	public boolean update(PersonnelWarehouse personnelWarehouse){
		return sqlOperator.update("com.qcloud.project.macaovehicle.dao.mysql.mapper.PersonnelWarehouseMapper.update", personnelWarehouse) > 0;
	}
	
	@Override
	public List<PersonnelWarehouse> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, PersonnelWarehouse> map(Set<Long> idSet){
		throw new NotImplementedException();
	}
		
	@Override
	public Page<PersonnelWarehouse> page(int start, int count){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		param.put("count", count);

		List<PersonnelWarehouse> list = sqlOperator.selectList(
				"com.qcloud.project.macaovehicle.dao.mysql.mapper.PersonnelWarehouseMapper.list4page",
				param);
		int total = sqlOperator.selectOne(
				"com.qcloud.project.macaovehicle.dao.mysql.mapper.PersonnelWarehouseMapper.count4page",
				param);
		Page<PersonnelWarehouse> page = new Page<PersonnelWarehouse>();
		page.setCount(total);
		page.setData(list);
		return page;
	}
	
	@Override
	public Page<PersonnelWarehouse> page(PersonnelWarehouseQuery query, int start, int count){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		param.put("count", count);

		List<PersonnelWarehouse> list = sqlOperator.selectList(
				"com.qcloud.project.macaovehicle.dao.mysql.mapper.PersonnelWarehouseMapper.list4query",
				param);
		int total = sqlOperator.selectOne(
				"com.qcloud.project.macaovehicle.dao.mysql.mapper.PersonnelWarehouseMapper.count4query",
				param);
		Page<PersonnelWarehouse> page = new Page<PersonnelWarehouse>();
		page.setCount(total);
		page.setData(list);
		return page;
	}
	
	@Override
	public List<PersonnelWarehouse> listAll(){	
		List<PersonnelWarehouse> list = sqlOperator.selectList(
				"com.qcloud.project.macaovehicle.dao.mysql.mapper.PersonnelWarehouseMapper.listAll");
		return list;
	}

    @Override
    public PersonnelWarehouse getByRegister(String name, String mobile, String idcardNumber) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("name", name);
        param.put("mobile", mobile);
        param.put("idcardNumber", idcardNumber);
        return sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.PersonnelWarehouseMapper.getByRegister", param);
    }
}

