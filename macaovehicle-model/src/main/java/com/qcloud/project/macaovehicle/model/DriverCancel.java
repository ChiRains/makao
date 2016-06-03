package com.qcloud.project.macaovehicle.model;

import java.util.Date;
import java.math.BigDecimal;

public class DriverCancel {
	
	//ID
	private long id;		
	
	//表单编码(不涉及流程)
	private String formInstCode;		
	
	//车主id
	private long carOwnerId;		
	
	//车辆id
	private long vehicleId;		
	
	//驾驶员id
	private long driverId;		
	
	//驾驶员姓名
	private String driverName;		
	
	//证件类型
	private int certificateType;		
	
	//证件号码
	private String certificateNo;		
	
	//境外车牌号
	private String plateNumber;		
	
	//临时号牌
	private String temporaryplate;		
	
	//记录时间
	private Date recordTime;		
	
	//驾驶员卡id
	private String driverIc;		
	
	//状态（1未标记  2已标记）
	private int state;		

	public DriverCancel(){
	
	}

	public DriverCancel(long id,String formInstCode,long carOwnerId,long vehicleId,long driverId,String driverName,int certificateType,String certificateNo,String plateNumber,String temporaryplate,Date recordTime,String driverIc,int state){
		this.id = id;		
		this.formInstCode = formInstCode;		
		this.carOwnerId = carOwnerId;		
		this.vehicleId = vehicleId;		
		this.driverId = driverId;		
		this.driverName = driverName;		
		this.certificateType = certificateType;		
		this.certificateNo = certificateNo;		
		this.plateNumber = plateNumber;		
		this.temporaryplate = temporaryplate;		
		this.recordTime = recordTime;		
		this.driverIc = driverIc;		
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
		
	public void setDriverId(long driverId) {
		this.driverId = driverId;
	}

	public long getDriverId() {
		return driverId;
	}	
		
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getDriverName() {
		return driverName;
	}	
		
	public void setCertificateType(int certificateType) {
		this.certificateType = certificateType;
	}

	public int getCertificateType() {
		return certificateType;
	}	
		
	public void setCertificateNo(String certificateNo) {
		this.certificateNo = certificateNo;
	}

	public String getCertificateNo() {
		return certificateNo;
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
		
	public void setDriverIc(String driverIc) {
		this.driverIc = driverIc;
	}

	public String getDriverIc() {
		return driverIc;
	}	
		
	public void setState(int state) {
		this.state = state;
	}

	public int getState() {
		return state;
	}	
		
}
