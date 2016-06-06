package com.qcloud.component.organization.dao.mysql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.apache.commons.lang.NotImplementedException;

import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.sql.mybatis.SqlOperator;
import com.qcloud.component.organization.dao.UsergroupDao;
import com.qcloud.component.organization.model.Usergroup;
import com.qcloud.component.organization.model.query.UsergroupQuery;
		
@Repository
public class UsergroupDaoMysqlImpl implements UsergroupDao {

	@Resource(name = "sqlOperator-organization")
	private SqlOperator sqlOperator;

	@Override
	public boolean add(Usergroup usergroup) {
		return sqlOperator.insert("com.qcloud.component.organization.dao.mysql.mapper.UsergroupMapper.insert", usergroup) == 1;
	}	
	
	@Override
	public Usergroup get(Long id) {
		return sqlOperator.selectOne("com.qcloud.component.organization.dao.mysql.mapper.UsergroupMapper.get", id);
	}	
	
	@Override
	public boolean delete(Long id){
		return sqlOperator.delete("com.qcloud.component.organization.dao.mysql.mapper.UsergroupMapper.delete", id) > 0;
	}	
		
	@Override
	public boolean update(Usergroup usergroup){
		return sqlOperator.update("com.qcloud.component.organization.dao.mysql.mapper.UsergroupMapper.update", usergroup) > 0;
	}
	
	@Override
	public List<Usergroup> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, Usergroup> map(Set<Long> idSet){
		throw new NotImplementedException();
	}
		
	@Override
	public Page<Usergroup> page(int start, int count){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		param.put("count", count);

		List<Usergroup> list = sqlOperator.selectList(
				"com.qcloud.component.organization.dao.mysql.mapper.UsergroupMapper.list4page",
				param);
		int total = sqlOperator.selectOne(
				"com.qcloud.component.organization.dao.mysql.mapper.UsergroupMapper.count4page",
				param);
		Page<Usergroup> page = new Page<Usergroup>();
		page.setCount(total);
		page.setData(list);
		return page;
	}
	
	@Override
	public Page<Usergroup> page(UsergroupQuery query, int start, int count){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		param.put("count", count);

		List<Usergroup> list = sqlOperator.selectList(
				"com.qcloud.component.organization.dao.mysql.mapper.UsergroupMapper.list4query",
				param);
		int total = sqlOperator.selectOne(
				"com.qcloud.component.organization.dao.mysql.mapper.UsergroupMapper.count4query",
				param);
		Page<Usergroup> page = new Page<Usergroup>();
		page.setCount(total);
		page.setData(list);
		return page;
	}
	
	@Override
	public List<Usergroup> listAll(){	
		List<Usergroup> list = sqlOperator.selectList(
				"com.qcloud.component.organization.dao.mysql.mapper.UsergroupMapper.listAll");
		return list;
	}
}

