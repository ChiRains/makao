package com.qcloud.component.permission.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.component.permission.model.Permission;

public interface PermissionDao extends ISimpleDao<Permission, Long> {

    public boolean add(Permission permission);

    public Permission get(Long id);

    public boolean delete(Long id);

    public boolean update(Permission permission);

    public List<Permission> list(List<Long> idList);

    public Map<Long, Permission> map(Set<Long> idSet);

    public Page<Permission> page(int start, int size);

    public Permission getByMenu(Long menuId);

    public Permission getByTargetId(int type, long targetId);
}
