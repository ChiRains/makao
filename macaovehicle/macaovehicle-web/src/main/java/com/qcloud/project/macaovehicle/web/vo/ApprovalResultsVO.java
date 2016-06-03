package com.qcloud.project.macaovehicle.web.vo;

import java.util.Date;
import java.math.BigDecimal;

public class ApprovalResultsVO {

    private long   id;

    private long   formInstanceId;

    private String appointmentNumber;

    private String cardNumber;

    private int    type;

    private int    state;

    private Date   time;

    private String timeStr;

    private String stateStr;

    private String typeStr;

    private long   vehicleId;

    private long   driverId;

    public ApprovalResultsVO() {

    }

    public ApprovalResultsVO(long id, long formInstanceId, String appointmentNumber, String cardNumber, int type, int state, Date time) {

        this.id = id;
        this.formInstanceId = formInstanceId;
        this.appointmentNumber = appointmentNumber;
        this.cardNumber = cardNumber;
        this.type = type;
        this.state = state;
        this.time = time;
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

    public String getTimeStr() {

        return timeStr;
    }

    public void setTimeStr(String timeStr) {

        this.timeStr = timeStr;
    }

    public String getStateStr() {

        return stateStr;
    }

    public void setStateStr(String stateStr) {

        this.stateStr = stateStr;
    }

    public String getTypeStr() {

        return typeStr;
    }

    public void setTypeStr(String typeStr) {

        this.typeStr = typeStr;
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
}
