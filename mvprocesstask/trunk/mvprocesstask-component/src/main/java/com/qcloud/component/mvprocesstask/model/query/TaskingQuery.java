package com.qcloud.component.mvprocesstask.model.query;

import java.util.Date;

public class TaskingQuery {

    // 申请编号
    private String formInstCode;

    // 个人企业类型
    private String clerkType;

    // 角色类型
    private String applyType;

    // 类型
    private String type;

    //
    private long   clerkId;

    private String clerkName;

    // 身份证号
    private String idCard;

    // 公司名称
    private String companyName;

    // 公司代码
    private String companyCode;

    // 车牌号
    private String plateNumber;

    // 搜索申请时间
    private Date   applyTimeFront;

    // 搜索申请时间
    private Date   applyTimeBack;

    // 车主姓名
    private String ownerName;

    private long   departmentId;

    public TaskingQuery() {

    }

    public String getType() {

        return type;
    }

    public void setType(String type) {

        this.type = type;
    }

    public long getClerkId() {

        return clerkId;
    }

    public void setClerkId(long clerkId) {

        this.clerkId = clerkId;
    }

    public String getClerkName() {

        return clerkName;
    }

    public void setClerkName(String clerkName) {

        this.clerkName = clerkName;
    }

    public String getIdCard() {

        return idCard;
    }

    public void setIdCard(String idCard) {

        this.idCard = idCard;
    }

    public String getCompanyName() {

        return companyName;
    }

    public void setCompanyName(String companyName) {

        this.companyName = companyName;
    }

    public String getCompanyCode() {

        return companyCode;
    }

    public void setCompanyCode(String companyCode) {

        this.companyCode = companyCode;
    }

    public String getPlateNumber() {

        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {

        this.plateNumber = plateNumber;
    }

    public Date getApplyTimeFront() {

        return applyTimeFront;
    }

    public void setApplyTimeFront(Date applyTimeFront) {

        this.applyTimeFront = applyTimeFront;
    }

    public Date getApplyTimeBack() {

        return applyTimeBack;
    }

    public void setApplyTimeBack(Date applyTimeBack) {

        this.applyTimeBack = applyTimeBack;
    }

    public String getFormInstCode() {

        return formInstCode;
    }

    public void setFormInstCode(String formInstCode) {

        this.formInstCode = formInstCode;
    }

    public String getClerkType() {

        return clerkType;
    }

    public String getApplyType() {

        return applyType;
    }

    public String getOwnerName() {

        return ownerName;
    }

    public void setClerkType(String clerkType) {

        this.clerkType = clerkType;
    }

    public void setApplyType(String applyType) {

        this.applyType = applyType;
    }

    public void setOwnerName(String ownerName) {

        this.ownerName = ownerName;
    }

    public long getDepartmentId() {

        return departmentId;
    }

    public void setDepartmentId(long departmentId) {

        this.departmentId = departmentId;
    }
}
