package com.qcloud.component.organization.web.vo.admin;

import java.util.Comparator;
import java.util.Date;
import java.math.BigDecimal;

public class AdminClerkVO {

    // ID
    private long   id;

    // 账号 唯一 登录使用
    private String account;

    // 姓名
    private String name;

    // 密码
    private String password;

    // 手机号
    private String mobile;

    // 头像
    private String headImage;

    // 是否启用,在职
    private int    enable;

    private String jobEmail;

    private long   departmentId;

    private String departmentName;

    public AdminClerkVO() {

    }

    public void setId(long id) {

        this.id = id;
    }

    public long getId() {

        return id;
    }

    public void setAccount(String account) {

        this.account = account;
    }

    public String getAccount() {

        return account;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getName() {

        return name;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public String getPassword() {

        return password;
    }

    public void setMobile(String mobile) {

        this.mobile = mobile;
    }

    public String getMobile() {

        return mobile;
    }

    public void setHeadImage(String headImage) {

        this.headImage = headImage;
    }

    public String getHeadImage() {

        return headImage;
    }

    public void setEnable(int enable) {

        this.enable = enable;
    }

    public int getEnable() {

        return enable;
    }

    public String getJobEmail() {

        return jobEmail;
    }

    public void setJobEmail(String jobEmail) {

        this.jobEmail = jobEmail;
    }

    public long getDepartmentId() {

        return departmentId;
    }

    public void setDepartmentId(long departmentId) {

        this.departmentId = departmentId;
    }

    public String getDepartmentName() {

        return departmentName;
    }

    public void setDepartmentName(String departmentName) {

        this.departmentName = departmentName;
    }
}
