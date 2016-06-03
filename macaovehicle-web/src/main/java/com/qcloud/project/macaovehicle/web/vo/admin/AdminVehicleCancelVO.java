package com.qcloud.project.macaovehicle.web.vo.admin;

import java.util.Date;
import java.math.BigDecimal;

public class AdminVehicleCancelVO {
	
	//ID
	private long id;		
	
	//表单编码(不涉及流程)
	private String formInstCode;		
	
	//车主id
	private long carOwnerId;		
	
	//车辆id
	private long vehicleId;		
	
	//电子车卡
	private String ric;		
	
	//境外车牌号
	private String plateNumber;		
	
	//临时号牌
	private String temporaryplate;		
	
	//记录时间
	private Date recordTime;		
	
	//状态（1未标记  2已标记）
	private int state;		

	public AdminVehicleCancelVO(){
	
	}

	public AdminVehicleCancelVO(long id,String formInstCode,long carOwnerId,long vehicleId,String ric,String plateNumber,String temporaryplate,Date recordTime,int state){
		this.id = id;		
		this.formInstCode = formInstCode;		
		this.carOwnerId = carOwnerId;		
		this.vehicleId = vehicleId;		
		this.ric = ric;		
		this.plateNumber = plateNumber;		
		this.temporaryplate = temporaryplate;		
		this.recordTime = recordTime;		
		this.state = state;		
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}	
		
	public void setFormInstCode(String formInstCode) {
		this.formInstCode = formInstCode;
	}

	public String getFormInstCode() {
		return formInstCode;
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
		
	public void setRic(String ric) {
		this.ric = ric;
	}

	public String getRic() {
		return ric;
	}	
		
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public String getPlateNumber() {
		return plateNumber;
	}	
		
	public void setTemporaryplate(String temporaryplate) {
		this.temporaryplate = temporaryplate;
	}

	public String getTemporaryplate() {
		return temporaryplate;
	}	
		
	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}

	public Date getRecordTime() {
		return recordTime;
	}	
		
	public void setState(int state) {
		this.state = state;
	}

	public int getState() {
		return state;
	}	
		
}
