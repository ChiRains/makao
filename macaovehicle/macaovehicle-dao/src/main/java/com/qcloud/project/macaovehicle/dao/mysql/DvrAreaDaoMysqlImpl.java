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
import com.qcloud.project.macaovehicle.dao.DvrAreaDao;
import com.qcloud.project.macaovehicle.model.DvrArea;
import com.qcloud.project.macaovehicle.model.query.DvrAreaQuery;
		
@Repository
public class DvrAreaDaoMysqlImpl implements DvrAreaDao {

	@Resource(name = "sqlOperator-macaovehicle")
	private SqlOperator sqlOperator;

	@Override
	public boolean add(DvrArea dvrArea) {
		return sqlOperator.insert("com.qcloud.project.macaovehicle.dao.mysql.mapper.DvrAreaMapper.insert", dvrArea) == 1;
	}	
	
	@Override
	public DvrArea get(Long id) {
		return sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.DvrAreaMapper.get", id);
	}	
	
	@Override
	public boolean delete(Long id){
		return sqlOperator.delete("com.qcloud.project.macaovehicle.dao.mysql.mapper.DvrAreaMapper.delete", id) > 0;
	}	
		
	@Override
	public boolean update(DvrArea dvrArea){
		return sqlOperator.update("com.qcloud.project.macaovehicle.dao.mysql.mapper.DvrAreaMapper.update", dvrArea) > 0;
	}
	
	@Override
	public List<DvrArea> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, DvrArea> map(Set<Long> idSet){
		throw new NotImplementedException();
	}
		
	@Override
	public Page<DvrArea> page(int start, int count){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		param.put("count", count);

		List<DvrArea> list = sqlOperator.selectList(
				"com.qcloud.project.macaovehicle.dao.mysql.mapper.DvrAreaMapper.list4page",
				param);
		int total = sqlOperator.selectOne(
				"com.qcloud.project.macaovehicle.dao.mysql.mapper.DvrAreaMapper.count4page",
				param);
		Page<DvrArea> page = new Page<DvrArea>();
		page.setCount(total);
		page.setData(list);
		return page;
	}
	
	@Override
	public Page<DvrArea> page(DvrAreaQuery query, int start, int count){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		param.put("count", count);

		List<DvrArea> list = sqlOperator.selectList(
				"com.qcloud.project.macaovehicle.dao.mysql.mapper.DvrAreaMapper.list4query",
				param);
		int total = sqlOperator.selectOne(
				"com.qcloud.project.macaovehicle.dao.mysql.mapper.DvrAreaMapper.count4query",
				param);
		Page<DvrArea> page = new Page<DvrArea>();
		page.setCount(total);
		page.setData(list);
		return page;
	}
	
	@Override
	public List<DvrArea> listAll(){	
		List<DvrArea> list = sqlOperator.selectList(
				"com.qcloud.project.macaovehicle.dao.mysql.mapper.DvrAreaMapper.listAll");
		return list;
	}
}

