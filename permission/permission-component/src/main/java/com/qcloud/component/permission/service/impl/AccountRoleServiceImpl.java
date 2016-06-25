package com.qcloud.component.permission.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.component.permission.dao.AccountRoleDao;
import com.qcloud.component.permission.model.AccountRole;
import com.qcloud.component.permission.service.AccountRoleService;
import com.qcloud.pirates.data.Page;

@Service
public class AccountRoleServiceImpl implements AccountRoleService {

    @Autowired
    private AccountRoleDao  accountRoleDao;

    @Autowired
    private AutoIdGenerator autoIdGenerator;

    private String          key = "permission_account_role";

    @Override
    public boolean add(AccountRole accountRole) {

        AccountRole ar = get(accountRole.getAccountId(), accountRole.getRoleId());
        if (ar != null) {
            return false;
        }
        long id = autoIdGenerator.get(key);
        accountRole.setId(id);
        return accountRoleDao.add(accountRole);
    }

    @Override
    public AccountRole get(Long id) {

        return accountRoleDao.get(id);
    }

    @Override
    public boolean delete(Long id) {

        return accountRoleDao.delete(id);
    }

    @Override
    public boolean update(AccountRole accountRole) {

        return accountRoleDao.update(accountRole);
    }

    @Override
    public Page<AccountRole> page(int start, int count) {

        return accountRoleDao.page(start, count);
    }

    @Override
    public List<AccountRole> list(Long accountId) {

        return accountRoleDao.list(accountId);
    }

    @Override
    public AccountRole get(Long accountId, Long roleId) {

        return accountRoleDao.get(accountId, roleId);
    }

    @Override
    public boolean unbindAccountGrant(long accountId) {

        return accountRoleDao.unbindAccountGrant(accountId);
    }

    @Override
    public List<AccountRole> listByRoleId(Long roleId) {

        return accountRoleDao.listByRoleId(roleId);
    }
}
