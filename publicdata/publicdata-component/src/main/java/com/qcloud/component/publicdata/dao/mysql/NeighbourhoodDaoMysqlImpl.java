package com.qcloud.component.publicdata.dao.mysql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.apache.commons.lang.NotImplementedException;

import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.sql.mybatis.SqlOperator;
import com.qcloud.component.publicdata.dao.NeighbourhoodDao;
import com.qcloud.component.publicdata.model.Neighbourhood;
import com.qcloud.component.publicdata.model.query.NeighbourhoodQuery;
		
@Repository
public class NeighbourhoodDaoMysqlImpl implements NeighbourhoodDao {

	@Resource(name = "sqlOperator-publicdata")
	private SqlOperator sqlOperator;

	@Override
	public boolean add(Neighbourhood neighbourhood) {
		return sqlOperator.insert("com.qcloud.component.publicdata.dao.mysql.mapper.NeighbourhoodMapper.insert", neighbourhood) == 1;
	}	
	
	@Override
	public Neighbourhood get(Long id) {
		return sqlOperator.selectOne("com.qcloud.component.publicdata.dao.mysql.mapper.NeighbourhoodMapper.get", id);
	}	
	
	@Override
	public boolean delete(Long id){
		return sqlOperator.delete("com.qcloud.component.publicdata.dao.mysql.mapper.NeighbourhoodMapper.delete", id) > 0;
	}	
		
	@Override
	public boolean update(Neighbourhood neighbourhood){
		return sqlOperator.update("com.qcloud.component.publicdata.dao.mysql.mapper.NeighbourhoodMapper.update", neighbourhood) > 0;
	}
	
	@Override
	public List<Neighbourhood> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, Neighbourhood> map(Set<Long> idSet){
		throw new NotImplementedException();
	}
		
	@Override
	public Page<Neighbourhood> page(int start, int count){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		param.put("count", count);

		List<Neighbourhood> list = sqlOperator.selectList(
				"com.qcloud.component.publicdata.dao.mysql.mapper.NeighbourhoodMapper.list4page",
				param);
		int total = sqlOperator.selectOne(
				"com.qcloud.component.publicdata.dao.mysql.mapper.NeighbourhoodMapper.count4page",
				param);
		Page<Neighbourhood> page = new Page<Neighbourhood>();
		page.setCount(total);
		page.setData(list);
		return page;
	}
	
	@Override
	public Page<Neighbourhood> page(NeighbourhoodQuery query, int start, int count){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		param.put("count", count);

		List<Neighbourhood> list = sqlOperator.selectList(
				"com.qcloud.component.publicdata.dao.mysql.mapper.NeighbourhoodMapper.list4query",
				param);
		int total = sqlOperator.selectOne(
				"com.qcloud.component.publicdata.dao.mysql.mapper.NeighbourhoodMapper.count4query",
				param);
		Page<Neighbourhood> page = new Page<Neighbourhood>();
		page.setCount(total);
		page.setData(list);
		return page;
	}
	
	@Override
	public List<Neighbourhood> listAll(){	
		List<Neighbourhood> list = sqlOperator.selectList(
				"com.qcloud.component.publicdata.dao.mysql.mapper.NeighbourhoodMapper.listAll");
		return list;
	}
}

