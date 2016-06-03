package com.qcloud.project.macaovehicle.model.query;

import java.util.Date;

public class IllegalPoliceRecordQuery {

    private long   carOwnerId;

    // 境外车牌号
    private String plateNumber;

    // 临时号牌
    private String tplateNumber;

    // 部门id
    private long   departmentId;

    // 搜索申请时间
    private Date   applyTimeFront;

    // 搜索申请时间
    private Date   applyTimeBack;

    public IllegalPoliceRecordQuery() {

    }

    public long getCarOwnerId() {

        return carOwnerId;
    }

    public void setCarOwnerId(long carOwnerId) {

        this.carOwnerId = carOwnerId;
    }

    public String getPlateNumber() {

        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {

        this.plateNumber = plateNumber;
    }

    public String getTplateNumber() {

        return tplateNumber;
    }

    public long getDepartmentId() {

        return departmentId;
    }

    public Date getApplyTimeFront() {

        return applyTimeFront;
    }

    public Date getApplyTimeBack() {

        return applyTimeBack;
    }

    public void setTplateNumber(String tplateNumber) {

        this.tplateNumber = tplateNumber;
    }

    public void setDepartmentId(long departmentId) {

        this.departmentId = departmentId;
    }

    public void setApplyTimeFront(Date applyTimeFront) {

        this.applyTimeFront = applyTimeFront;
    }

    public void setApplyTimeBack(Date applyTimeBack) {

        this.applyTimeBack = applyTimeBack;
    }
}
