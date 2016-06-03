package com.qcloud.project.macaovehicle.web.vo;

import java.util.Date;

public class VehicleLossVO {

    // ID
    private long   id;

    // 表单编码(不涉及流程)
    private String formInstCode;

    // ID
    private long   carOwnerId;

    // 车辆id
    private long   vehicleId;

    // 旧电子车卡卡号
    private String oldRic;

    // 新电子车卡卡号
    private String newRic;

    // 挂失时间
    private Date   lossTime;

    // 已标记时间
    private Date   recordTime;

    // 类型（1 挂失 2补办 3已处理）
    private int    type;

    private String plateNumber;

    private String temporaryplate;

    private String endDateStr;

    private String lossTimeStr;

    public VehicleLossVO() {

    }

    public void setId(long id) {

        this.id = id;
    }

    public long getId() {

        return id;
    }

    public void setFormInstCode(String formInstCode) {

        this.formInstCode = formInstCode;
    }

    public String getFormInstCode() {

        return formInstCode;
    }

    public void setCarOwnerId(long carOwnerId) {

        this.carOwnerId = carOwnerId;
    }

    public long getCarOwnerId() {

        return carOwnerId;
    }

    public void setVehicleId(long vehicleId) {

        this.vehicleId = vehicleId;
    }

    public long getVehicleId() {

        return vehicleId;
    }

    public void setOldRic(String oldRic) {

        this.oldRic = oldRic;
    }

    public String getOldRic() {

        return oldRic;
    }

    public void setNewRic(String newRic) {

        this.newRic = newRic;
    }

    public String getNewRic() {

        return newRic;
    }

    public void setLossTime(Date lossTime) {

        this.lossTime = lossTime;
    }

    public Date getLossTime() {

        return lossTime;
    }

    public void setRecordTime(Date recordTime) {

        this.recordTime = recordTime;
    }

    public Date getRecordTime() {

        return recordTime;
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

    public void setPlateNumber(String plateNumber) {

        this.plateNumber = plateNumber;
    }

    public String getTemporaryplate() {

        return temporaryplate;
    }

    public String getEndDateStr() {

        return endDateStr;
    }

    public String getLossTimeStr() {

        return lossTimeStr;
    }

    public void setTemporaryplate(String temporaryplate) {

        this.temporaryplate = temporaryplate;
    }

    public void setEndDateStr(String endDateStr) {

        this.endDateStr = endDateStr;
    }

    public void setLossTimeStr(String lossTimeStr) {

        this.lossTimeStr = lossTimeStr;
    }
}
