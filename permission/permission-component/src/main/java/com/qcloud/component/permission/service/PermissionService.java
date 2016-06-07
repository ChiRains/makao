package com.qcloud.component.permission.service;

import java.util.List;
import com.qcloud.component.permission.model.Permission;
import com.qcloud.pirates.data.Page;

public interface PermissionService {

    public boolean add(Permission permission);

    public Permission get(Long id);

    public boolean delete(Long id);

    public boolean update(Permission permission);

    public Page<Permission> page(int start, int count);

    List<Permission> list(List<Long> keys);

    public Permission getByMenu(Long menuId);

    public Permission getByTargetId(int type, long targetId);
}
