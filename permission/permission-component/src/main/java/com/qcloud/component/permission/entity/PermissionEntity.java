package com.qcloud.component.permission.entity;

import com.qcloud.component.permission.QPermission;

public class PermissionEntity implements QPermission {

    // 主键
    private long   id;

    // 权限点名称
    private String name;

    // 权限点类型 1 菜单 2 资源
    private int    type;

    private long   targetId;

    public PermissionEntity() {

    }

    public PermissionEntity(long id, String name, int type, long targetId) {

        this.id = id;
        this.name = name;
        this.type = type;
        this.targetId = targetId;
    }

    public void setId(long id) {

        this.id = id;
    }

    public long getId() {

        return id;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getName() {

        return name;
    }

    public void setType(int type) {

        this.type = type;
    }

    public int getType() {

        return type;
    }

    public void setTargetId(long targetId) {

        this.targetId = targetId;
    }

    public long getTargetId() {

        return targetId;
    }
}
