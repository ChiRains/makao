package com.qcloud.component.snakerext.web.vo;

import java.util.Date;
import java.math.BigDecimal;

public class ProcessGroupClerkVO {

    private long id;

    private long clerkId;

    private long groupId;

    public ProcessGroupClerkVO() {

    }

    public ProcessGroupClerkVO(long id, long clerkId) {

        this.id = id;
        this.clerkId = clerkId;
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

    
    public long getGroupId() {
    
        return groupId;
    }

    
    public void setGroupId(long groupId) {
    
        this.groupId = groupId;
    }
}
