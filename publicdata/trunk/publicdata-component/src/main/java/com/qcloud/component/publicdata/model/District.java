package com.qcloud.component.publicdata.model;

import java.util.Date;
import java.math.BigDecimal;

public class District {
	
	private long id;		
	
	private long provinceId;		
	
	private long cityId;		
	
	//区/县
	private String name;		

	public District(){
	
	}

	public District(long id,long provinceId,long cityId,String name){
		this.id = id;		
		this.provinceId = provinceId;		
		this.cityId = cityId;		
		this.name = name;		
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}	
		
	public void setProvinceId(long provinceId) {
		this.provinceId = provinceId;
	}

	public long getProvinceId() {
		return provinceId;
	}	
		
	public void setCityId(long cityId) {
		this.cityId = cityId;
	}

	public long getCityId() {
		return cityId;
	}	
		
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}	
		
}
