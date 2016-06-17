package com.qcloud.component.permission.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.component.permission.model.RolePermission;

public interface RolePermissionDao extends ISimpleDao<RolePermission, Long> {

    public boolean add(RolePermission rolePermission);

    public RolePermission get(Long id);

    public boolean delete(Long id);

    public boolean update(RolePermission rolePermission);

    public List<RolePermission> list(List<Long> idList);

    public Map<Long, RolePermission> map(Set<Long> idSet);

    public Page<RolePermission> page(int start, int size);

    List<RolePermission> list(Long roleId);

    public boolean delete(Long permissionId, Long roleId);

    public boolean unbindRolePermission(Long roleId);
}
