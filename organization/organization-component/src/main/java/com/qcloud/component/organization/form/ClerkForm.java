package com.qcloud.component.organization.form;

import java.util.Date;

public class ClerkForm {

    // ID
    private long   id;

    // 姓名
    private String name;

    // 性别
    private int    sex;

    // 是否启用,在职(0否，1是)
    private int    enable;

    // 工号
    private String laborNumber;

    // 创建人
    private long   creator;

    // 更新时间
    private Date   updateTime;

    // 部门id
    private long   departmentId;

    // 密码
    private String pwd1;

    public long getId() {

        return id;
    }

    public String getName() {

        return name;
    }

    public int getSex() {

        return sex;
    }

    public int getEnable() {

        return enable;
    }

    public String getLaborNumber() {

        return laborNumber;
    }

    public long getCreator() {

        return creator;
    }

    public Date getUpdateTime() {

        return updateTime;
    }

    public void setId(long id) {

        this.id = id;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setSex(int sex) {

        this.sex = sex;
    }

    public void setEnable(int enable) {

        this.enable = enable;
    }

    public void setLaborNumber(String laborNumber) {

        this.laborNumber = laborNumber;
    }

    public void setCreator(long creator) {

        this.creator = creator;
    }

    public void setUpdateTime(Date updateTime) {

        this.updateTime = updateTime;
    }

    public long getDepartmentId() {

        return departmentId;
    }

    public void setDepartmentId(long departmentId) {

        this.departmentId = departmentId;
    }

    public String getPwd1() {

        return pwd1;
    }

    public void setPwd1(String pwd1) {

        this.pwd1 = pwd1;
    }
}
