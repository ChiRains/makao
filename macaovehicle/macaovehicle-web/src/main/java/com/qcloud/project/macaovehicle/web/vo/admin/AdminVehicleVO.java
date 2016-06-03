package com.qcloud.project.macaovehicle.web.vo.admin;

import java.util.Date;
import java.math.BigDecimal;

public class AdminVehicleVO {

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
    private String   buyTime;

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
    private String   startTime;

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
    private String   registTime;

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
    
    private int state;


	public AdminVehicleVO() {

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

    public void setAuthority(String authority) {

        this.authority = authority;
    }

    public String getAuthority() {

        return authority;
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

    public String getModels() {

        return models;
    }

    public void setModels(String models) {

        this.models = models;
    }

    public void setSteeringWheel(String steeringWheel) {

        this.steeringWheel = steeringWheel;
    }

    public String getType() {

        return type;
    }

    public void setType(String type) {

        this.type = type;
    }

    public String getSteeringWheel() {

        return steeringWheel;
    }

    
    public String getBuyTime() {
    
        return buyTime;
    }

    
    public void setBuyTime(String buyTime) {
    
        this.buyTime = buyTime;
    }

    
    public String getStartTime() {
    
        return startTime;
    }

    
    public void setStartTime(String startTime) {
    
        this.startTime = startTime;
    }

    
    public String getRegistTime() {
    
        return registTime;
    }

    
    public void setRegistTime(String registTime) {
    
        this.registTime = registTime;
    }
    

    public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
}
