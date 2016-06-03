package com.qcloud.component.permission;

import com.qcloud.component.permission.model.Account;

public interface AccountClient {

	boolean addAccount(Account account);

	Account getAccount(String code);
}
