package com.qcloud.project.macaovehicle.web.vo;

import java.util.Date;

public class TaskingCustomsVO {

    // ID
    private long   id;

    // 处理人ID
    private long   clerkId;

    private String clerkName;

    private String departmentName;

    private String processName;

    private String applyTimeStr;

    // 流程申请ID
    private long   creator;

    private String creatorName;

    // 任务名称
    private String name;

    // 流程类型
    private String type;

    // 申请时间
    private Date   applyTime;

    // 接收时间
    private Date   receiveTime;

    private String receiveTimeStr;

    // 表单实例ID
    private long   formId;

    // 表单实例ID
    private long   formInstanceId;

    // 流程实例ID
    private String processId;

    // 流程实例ID
    private String processInstId;

    // 流程任务ID
    private String workitemId;

    // PC页面
    private String pcPageUrl;

    // 表单编号
    private String code;

    // 申请类型
    private String applyType;

    // 申请类型
    private String clerkType;

    // 身份证号
    private String idCard;

    // 公司名称
    private String companyName;

    // 公司代码
    private String companyCode;

    // 车牌号
    private String plateNumber;

    private String formInstCode;

    // 指标号
    private String indicatorsNo;

    // 指标发放日期
    private Date   indicatorsTime;

    // 指标有效期
    private Date   indicatorsPeriod;

    // 指标发放日期
    private String indicatorsTimeStr;

    // 指标有效期
    private String indicatorsPeriodStr;

    // 机动車所有人
    private String ownerName;

    // 七座以下客车
    private String vehicleType;

    // 厂牌型号
    private String specification;

    // 发动机号码
    private String engineNo;

    // 车架号码
    private String frameNumber;

    // 核定载质量
    private String permittedWeight;

    // 核定载客
    private String passengers;

    // 车品牌
    private String brand;

    // 境外車牌號碼
    private String fplateNumber;

    // 临时号牌
    private String temporaryplate;

    // 车辆有效期至(申请入境无此数据)
    private String validDateStr;

    // 拒绝原因
    private String reason;

    public void setId(long id) {

        this.id = id;
    }

    public long getId() {

        return id;
    }

    public void setClerkId(long clerkId) {

        this.clerkId = clerkId;
    }

    public long getClerkId() {

        return clerkId;
    }

    public void setCreator(long creator) {

        this.creator = creator;
    }

    public long getCreator() {

        return creator;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getName() {

        return name;
    }

    public void setType(String type) {

        this.type = type;
    }

    public String getType() {

        return type;
    }

    public void setApplyTime(Date applyTime) {

        this.applyTime = applyTime;
    }

    public Date getApplyTime() {

        return applyTime;
    }

    public void setReceiveTime(Date receiveTime) {

        this.receiveTime = receiveTime;
    }

    public Date getReceiveTime() {

        return receiveTime;
    }

    public void setFormId(long formId) {

        this.formId = formId;
    }

    public long getFormId() {

        return formId;
    }

    public void setFormInstanceId(long formInstanceId) {

        this.formInstanceId = formInstanceId;
    }

    public long getFormInstanceId() {

        return formInstanceId;
    }

    public void setProcessId(String processId) {

        this.processId = processId;
    }

    public String getProcessId() {

        return processId;
    }

    public void setProcessInstId(String processInstId) {

        this.processInstId = processInstId;
    }

    public String getProcessInstId() {

        return processInstId;
    }

    public void setWorkitemId(String workitemId) {

        this.workitemId = workitemId;
    }

    public String getWorkitemId() {

        return workitemId;
    }

    public void setPcPageUrl(String pcPageUrl) {

        this.pcPageUrl = pcPageUrl;
    }

    public String getPcPageUrl() {

        return pcPageUrl;
    }

    public void setCode(String code) {

        this.code = code;
    }

    public String getCode() {

        return code;
    }

    public void setApplyType(String applyType) {

        this.applyType = applyType;
    }

    public String getApplyType() {

        return applyType;
    }

    public void setClerkName(String clerkName) {

        this.clerkName = clerkName;
    }

    public String getClerkName() {

        return clerkName;
    }

    public void setIdCard(String idCard) {

        this.idCard = idCard;
    }

    public String getIdCard() {

        return idCard;
    }

    public void setCompanyName(String companyName) {

        this.companyName = companyName;
    }

    public String getCompanyName() {

        return companyName;
    }

    public void setCompanyCode(String companyCode) {

        this.companyCode = companyCode;
    }

    public String getCompanyCode() {

        return companyCode;
    }

    public void setPlateNumber(String plateNumber) {

        this.plateNumber = plateNumber;
    }

    public String getPlateNumber() {

        return plateNumber;
    }

    public String getDepartmentName() {

        return departmentName;
    }

    public void setDepartmentName(String departmentName) {

        this.departmentName = departmentName;
    }

    public String getProcessName() {

        return processName;
    }

    public void setProcessName(String processName) {

        this.processName = processName;
    }

    public String getApplyTimeStr() {

        return applyTimeStr;
    }

    public void setApplyTimeStr(String applyTimeStr) {

        this.applyTimeStr = applyTimeStr;
    }

    public String getCreatorName() {

        return creatorName;
    }

    public void setCreatorName(String creatorName) {

        this.creatorName = creatorName;
    }

    public String getReceiveTimeStr() {

        return receiveTimeStr;
    }

    public void setReceiveTimeStr(String receiveTimeStr) {

        this.receiveTimeStr = receiveTimeStr;
    }

    public String getFormInstCode() {

        return formInstCode;
    }

    public void setFormInstCode(String formInstCode) {

        this.formInstCode = formInstCode;
    }

    public String getIndicatorsNo() {

        return indicatorsNo;
    }

    public Date getIndicatorsTime() {

        return indicatorsTime;
    }

    public Date getIndicatorsPeriod() {

        return indicatorsPeriod;
    }

    public void setIndicatorsNo(String indicatorsNo) {

        this.indicatorsNo = indicatorsNo;
    }

    public void setIndicatorsTime(Date indicatorsTime) {

        this.indicatorsTime = indicatorsTime;
    }

    public void setIndicatorsPeriod(Date indicatorsPeriod) {

        this.indicatorsPeriod = indicatorsPeriod;
    }

    public String getIndicatorsTimeStr() {

        return indicatorsTimeStr;
    }

    public String getIndicatorsPeriodStr() {

        return indicatorsPeriodStr;
    }

    public void setIndicatorsTimeStr(String indicatorsTimeStr) {

        this.indicatorsTimeStr = indicatorsTimeStr;
    }

    public void setIndicatorsPeriodStr(String indicatorsPeriodStr) {

        this.indicatorsPeriodStr = indicatorsPeriodStr;
    }

    public String getClerkType() {

        return clerkType;
    }

    public void setClerkType(String clerkType) {

        this.clerkType = clerkType;
    }

    public String getOwnerName() {

        return ownerName;
    }

    public String getVehicleType() {

        return vehicleType;
    }

    public String getSpecification() {

        return specification;
    }

    public String getEngineNo() {

        return engineNo;
    }

    public String getFrameNumber() {

        return frameNumber;
    }

    public String getPermittedWeight() {

        return permittedWeight;
    }

    public String getPassengers() {

        return passengers;
    }

    public void setOwnerName(String ownerName) {

        this.ownerName = ownerName;
    }

    public void setVehicleType(String vehicleType) {

        this.vehicleType = vehicleType;
    }

    public void setSpecification(String specification) {

        this.specification = specification;
    }

    public void setEngineNo(String engineNo) {

        this.engineNo = engineNo;
    }

    public void setFrameNumber(String frameNumber) {

        this.frameNumber = frameNumber;
    }

    public void setPermittedWeight(String permittedWeight) {

        this.permittedWeight = permittedWeight;
    }

    public void setPassengers(String passengers) {

        this.passengers = passengers;
    }

    public String getBrand() {

        return brand;
    }

    public void setBrand(String brand) {

        this.brand = brand;
    }

    public String getFplateNumber() {

        return fplateNumber;
    }

    public void setFplateNumber(String fplateNumber) {

        this.fplateNumber = fplateNumber;
    }

    public String getTemporaryplate() {

        return temporaryplate;
    }

    public void setTemporaryplate(String temporaryplate) {

        this.temporaryplate = temporaryplate;
    }

    public String getValidDateStr() {

        return validDateStr;
    }

    public void setValidDateStr(String validDateStr) {

        this.validDateStr = validDateStr;
    }

    public String getReason() {

        return reason;
    }

    public void setReason(String reason) {

        this.reason = reason;
    }
}
