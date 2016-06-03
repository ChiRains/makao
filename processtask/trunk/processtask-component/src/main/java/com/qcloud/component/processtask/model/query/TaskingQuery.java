package com.qcloud.component.processtask.model.query;

public class TaskingQuery {

    private String type;

    private Long   clerkId;

    private String process;

    private String clerk;

    private String department;

    private String keywords;

    public TaskingQuery() {

    }

    public String getKeywords() {

        return keywords;
    }

    public void setKeywords(String keywords) {

        this.keywords = keywords;
    }

    public String getType() {

        return type;
    }

    public void setType(String type) {

        this.type = type;
    }

    public Long getClerkId() {

        return clerkId;
    }

    public void setClerkId(Long clerkId) {

        this.clerkId = clerkId;
    }

    public String getProcess() {

        return process;
    }

    public void setProcess(String process) {

        this.process = process;
    }

    public String getClerk() {

        return clerk;
    }

    public void setClerk(String clerk) {

        this.clerk = clerk;
    }

    public String getDepartment() {

        return department;
    }

    public void setDepartment(String department) {

        this.department = department;
    }
}
