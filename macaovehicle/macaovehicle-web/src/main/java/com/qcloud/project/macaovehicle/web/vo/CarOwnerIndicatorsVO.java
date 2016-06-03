package com.qcloud.project.macaovehicle.web.vo;

import java.util.Date;
import java.math.BigDecimal;

public class CarOwnerIndicatorsVO {

    // id
    private long   id;

    private long   vehicleId;

    // 指标号
    private String indicatorsNo;

    // 指标所有人
    private String userName;

    // 有效期
    private String validityPeriod;

    public CarOwnerIndicatorsVO() {

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

    public String getValidityPeriod() {

        return validityPeriod;
    }

    public void setValidityPeriod(String validityPeriod) {

        this.validityPeriod = validityPeriod;
    }

    public long getVehicleId() {

        return vehicleId;
    }

    public void setVehicleId(long vehicleId) {

        this.vehicleId = vehicleId;
    }
}
