package com.qcloud.project.macaovehicle.web.vo;

import java.util.Date;
import java.math.BigDecimal;

public class IllegalOwnerRecordVO {

    private long   id;

    // 证件类型
    private String certificates;

    // 证件号码
    private String certificatesNo;

    // 姓名
    private String name;

    // 备注
    private String desc;

    // 创建部门
    private long   departmentId;

    // 创建时间
    private Date   createTime;

    // 创建人
    private long   clerkId;

    // 部门名称
    private String departmentName;

    // 职工名称
    private String clerkName;

    // 创建时间
    private String createTimeStr;

    public IllegalOwnerRecordVO() {

    }

    public IllegalOwnerRecordVO(long id, String certificates, String certificatesNo, String name, String desc, long departmentId, Date createTime, long clerkId) {

        this.id = id;
        this.certificates = certificates;
        this.certificatesNo = certificatesNo;
        this.name = name;
        this.desc = desc;
        this.departmentId = departmentId;
        this.createTime = createTime;
        this.clerkId = clerkId;
    }

    public void setId(long id) {

        this.id = id;
    }

    public long getId() {

        return id;
    }

    public void setCertificates(String certificates) {

        this.certificates = certificates;
    }

    public String getCertificates() {

        return certificates;
    }

    public void setCertificatesNo(String certificatesNo) {

        this.certificatesNo = certificatesNo;
    }

    public String getCertificatesNo() {

        return certificatesNo;
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

    public void setDepartmentId(long departmentId) {

        this.departmentId = departmentId;
    }

    public long getDepartmentId() {

        return departmentId;
    }

    public void setCreateTime(Date createTime) {

        this.createTime = createTime;
    }

    public Date getCreateTime() {

        return createTime;
    }

    public void setClerkId(long clerkId) {

        this.clerkId = clerkId;
    }

    public long getClerkId() {

        return clerkId;
    }

    public String getDepartmentName() {

        return departmentName;
    }

    public String getClerkName() {

        return clerkName;
    }

    public void setDepartmentName(String departmentName) {

        this.departmentName = departmentName;
    }

    public void setClerkName(String clerkName) {

        this.clerkName = clerkName;
    }

    public String getCreateTimeStr() {

        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {

        this.createTimeStr = createTimeStr;
    }
}
