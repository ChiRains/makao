package com.qcloud.project.macaovehicle.model.query;

import java.util.Date;

public class VehicleLossQuery {

    private String formInstCode;

    private String plateNumber;

    // 搜索申请时间
    private Date   applyTimeFront;

    // 搜索申请时间
    private Date   applyTimeBack;

    public VehicleLossQuery() {

    }

    public String getFormInstCode() {

        return formInstCode;
    }

    public String getPlateNumber() {

        return plateNumber;
    }

    public Date getApplyTimeFront() {

        return applyTimeFront;
    }

    public Date getApplyTimeBack() {

        return applyTimeBack;
    }

    public void setFormInstCode(String formInstCode) {

        this.formInstCode = formInstCode;
    }

    public void setPlateNumber(String plateNumber) {

        this.plateNumber = plateNumber;
    }

    public void setApplyTimeFront(Date applyTimeFront) {

        this.applyTimeFront = applyTimeFront;
    }

    public void setApplyTimeBack(Date applyTimeBack) {

        this.applyTimeBack = applyTimeBack;
    }
}
