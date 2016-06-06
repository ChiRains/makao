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
import com.qcloud.component.permission.dao.MenuDao;
import com.qcloud.component.permission.model.Menu;
import com.qcloud.component.permission.model.query.MenuQuery;
		
@Repository
public class MenuDaoMysqlImpl implements MenuDao {

	@Resource(name = "sqlOperator-permission")
	private SqlOperator sqlOperator;

	@Override
	public boolean add(Menu menu) {
		return sqlOperator.insert("com.qcloud.component.permission.dao.mysql.mapper.MenuMapper.insert", menu) == 1;
	}	
	
	@Override
	public Menu get(Long id) {
		return sqlOperator.selectOne("com.qcloud.component.permission.dao.mysql.mapper.MenuMapper.get", id);
	}	
	
	@Override
	public boolean delete(Long id){
		return sqlOperator.delete("com.qcloud.component.permission.dao.mysql.mapper.MenuMapper.delete", id) > 0;
	}	
		
	@Override
	public boolean update(Menu menu){
		return sqlOperator.update("com.qcloud.component.permission.dao.mysql.mapper.MenuMapper.update", menu) > 0;
	}
	
	@Override
	public List<Menu> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, Menu> map(Set<Long> idSet){
		throw new NotImplementedException();
	}
		
	@Override
	public Page<Menu> page(int start, int count){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		param.put("count", count);

		List<Menu> list = sqlOperator.selectList(
				"com.qcloud.component.permission.dao.mysql.mapper.MenuMapper.list4page",
				param);
		int total = sqlOperator.selectOne(
				"com.qcloud.component.permission.dao.mysql.mapper.MenuMapper.count4page",
				param);
		Page<Menu> page = new Page<Menu>();
		page.setCount(total);
		page.setData(list);
		return page;
	}
	
	@Override
	public List<Menu> list() {
		throw new NotImplementedException();
	}

	@Override
	public List<Menu> list(long catalogId) {
		throw new NotImplementedException();
	}

	@Override
	public List<Long> listKeys() {
		return sqlOperator.selectList("com.qcloud.component.permission.dao.mysql.mapper.MenuMapper.listKeys");
	}

	@Override
	public List<Long> listKeysByCatalog(long catalogId) {
		return sqlOperator.selectList("com.qcloud.component.permission.dao.mysql.mapper.MenuMapper.listKeysByCatalog", catalogId);
	}

	@Override
	public void addKeys(List<Long> keys) {
		throw new NotImplementedException();
	}

	@Override
	public void addKeys(long catalogId, List<Long> keys) {
		throw new NotImplementedException();
	}

    @Override
    public Page<Menu> page(MenuQuery query, int start, int count) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        param.put("catalogId", query.getCatalogId());
        
        List<Menu> list = sqlOperator.selectList(
                "com.qcloud.component.permission.dao.mysql.mapper.MenuMapper.list4Query",
                param);
        int total = sqlOperator.selectOne(
                "com.qcloud.component.permission.dao.mysql.mapper.MenuMapper.count4Query",
                param);
        Page<Menu> page = new Page<Menu>();
        page.setCount(total);
        page.setData(list);
        return page;
    }
}

