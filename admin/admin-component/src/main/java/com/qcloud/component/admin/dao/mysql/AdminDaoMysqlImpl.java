package com.qcloud.component.admin.dao.mysql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.qcloud.component.admin.dao.AdminDao;
import com.qcloud.component.admin.model.Admin;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.sql.mybatis.SqlOperator;

@Repository
public class AdminDaoMysqlImpl implements AdminDao {

	@Resource(name = "sqlOperator-pirates-admin")
	private SqlOperator sqlOperator;

	@Override
	public boolean add(Admin bean) {
		return sqlOperator.insert("com.qcloud.component.admin.dao.mysql.mapper.AdminMapper.insert", bean) == 1;
	}

	@Override
	public Page<Admin> list(int start, int count) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("start", start);
		param.put("count", count);
		
		List<Admin> list = sqlOperator.selectList("com.qcloud.component.admin.dao.mysql.mapper.AdminMapper.list4page", param);
		int total = sqlOperator.selectOne("com.qcloud.component.admin.dao.mysql.mapper.AdminMapper.count4page", param);
		Page<Admin> page = new Page<Admin>();
		page.setCount(total);
		page.setData(list);
		return page;
	}

	@Override
	public boolean delete(long key) {
		return sqlOperator.delete("com.qcloud.component.admin.dao.mysql.mapper.AdminMapper.delete", key) > 0;
	}

	@Override
	public boolean update(Admin bean) {
		return sqlOperator.update("com.qcloud.component.admin.dao.mysql.mapper.AdminMapper.update", bean) > 0;
	}

	@Override
	public Admin get(long key) {
		return sqlOperator.selectOne("com.qcloud.component.admin.dao.mysql.mapper.AdminMapper.get", key);
	}

	@Override
	public Admin getByAccount(String code) {
		return sqlOperator.selectOne("com.qcloud.component.admin.dao.mysql.mapper.AdminMapper.getByAccount", code);
	}
}
