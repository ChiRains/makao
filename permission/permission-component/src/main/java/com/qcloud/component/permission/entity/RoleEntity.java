package com.qcloud.component.permission.entity;

import java.util.ArrayList;
import java.util.List;
import com.qcloud.component.permission.QRole;
import com.qcloud.component.permission.model.RolePermission;

public class RoleEntity implements QRole {

    // 主键
    private long                 id;

    // 角色名称
    private String               name;

    // 角色描述
    private String               desc;

    // 角色权限
    private List<RolePermission> rolePermissions = new ArrayList<RolePermission>();

    public long getId() {

        return id;
    }

    public void setId(long id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getDesc() {

        return desc;
    }

    public void setDesc(String desc) {

        this.desc = desc;
    }

    public List<RolePermission> getRolePermissions() {

        return rolePermissions;
    }

    public void setRolePermissions(List<RolePermission> rolePermissions) {

        this.rolePermissions = rolePermissions;
    }
}
