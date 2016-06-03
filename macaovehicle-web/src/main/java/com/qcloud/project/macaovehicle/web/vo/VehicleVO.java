package com.qcloud.project.macaovehicle.web.vo;

public class VehicleVO {

    // ID
    private long   id;

    private long   carOwnerId;

    // 车牌号
    private String plateNumber;

    // 行驶证号码
    private String licenseNumber;

    // 行驶证拍照
    private String licenseImage;

    // 车品牌
    private String brand;

    // 车辆规格型号
    private String specification;

    // 车型 1小车2货车
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

    // 燃料种类 1汽油2柴油
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

    private String licenseImageUid;

    // 车辆正面
    private String faceImageUid;

    // 车辆左侧45度（前）
    private String leftfaceImageUid;

    // 车辆右侧45度（前）：
    private String rightfaceImageUid;

    // 车辆左侧45度（后）：
    private String leftbackImageUid;

    // 车辆右侧45度（后）：
    private String rightbackImageUid;

    // 境外車牌號碼
    private String fplateNumber;

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

    // 七座以下客車
    private String vehicleType;

    // 保险单图片
    private String insuranceUrl;

    // 保险单图片
    private String insuranceUrlUid;

    private int    state;

    // 时间有效期
    private String validDateStr;

    // 卡id是否可用
    private int    ricState;

    // 临时号牌是否可用
    private int    temState;

    // 指标号
    private String indicators;

    // 指标号有效期
    private String indicatorsTimeStr;

    public String getFplateNumber() {

        return fplateNumber;
    }

    public void setFplateNumber(String fplateNumber) {

        this.fplateNumber = fplateNumber;
    }

    public String getArea() {

        return area;
    }

    public void setArea(String area) {

        this.area = area;
    }

    public String getEngineNo() {

        return engineNo;
    }

    public void setEngineNo(String engineNo) {

        this.engineNo = engineNo;
    }

    public String getPermittedWeight() {

        return permittedWeight;
    }

    public void setPermittedWeight(String permittedWeight) {

        this.permittedWeight = permittedWeight;
    }

    public String getPassengers() {

        return passengers;
    }

    public void setPassengers(String passengers) {

        this.passengers = passengers;
    }

    public String getEffectiveDates() {

        return effectiveDates;
    }

    public void setEffectiveDates(String effectiveDates) {

        this.effectiveDates = effectiveDates;
    }

    public String getEndDates() {

        return endDates;
    }

    public void setEndDates(String endDates) {

        this.endDates = endDates;
    }

    public String getVehicleType() {

        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {

        this.vehicleType = vehicleType;
    }

    public int getState() {

        return state;
    }

    public void setState(int state) {

        this.state = state;
    }

    public VehicleVO() {

    }

    public long getId() {

        return id;
    }

    public void setId(long id) {

        this.id = id;
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

    public String getLicenseNumber() {

        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {

        this.licenseNumber = licenseNumber;
    }

    public String getLicenseImage() {

        return licenseImage;
    }

    public void setLicenseImage(String licenseImage) {

        this.licenseImage = licenseImage;
    }

    public String getBrand() {

        return brand;
    }

    public void setBrand(String brand) {

        this.brand = brand;
    }

    public String getSpecification() {

        return specification;
    }

    public void setSpecification(String specification) {

        this.specification = specification;
    }

    public String getAuthority() {

        return authority;
    }

    public void setAuthority(String authority) {

        this.authority = authority;
    }

    public String getBuyTime() {

        return buyTime;
    }

    public void setBuyTime(String buyTime) {

        this.buyTime = buyTime;
    }

    public String getOwnerName() {

        return ownerName;
    }

    public void setOwnerName(String ownerName) {

        this.ownerName = ownerName;
    }

    public String getOwnerPhone() {

        return ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone) {

        this.ownerPhone = ownerPhone;
    }

    public String getOwnerAddress() {

        return ownerAddress;
    }

    public void setOwnerAddress(String ownerAddress) {

        this.ownerAddress = ownerAddress;
    }

    public String getEngineNumber() {

        return engineNumber;
    }

    public void setEngineNumber(String engineNumber) {

        this.engineNumber = engineNumber;
    }

    public String getFrameNumber() {

        return frameNumber;
    }

    public void setFrameNumber(String frameNumber) {

        this.frameNumber = frameNumber;
    }

    public String getStartTime() {

        return startTime;
    }

    public void setStartTime(String startTime) {

        this.startTime = startTime;
    }

    public double getWeight() {

        return weight;
    }

    public void setWeight(double weight) {

        this.weight = weight;
    }

    public double getLength() {

        return length;
    }

    public void setLength(double length) {

        this.length = length;
    }

    public double getHeight() {

        return height;
    }

    public void setHeight(double height) {

        this.height = height;
    }

    public double getWidth() {

        return width;
    }

    public void setWidth(double width) {

        this.width = width;
    }

    public String getColor() {

        return color;
    }

    public void setColor(String color) {

        this.color = color;
    }

    public double getCapacity() {

        return capacity;
    }

    public void setCapacity(double capacity) {

        this.capacity = capacity;
    }

    public int getSeat() {

        return seat;
    }

    public void setSeat(int seat) {

        this.seat = seat;
    }

    public int getBackupWheel() {

        return backupWheel;
    }

    public void setBackupWheel(int backupWheel) {

        this.backupWheel = backupWheel;
    }

    public int getFaceWheel() {

        return faceWheel;
    }

    public void setFaceWheel(int faceWheel) {

        this.faceWheel = faceWheel;
    }

    public int getBackWheel() {

        return backWheel;
    }

    public void setBackWheel(int backWheel) {

        this.backWheel = backWheel;
    }

    public String getRegistTime() {

        return registTime;
    }

    public void setRegistTime(String registTime) {

        this.registTime = registTime;
    }

    public String getFaceImage() {

        return faceImage;
    }

    public void setFaceImage(String faceImage) {

        this.faceImage = faceImage;
    }

    public String getLeftfaceImage() {

        return leftfaceImage;
    }

    public void setLeftfaceImage(String leftfaceImage) {

        this.leftfaceImage = leftfaceImage;
    }

    public String getRightfaceImage() {

        return rightfaceImage;
    }

    public void setRightfaceImage(String rightfaceImage) {

        this.rightfaceImage = rightfaceImage;
    }

    public String getLeftbackImage() {

        return leftbackImage;
    }

    public void setLeftbackImage(String leftbackImage) {

        this.leftbackImage = leftbackImage;
    }

    public String getRightbackImage() {

        return rightbackImage;
    }

    public void setRightbackImage(String rightbackImage) {

        this.rightbackImage = rightbackImage;
    }

    public void setModels(String models) {

        this.models = models;
    }

    public String getModels() {

        return models;
    }

    public void setSteeringWheel(String steeringWheel) {

        this.steeringWheel = steeringWheel;
    }

    public String getSteeringWheel() {

        return steeringWheel;
    }

    public void setType(String type) {

        this.type = type;
    }

    public String getType() {

        return type;
    }

    public String getLicenseImageUid() {

        return licenseImageUid;
    }

    public void setLicenseImageUid(String licenseImageUid) {

        this.licenseImageUid = licenseImageUid;
    }

    public String getFaceImageUid() {

        return faceImageUid;
    }

    public void setFaceImageUid(String faceImageUid) {

        this.faceImageUid = faceImageUid;
    }

    public String getLeftfaceImageUid() {

        return leftfaceImageUid;
    }

    public void setLeftfaceImageUid(String leftfaceImageUid) {

        this.leftfaceImageUid = leftfaceImageUid;
    }

    public String getRightfaceImageUid() {

        return rightfaceImageUid;
    }

    public void setRightfaceImageUid(String rightfaceImageUid) {

        this.rightfaceImageUid = rightfaceImageUid;
    }

    public String getLeftbackImageUid() {

        return leftbackImageUid;
    }

    public void setLeftbackImageUid(String leftbackImageUid) {

        this.leftbackImageUid = leftbackImageUid;
    }

    public String getRightbackImageUid() {

        return rightbackImageUid;
    }

    public void setRightbackImageUid(String rightbackImageUid) {

        this.rightbackImageUid = rightbackImageUid;
    }

    public String getInsuranceUrl() {

        return insuranceUrl;
    }

    public void setInsuranceUrl(String insuranceUrl) {

        this.insuranceUrl = insuranceUrl;
    }

    public String getInsuranceUrlUid() {

        return insuranceUrlUid;
    }

    public void setInsuranceUrlUid(String insuranceUrlUid) {

        this.insuranceUrlUid = insuranceUrlUid;
    }

    public String getValidDateStr() {

        return validDateStr;
    }

    public void setValidDateStr(String validDateStr) {

        this.validDateStr = validDateStr;
    }

    public int getRicState() {

        return ricState;
    }

    public int getTemState() {

        return temState;
    }

    public void setRicState(int ricState) {

        this.ricState = ricState;
    }

    public void setTemState(int temState) {

        this.temState = temState;
    }

    public String getIndicators() {

        return indicators;
    }

    public String getIndicatorsTimeStr() {

        return indicatorsTimeStr;
    }

    public void setIndicators(String indicators) {

        this.indicators = indicators;
    }

    public void setIndicatorsTimeStr(String indicatorsTimeStr) {

        this.indicatorsTimeStr = indicatorsTimeStr;
    }
}
