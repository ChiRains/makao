package com.qcloud.project.macaovehicle.web.vo.admin;

import java.util.Date;
import java.math.BigDecimal;

public class AdminDvrDetailVO {
	
	private long id;		
	
	//DVR区域表的id
	private long areaId;		
	
	//DVR设备代号(与下拉菜单对应)
	private String code;		
	
	//DVR设备名称
	private String name;		
	
	//DVR设备IP地址
	private String ip;		
	
	//DVR设备生产厂家
	private String vendor;		
	
	//拍摄方向
	private String direction;		
	
	//是否启用(1启用, 0不启用)
	private int status;		

	public AdminDvrDetailVO(){
	
	}

	public AdminDvrDetailVO(long id,long areaId,String code,String name,String ip,String vendor,String direction,int status){
		this.id = id;		
		this.areaId = areaId;		
		this.code = code;		
		this.name = name;		
		this.ip = ip;		
		this.vendor = vendor;		
		this.direction = direction;		
		this.status = status;		
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}	
		
	public void setAreaId(long areaId) {
		this.areaId = areaId;
	}

	public long getAreaId() {
		return areaId;
	}	
		
	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}	
		
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}	
		
	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getIp() {
		return ip;
	}	
		
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getVendor() {
		return vendor;
	}	
		
	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getDirection() {
		return direction;
	}	
		
	public void setStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}	
		
}
