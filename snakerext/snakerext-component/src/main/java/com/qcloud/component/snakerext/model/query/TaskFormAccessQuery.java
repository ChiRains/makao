package com.qcloud.component.snakerext.model.query;
public class TaskFormAccessQuery {
    private String          processId;
    private String          taskName;
    private Long            formId;
    // 主表单
    public static final int MAINFORM_TYPE  = 0;
    // 子表单
    public static final int CHILDFORM_TYPE = 1;
    // 可读
    public static final int READ           = 0;
    // 可写
    public static final int WRITE          = 1;

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Long getFormId() {
        return formId;
    }

    public void setFormId(Long formId) {
        this.formId = formId;
    }
}
