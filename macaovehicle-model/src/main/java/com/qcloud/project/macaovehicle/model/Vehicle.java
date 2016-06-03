package com.qcloud.project.macaovehicle.model;

import java.util.Date;
import java.math.BigDecimal;

public class Vehicle {

    // ID
    private long   id;

    private long   carOwnerId;

    // 境外车牌号
    private String plateNumber;

    // 行驶证号码
    private String licenseNumber;

    // 行驶证拍照
    private String licenseImage;

    // 车品牌
    private String brand;

    // 车辆规格型号
    private String specification;

    // 车型
    private String models;

    // 发证机关
    private String authority;

    // 购置时间
    private String buyTime;

    // 车主姓名
    private String ownerName;

    // 车主电话
    private String ownerPhone;

    // 车主地址
    private String ownerAddress;

    // 发动机号
    private String engineNumber;

    // 车架号
    private String frameNumber;

    // 方向盘 1左2右
    private String steeringWheel;

    // 启用年份
    private String startTime;

    // 自重 KG
    private double weight;

    // 车身长 m
    private double length;

    // 车高 m
    private double height;

    // 车宽 m
    private double width;

    // 颜色
    private String color;

    // 燃料种类 1汽油2柴油3混合油4液化石油气5天然气6电7太阳能8生物燃料9氢
    private String type;

    // 容量
    private double capacity;

    // 吨位/座
    private int    seat;

    // 备用轮胎个数
    private int    backupWheel;

    // 前轮胎个数
    private int    faceWheel;

    // 后轮胎个数
    private int    backWheel;

    // 注册时间
    private String registTime;

    // 车辆正面
    private String faceImage;

    // 车辆左侧45度（前）
    private String leftfaceImage;

    // 车辆右侧45度（前）：
    private String rightfaceImage;

    // 车辆左侧45度（后）：
    private String leftbackImage;

    // 车辆右侧45度（后）：
    private String rightbackImage;

    // 所属国籍
    private String area;

    // 发动机号
    private String engineNo;

    // 核定载质量
    private String permittedWeight;

    // 核定载客
    private String passengers;

    // 保险生效日期
    private String effectiveDates;

    // 保险终止日期
    private String endDates;

    // 保险单图片
    private String insuranceUrl;

    // 申请状态(0，未申请；1，正在审批；2，可入境；3，审批不通过)
    private int    state;

    // 电子车牌号id
    private String ric;

    // 车辆可入境通过时间
    private Date   approveTime;

    // 临时号牌
    private String temporaryplate;

    // 卡id是否可用
    private int    ricState;

    // 临时号牌是否可用
    private int    temState;

    // 指标号
    private String indicators;

    // 指标号有效期
    private Date   indicatorsTime;

    // 曾用临时号牌
    private String temporaryplated;

    public Vehicle() {

    }

    public Vehicle(long id, long carOwnerId, String plateNumber, String licenseNumber, String licenseImage, String brand, String specification, String models, String authority, String buyTime, String ownerName, String ownerPhone, String ownerAddress, String engineNumber, String frameNumber, String steeringWheel, String startTime, double weight, double length, double height, double width, String color, String type, double capacity, int seat, int backupWheel, int faceWheel, int backWheel, String registTime, String faceImage, String leftfaceImage, String rightfaceImage, String leftbackImage, String rightbackImage, String area, String engineNo, String permittedWeight, String passengers, String effectiveDates, String endDates, String insuranceUrl, int state, String ric, Date approveTime,
            String temporaryplate, int ricState, int temState, String indicators, Date indicatorsTime, String temporaryplated) {

        this.id = id;
        this.carOwnerId = carOwnerId;
        this.plateNumber = plateNumber;
        this.licenseNumber = licenseNumber;
        this.licenseImage = licenseImage;
        this.brand = brand;
        this.specification = specification;
        this.models = models;
        this.authority = authority;
        this.buyTime = buyTime;
        this.ownerName = ownerName;
        this.ownerPhone = ownerPhone;
        this.ownerAddress = ownerAddress;
        this.engineNumber = engineNumber;
        this.frameNumber = frameNumber;
        this.steeringWheel = steeringWheel;
        this.startTime = startTime;
        this.weight = weight;
        this.length = length;
        this.height = height;
        this.width = width;
        this.color = color;
        this.type = type;
        this.capacity = capacity;
        this.seat = seat;
        this.backupWheel = backupWheel;
        this.faceWheel = faceWheel;
        this.backWheel = backWheel;
        this.registTime = registTime;
        this.faceImage = faceImage;
        this.leftfaceImage = leftfaceImage;
        this.rightfaceImage = rightfaceImage;
        this.leftbackImage = leftbackImage;
        this.rightbackImage = rightbackImage;
        this.area = area;
        this.engineNo = engineNo;
        this.permittedWeight = permittedWeight;
        this.passengers = passengers;
        this.effectiveDates = effectiveDates;
        this.endDates = endDates;
        this.insuranceUrl = insuranceUrl;
        this.state = state;
        this.ric = ric;
        this.approveTime = approveTime;
        this.temporaryplate = temporaryplate;
        this.ricState = ricState;
        this.temState = temState;
        this.indicators = indicators;
        this.indicatorsTime = indicatorsTime;
        this.temporaryplated = temporaryplated;
    }

    public void setId(long id) {

        this.id = id;
    }

    public long getId() {

        return id;
    }

    public void setCarOwnerId(long carOwnerId) {

        this.carOwnerId = carOwnerId;
    }

    public long getCarOwnerId() {

        return carOwnerId;
    }

    public void setPlateNumber(String plateNumber) {

        this.plateNumber = plateNumber;
    }

    public String getPlateNumber() {

        return plateNumber;
    }

    public void setLicenseNumber(String licenseNumber) {

        this.licenseNumber = licenseNumber;
    }

    public String getLicenseNumber() {

        return licenseNumber;
    }

    public void setLicenseImage(String licenseImage) {

        this.licenseImage = licenseImage;
    }

    public String getLicenseImage() {

        return licenseImage;
    }

    public void setBrand(String brand) {

        this.brand = brand;
    }

    public String getBrand() {

        return brand;
    }

    public void setSpecification(String specification) {

        this.specification = specification;
    }

    public String getSpecification() {

        return specification;
    }

    public void setModels(String models) {

        this.models = models;
    }

    public String getModels() {

        return models;
    }

    public void setAuthority(String authority) {

        this.authority = authority;
    }

    public String getAuthority() {

        return authority;
    }

    public void setBuyTime(String buyTime) {

        this.buyTime = buyTime;
    }

    public String getBuyTime() {

        return buyTime;
    }

    public void setOwnerName(String ownerName) {

        this.ownerName = ownerName;
    }

    public String getOwnerName() {

        return ownerName;
    }

    public void setOwnerPhone(String ownerPhone) {

        this.ownerPhone = ownerPhone;
    }

    public String getOwnerPhone() {

        return ownerPhone;
    }

    public void setOwnerAddress(String ownerAddress) {

        this.ownerAddress = ownerAddress;
    }

    public String getOwnerAddress() {

        return ownerAddress;
    }

    public void setEngineNumber(String engineNumber) {

        this.engineNumber = engineNumber;
    }

    public String getEngineNumber() {

        return engineNumber;
    }

    public void setFrameNumber(String frameNumber) {

        this.frameNumber = frameNumber;
    }

    public String getFrameNumber() {

        return frameNumber;
    }

    public void setSteeringWheel(String steeringWheel) {

        this.steeringWheel = steeringWheel;
    }

    public String getSteeringWheel() {

        return steeringWheel;
    }

    public void setStartTime(String startTime) {

        this.startTime = startTime;
    }

    public String getStartTime() {

        return startTime;
    }

    public void setWeight(double weight) {

        this.weight = weight;
    }

    public double getWeight() {

        return weight;
    }

    public void setLength(double length) {

        this.length = length;
    }

    public double getLength() {

        return length;
    }

    public void setHeight(double height) {

        this.height = height;
    }

    public double getHeight() {

        return height;
    }

    public void setWidth(double width) {

        this.width = width;
    }

    public double getWidth() {

        return width;
    }

    public void setColor(String color) {

        this.color = color;
    }

    public String getColor() {

        return color;
    }

    public void setType(String type) {

        this.type = type;
    }

    public String getType() {

        return type;
    }

    public void setCapacity(double capacity) {

        this.capacity = capacity;
    }

    public double getCapacity() {

        return capacity;
    }

    public void setSeat(int seat) {

        this.seat = seat;
    }

    public int getSeat() {

        return seat;
    }

    public void setBackupWheel(int backupWheel) {

        this.backupWheel = backupWheel;
    }

    public int getBackupWheel() {

        return backupWheel;
    }

    public void setFaceWheel(int faceWheel) {

        this.faceWheel = faceWheel;
    }

    public int getFaceWheel() {

        return faceWheel;
    }

    public void setBackWheel(int backWheel) {

        this.backWheel = backWheel;
    }

    public int getBackWheel() {

        return backWheel;
    }

    public void setRegistTime(String registTime) {

        this.registTime = registTime;
    }

    public String getRegistTime() {

        return registTime;
    }

    public void setFaceImage(String faceImage) {

        this.faceImage = faceImage;
    }

    public String getFaceImage() {

        return faceImage;
    }

    public void setLeftfaceImage(String leftfaceImage) {

        this.leftfaceImage = leftfaceImage;
    }

    public String getLeftfaceImage() {

        return leftfaceImage;
    }

    public void setRightfaceImage(String rightfaceImage) {

        this.rightfaceImage = rightfaceImage;
    }

    public String getRightfaceImage() {

        return rightfaceImage;
    }

    public void setLeftbackImage(String leftbackImage) {

        this.leftbackImage = leftbackImage;
    }

    public String getLeftbackImage() {

        return leftbackImage;
    }

    public void setRightbackImage(String rightbackImage) {

        this.rightbackImage = rightbackImage;
    }

    public String getRightbackImage() {

        return rightbackImage;
    }

    public void setArea(String area) {

        this.area = area;
    }

    public String getArea() {

        return area;
    }

    public void setEngineNo(String engineNo) {

        this.engineNo = engineNo;
    }

    public String getEngineNo() {

        return engineNo;
    }

    public void setPermittedWeight(String permittedWeight) {

        this.permittedWeight = permittedWeight;
    }

    public String getPermittedWeight() {

        return permittedWeight;
    }

    public void setPassengers(String passengers) {

        this.passengers = passengers;
    }

    public String getPassengers() {

        return passengers;
    }

    public void setEffectiveDates(String effectiveDates) {

        this.effectiveDates = effectiveDates;
    }

    public String getEffectiveDates() {

        return effectiveDates;
    }

    public void setEndDates(String endDates) {

        this.endDates = endDates;
    }

    public String getEndDates() {

        return endDates;
    }

    public void setInsuranceUrl(String insuranceUrl) {

        this.insuranceUrl = insuranceUrl;
    }

    public String getInsuranceUrl() {

        return insuranceUrl;
    }

    public void setState(int state) {

        this.state = state;
    }

    public int getState() {

        return state;
    }

    public void setRic(String ric) {

        this.ric = ric;
    }

    public String getRic() {

        return ric;
    }

    public void setApproveTime(Date approveTime) {

        this.approveTime = approveTime;
    }

    public Date getApproveTime() {

        return approveTime;
    }

    public void setTemporaryplate(String temporaryplate) {

        this.temporaryplate = temporaryplate;
    }

    public String getTemporaryplate() {

        return temporaryplate;
    }

    public void setRicState(int ricState) {

        this.ricState = ricState;
    }

    public int getRicState() {

        return ricState;
    }

    public void setTemState(int temState) {

        this.temState = temState;
    }

    public int getTemState() {

        return temState;
    }

    public void setIndicators(String indicators) {

        this.indicators = indicators;
    }

    public String getIndicators() {

        return indicators;
    }

    public void setIndicatorsTime(Date indicatorsTime) {

        this.indicatorsTime = indicatorsTime;
    }

    public Date getIndicatorsTime() {

        return indicatorsTime;
    }

    public String getTemporaryplated() {

        return temporaryplated;
    }

    public void setTemporaryplated(String temporaryplated) {

        this.temporaryplated = temporaryplated;
    }
}
