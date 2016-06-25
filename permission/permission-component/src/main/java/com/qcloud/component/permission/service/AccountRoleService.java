package com.qcloud.component.permission.service;

import java.util.List;
import com.qcloud.component.permission.model.AccountRole;
import com.qcloud.pirates.data.Page;

public interface AccountRoleService {

    public boolean add(AccountRole accountRole);

    public AccountRole get(Long id);

    public AccountRole get(Long accountId, Long roleId);

    public boolean delete(Long id);

    public boolean update(AccountRole accountRole);

    public Page<AccountRole> page(int start, int count);

    List<AccountRole> list(Long accountId);

    public boolean unbindAccountGrant(long accountId);

    public List<AccountRole> listByRoleId(Long roleId);
}
