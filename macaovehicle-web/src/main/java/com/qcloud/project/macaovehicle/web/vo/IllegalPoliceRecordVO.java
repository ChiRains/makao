package com.qcloud.project.macaovehicle.web.vo;

public class IllegalPoliceRecordVO {

    private long   id;

    // 车辆号码
    private String plateNumber;

    // 临时号牌
    private String tplateNumber;

    // 违章时间
    private String violationTime;

    // 违章代码
    private String violationCode;

    // 违章地址
    private String violationAddress;

    // 违章行为
    private String violationDesc;

    // 部门
    private long   departmentId;

    // 创建时间
    private String createTime;

    // 职工id
    private long   clerkId;

    // 车主id
    private long   carOwnerId;

    // 创建者
    private String clerkName;

    public IllegalPoliceRecordVO() {

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

    public void setViolationCode(String violationCode) {

        this.violationCode = violationCode;
    }

    public String getViolationCode() {

        return violationCode;
    }

    public void setViolationAddress(String violationAddress) {

        this.violationAddress = violationAddress;
    }

    public String getViolationAddress() {

        return violationAddress;
    }

    public void setViolationDesc(String violationDesc) {

        this.violationDesc = violationDesc;
    }

    public String getViolationDesc() {

        return violationDesc;
    }

    public void setDepartmentId(long departmentId) {

        this.departmentId = departmentId;
    }

    public long getDepartmentId() {

        return departmentId;
    }

    public void setClerkId(long clerkId) {

        this.clerkId = clerkId;
    }

    public long getClerkId() {

        return clerkId;
    }

    public long getCarOwnerId() {

        return carOwnerId;
    }

    public void setCarOwnerId(long carOwnerId) {

        this.carOwnerId = carOwnerId;
    }

    public String getClerkName() {

        return clerkName;
    }

    public void setClerkName(String clerkName) {

        this.clerkName = clerkName;
    }

    public String getViolationTime() {

        return violationTime;
    }

    public String getCreateTime() {

        return createTime;
    }

    public void setViolationTime(String violationTime) {

        this.violationTime = violationTime;
    }

    public void setCreateTime(String createTime) {

        this.createTime = createTime;
    }
}
