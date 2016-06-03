package com.qcloud.project.macaovehicle.model.query;

import java.util.Date;

public class TaskingCustomsQuery {

    private int    customsStatus;

    private int    statusIgnore;

    private int    status;

    private String type;

    // 申请编号
    private String formInstCode;

    // 个人企业类型
    private String clerkType;

    // 角色类型
    private String applyType;

    //
    private Long   clerkId;

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

    public TaskingCustomsQuery() {

    }

    public int getCustomsStatus() {

        return customsStatus;
    }

    public void setCustomsStatus(int customsStatus) {

        this.customsStatus = customsStatus;
    }

    public int getStatusIgnore() {

        return statusIgnore;
    }

    public void setStatusIgnore(int statusIgnore) {

        this.statusIgnore = statusIgnore;
    }

    public int getStatus() {

        return status;
    }

    public void setStatus(int status) {

        this.status = status;
    }

    public void setType(String type) {

        this.type = type;
    }

    public String getType() {

        return type;
    }

    public String getFormInstCode() {

        return formInstCode;
    }

    public String getClerkType() {

        return clerkType;
    }

    public String getApplyType() {

        return applyType;
    }

    public Long getClerkId() {

        return clerkId;
    }

    public String getClerkName() {

        return clerkName;
    }

    public String getIdCard() {

        return idCard;
    }

    public String getCompanyName() {

        return companyName;
    }

    public String getCompanyCode() {

        return companyCode;
    }

    public String getPlateNumber() {

        return plateNumber;
    }

    public Date getApplyTimeFront() {

        return applyTimeFront;
    }

    public Date getApplyTimeBack() {

        return applyTimeBack;
    }

    public String getOwnerName() {

        return ownerName;
    }

    public void setFormInstCode(String formInstCode) {

        this.formInstCode = formInstCode;
    }

    public void setClerkType(String clerkType) {

        this.clerkType = clerkType;
    }

    public void setApplyType(String applyType) {

        this.applyType = applyType;
    }

    public void setClerkId(Long clerkId) {

        this.clerkId = clerkId;
    }

    public void setClerkName(String clerkName) {

        this.clerkName = clerkName;
    }

    public void setIdCard(String idCard) {

        this.idCard = idCard;
    }

    public void setCompanyName(String companyName) {

        this.companyName = companyName;
    }

    public void setCompanyCode(String companyCode) {

        this.companyCode = companyCode;
    }

    public void setPlateNumber(String plateNumber) {

        this.plateNumber = plateNumber;
    }

    public void setApplyTimeFront(Date applyTimeFront) {

        this.applyTimeFront = applyTimeFront;
    }

    public void setApplyTimeBack(Date applyTimeBack) {

        this.applyTimeBack = applyTimeBack;
    }

    public void setOwnerName(String ownerName) {

        this.ownerName = ownerName;
    }
}
