package com.qcloud.component.publicdata.web.vo.admin;

import com.qcloud.component.publicdata.IntKeyValue;

public class AdminProvinceVO implements IntKeyValue{
	
	private long id;		
	
	//省
	private String name;		

	public AdminProvinceVO(){
	
	}

	public AdminProvinceVO(long id,String name){
		this.id = id;		
		this.name = name;		
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

    @Override
    public long getKey() {       
        return id;
    }

    @Override
    public String getValue() {
        return name;
    }	
}
