package com.qcloud.component.processtask.web.vo;

public class AppTaskedVO {

    // ID
    private long    id;

    private String  departmentName;

    private String  processName;

    private String  creatorName;

    private String  applyTimeStr;

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

    // 移动端入口
    private String  mobilePageUrl;

    private String  processStateStr;

    private String  image;

    private boolean apply = false;

    public boolean isApply() {

        return apply;
    }

    public void setApply(boolean apply) {

        this.apply = apply;
    }

    public String getProcessStateStr() {

        return processStateStr;
    }

    public void setProcessStateStr(String processStateStr) {

        this.processStateStr = processStateStr;
    }

    public void setId(long id) {

        this.id = id;
    }

    public long getId() {

        return id;
    }

    public String getMobilePageUrl() {

        return mobilePageUrl;
    }

    public void setMobilePageUrl(String mobilePageUrl) {

        this.mobilePageUrl = mobilePageUrl;
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

    public String getCreatorName() {

        return creatorName;
    }

    public void setCreatorName(String creatorName) {

        this.creatorName = creatorName;
    }

    public String getImage() {

        return image;
    }

    public void setImage(String image) {

        this.image = image;
    }
}
