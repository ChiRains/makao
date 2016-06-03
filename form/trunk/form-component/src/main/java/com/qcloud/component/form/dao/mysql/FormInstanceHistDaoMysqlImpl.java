package com.qcloud.component.form.dao.mysql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.apache.commons.lang.NotImplementedException;

import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.sql.mybatis.SqlOperator;
import com.qcloud.component.form.dao.FormInstanceHistDao;
import com.qcloud.component.form.model.FormInstanceHist;
import com.qcloud.component.form.model.query.FormInstanceHistQuery;
		
@Repository
public class FormInstanceHistDaoMysqlImpl implements FormInstanceHistDao {

	@Resource(name = "sqlOperator-form")
	private SqlOperator sqlOperator;

	@Override
	public boolean add(FormInstanceHist formInstanceHist) {
		return sqlOperator.insert("com.qcloud.component.form.dao.mysql.mapper.FormInstanceHistMapper.insert", formInstanceHist) == 1;
	}	
	
	@Override
	public FormInstanceHist get(Long id) {
		return sqlOperator.selectOne("com.qcloud.component.form.dao.mysql.mapper.FormInstanceHistMapper.get", id);
	}	
	
	@Override
	public boolean delete(Long id){
		return sqlOperator.delete("com.qcloud.component.form.dao.mysql.mapper.FormInstanceHistMapper.delete", id) > 0;
	}	
		
	@Override
	public boolean update(FormInstanceHist formInstanceHist){
		return sqlOperator.update("com.qcloud.component.form.dao.mysql.mapper.FormInstanceHistMapper.update", formInstanceHist) > 0;
	}
	
	@Override
	public List<FormInstanceHist> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, FormInstanceHist> map(Set<Long> idSet){
		throw new NotImplementedException();
	}
		
	@Override
	public Page<FormInstanceHist> page(int start, int count){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		param.put("count", count);

		List<FormInstanceHist> list = sqlOperator.selectList(
				"com.qcloud.component.form.dao.mysql.mapper.FormInstanceHistMapper.list4page",
				param);
		int total = sqlOperator.selectOne(
				"com.qcloud.component.form.dao.mysql.mapper.FormInstanceHistMapper.count4page",
				param);
		Page<FormInstanceHist> page = new Page<FormInstanceHist>();
		page.setCount(total);
		page.setData(list);
		return page;
	}
	
	@Override
	public Page<FormInstanceHist> page(FormInstanceHistQuery query, int start, int count){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		param.put("count", count);

		List<FormInstanceHist> list = sqlOperator.selectList(
				"com.qcloud.component.form.dao.mysql.mapper.FormInstanceHistMapper.list4query",
				param);
		int total = sqlOperator.selectOne(
				"com.qcloud.component.form.dao.mysql.mapper.FormInstanceHistMapper.count4query",
				param);
		Page<FormInstanceHist> page = new Page<FormInstanceHist>();
		page.setCount(total);
		page.setData(list);
		return page;
	}
	
	@Override
	public List<FormInstanceHist> listAll(){	
		List<FormInstanceHist> list = sqlOperator.selectList(
				"com.qcloud.component.form.dao.mysql.mapper.FormInstanceHistMapper.listAll");
		return list;
	}
}

