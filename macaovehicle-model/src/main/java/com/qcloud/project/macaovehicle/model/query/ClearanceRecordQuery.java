package com.qcloud.project.macaovehicle.model.query;

public class ClearanceRecordQuery {
    private int type;
    
    private String startTime;
    
    private String endTime;
    
    private String carCardNumber;
    
    private String driverCardNumber;
    
    
    
    
	public ClearanceRecordQuery(){
	
	}
    
    public int getType() {
    
        return type;
    }
    
    public void setType(int type) {
    
        this.type = type;
    }

    
    public String getStartTime() {
    
        return startTime;
    }

    
    public void setStartTime(String startTime) {
    
        this.startTime = startTime;
    }

    
    public String getEndTime() {
    
        return endTime;
    }

    
    public void setEndTime(String endTime) {
    
        this.endTime = endTime;
    }

    
    public String getCarCardNumber() {
    
        return carCardNumber;
    }

    
    public void setCarCardNumber(String carCardNumber) {
    
        this.carCardNumber = carCardNumber;
    }

    
    public String getDriverCardNumber() {
    
        return driverCardNumber;
    }

    
    public void setDriverCardNumber(String driverCardNumber) {
    
        this.driverCardNumber = driverCardNumber;
    }
}
