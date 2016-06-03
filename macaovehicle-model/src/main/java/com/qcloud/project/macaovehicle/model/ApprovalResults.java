package com.qcloud.project.macaovehicle.model;

import java.util.Date;
import java.math.BigDecimal;

public class ApprovalResults {

    private long   id;

    private long   formInstanceId;

    private String appointmentNumber;

    private String cardNumber;

    // 1车卡 2司机卡
    private int    type;

    // 1 申请成功 2 申请号 3 取到卡号 4 发起备案（卡是全的） 51（备案成功） 52 备案失败 61 预约装卡 62 物联网取消卡 7 预约装卡成功 8 初装成功 9 安装成功
    private int    state;

    private Date   time;

    private long   vehicleId;

    private long   driverId;

    private String formInstCode;

    public ApprovalResults() {

    }

    public ApprovalResults(long id, long formInstanceId, String appointmentNumber, String cardNumber, int type, int state, Date time, String formInstCode) {

        this.id = id;
        this.formInstanceId = formInstanceId;
        this.appointmentNumber = appointmentNumber;
        this.cardNumber = cardNumber;
        this.type = type;
        this.state = state;
        this.time = time;
        this.formInstCode = formInstCode;
    }

    public void setId(long id) {

        this.id = id;
    }

    public long getId() {

        return id;
    }

    public void setFormInstanceId(long formInstanceId) {

        this.formInstanceId = formInstanceId;
    }

    public long getFormInstanceId() {

        return formInstanceId;
    }

    public void setAppointmentNumber(String appointmentNumber) {

        this.appointmentNumber = appointmentNumber;
    }

    public String getAppointmentNumber() {

        return appointmentNumber;
    }

    public void setCardNumber(String cardNumber) {

        this.cardNumber = cardNumber;
    }

    public String getCardNumber() {

        return cardNumber;
    }

    public void setType(int type) {

        this.type = type;
    }

    public int getType() {

        return type;
    }

    public void setState(int state) {

        this.state = state;
    }

    public int getState() {

        return state;
    }

    public void setTime(Date time) {

        this.time = time;
    }

    public Date getTime() {

        return time;
    }

    public long getVehicleId() {

        return vehicleId;
    }

    public void setVehicleId(long vehicleId) {

        this.vehicleId = vehicleId;
    }

    public long getDriverId() {

        return driverId;
    }

    public void setDriverId(long driverId) {

        this.driverId = driverId;
    }

    public String getFormInstCode() {

        return formInstCode;
    }

    public void setFormInstCode(String formInstCode) {

        this.formInstCode = formInstCode;
    }
}
