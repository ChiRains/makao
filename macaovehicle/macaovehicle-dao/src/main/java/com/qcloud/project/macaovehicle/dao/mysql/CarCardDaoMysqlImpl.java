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
import com.qcloud.project.macaovehicle.dao.CarCardDao;
import com.qcloud.project.macaovehicle.model.CarCard;
import com.qcloud.project.macaovehicle.model.query.CarCardQuery;
		
@Repository
public class CarCardDaoMysqlImpl implements CarCardDao {

	@Resource(name = "sqlOperator-macaovehicle")
	private SqlOperator sqlOperator;

	@Override
	public boolean add(CarCard carCard) {
		return sqlOperator.insert("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarCardMapper.insert", carCard) == 1;
	}	
	
	@Override
	public CarCard get(Long id) {
		return sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarCardMapper.get", id);
	}	
	
	@Override
	public boolean delete(Long id){
		return sqlOperator.delete("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarCardMapper.delete", id) > 0;
	}	
		
	@Override
	public boolean update(CarCard carCard){
		return sqlOperator.update("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarCardMapper.update", carCard) > 0;
	}
	
	@Override
	public List<CarCard> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, CarCard> map(Set<Long> idSet){
		throw new NotImplementedException();
	}
		
	@Override
	public Page<CarCard> page(int start, int count){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		param.put("count", count);

		List<CarCard> list = sqlOperator.selectList(
				"com.qcloud.project.macaovehicle.dao.mysql.mapper.CarCardMapper.list4page",
				param);
		int total = sqlOperator.selectOne(
				"com.qcloud.project.macaovehicle.dao.mysql.mapper.CarCardMapper.count4page",
				param);
		Page<CarCard> page = new Page<CarCard>();
		page.setCount(total);
		page.setData(list);
		return page;
	}
	
	@Override
	public Page<CarCard> page(CarCardQuery query, int start, int count){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		param.put("count", count);

		List<CarCard> list = sqlOperator.selectList(
				"com.qcloud.project.macaovehicle.dao.mysql.mapper.CarCardMapper.list4query",
				param);
		int total = sqlOperator.selectOne(
				"com.qcloud.project.macaovehicle.dao.mysql.mapper.CarCardMapper.count4query",
				param);
		Page<CarCard> page = new Page<CarCard>();
		page.setCount(total);
		page.setData(list);
		return page;
	}
	
	@Override
	public List<CarCard> listAll(){	
		List<CarCard> list = sqlOperator.selectList(
				"com.qcloud.project.macaovehicle.dao.mysql.mapper.CarCardMapper.listAll");
		return list;
	}
}

