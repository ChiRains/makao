package com.qcloud.component.publicdata.model;

import java.util.Date;
import java.math.BigDecimal;

public class City {
	
	private long id;		
	
	private long provinceId;		
	
	//市
	private String name;		

	public City(){
	
	}

	public City(long id,long provinceId,String name){
		this.id = id;		
		this.provinceId = provinceId;		
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
		
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}	
		
}
