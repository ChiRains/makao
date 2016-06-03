package com.qcloud.project.macaovehicle.web.vo;



public class VehicleListVO {

    
    //ID
    private long id;        
    
    //身份证号码
    private String idcardNumber;        
    
    //车牌号
    private String plateNumber;     
    
    //行驶证号码
    private String licenseNumber;       
    
    //车品牌
    private String brand;       
    
    //车辆规格型号
    private String specification;       
    
    //车型 1小车2货车
    private String  models;     
    
    //车主电话
    private String ownerPhone;
    
    private String ownerName;
    
    private String color;
    
    

    
    public long getId() {
    
        return id;
    }

    
    public void setId(long id) {
    
        this.id = id;
    }

    
    public String getIdcardNumber() {
    
        return idcardNumber;
    }

    
    public void setIdcardNumber(String idcardNumber) {
    
        this.idcardNumber = idcardNumber;
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

    

    
    public String getOwnerPhone() {
    
        return ownerPhone;
    }

    
    public void setOwnerPhone(String ownerPhone) {
    
        this.ownerPhone = ownerPhone;
    }


    
    public String getModels() {
    
        return models;
    }


    
    public void setModels(String models) {
    
        this.models = models;
    }


    
    public String getOwnerName() {
    
        return ownerName;
    }


    
    public void setOwnerName(String ownerName) {
    
        this.ownerName = ownerName;
    }


    
    public String getColor() {
    
        return color;
    }


    
    public void setColor(String color) {
    
        this.color = color;
    }      
 

}
