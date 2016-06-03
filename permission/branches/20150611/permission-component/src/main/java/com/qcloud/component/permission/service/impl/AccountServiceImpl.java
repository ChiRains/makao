package com.qcloud.component.permission.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qcloud.pirates.data.Page;
import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.component.permission.dao.AccountDao;
import com.qcloud.component.permission.model.Account;
import com.qcloud.component.permission.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDao accountDao;

	@Autowired
	private AutoIdGenerator autoIdGenerator;

	private String key = "permission_account";

	@Override
	public boolean add(Account account) {
		long id = autoIdGenerator.get(key);
		account.setId(id);
		return accountDao.add(account);
	}

	@Override
	public Account get(Long id) {
		return accountDao.get(id);
	}

	@Override
	public boolean delete(Long id) {
		return accountDao.delete(id);
	}

	@Override
	public boolean update(Account account) {
		return accountDao.update(account);
	}

	@Override
	public Page<Account> page(int start, int count) {
		return accountDao.page(start, count);
	}

	@Override
	public Account getByCode(String code) {
		return accountDao.getByCode(code);
	}

	@Override
	public Page<Account> page(String[] exAccountCodes, int start, int count) {
		return accountDao.page(exAccountCodes, start, count);
	}
}
