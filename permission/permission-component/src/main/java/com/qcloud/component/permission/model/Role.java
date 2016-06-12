package com.qcloud.component.permission.model;

import java.util.Date;
import java.math.BigDecimal;

public class Role {

    // 主键
    private long   id;

    // 角色名称
    private String name;

    // 角色描述
    private String desc;

    // 可给当前角色授权的父角色ID
    private long   parentGrantRoleId = -1;

    // 是否启用(1启用 2禁用)
    private int    enable;

    public Role() {

    }

    public Role(long id, String name, String desc, long parentGrantRoleId, int enable) {

        this.id = id;
        this.name = name;
        this.desc = desc;
        this.parentGrantRoleId = parentGrantRoleId;
        this.enable = enable;
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

    public void setDesc(String desc) {

        this.desc = desc;
    }

    public String getDesc() {

        return desc;
    }

    public long getParentGrantRoleId() {

        return parentGrantRoleId;
    }

    public void setParentGrantRoleId(long parentGrantRoleId) {

        this.parentGrantRoleId = parentGrantRoleId;
    }

    public int getEnable() {

        return enable;
    }

    public void setEnable(int enable) {

        this.enable = enable;
    }
}
