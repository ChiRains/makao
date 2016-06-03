package com.qcloud.project.macaovehicle.model.query;

public class VehicleQuery {
     //车牌号
    private String plateNumber;
    //licenseNumber
    private String  licenseNumber;
    //车型 1小车2货车
    private int models;
   //身份证号码
    private String idcardNumber;
   
    private long carOwnerId;

	public VehicleQuery(){
	
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

    
    public int getModels() {
    
        return models;
    }

    
    public void setModels(int models) {
    
        this.models = models;
    }

    
    public String getIdcardNumber() {
    
        return idcardNumber;
    }

    
    public void setIdcardNumber(String idcardNumber) {
    
        this.idcardNumber = idcardNumber;
    }


    
    public long getCarOwnerId() {
    
        return carOwnerId;
    }


    
    public void setCarOwnerId(long carOwnerId) {
    
        this.carOwnerId = carOwnerId;
    }
	
}
