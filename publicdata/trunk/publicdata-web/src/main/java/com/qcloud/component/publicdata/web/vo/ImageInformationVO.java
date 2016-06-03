package com.qcloud.component.publicdata.web.vo;

import java.util.Date;
import java.math.BigDecimal;

public class ImageInformationVO {
	
	private long id;		
	
	private String name;		
	
	private String size;		
	
	private String remark;		

	private String code;
	
	public ImageInformationVO(){
	
	}

	public ImageInformationVO(long id,String name,String size,String remark){
		this.id = id;		
		this.name = name;		
		this.size = size;		
		this.remark = remark;		
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
		
	public void setSize(String size) {
		this.size = size;
	}

	public String getSize() {
		return size;
	}	
		
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark() {
		return remark;
	}

    
    public String getCode() {
    
        return code;
    }

    
    public void setCode(String code) {
    
        this.code = code;
    }	
		
}
