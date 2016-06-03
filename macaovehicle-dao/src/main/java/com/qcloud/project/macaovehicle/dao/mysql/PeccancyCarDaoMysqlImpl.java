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
import com.qcloud.project.macaovehicle.dao.PeccancyCarDao;
import com.qcloud.project.macaovehicle.model.PeccancyCar;
import com.qcloud.project.macaovehicle.model.query.PeccancyCarQuery;
		
@Repository
public class PeccancyCarDaoMysqlImpl implements PeccancyCarDao {

	@Resource(name = "sqlOperator-macaovehicle")
	private SqlOperator sqlOperator;

	@Override
	public boolean add(PeccancyCar peccancyCar) {
		return sqlOperator.insert("com.qcloud.project.macaovehicle.dao.mysql.mapper.PeccancyCarMapper.insert", peccancyCar) == 1;
	}	
	
	@Override
	public PeccancyCar get(Long id) {
		return sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.PeccancyCarMapper.get", id);
	}	
	
	@Override
	public boolean delete(Long id){
		return sqlOperator.delete("com.qcloud.project.macaovehicle.dao.mysql.mapper.PeccancyCarMapper.delete", id) > 0;
	}	
		
	@Override
	public boolean update(PeccancyCar peccancyCar){
		return sqlOperator.update("com.qcloud.project.macaovehicle.dao.mysql.mapper.PeccancyCarMapper.update", peccancyCar) > 0;
	}
	
	@Override
	public List<PeccancyCar> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, PeccancyCar> map(Set<Long> idSet){
		throw new NotImplementedException();
	}
		
	@Override
	public Page<PeccancyCar> page(int start, int count){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		param.put("count", count);

		List<PeccancyCar> list = sqlOperator.selectList(
				"com.qcloud.project.macaovehicle.dao.mysql.mapper.PeccancyCarMapper.list4page",
				param);
		int total = sqlOperator.selectOne(
				"com.qcloud.project.macaovehicle.dao.mysql.mapper.PeccancyCarMapper.count4page",
				param);
		Page<PeccancyCar> page = new Page<PeccancyCar>();
		page.setCount(total);
		page.setData(list);
		return page;
	}
	
	@Override
	public Page<PeccancyCar> page(PeccancyCarQuery query, int start, int count){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		param.put("count", count);
		param.put("outsidePlate", query.getOutsidePlate());
		param.put("temporaryPlate", query.getTemporaryPlate());
		param.put("code", query.getCode());
		param.put("carOwnerId", query.getCarOwnerId());
		List<PeccancyCar> list = sqlOperator.selectList(
				"com.qcloud.project.macaovehicle.dao.mysql.mapper.PeccancyCarMapper.list4query",
				param);
		int total = sqlOperator.selectOne(
				"com.qcloud.project.macaovehicle.dao.mysql.mapper.PeccancyCarMapper.count4query",
				param);
		Page<PeccancyCar> page = new Page<PeccancyCar>();
		page.setCount(total);
		page.setData(list);
		return page;
	}
	
	@Override
	public List<PeccancyCar> listAll(){	
		List<PeccancyCar> list = sqlOperator.selectList(
				"com.qcloud.project.macaovehicle.dao.mysql.mapper.PeccancyCarMapper.listAll");
		return list;
	}
}

