package com.qcloud.component.organization.model;

import java.util.Date;

public class Clerk {

    // ID
    private long   id;

    // 姓名
    private String name;

    // 手机号
    private String mobile;

    // 工作邮箱
    private String jobEmail;

    // 身份证
    private String idCard;

    private int    sex;

    // 头像
    private String headImage;

    // 是否启用,在职(0否，1是)
    private int    enable;

    private String inside;

    // 账号组别
    private String accountGroup;

    // 工号
    private String laborNumber;

    // 用户类型(1 门户网 2 审批端)
    private int    type;

    // 创建人
    private long   creator;

    // 更新时间
    private Date   updateTime;

    public Clerk() {

    }

    public Clerk(long id, String name, String mobile, String jobEmail, String idCard, int sex, String headImage, int enable, String accountGroup, String laborNumber, int type, long creator, Date updateTime) {

        this.id = id;
        this.name = name;
        this.mobile = mobile;
        this.jobEmail = jobEmail;
        this.idCard = idCard;
        this.sex = sex;
        this.headImage = headImage;
        this.enable = enable;
        this.accountGroup = accountGroup;
        this.laborNumber = laborNumber;
        this.type = type;
        this.creator = creator;
        this.updateTime = updateTime;
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

    public void setMobile(String mobile) {

        this.mobile = mobile;
    }

    public String getMobile() {

        return mobile;
    }

    public void setJobEmail(String jobEmail) {

        this.jobEmail = jobEmail;
    }

    public String getJobEmail() {

        return jobEmail;
    }

    public void setIdCard(String idCard) {

        this.idCard = idCard;
    }

    public String getIdCard() {

        return idCard;
    }

    public void setSex(int sex) {

        this.sex = sex;
    }

    public int getSex() {

        return sex;
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

    public void setAccountGroup(String accountGroup) {

        this.accountGroup = accountGroup;
    }

    public String getAccountGroup() {

        return accountGroup;
    }

    public String getInside() {

        return inside;
    }

    public void setInside(String inside) {

        this.inside = inside;
    }

    public String getLaborNumber() {

        return laborNumber;
    }

    public void setLaborNumber(String laborNumber) {

        this.laborNumber = laborNumber;
    }

    public int getType() {

        return type;
    }

    public void setType(int type) {

        this.type = type;
    }

    public long getCreator() {

        return creator;
    }

    public void setCreator(long creator) {

        this.creator = creator;
    }

    public Date getUpdateTime() {

        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {

        this.updateTime = updateTime;
    }
}
