package com.qcloud.component.permission.web.vo;

public class AccountVO {

    // 主键
    private long   id;

    // 账号代码 最好使用手机号
    private String code;

    private String roleStr;

    private String name;

    public long getId() {

        return id;
    }

    public void setId(long id) {

        this.id = id;
    }

    public String getCode() {

        return code;
    }

    public void setCode(String code) {

        this.code = code;
    }

    public String getRoleStr() {

        return roleStr;
    }

    public void setRoleStr(String roleStr) {

        this.roleStr = roleStr;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }
}
