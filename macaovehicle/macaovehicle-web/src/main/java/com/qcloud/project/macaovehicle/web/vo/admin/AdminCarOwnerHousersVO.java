package com.qcloud.project.macaovehicle.web.vo.admin;

import java.util.Date;
import java.math.BigDecimal;

public class AdminCarOwnerHousersVO {
	
	private long id;		
	
	private long carOwnerId;		
	
	//房屋性质
	private String property;		
	
	//规划用途
	private String application;		
	
	//共有情况
	private String situation;		
	
	//房屋编号
	private String code;		
	
	//登记时间
	private String time;		
	
	//房屋坐落
	private String located;		
	
	//房屋结构
	private String structure;		
	
	//层数
	private int floor;		
	
	//建筑面积(㎡)
	private double buildArea;		
	
	//套内建筑面积(㎡)
	private double totalArea;	
	
	//房屋所有权获取方式
	private String method;

	public AdminCarOwnerHousersVO(long id,long carOwnerId,String property,String application,String situation,String code,String time,String located,String structure,int floor,double buildArea,double totalArea){
		this.id = id;		
		this.carOwnerId = carOwnerId;		
		this.property = property;		
		this.application = application;		
		this.situation = situation;		
		this.code = code;		
		this.time = time;		
		this.located = located;		
		this.structure = structure;		
		this.floor = floor;		
		this.buildArea = buildArea;		
		this.totalArea = totalArea;		
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
		
	public void setProperty(String property) {
		this.property = property;
	}

	public String getProperty() {
		return property;
	}	
		
	public void setApplication(String application) {
		this.application = application;
	}

	public String getApplication() {
		return application;
	}	
		
	public void setSituation(String situation) {
		this.situation = situation;
	}

	public String getSituation() {
		return situation;
	}	
		
	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}	
		
	public void setTime(String time) {
		this.time = time;
	}

	public String getTime() {
		return time;
	}	
		
	public void setLocated(String located) {
		this.located = located;
	}

	public String getLocated() {
		return located;
	}	
		
	public void setStructure(String structure) {
		this.structure = structure;
	}

	public String getStructure() {
		return structure;
	}	
		
	public void setFloor(int floor) {
		this.floor = floor;
	}

	public int getFloor() {
		return floor;
	}	
		
	public void setBuildArea(double buildArea) {
		this.buildArea = buildArea;
	}

	public double getBuildArea() {
		return buildArea;
	}	
		
	public void setTotalArea(double totalArea) {
		this.totalArea = totalArea;
	}

	public double getTotalArea() {
		return totalArea;
	}	
		
	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public AdminCarOwnerHousersVO(){
	
	}
}
