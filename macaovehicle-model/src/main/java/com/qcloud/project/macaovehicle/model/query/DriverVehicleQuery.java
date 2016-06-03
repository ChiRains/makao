package com.qcloud.project.macaovehicle.model.query;

public class DriverVehicleQuery {

    private String formInstCode;

    private String groupByStr;

    private long   carOwnerId;

    private int    state;

    private int    type;

    private long   vehicleId;

    private long   driverId;

    private String ric;

    private String driverIc;

    private long   formInstanceId;

    public String getFormInstCode() {

        return formInstCode;
    }

    public void setFormInstCode(String formInstCode) {

        this.formInstCode = formInstCode;
    }

    public DriverVehicleQuery() {

    }

    public String getGroupByStr() {

        return groupByStr;
    }

    public void setGroupByStr(String groupByStr) {

        this.groupByStr = groupByStr;
    }

    public long getCarOwnerId() {

        return carOwnerId;
    }

    public void setCarOwnerId(long carOwnerId) {

        this.carOwnerId = carOwnerId;
    }

    public int getState() {

        return state;
    }

    public void setState(int state) {

        this.state = state;
    }

    public int getType() {

        return type;
    }

    public void setType(int type) {

        this.type = type;
    }

    public long getVehicleId() {

        return vehicleId;
    }

    public long getDriverId() {

        return driverId;
    }

    public String getRic() {

        return ric;
    }

    public String getDriverIc() {

        return driverIc;
    }

    public void setVehicleId(long vehicleId) {

        this.vehicleId = vehicleId;
    }

    public void setDriverId(long driverId) {

        this.driverId = driverId;
    }

    public void setRic(String ric) {

        this.ric = ric;
    }

    public void setDriverIc(String driverIc) {

        this.driverIc = driverIc;
    }

    public long getFormInstanceId() {

        return formInstanceId;
    }

    public void setFormInstanceId(long formInstanceId) {

        this.formInstanceId = formInstanceId;
    }
}
