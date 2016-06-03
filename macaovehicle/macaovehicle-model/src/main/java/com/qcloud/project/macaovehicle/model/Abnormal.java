package com.qcloud.project.macaovehicle.model;

import java.util.Date;
import java.math.BigDecimal;

public class Abnormal {
	
	private long id;		
	
	//监控点Id
	private String monitorId;		
	
	//监控点名称
	private String monitorName;		
	
	//发生时间
	private String happenedTime;		
	
	//车卡ID
	private String carCardId;		
	
	//司机卡ID
	private String driverCardId;		
	
	//射频车牌号
	private String rfPlate;		
	
	//视频车牌号
	private String ocrPlate;		
	
	//事件类型：1:越界预警；2；越界告警；其他未定义；
	private String eventType;		
	
	//将图片字节流采用BASE64 编码后传输。
	private String picture;		
	
	//告警次数
	private int alarmNum;		
	
	//本地图片路径
	private String pictureUrl;		

	public Abnormal(){
	
	}

	public Abnormal(long id,String monitorId,String monitorName,String happenedTime,String carCardId,String driverCardId,String rfPlate,String ocrPlate,String eventType,String picture,int alarmNum,String pictureUrl){
		this.id = id;		
		this.monitorId = monitorId;		
		this.monitorName = monitorName;		
		this.happenedTime = happenedTime;		
		this.carCardId = carCardId;		
		this.driverCardId = driverCardId;		
		this.rfPlate = rfPlate;		
		this.ocrPlate = ocrPlate;		
		this.eventType = eventType;		
		this.picture = picture;		
		this.alarmNum = alarmNum;		
		this.pictureUrl = pictureUrl;		
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}	
		
	public void setMonitorId(String monitorId) {
		this.monitorId = monitorId;
	}

	public String getMonitorId() {
		return monitorId;
	}	
		
	public void setMonitorName(String monitorName) {
		this.monitorName = monitorName;
	}

	public String getMonitorName() {
		return monitorName;
	}	
		
	public void setHappenedTime(String happenedTime) {
		this.happenedTime = happenedTime;
	}

	public String getHappenedTime() {
		return happenedTime;
	}	
		
	public void setCarCardId(String carCardId) {
		this.carCardId = carCardId;
	}

	public String getCarCardId() {
		return carCardId;
	}	
		
	public void setDriverCardId(String driverCardId) {
		this.driverCardId = driverCardId;
	}

	public String getDriverCardId() {
		return driverCardId;
	}	
		
	public void setRfPlate(String rfPlate) {
		this.rfPlate = rfPlate;
	}

	public String getRfPlate() {
		return rfPlate;
	}	
		
	public void setOcrPlate(String ocrPlate) {
		this.ocrPlate = ocrPlate;
	}

	public String getOcrPlate() {
		return ocrPlate;
	}	
		
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getEventType() {
		return eventType;
	}	
		
	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getPicture() {
		return picture;
	}	
		
	public void setAlarmNum(int alarmNum) {
		this.alarmNum = alarmNum;
	}

	public int getAlarmNum() {
		return alarmNum;
	}	
		
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}	
		
}
