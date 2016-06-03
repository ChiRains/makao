package com.qcloud.component.publicdata.web.vo.admin;

import java.util.Date;
import java.math.BigDecimal;

public class AdminDistrictVO {
	
	private long id;		
	
	private long provinceId;		
	private String province;
	private long cityId;		
	private String city;
	//区/县
	private String name;		

	public AdminDistrictVO(){
	
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

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }	
}
