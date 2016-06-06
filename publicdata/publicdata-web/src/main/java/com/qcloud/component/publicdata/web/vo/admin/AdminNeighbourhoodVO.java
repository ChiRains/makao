package com.qcloud.component.publicdata.web.vo.admin;

import java.util.Date;
import java.math.BigDecimal;

public class AdminNeighbourhoodVO {
	
	private long id;		
	
	//名称
	private String name;		
	
	//省
	private String province;		
	
	//城市
	private String city;		
	
	//地区
	private String district;		
	
	//经度
	private String longitude;		
	
	//纬度
	private String latitude;		

	public AdminNeighbourhoodVO(){
	
	}

	public AdminNeighbourhoodVO(long id,String name,String province,String city,String district,String longitude,String latitude){
		this.id = id;		
		this.name = name;		
		this.province = province;		
		this.city = city;		
		this.district = district;		
		this.longitude = longitude;		
		this.latitude = latitude;		
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}	
		
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}	
		
	public void setProvince(String province) {
		this.province = province;
	}

	public String getProvince() {
		return province;
	}	
		
	public void setCity(String city) {
		this.city = city;
	}

	public String getCity() {
		return city;
	}	
		
	public void setDistrict(String district) {
		this.district = district;
	}

	public String getDistrict() {
		return district;
	}	
		
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLongitude() {
		return longitude;
	}	
		
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLatitude() {
		return latitude;
	}	
		
}
