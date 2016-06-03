package com.qcloud.component.permission.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.qcloud.component.permission.model.Role;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;

public interface RoleDao extends ISimpleDao<Role, Long> {

	public boolean add(Role role);

	public Role get(Long id);

	public boolean delete(Long id);

	public boolean update(Role role);

	public List<Role> list(List<Long> idList);

	List<Role> list();

	public Map<Long, Role> map(Set<Long> idSet);

	public Page<Role> page(int start, int size);

}
