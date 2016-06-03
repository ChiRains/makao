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
import com.qcloud.component.permission.dao.OrganizationDao;
import com.qcloud.component.permission.model.Organization;
		
@Repository
public class OrganizationDaoMysqlImpl implements OrganizationDao {

	@Resource(name = "sqlOperator-permission")
	private SqlOperator sqlOperator;

	@Override
	public boolean add(Organization organization) {
		return sqlOperator.insert("com.qcloud.component.permission.dao.mysql.mapper.OrganizationMapper.insert", organization) == 1;
	}	
	
	@Override
	public Organization get(Long id) {
		return sqlOperator.selectOne("com.qcloud.component.permission.dao.mysql.mapper.OrganizationMapper.get", id);
	}	
	
	@Override
	public boolean delete(Long id){
		return sqlOperator.delete("com.qcloud.component.permission.dao.mysql.mapper.OrganizationMapper.delete", id) > 0;
	}	
		
	@Override
	public boolean update(Organization organization){
		return sqlOperator.update("com.qcloud.component.permission.dao.mysql.mapper.OrganizationMapper.update", organization) > 0;
	}
	
	@Override
	public List<Organization> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, Organization> map(Set<Long> idSet){
		throw new NotImplementedException();
	}
		
	@Override
	public Page<Organization> page(int start, int count){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		param.put("count", count);

		List<Organization> list = sqlOperator.selectList(
				"com.qcloud.component.permission.dao.mysql.mapper.OrganizationMapper.list4page",
				param);
		int total = sqlOperator.selectOne(
				"com.qcloud.component.permission.dao.mysql.mapper.OrganizationMapper.count4page",
				param);
		Page<Organization> page = new Page<Organization>();
		page.setCount(total);
		page.setData(list);
		return page;
	}
}

