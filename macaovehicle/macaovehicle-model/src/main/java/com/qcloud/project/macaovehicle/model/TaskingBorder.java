package com.qcloud.project.macaovehicle.model;

import java.util.Date;
import java.math.BigDecimal;

public class TaskingBorder {

    // ID
    private long   id;

    // 原待办任务ID
    private long   taskingId;

    // 处理人ID
    private long   clerkId;

    // 流程申请ID
    private long   creator;

    // 任务名称
    private String name;

    // 流程类型
    private String type;

    // 申请时间
    private Date   applyTime;

    // 接收时间
    private Date   receiveTime;

    // 接收时间
    private Date   dealTime;

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

    // 申请类型
    private String clerkType;

    // 职员姓名
    private String clerkName;

    // 身份证号
    private String idCard;

    // 公司名称
    private String companyName;

    // 公司代码
    private String companyCode;

    // 车牌号
    private String plateNumber;

    // 指标号
    private String indicatorsNo;

    // 指标发放日期
    private Date   indicatorsTime;

    // 指标有效期
    private Date   indicatorsPeriod;

    // 机动車所有人
    private String ownerName;

    // 七座以下客车
    private String vehicleType;

    // 型号
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

    // 状态 (1, "未处理" 2, "拒绝" 3, "已确认" 4,"已发送")
    private int    status;

    // 操作员id
    private long   operatorClerkId;

    // 处理时间
    private Date   recordTime;

    // 临时号牌
    private String temporaryplate;

    // 边检审批状态（1,"处理中" 2, "未通过",3, "已通过"）
    private int    borderStatus;

    // 国检审批状态（1,"处理中" 2, "未通过",3, "已通过"）
    private int    ciqStatus;

    // 海关审批状态（1,"处理中" 2, "未通过",3, "已通过"）
    private int    customsStatus;

    // 拒绝原因
    private String reason;

    // 申请编号
    private String formInstCode;

    public TaskingBorder() {

    }

    public TaskingBorder(long id, long taskingId, long clerkId, long creator, String name, String type, Date applyTime, Date receiveTime, Date dealTime, long formId, long formInstanceId, long formInstanceHistId, String processId, String processInstId, String workitemId, String pcPageUrl, String code, String applyType, String clerkType, String clerkName, String idCard, String companyName, String companyCode, String plateNumber, String indicatorsNo, Date indicatorsTime, Date indicatorsPeriod, String ownerName, String vehicleType, String specification, String engineNo, String frameNumber, String permittedWeight, String passengers, String brand, String fplateNumber, int status, long operatorClerkId, Date recordTime, String temporaryplate, int borderStatus, int ciqStatus, int customsStatus,
            String reason, String formInstCode) {

        this.id = id;
        this.taskingId = taskingId;
        this.clerkId = clerkId;
        this.creator = creator;
        this.name = name;
        this.type = type;
        this.applyTime = applyTime;
        this.receiveTime = receiveTime;
        this.dealTime = dealTime;
        this.formId = formId;
        this.formInstanceId = formInstanceId;
        this.formInstanceHistId = formInstanceHistId;
        this.processId = processId;
        this.processInstId = processInstId;
        this.workitemId = workitemId;
        this.pcPageUrl = pcPageUrl;
        this.code = code;
        this.applyType = applyType;
        this.clerkType = clerkType;
        this.clerkName = clerkName;
        this.idCard = idCard;
        this.companyName = companyName;
        this.companyCode = companyCode;
        this.plateNumber = plateNumber;
        this.indicatorsNo = indicatorsNo;
        this.indicatorsTime = indicatorsTime;
        this.indicatorsPeriod = indicatorsPeriod;
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.specification = specification;
        this.engineNo = engineNo;
        this.frameNumber = frameNumber;
        this.permittedWeight = permittedWeight;
        this.passengers = passengers;
        this.brand = brand;
        this.fplateNumber = fplateNumber;
        this.status = status;
        this.operatorClerkId = operatorClerkId;
        this.recordTime = recordTime;
        this.temporaryplate = temporaryplate;
        this.borderStatus = borderStatus;
        this.ciqStatus = ciqStatus;
        this.customsStatus = customsStatus;
        this.reason = reason;
        this.formInstCode = formInstCode;
    }

    public void setId(long id) {

        this.id = id;
    }

    public long getId() {

        return id;
    }

    public void setTaskingId(long taskingId) {

        this.taskingId = taskingId;
    }

    public long getTaskingId() {

        return taskingId;
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

    public void setClerkType(String clerkType) {

        this.clerkType = clerkType;
    }

    public String getClerkType() {

        return clerkType;
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

    public void setIndicatorsNo(String indicatorsNo) {

        this.indicatorsNo = indicatorsNo;
    }

    public String getIndicatorsNo() {

        return indicatorsNo;
    }

    public void setIndicatorsTime(Date indicatorsTime) {

        this.indicatorsTime = indicatorsTime;
    }

    public Date getIndicatorsTime() {

        return indicatorsTime;
    }

    public void setIndicatorsPeriod(Date indicatorsPeriod) {

        this.indicatorsPeriod = indicatorsPeriod;
    }

    public Date getIndicatorsPeriod() {

        return indicatorsPeriod;
    }

    public void setOwnerName(String ownerName) {

        this.ownerName = ownerName;
    }

    public String getOwnerName() {

        return ownerName;
    }

    public void setVehicleType(String vehicleType) {

        this.vehicleType = vehicleType;
    }

    public String getVehicleType() {

        return vehicleType;
    }

    public void setSpecification(String specification) {

        this.specification = specification;
    }

    public String getSpecification() {

        return specification;
    }

    public void setEngineNo(String engineNo) {

        this.engineNo = engineNo;
    }

    public String getEngineNo() {

        return engineNo;
    }

    public void setFrameNumber(String frameNumber) {

        this.frameNumber = frameNumber;
    }

    public String getFrameNumber() {

        return frameNumber;
    }

    public void setPermittedWeight(String permittedWeight) {

        this.permittedWeight = permittedWeight;
    }

    public String getPermittedWeight() {

        return permittedWeight;
    }

    public void setPassengers(String passengers) {

        this.passengers = passengers;
    }

    public String getPassengers() {

        return passengers;
    }

    public void setBrand(String brand) {

        this.brand = brand;
    }

    public String getBrand() {

        return brand;
    }

    public void setFplateNumber(String fplateNumber) {

        this.fplateNumber = fplateNumber;
    }

    public String getFplateNumber() {

        return fplateNumber;
    }

    public void setStatus(int status) {

        this.status = status;
    }

    public int getStatus() {

        return status;
    }

    public void setOperatorClerkId(long operatorClerkId) {

        this.operatorClerkId = operatorClerkId;
    }

    public long getOperatorClerkId() {

        return operatorClerkId;
    }

    public void setRecordTime(Date recordTime) {

        this.recordTime = recordTime;
    }

    public Date getRecordTime() {

        return recordTime;
    }

    public void setTemporaryplate(String temporaryplate) {

        this.temporaryplate = temporaryplate;
    }

    public String getTemporaryplate() {

        return temporaryplate;
    }

    public void setBorderStatus(int borderStatus) {

        this.borderStatus = borderStatus;
    }

    public int getBorderStatus() {

        return borderStatus;
    }

    public void setCiqStatus(int ciqStatus) {

        this.ciqStatus = ciqStatus;
    }

    public int getCiqStatus() {

        return ciqStatus;
    }

    public void setCustomsStatus(int customsStatus) {

        this.customsStatus = customsStatus;
    }

    public int getCustomsStatus() {

        return customsStatus;
    }

    public void setReason(String reason) {

        this.reason = reason;
    }

    public String getReason() {

        return reason;
    }

    public String getFormInstCode() {

        return formInstCode;
    }

    public void setFormInstCode(String formInstCode) {

        this.formInstCode = formInstCode;
    }
}
