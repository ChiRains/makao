package com.qcloud.component.permission.service;

import java.util.List;
import com.qcloud.component.permission.model.RolePermission;
import com.qcloud.pirates.data.Page;

public interface RolePermissionService {

    public boolean add(RolePermission rolePermission);

    public RolePermission get(Long id);

    public boolean delete(Long id);

    public boolean update(RolePermission rolePermission);

    public Page<RolePermission> page(int start, int count);

    List<RolePermission> list(Long... roleIds);

    public boolean delete(Long permissionId, Long roleId);

    public boolean unbindRolePermission(long roleId);
}
