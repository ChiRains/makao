package com.qcloud.project.macaovehicle.web.vo;

import java.util.Date;

public class OnestopCarRecordVO {

    // ID
    private long   id;

    // 时间
    private Date   date;

    // 关口
    private String gate;

    // 类型(1:入境 2:出境)
    private int    type;

    private String temporaryplate;

    private String plateNumber;

    private String specification;

    public OnestopCarRecordVO() {

    }

    public void setId(long id) {

        this.id = id;
    }

    public long getId() {

        return id;
    }

    public void setDate(Date date) {

        this.date = date;
    }

    public Date getDate() {

        return date;
    }

    public void setGate(String gate) {

        this.gate = gate;
    }

    public String getGate() {

        return gate;
    }

    public void setType(int type) {

        this.type = type;
    }

    public int getType() {

        return type;
    }

    public String getPlateNumber() {

        return plateNumber;
    }

    public String getSpecification() {

        return specification;
    }

    public void setPlateNumber(String plateNumber) {

        this.plateNumber = plateNumber;
    }

    public void setSpecification(String specification) {

        this.specification = specification;
    }

    public String getTemporaryplate() {

        return temporaryplate;
    }

    public void setTemporaryplate(String temporaryplate) {

        this.temporaryplate = temporaryplate;
    }
}
