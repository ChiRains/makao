package com.qcloud.project.macaovehicle.web.vo;

import java.util.Date;
import java.math.BigDecimal;

public class IllegalCarRecordVO {

    private long   id;

    // 车辆号码
    private String plateNumber;

    // 临时号牌
    private String tplateNumber;

    // 部门
    private long   departmentId;

    // 创建时间
    private Date   createTime;

    // 职工id
    private long   clerkId;

    // 描述
    private String desc;

    // 部门名称
    private String departmentName;

    // 职工名称
    private String clerkName;

    // 创建时间
    private String createTimeStr;

    public IllegalCarRecordVO() {

    }

    public IllegalCarRecordVO(long id, String plateNumber, String tplateNumber, long departmentId, Date createTime, long clerkId, String desc) {

        this.id = id;
        this.plateNumber = plateNumber;
        this.tplateNumber = tplateNumber;
        this.departmentId = departmentId;
        this.createTime = createTime;
        this.clerkId = clerkId;
        this.desc = desc;
    }

    public void setId(long id) {

        this.id = id;
    }

    public long getId() {

        return id;
    }

    public void setPlateNumber(String plateNumber) {

        this.plateNumber = plateNumber;
    }

    public String getPlateNumber() {

        return plateNumber;
    }

    public void setTplateNumber(String tplateNumber) {

        this.tplateNumber = tplateNumber;
    }

    public String getTplateNumber() {

        return tplateNumber;
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

    public void setDesc(String desc) {

        this.desc = desc;
    }

    public String getDesc() {

        return desc;
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
