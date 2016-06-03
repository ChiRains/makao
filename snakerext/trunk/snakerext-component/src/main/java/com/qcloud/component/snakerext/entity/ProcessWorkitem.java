package com.qcloud.component.snakerext.entity;

public class ProcessWorkitem {

    private String workitem;

    private String name;

    private String clerkName;

    private String time;

    // 1未审批 2通过 3不通过
    private int    state;

    public String getWorkitem() {

        return workitem;
    }

    public void setWorkitem(String workitem) {

        this.workitem = workitem;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getClerkName() {

        return clerkName;
    }

    public void setClerkName(String clerkName) {

        this.clerkName = clerkName;
    }

    public String getTime() {

        return time;
    }

    public void setTime(String time) {

        this.time = time;
    }

    public int getState() {

        return state;
    }

    public void setState(int state) {

        this.state = state;
    }
}
