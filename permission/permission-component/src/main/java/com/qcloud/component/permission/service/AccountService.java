package com.qcloud.component.permission.service;

import com.qcloud.pirates.data.Page;
import com.qcloud.component.permission.model.Account;

public interface AccountService {

	public boolean add(Account account);

	public Account get(Long id);

	public Account getByCode(String code);

	public boolean delete(Long id);

	public boolean update(Account account);

	public Page<Account> page(int start, int count);

	public Page<Account> page(String[] exAccountCodes, int start, int count);
}
