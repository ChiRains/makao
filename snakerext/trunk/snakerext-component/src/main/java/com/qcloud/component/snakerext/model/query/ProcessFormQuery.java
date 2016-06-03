package com.qcloud.component.snakerext.model.query;

public class ProcessFormQuery {

    private String processId;

    private Long   mainFormId;

    private String name;

    public Long getMainFormId() {

        return mainFormId;
    }

    public void setMainFormId(Long mainFormId) {

        this.mainFormId = mainFormId;
    }

    public String getProcessId() {

        return processId;
    }

    public void setProcessId(String processId) {

        this.processId = processId;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }
}
