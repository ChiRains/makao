package com.qcloud.component.permission.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.permission.dao.AccountDao;
import com.qcloud.component.permission.model.Account;

@Repository
public class AccountDaoCacheImpl implements AccountDao {

	@Autowired
	private AccountDao accountDaoMysqlImpl;

	@Autowired
	private AccountDao accountDaoRedisImpl;

	@Override
	public boolean add(Account account) {
		return accountDaoMysqlImpl.add(account);
	}

	@Override
	public Account get(Long id) {
		return CacheLoader.get(accountDaoRedisImpl, accountDaoMysqlImpl, id);
	}

	@Override
	public boolean delete(Long id) {
		return accountDaoMysqlImpl.delete(id);
	}

	@Override
	public boolean update(Account account) {
		return accountDaoMysqlImpl.update(account);
	}

	@Override
	public List<Account> list(List<Long> idList) {
		return CacheLoader.list(accountDaoRedisImpl, accountDaoMysqlImpl,
				idList);
	}

	@Override
	public Map<Long, Account> map(Set<Long> idSet) {
		return CacheLoader.map(accountDaoRedisImpl, accountDaoMysqlImpl, idSet);
	}

	@Override
	public Page<Account> page(int start, int count) {
		return accountDaoMysqlImpl.page(start, count);
	}

	@Override
	public Account getByCode(String code) {
		return accountDaoMysqlImpl.getByCode(code);
	}

	@Override
	public Page<Account> page(String[] exAccountCodes, int start, int count) {
		return accountDaoMysqlImpl.page(exAccountCodes, start, count);
	}
}
