package com.qcloud.project.macaovehicle.model.query;

public class ProfilesSuccessQuery {

    private long    carOwnerId;

    private long    vehicleId;

    private long    driverId;

    private String  groupByStr;

    private Integer vEnable;

    private Integer dEnable;

    // 境外车牌号
    private String  plateNumber;

    // 驾驶证号码
    private String  licenseNumber;

    // 姓名
    private String  driverName;

    // 驾驶员身份证
    private String  driverIdCard;

    // 车型
    private String  models;

    // 身份证号码
    private String  idcardNumber;

    // 性别
    private int     sex;

    // 国籍
    private int     nation;

    public ProfilesSuccessQuery() {
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

    public long getVehicleId() {

        return vehicleId;
    }

    public long getDriverId() {

        return driverId;
    }

    public void setCarOwnerId(long carOwnerId) {

        this.carOwnerId = carOwnerId;
    }

    public void setVehicleId(long vehicleId) {

        this.vehicleId = vehicleId;
    }

    public void setDriverId(long driverId) {

        this.driverId = driverId;
    }

    public Integer getvEnable() {

        return vEnable;
    }

    public Integer getdEnable() {

        return dEnable;
    }

    public void setvEnable(Integer vEnable) {

        this.vEnable = vEnable;
    }

    public void setdEnable(Integer dEnable) {

        this.dEnable = dEnable;
    }

    public String getPlateNumber() {

        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {

        this.plateNumber = plateNumber;
    }

    public String getLicenseNumber() {

        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {

        this.licenseNumber = licenseNumber;
    }

    public String getDriverName() {

        return driverName;
    }

    public void setDriverName(String driverName) {

        this.driverName = driverName;
    }

    public String getDriverIdCard() {

        return driverIdCard;
    }

    public void setDriverIdCard(String driverIdCard) {

        this.driverIdCard = driverIdCard;
    }

    public String getModels() {

        return models;
    }

    public void setModels(String models) {

        this.models = models;
    }

    public String getIdcardNumber() {

        return idcardNumber;
    }

    public void setIdcardNumber(String idcardNumber) {

        this.idcardNumber = idcardNumber;
    }

    public int getSex() {

        return sex;
    }

    public void setSex(int sex) {

        this.sex = sex;
    }

    public int getNation() {

        return nation;
    }

    public void setNation(int nation) {

        this.nation = nation;
    }
}
