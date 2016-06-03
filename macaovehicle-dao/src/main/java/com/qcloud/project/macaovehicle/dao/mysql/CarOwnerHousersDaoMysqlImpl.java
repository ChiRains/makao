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
import com.qcloud.project.macaovehicle.dao.CarOwnerHousersDao;
import com.qcloud.project.macaovehicle.model.CarOwnerHousers;
import com.qcloud.project.macaovehicle.model.query.CarOwnerHousersQuery;
		
@Repository
public class CarOwnerHousersDaoMysqlImpl implements CarOwnerHousersDao {

	@Resource(name = "sqlOperator-macaovehicle")
	private SqlOperator sqlOperator;

	@Override
	public boolean add(CarOwnerHousers carOwnerHousers) {
		return sqlOperator.insert("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerHousersMapper.insert", carOwnerHousers) == 1;
	}	
	
	@Override
	public CarOwnerHousers get(Long id) {
		return sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerHousersMapper.get", id);
	}	
	
	@Override
	public boolean delete(Long id){
		return sqlOperator.delete("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerHousersMapper.delete", id) > 0;
	}	
		
	@Override
	public boolean update(CarOwnerHousers carOwnerHousers){
		return sqlOperator.update("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerHousersMapper.update", carOwnerHousers) > 0;
	}
	
	@Override
	public List<CarOwnerHousers> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, CarOwnerHousers> map(Set<Long> idSet){
		throw new NotImplementedException();
	}
		
	@Override
	public Page<CarOwnerHousers> page(int start, int count){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		param.put("count", count);

		List<CarOwnerHousers> list = sqlOperator.selectList(
				"com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerHousersMapper.list4page",
				param);
		int total = sqlOperator.selectOne(
				"com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerHousersMapper.count4page",
				param);
		Page<CarOwnerHousers> page = new Page<CarOwnerHousers>();
		page.setCount(total);
		page.setData(list);
		return page;
	}
	
	@Override
	public Page<CarOwnerHousers> page(CarOwnerHousersQuery query, int start, int count){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		param.put("count", count);

		List<CarOwnerHousers> list = sqlOperator.selectList(
				"com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerHousersMapper.list4query",
				param);
		int total = sqlOperator.selectOne(
				"com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerHousersMapper.count4query",
				param);
		Page<CarOwnerHousers> page = new Page<CarOwnerHousers>();
		page.setCount(total);
		page.setData(list);
		return page;
	}
	
	@Override
	public List<CarOwnerHousers> listAll(){	
		List<CarOwnerHousers> list = sqlOperator.selectList(
				"com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerHousersMapper.listAll");
		return list;
	}

    @Override
    public CarOwnerHousers getByCarOwner(Long userId) {

        return sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerHousersMapper.getByCarOwner", userId);
    }
}

