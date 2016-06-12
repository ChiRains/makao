package com.qcloud.component.permission;

import java.util.List;
import com.qcloud.component.permission.model.RolePermission;

public interface QRole {

    public long getId();

    public String getName();

    public String getDesc();

    public int getEnable();

    public List<RolePermission> getRolePermissions();
}
