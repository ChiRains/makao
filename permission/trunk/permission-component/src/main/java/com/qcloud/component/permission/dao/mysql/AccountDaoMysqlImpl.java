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
import com.qcloud.component.permission.dao.AccountDao;
import com.qcloud.component.permission.model.Account;

@Repository
public class AccountDaoMysqlImpl implements AccountDao {

	@Resource(name = "sqlOperator-permission")
	private SqlOperator sqlOperator;

	@Override
	public boolean add(Account account) {
		return sqlOperator
				.insert("com.qcloud.component.permission.dao.mysql.mapper.AccountMapper.insert",
						account) == 1;
	}

	@Override
	public Account get(Long id) {
		return sqlOperator
				.selectOne(
						"com.qcloud.component.permission.dao.mysql.mapper.AccountMapper.get",
						id);
	}

	@Override
	public boolean delete(Long id) {
		return sqlOperator
				.delete("com.qcloud.component.permission.dao.mysql.mapper.AccountMapper.delete",
						id) > 0;
	}

	@Override
	public boolean update(Account account) {
		return sqlOperator
				.update("com.qcloud.component.permission.dao.mysql.mapper.AccountMapper.update",
						account) > 0;
	}

	@Override
	public List<Account> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, Account> map(Set<Long> idSet) {
		throw new NotImplementedException();
	}

	@Override
	public Page<Account> page(int start, int count) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		param.put("count", count);

		List<Account> list = sqlOperator
				.selectList(
						"com.qcloud.component.permission.dao.mysql.mapper.AccountMapper.list4page",
						param);
		int total = sqlOperator
				.selectOne(
						"com.qcloud.component.permission.dao.mysql.mapper.AccountMapper.count4page",
						param);
		Page<Account> page = new Page<Account>();
		page.setCount(total);
		page.setData(list);
		return page;
	}

	@Override
	public Account getByCode(String code) {
		return sqlOperator
				.selectOne(
						"com.qcloud.component.permission.dao.mysql.mapper.AccountMapper.getByCode",
						code);
	}

	@Override
	public Page<Account> page(String[] exAccountCodes, int start, int count) {
		StringBuffer sb = new StringBuffer();
		if (exAccountCodes != null && exAccountCodes.length != 0) {
			for (int index = 0; index < exAccountCodes.length; index++) {
				sb.append("'").append(exAccountCodes[index]).append("'");
				if (index != exAccountCodes.length - 1) {
					sb.append(",");
				}
			}
		} else {
			sb.append("''");
		}

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		param.put("count", count);
		param.put("exCode", sb.toString());

		List<Account> list = sqlOperator
				.selectList(
						"com.qcloud.component.permission.dao.mysql.mapper.AccountMapper.list4expage",
						param);
		int total = sqlOperator
				.selectOne(
						"com.qcloud.component.permission.dao.mysql.mapper.AccountMapper.count4expage",
						param);
		Page<Account> page = new Page<Account>();
		page.setCount(total);
		page.setData(list);
		return page;
	}
}
