package com.qcloud.project.macaovehicle.web.vo;

import java.util.Date;

public class HistoryRecordsVO {

    // id
    private long   id;

    private long   carOwnerId;

    // 被修改项字段
    private String updateParam;

    // 被修改项
    private String updateParamStr;

    // 原有值
    private String oldValue;

    // 修改值
    private String newValue;

    // 更新时间
    private Date   updateTime;

    // 操作人
    private long   clerkId;

    // 类型（ 1务工 2购房 3企业-投资 4高级人才 5购地）
    private int    type;

    // 操作员
    private String clerkName;

    private String updateTimeStr;

    public void setId(long id) {

        this.id = id;
    }

    public long getId() {

        return id;
    }

    public void setCarOwnerId(long carOwnerId) {

        this.carOwnerId = carOwnerId;
    }

    public long getCarOwnerId() {

        return carOwnerId;
    }

    public void setUpdateParam(String updateParam) {

        this.updateParam = updateParam;
    }

    public String getUpdateParam() {

        return updateParam;
    }

    public void setUpdateParamStr(String updateParamStr) {

        this.updateParamStr = updateParamStr;
    }

    public String getUpdateParamStr() {

        return updateParamStr;
    }

    public void setOldValue(String oldValue) {

        this.oldValue = oldValue;
    }

    public String getOldValue() {

        return oldValue;
    }

    public void setNewValue(String newValue) {

        this.newValue = newValue;
    }

    public String getNewValue() {

        return newValue;
    }

    public void setUpdateTime(Date updateTime) {

        this.updateTime = updateTime;
    }

    public Date getUpdateTime() {

        return updateTime;
    }

    public void setType(int type) {

        this.type = type;
    }

    public int getType() {

        return type;
    }

    public long getClerkId() {

        return clerkId;
    }

    public String getClerkName() {

        return clerkName;
    }

    public void setClerkId(long clerkId) {

        this.clerkId = clerkId;
    }

    public void setClerkName(String clerkName) {

        this.clerkName = clerkName;
    }

    public String getUpdateTimeStr() {

        return updateTimeStr;
    }

    public void setUpdateTimeStr(String updateTimeStr) {

        this.updateTimeStr = updateTimeStr;
    }
}
