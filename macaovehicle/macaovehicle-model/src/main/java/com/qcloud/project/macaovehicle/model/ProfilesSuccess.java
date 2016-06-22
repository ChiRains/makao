package com.qcloud.project.macaovehicle.model;

import java.util.Date;

public class ProfilesSuccess {

    private long   id;

    // 表单实例id
    private long   formInstanceId;

    // 申请人id
    private long   carOwnerId;

    // 车辆id
    private long   vehicleId;

    // 驾驶员id
    private long   driverId;

    // 创建时间
    private Date   createDate;

    // 是否可用
    private int    vEnable;

    private int    dEnable;

    // 境外车牌号
    private String plateNumber;

    // 驾驶证号码(来自vehicle)
    private String licenseNumber;

    // 姓名
    private String driverName;

    // 驾驶员身份证
    private String driverIdCard;

    // 车型
    private String models;

    // 身份证号码(来自carOwner)
    private String idcardNumber;

    // 性别
    private int    sex;

    // 国籍
    private int    nation;

    public ProfilesSuccess() {
    }

    public ProfilesSuccess(long id, long formInstanceId, long carOwnerId, long vehicleId, long driverId, Date createDate, int vEnable, int dEnable, String plateNumber, String licenseNumber, String driverName, String driverIdCard, String models,  int sex, int nation) {
        super();
        this.id = id;
        this.formInstanceId = formInstanceId;
        this.carOwnerId = carOwnerId;
        this.vehicleId = vehicleId;
        this.driverId = driverId;
        this.createDate = createDate;
        this.vEnable = vEnable;
        this.dEnable = dEnable;
        this.plateNumber = plateNumber;
        this.licenseNumber = licenseNumber;
        this.driverName = driverName;
        this.driverIdCard = driverIdCard;
        this.models = models;
        this.idcardNumber = idcardNumber;
        this.sex = sex;
        this.nation = nation;
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

    public void setDriverId(long driverId) {

        this.driverId = driverId;
    }

    public long getDriverId() {

        return driverId;
    }

    public void setCreateDate(Date createDate) {

        this.createDate = createDate;
    }

    public Date getCreateDate() {

        return createDate;
    }

    public int getvEnable() {

        return vEnable;
    }

    public int getdEnable() {

        return dEnable;
    }

    public void setvEnable(int vEnable) {

        this.vEnable = vEnable;
    }

    public void setdEnable(int dEnable) {

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
