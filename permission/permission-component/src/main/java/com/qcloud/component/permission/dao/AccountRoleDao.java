package com.qcloud.component.permission.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.component.permission.model.AccountRole;

public interface AccountRoleDao extends ISimpleDao<AccountRole, Long> {

	public boolean add(AccountRole accountRole);

	public AccountRole get(Long id);

	public boolean delete(Long id);

	public boolean update(AccountRole accountRole);

	public List<AccountRole> list(List<Long> idList);

	public Map<Long, AccountRole> map(Set<Long> idSet);

	public Page<AccountRole> page(int start, int size);

	List<AccountRole> list(Long accountId);

	AccountRole get(Long accountId, Long roleId);
}
