package com.qcloud.component.processtask.web.vo;

import java.util.Date;

public class TaskedVO {

    // ID
    private long    id;

    // 处理人ID
    private long    clerkId;

    private String  clerkName;

    private String  departmentName;

    private String  processName;

    // 流程申请ID
    private long    creator;

    private String  creatorName;

    // 任务名称
    private String  name;

    // 流程类型
    private String  type;

    // 申请时间
    private Date    applyTime;

    private String  applyTimeStr;

    // 接收时间
    private Date    receiveTime;

    private String  receiveTimeStr;

    // 接收时间
    private Date    dealTime;

    private String  dealTimeStr;

    // 表单ID
    private long    formId;

    // 表单实例ID
    private long    formInstanceId;

    // 表单实例历史ID
    private long    formInstanceHistId;

    // 流程ID
    private String  processId;

    // 流程实例ID
    private String  processInstId;

    // 流程任务ID
    private String  workitemId;

    // PC页面
    private String  pcPageUrl;

    // 移动端入口
    private String  mobilePageUrl;

    // 1审批中 2通过 3拒绝
    private int     processState;

    private boolean apply = false;
    
    private String formCode;
    

    public boolean isApply() {

        return apply;
    }

    public void setApply(boolean apply) {

        this.apply = apply;
    }

    public TaskedVO() {

    }

    public void setId(long id) {

        this.id = id;
    }

    public long getId() {

        return id;
    }

    public String getPcPageUrl() {

        return pcPageUrl;
    }

    public void setPcPageUrl(String pcPageUrl) {

        this.pcPageUrl = pcPageUrl;
    }

    public String getMobilePageUrl() {

        return mobilePageUrl;
    }

    public void setMobilePageUrl(String mobilePageUrl) {

        this.mobilePageUrl = mobilePageUrl;
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

    public String getCreatorName() {

        return creatorName;
    }

    public void setCreatorName(String creatorName) {

        this.creatorName = creatorName;
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

    public int getProcessState() {

        return processState;
    }

    public void setProcessState(int processState) {

        this.processState = processState;
    }

    
    public String getFormCode() {
    
        return formCode;
    }

    
    public void setFormCode(String formCode) {
    
        this.formCode = formCode;
    }
}
