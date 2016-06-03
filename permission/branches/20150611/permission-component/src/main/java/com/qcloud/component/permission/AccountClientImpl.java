package com.qcloud.component.permission;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.qcloud.component.permission.model.Account;
import com.qcloud.component.permission.service.AccountService;

@Service
public class AccountClientImpl implements AccountClient {
	@Autowired
	private AccountService accountService;

	@Override
	public boolean addAccount(Account account) {
		return accountService.add(account);
	}

	@Override
	public Account getAccount(String code) {
		return accountService.getByCode(code);
	}
}
