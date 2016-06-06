package com.qcloud.component.publicdata.web.vo;

import java.util.Date;
import java.math.BigDecimal;

public class ExpressDistrictVO {
	
	private long id;		
	
	//快递公司id
	private long expressId;		
	
	//首重重量
	private double firstPrice;		
	
	//续重重量
	private double continuedPrice;		
	
	//省份
	private String province;		
	
	//城市
	private String city;		
	
	//地区
	private String district;		

	public ExpressDistrictVO(){
	
	}

	public ExpressDistrictVO(long id,long expressId,double firstPrice,double continuedPrice,String province,String city,String district){
		this.id = id;		
		this.expressId = expressId;		
		this.firstPrice = firstPrice;		
		this.continuedPrice = continuedPrice;		
		this.province = province;		
		this.city = city;		
		this.district = district;		
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}	
		
	public void setExpressId(long expressId) {
		this.expressId = expressId;
	}

	public long getExpressId() {
		return expressId;
	}	
		
	public void setFirstPrice(double firstPrice) {
		this.firstPrice = firstPrice;
	}

	public double getFirstPrice() {
		return firstPrice;
	}	
		
	public void setContinuedPrice(double continuedPrice) {
		this.continuedPrice = continuedPrice;
	}

	public double getContinuedPrice() {
		return continuedPrice;
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
		
}
