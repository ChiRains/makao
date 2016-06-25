package com.qcloud.component.permission.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.permission.dao.AccountRoleDao;
import com.qcloud.component.permission.model.AccountRole;

@Repository
public class AccountRoleDaoCacheImpl implements AccountRoleDao {

    @Autowired
    private AccountRoleDao accountRoleDaoMysqlImpl;

    @Autowired
    private AccountRoleDao accountRoleDaoRedisImpl;

    @Override
    public boolean add(AccountRole accountRole) {

        return accountRoleDaoMysqlImpl.add(accountRole);
    }

    @Override
    public AccountRole get(Long id) {

        return CacheLoader.get(accountRoleDaoRedisImpl, accountRoleDaoMysqlImpl, id);
    }

    @Override
    public boolean delete(Long id) {

        return accountRoleDaoMysqlImpl.delete(id);
    }

    @Override
    public boolean update(AccountRole accountRole) {

        return accountRoleDaoMysqlImpl.update(accountRole);
    }

    @Override
    public List<AccountRole> list(List<Long> idList) {

        return CacheLoader.list(accountRoleDaoRedisImpl, accountRoleDaoMysqlImpl, idList);
    }

    @Override
    public Map<Long, AccountRole> map(Set<Long> idSet) {

        return CacheLoader.map(accountRoleDaoRedisImpl, accountRoleDaoMysqlImpl, idSet);
    }

    @Override
    public Page<AccountRole> page(int start, int count) {

        return accountRoleDaoMysqlImpl.page(start, count);
    }

    @Override
    public List<AccountRole> list(Long accountId) {

        return accountRoleDaoMysqlImpl.list(accountId);
    }

    @Override
    public AccountRole get(Long accountId, Long roleId) {

        return accountRoleDaoMysqlImpl.get(accountId, roleId);
    }

    @Override
    public boolean unbindAccountGrant(long accountId) {

        return accountRoleDaoMysqlImpl.unbindAccountGrant(accountId);
    }

    @Override
    public List<AccountRole> listByRoleId(Long roleId) {

        return accountRoleDaoMysqlImpl.listByRoleId(roleId);
    }
}
