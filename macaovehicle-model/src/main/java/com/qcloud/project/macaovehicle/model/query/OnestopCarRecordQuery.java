package com.qcloud.project.macaovehicle.model.query;

public class OnestopCarRecordQuery {

    private String dCardid;

    private String vCardid;

    private int    type;

    private String date;

    private String groupByStr;

    private String orderBy;

    public OnestopCarRecordQuery() {

    }

    public String getdCardid() {

        return dCardid;
    }

    public String getvCardid() {

        return vCardid;
    }

    public void setdCardid(String dCardid) {

        this.dCardid = dCardid;
    }

    public void setvCardid(String vCardid) {

        this.vCardid = vCardid;
    }

    public int getType() {

        return type;
    }

    public void setType(int type) {

        this.type = type;
    }

    public String getDate() {

        return date;
    }

    public void setDate(String date) {

        this.date = date;
    }

    public String getGroupByStr() {

        return groupByStr;
    }

    public void setGroupByStr(String groupByStr) {

        this.groupByStr = groupByStr;
    }

    public String getOrderBy() {

        return orderBy;
    }

    public void setOrderBy(String orderBy) {

        this.orderBy = orderBy;
    }
}
