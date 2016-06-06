package com.qcloud.component.permission.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.component.permission.model.Account;

public interface AccountDao extends ISimpleDao<Account, Long> {

	public boolean add(Account account);

	public Account get(Long id);

	public Account getByCode(String code);

	public boolean delete(Long id);

	public boolean update(Account account);

	public List<Account> list(List<Long> idList);

	public Map<Long, Account> map(Set<Long> idSet);

	public Page<Account> page(int start, int size);

	public Page<Account> page(String[] exAccountCodes, int start, int count);
}
