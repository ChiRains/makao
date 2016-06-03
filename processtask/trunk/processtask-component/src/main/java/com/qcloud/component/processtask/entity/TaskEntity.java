package com.qcloud.component.processtask.entity;

import java.util.Date;
import com.qcloud.component.processtask.QTask;

public class TaskEntity implements QTask {

    private Long    clerk;

    private String  name;

    private Long    formInstance;

    private String  workitem;

    private boolean tasking;

    private boolean pass;

    private Date    doneTime;

    public Long getClerk() {

        return clerk;
    }

    public void setClerk(Long clerk) {

        this.clerk = clerk;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public Long getFormInstance() {

        return formInstance;
    }

    public void setFormInstance(Long formInstance) {

        this.formInstance = formInstance;
    }

    public String getWorkitem() {

        return workitem;
    }

    public void setWorkitem(String workitem) {

        this.workitem = workitem;
    }

    public boolean isTasking() {

        return tasking;
    }

    public void setTasking(boolean tasking) {

        this.tasking = tasking;
    }

    public boolean isPass() {

        return pass;
    }

    public void setPass(boolean pass) {

        this.pass = pass;
    }

    public Date getDoneTime() {

        return doneTime;
    }

    public void setDoneTime(Date doneTime) {

        this.doneTime = doneTime;
    }
}
