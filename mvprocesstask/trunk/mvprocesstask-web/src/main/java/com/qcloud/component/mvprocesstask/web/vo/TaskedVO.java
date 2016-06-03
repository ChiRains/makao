package com.qcloud.component.mvprocesstask.web.vo;

import java.util.Date;

public class TaskedVO {

    // ID
    private long   id;

    // 处理人ID
    private long   clerkId;

    private String clerkName;

    private String departmentName;

    private String processName;

    // 流程申请ID
    private long   creator;

    private String creatorName;

    // 任务名称
    private String name;

    // 流程类型
    private String type;

    // 申请时间
    private Date   applyTime;

    private String applyTimeStr;

    // 接收时间
    private Date   receiveTime;

    private String receiveTimeStr;

    // 接收时间
    private Date   dealTime;

    private String dealTimeStr;

    // 表单ID
    private long   formId;

    // 表单实例ID
    private long   formInstanceId;

    // 表单实例历史ID
    private long   formInstanceHistId;

    // 流程ID
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

    // 申请类型
    private String clerkType;

    // 状态(1"启用",2"通过",3"拒绝")
    private int    status;

    // 操作员id
    private long   operatorClerkId;

    // 操作员
    private String operator;

    // 处理时间
    private String recordTime;

    // 临时号牌
    private String temporaryplate;

    // 边检审批状态（1,"未处理" 2, "未通过",3, "已通过"）
    private int    borderStatus;

    // 国检审批状态（1,"未处理" 2, "未通过",3, "已通过"）
    private int    ciqStatus;

    // 海关审批状态（1,"未处理" 2, "未通过",3, "已通过"）
    private int    customsStatus;

    // 车辆有效期至(申请入境无此数据)
    private String validDateStr;

    public TaskedVO() {

    }

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

    public void setDealTime(Date dealTime) {

        this.dealTime = dealTime;
    }

    public Date getDealTime() {

        return dealTime;
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

    public void setFormInstanceHistId(long formInstanceHistId) {

        this.formInstanceHistId = formInstanceHistId;
    }

    public long getFormInstanceHistId() {

        return formInstanceHistId;
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

    public String getCreatorName() {

        return creatorName;
    }

    public void setCreatorName(String creatorName) {

        this.creatorName = creatorName;
    }

    public String getApplyTimeStr() {

        return applyTimeStr;
    }

    public void setApplyTimeStr(String applyTimeStr) {

        this.applyTimeStr = applyTimeStr;
    }

    public String getReceiveTimeStr() {

        return receiveTimeStr;
    }

    public void setReceiveTimeStr(String receiveTimeStr) {

        this.receiveTimeStr = receiveTimeStr;
    }

    public String getDealTimeStr() {

        return dealTimeStr;
    }

    public void setDealTimeStr(String dealTimeStr) {

        this.dealTimeStr = dealTimeStr;
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

    public String getClerkType() {

        return clerkType;
    }

    public void setClerkType(String clerkType) {

        this.clerkType = clerkType;
    }

    public int getStatus() {

        return status;
    }

    public long getOperatorClerkId() {

        return operatorClerkId;
    }

    public void setStatus(int status) {

        this.status = status;
    }

    public void setOperatorClerkId(long operatorClerkId) {

        this.operatorClerkId = operatorClerkId;
    }

    public String getOperator() {

        return operator;
    }

    public void setOperator(String operator) {

        this.operator = operator;
    }

    public String getRecordTime() {

        return recordTime;
    }

    public void setRecordTime(String recordTime) {

        this.recordTime = recordTime;
    }

    public String getTemporaryplate() {

        return temporaryplate;
    }

    public int getBorderStatus() {

        return borderStatus;
    }

    public int getCiqStatus() {

        return ciqStatus;
    }

    public int getCustomsStatus() {

        return customsStatus;
    }

    public void setTemporaryplate(String temporaryplate) {

        this.temporaryplate = temporaryplate;
    }

    public void setBorderStatus(int borderStatus) {

        this.borderStatus = borderStatus;
    }

    public void setCiqStatus(int ciqStatus) {

        this.ciqStatus = ciqStatus;
    }

    public void setCustomsStatus(int customsStatus) {

        this.customsStatus = customsStatus;
    }

    public String getValidDateStr() {

        return validDateStr;
    }

    public void setValidDateStr(String validDateStr) {

        this.validDateStr = validDateStr;
    }
}
