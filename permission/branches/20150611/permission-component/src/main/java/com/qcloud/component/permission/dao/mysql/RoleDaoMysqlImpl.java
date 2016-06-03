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
import com.qcloud.component.permission.dao.RoleDao;
import com.qcloud.component.permission.model.Role;

@Repository
public class RoleDaoMysqlImpl implements RoleDao {

	@Resource(name = "sqlOperator-permission")
	private SqlOperator sqlOperator;

	@Override
	public boolean add(Role role) {
		return sqlOperator
				.insert("com.qcloud.component.permission.dao.mysql.mapper.RoleMapper.insert",
						role) == 1;
	}

	@Override
	public Role get(Long id) {
		return sqlOperator
				.selectOne(
						"com.qcloud.component.permission.dao.mysql.mapper.RoleMapper.get",
						id);
	}

	@Override
	public boolean delete(Long id) {
		return sqlOperator
				.delete("com.qcloud.component.permission.dao.mysql.mapper.RoleMapper.delete",
						id) > 0;
	}

	@Override
	public boolean update(Role role) {
		return sqlOperator
				.update("com.qcloud.component.permission.dao.mysql.mapper.RoleMapper.update",
						role) > 0;
	}

	@Override
	public List<Role> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, Role> map(Set<Long> idSet) {
		throw new NotImplementedException();
	}

	@Override
	public Page<Role> page(int start, int count) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		param.put("count", count);

		List<Role> list = sqlOperator
				.selectList(
						"com.qcloud.component.permission.dao.mysql.mapper.RoleMapper.list4page",
						param);
		int total = sqlOperator
				.selectOne(
						"com.qcloud.component.permission.dao.mysql.mapper.RoleMapper.count4page",
						param);
		Page<Role> page = new Page<Role>();
		page.setCount(total);
		page.setData(list);
		return page;
	}

	@Override
	public List<Role> list() {
		List<Role> list = sqlOperator
				.selectList("com.qcloud.component.permission.dao.mysql.mapper.RoleMapper.list");
		return list;
	}
}
