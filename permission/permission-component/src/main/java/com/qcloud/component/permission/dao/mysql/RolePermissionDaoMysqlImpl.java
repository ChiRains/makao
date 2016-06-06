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
import com.qcloud.component.permission.dao.RolePermissionDao;
import com.qcloud.component.permission.model.RolePermission;

@Repository
public class RolePermissionDaoMysqlImpl implements RolePermissionDao {

	@Resource(name = "sqlOperator-permission")
	private SqlOperator sqlOperator;

	@Override
	public boolean add(RolePermission rolePermission) {
		return sqlOperator
				.insert("com.qcloud.component.permission.dao.mysql.mapper.RolePermissionMapper.insert",
						rolePermission) == 1;
	}

	@Override
	public RolePermission get(Long id) {
		return sqlOperator
				.selectOne(
						"com.qcloud.component.permission.dao.mysql.mapper.RolePermissionMapper.get",
						id);
	}

	@Override
	public boolean delete(Long id) {
		return sqlOperator
				.delete("com.qcloud.component.permission.dao.mysql.mapper.RolePermissionMapper.delete",
						id) > 0;
	}

	@Override
	public boolean update(RolePermission rolePermission) {
		return sqlOperator
				.update("com.qcloud.component.permission.dao.mysql.mapper.RolePermissionMapper.update",
						rolePermission) > 0;
	}

	@Override
	public List<RolePermission> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, RolePermission> map(Set<Long> idSet) {
		throw new NotImplementedException();
	}

	@Override
	public Page<RolePermission> page(int start, int count) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		param.put("count", count);

		List<RolePermission> list = sqlOperator
				.selectList(
						"com.qcloud.component.permission.dao.mysql.mapper.RolePermissionMapper.list4page",
						param);
		int total = sqlOperator
				.selectOne(
						"com.qcloud.component.permission.dao.mysql.mapper.RolePermissionMapper.count4page",
						param);
		Page<RolePermission> page = new Page<RolePermission>();
		page.setCount(total);
		page.setData(list);
		return page;
	}

	@Override
	public List<RolePermission> list(Long roleId) {
		List<RolePermission> list = sqlOperator
				.selectList(
						"com.qcloud.component.permission.dao.mysql.mapper.RolePermissionMapper.listByRole",
						roleId);
		return list;
	}
}
