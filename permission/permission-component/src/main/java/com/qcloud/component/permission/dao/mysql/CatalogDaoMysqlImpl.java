package com.qcloud.component.permission.dao.mysql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.apache.commons.lang.NotImplementedException;

import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.sql.mybatis.SqlOperator;
import com.qcloud.component.permission.dao.CatalogDao;
import com.qcloud.component.permission.model.Catalog;
		
@Repository
public class CatalogDaoMysqlImpl implements CatalogDao {

	@Resource(name = "sqlOperator-permission")
	private SqlOperator sqlOperator;

	@Override
	public boolean add(Catalog catalog) {
		return sqlOperator.insert("com.qcloud.component.permission.dao.mysql.mapper.CatalogMapper.insert", catalog) == 1;
	}	
	
	@Override
	public Catalog get(Long id) {
		return sqlOperator.selectOne("com.qcloud.component.permission.dao.mysql.mapper.CatalogMapper.get", id);
	}	
	
	@Override
	public boolean delete(Long id){
		return sqlOperator.delete("com.qcloud.component.permission.dao.mysql.mapper.CatalogMapper.delete", id) > 0;
	}	
		
	@Override
	public boolean update(Catalog catalog){
		return sqlOperator.update("com.qcloud.component.permission.dao.mysql.mapper.CatalogMapper.update", catalog) > 0;
	}
	
	@Override
	public List<Catalog> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, Catalog> map(Set<Long> idSet){
		throw new NotImplementedException();
	}
		
	@Override
	public Page<Catalog> page(int start, int count){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		param.put("count", count);

		List<Catalog> list = sqlOperator.selectList(
				"com.qcloud.component.permission.dao.mysql.mapper.CatalogMapper.list4page",
				param);
		int total = sqlOperator.selectOne(
				"com.qcloud.component.permission.dao.mysql.mapper.CatalogMapper.count4page",
				param);
		Page<Catalog> page = new Page<Catalog>();
		page.setCount(total);
		page.setData(list);
		return page;
	}
	
	@Override
	public List<Catalog> list() {
		throw new NotImplementedException();
	}

	@Override
	public List<Long> listKeys() {
		return sqlOperator.selectList("com.qcloud.component.permission.dao.mysql.mapper.CatalogMapper.listKeys");
	}

	@Override
	public void addKeys(List<Long> keys) {
		throw new NotImplementedException();
	}
}

