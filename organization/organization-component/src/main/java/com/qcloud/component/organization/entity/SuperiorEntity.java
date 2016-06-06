package com.qcloud.component.organization.entity;

import com.qcloud.component.organization.QSuperior;

public class SuperiorEntity implements QSuperior {

    // ID
    private long   id;

    // 职员id
    private long   clerkId;

    // 上级领导id
    private long   leaderId;

    // 职员名称
    private String clerkName;

    // 上级领导名称
    private String leaderName;

    public SuperiorEntity() {

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

    public void setLeaderId(long leaderId) {

        this.leaderId = leaderId;
    }

    public long getLeaderId() {

        return leaderId;
    }

    public String getClerkName() {

        return clerkName;
    }

    public void setClerkName(String clerkName) {

        this.clerkName = clerkName;
    }

    public String getLeaderName() {

        return leaderName;
    }

    public void setLeaderName(String leaderName) {

        this.leaderName = leaderName;
    }
}
