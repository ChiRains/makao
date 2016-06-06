package com.qcloud.component.form.web.form;

public class Form {

    // 主表单 : 不可为空.
    private Long   formId;

    // 表单实例ID,如果是启动第一步,则可为空,系统会自动生成.
    private Long   formInstanceId;

    private String processId;

    private String processInstId;

    private String workitemId;

    private Long   taskId;

    // 是否保存提交:true是
    private String saveAndSubmit;

    public Long getFormId() {

        return formId;
    }

    public void setFormId(Long formId) {

        this.formId = formId;
    }

    public Long getFormInstanceId() {

        return formInstanceId;
    }

    public void setFormInstanceId(Long formInstanceId) {

        this.formInstanceId = formInstanceId;
    }

    public Long getTaskId() {

        return taskId;
    }

    public void setTaskId(Long taskId) {

        this.taskId = taskId;
    }

    public String getWorkitemId() {

        return workitemId;
    }

    public void setWorkitemId(String workitemId) {

        this.workitemId = workitemId;
    }

    public String getProcessId() {

        return processId;
    }

    public void setProcessId(String processId) {

        this.processId = processId;
    }

    public String getProcessInstId() {

        return processInstId;
    }

    public void setProcessInstId(String processInstId) {

        this.processInstId = processInstId;
    }

    public String getSaveAndSubmit() {

        return saveAndSubmit;
    }

    public void setSaveAndSubmit(String saveAndSubmit) {

        this.saveAndSubmit = saveAndSubmit;
    }
}
