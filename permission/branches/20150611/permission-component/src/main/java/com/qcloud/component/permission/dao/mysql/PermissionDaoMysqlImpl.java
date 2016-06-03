package com.qcloud.component.permission.dao.mysql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang.NotImplementedException;
import org.springframework.stereotype.Repository;

import com.qcloud.component.permission.dao.PermissionDao;
import com.qcloud.component.permission.model.Permission;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.sql.mybatis.SqlOperator;

@Repository
public class PermissionDaoMysqlImpl implements PermissionDao {

	@Resource(name = "sqlOperator-permission")
	private SqlOperator sqlOperator;

	@Override
	public boolean add(Permission permission) {
		return sqlOperator
				.insert("com.qcloud.component.permission.dao.mysql.mapper.PermissionMapper.insert",
						permission) == 1;
	}

	@Override
	public Permission get(Long id) {
		return sqlOperator
				.selectOne(
						"com.qcloud.component.permission.dao.mysql.mapper.PermissionMapper.get",
						id);
	}

	@Override
	public boolean delete(Long id) {
		return sqlOperator
				.delete("com.qcloud.component.permission.dao.mysql.mapper.PermissionMapper.delete",
						id) > 0;
	}

	@Override
	public boolean update(Permission permission) {
		return sqlOperator
				.update("com.qcloud.component.permission.dao.mysql.mapper.PermissionMapper.update",
						permission) > 0;
	}

	@Override
	public List<Permission> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, Permission> map(Set<Long> idSet) {
//		Map<Long, Permission> map = new HashMap<Long, Permission>();
//		for (Long key : idSet) {
//			map.put(key, get(key));
//		}
//		return map;
		throw new NotImplementedException();
	}

	@Override
	public Page<Permission> page(int start, int count) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		param.put("count", count);

		List<Permission> list = sqlOperator
				.selectList(
						"com.qcloud.component.permission.dao.mysql.mapper.PermissionMapper.list4page",
						param);
		int total = sqlOperator
				.selectOne(
						"com.qcloud.component.permission.dao.mysql.mapper.PermissionMapper.count4page",
						param);
		Page<Permission> page = new Page<Permission>();
		page.setCount(total);
		page.setData(list);
		return page;
	}
}
