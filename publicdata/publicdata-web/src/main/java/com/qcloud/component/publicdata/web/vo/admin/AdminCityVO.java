package com.qcloud.component.publicdata.web.vo.admin;

import com.qcloud.component.publicdata.IntKeyValue;

public class AdminCityVO implements IntKeyValue{
	
	@Override
    public long getKey() {       
        return id;
    }

    @Override
    public String getValue() {       
        return name;
    }

    private long id;		
	
	private long provinceId;		
	
	private String province;
	
	//市
	private String name;		

	public AdminCityVO(){
	
	}

	public AdminCityVO(long id,long provinceId,String name){
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

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
