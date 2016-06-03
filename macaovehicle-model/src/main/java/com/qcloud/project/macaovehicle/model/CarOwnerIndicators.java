package com.qcloud.project.macaovehicle.model;

import java.util.Date;

public class CarOwnerIndicators {

    // id
    private long   id;

    private long   vehicleId;

    // 指标号
    private String indicatorsNo;

    // 指标所有人
    private String userName;

    // 有效期
    private Date   validityPeriod;

    public CarOwnerIndicators() {

    }

    public CarOwnerIndicators(long id, long vehicleId, String indicatorsNo, String userName, Date validityPeriod) {

        this.id = id;
        this.vehicleId = vehicleId;
        this.indicatorsNo = indicatorsNo;
        this.userName = userName;
        this.validityPeriod = validityPeriod;
    }

    public void setId(long id) {

        this.id = id;
    }

    public long getId() {

        return id;
    }

    public void setIndicatorsNo(String indicatorsNo) {

        this.indicatorsNo = indicatorsNo;
    }

    public String getIndicatorsNo() {

        return indicatorsNo;
    }

    public void setUserName(String userName) {

        this.userName = userName;
    }

    public String getUserName() {

        return userName;
    }

    public void setValidityPeriod(Date validityPeriod) {

        this.validityPeriod = validityPeriod;
    }

    public Date getValidityPeriod() {

        return validityPeriod;
    }

    public long getVehicleId() {

        return vehicleId;
    }

    public void setVehicleId(long vehicleId) {

        this.vehicleId = vehicleId;
    }
}
