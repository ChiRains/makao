package com.qcloud.component.processtask.model;

import java.util.Date;

public class Tasking {

    // ID
    private long   id;

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

    // 移动端入口
    private String mobilePageUrl;

    // 任务名称
    private String creatorName;

    // 任务名称
    private String departmantName;

    // 任务名称
    private String processName;

    private int    start;

    public Tasking() {

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

    public void setMobilePageUrl(String mobilePageUrl) {

        this.mobilePageUrl = mobilePageUrl;
    }

    public String getMobilePageUrl() {

        return mobilePageUrl;
    }

    public void setCreatorName(String creatorName) {

        this.creatorName = creatorName;
    }

    public String getCreatorName() {

        return creatorName;
    }

    public void setDepartmantName(String departmantName) {

        this.departmantName = departmantName;
    }

    public String getDepartmantName() {

        return departmantName;
    }

    public void setProcessName(String processName) {

        this.processName = processName;
    }

    public String getProcessName() {

        return processName;
    }

    public int getStart() {

        return start;
    }

    public void setStart(int start) {

        this.start = start;
    }
}
