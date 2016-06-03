package com.qcloud.project.macaovehicle.model;

import java.util.Date;
import java.math.BigDecimal;

public class DriverVehicle {

    private long   id;

    // 表单编码
    private String formInstCode;

    // 车辆id
    private long   vehicleId;

    // 驾驶员id
    private long   driverId;

    // 电子车牌号（16位）
    private String ric;

    // 司机IC识别卡号
    private String driverIc;

    // 是否为主司机，（1是，0不是）
    private int    isPrimary;

    // 创建者
    private long   carOwnerId;

    // 创建时间
    private Date   createDate;

    // 修改人
    private String modifier;

    // 修改日期，格式"1989-11-12 00:00:00"
    private Date   modifyDate;

    // 申请状态'1, "申请" 2, "管委会预审通过" 3, "验车通过",4, "管委会核实原件", 5, "交警核实原件" 6, "备案" 7, "排期装卡" 8, "通知装卡" 9, "完成"',
    private int    state;

    // 申请类型
    private int    type;

    // 流程实例id
    private long   formInstanceId;

    // 交警临时号牌
    private String temporaryPlate;

    // 指标号
    private String indicatorsNo;

    // 指标有效期
    private Date   indicatorsTime;

    public DriverVehicle() {

    }

    public DriverVehicle(long id, String formInstCode, long vehicleId, long driverId, String ric, String driverIc, int isPrimary, long carOwnerId, Date createDate, String modifier, Date modifyDate, int state, int type, long formInstanceId, String temporaryPlate, String indicatorsNo, Date indicatorsTime) {

        this.id = id;
        this.formInstCode = formInstCode;
        this.vehicleId = vehicleId;
        this.driverId = driverId;
        this.ric = ric;
        this.driverIc = driverIc;
        this.isPrimary = isPrimary;
        this.carOwnerId = carOwnerId;
        this.createDate = createDate;
        this.modifier = modifier;
        this.modifyDate = modifyDate;
        this.state = state;
        this.type = type;
        this.formInstanceId = formInstanceId;
        this.temporaryPlate = temporaryPlate;
        this.indicatorsNo = indicatorsNo;
        this.indicatorsTime = indicatorsTime;
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

    public void setVehicleId(long vehicleId) {

        this.vehicleId = vehicleId;
    }

    public long getVehicleId() {

        return vehicleId;
    }

    public void setDriverId(long driverId) {

        this.driverId = driverId;
    }

    public long getDriverId() {

        return driverId;
    }

    public void setRic(String ric) {

        this.ric = ric;
    }

    public String getRic() {

        return ric;
    }

    public void setDriverIc(String driverIc) {

        this.driverIc = driverIc;
    }

    public String getDriverIc() {

        return driverIc;
    }

    public void setIsPrimary(int isPrimary) {

        this.isPrimary = isPrimary;
    }

    public int getIsPrimary() {

        return isPrimary;
    }

    public void setCarOwnerId(long carOwnerId) {

        this.carOwnerId = carOwnerId;
    }

    public long getCarOwnerId() {

        return carOwnerId;
    }

    public void setCreateDate(Date createDate) {

        this.createDate = createDate;
    }

    public Date getCreateDate() {

        return createDate;
    }

    public void setModifier(String modifier) {

        this.modifier = modifier;
    }

    public String getModifier() {

        return modifier;
    }

    public void setModifyDate(Date modifyDate) {

        this.modifyDate = modifyDate;
    }

    public Date getModifyDate() {

        return modifyDate;
    }

    public void setState(int state) {

        this.state = state;
    }

    public int getState() {

        return state;
    }

    public void setType(int type) {

        this.type = type;
    }

    public int getType() {

        return type;
    }

    public void setFormInstanceId(long formInstanceId) {

        this.formInstanceId = formInstanceId;
    }

    public long getFormInstanceId() {

        return formInstanceId;
    }

    public void setTemporaryPlate(String temporaryPlate) {

        this.temporaryPlate = temporaryPlate;
    }

    public String getTemporaryPlate() {

        return temporaryPlate;
    }

    public void setIndicatorsNo(String indicatorsNo) {

        this.indicatorsNo = indicatorsNo;
    }

    public String getIndicatorsNo() {

        return indicatorsNo;
    }

    public Date getIndicatorsTime() {

        return indicatorsTime;
    }

    public void setIndicatorsTime(Date indicatorsTime) {

        this.indicatorsTime = indicatorsTime;
    }
}
