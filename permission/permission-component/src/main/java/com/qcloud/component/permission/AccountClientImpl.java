package com.qcloud.component.permission;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.permission.model.Account;
import com.qcloud.component.permission.model.AccountRole;
import com.qcloud.component.permission.service.AccountRoleService;
import com.qcloud.component.permission.service.AccountService;

@Service
public class AccountClientImpl implements AccountClient {

    @Autowired
    private AccountService     accountService;

    @Autowired
    private AccountRoleService accountRoleService;

    @Override
    public boolean addAccount(Account account) {

        return accountService.add(account);
    }

    @Override
    public Account getAccount(String code) {

        return accountService.getByCode(code);
    }

    @Override
    public List<Account> listByRoleId(Long roleId) {

        List<Account> accounts = new ArrayList<Account>();
        List<AccountRole> list = accountRoleService.listByRoleId(roleId);
        for (AccountRole accountRole : list) {
            Account account = accountService.get(accountRole.getAccountId());
            if (account == null) {
                continue;
            }
            accounts.add(account);
        }
        return accounts;
    }
}
