package com.qcloud.component.snakerext.web.vo;

import java.util.Date;
import java.math.BigDecimal;

public class ProcessGroupVO {
	
	private long id;		
	
	private String name;		
	
	private String remark;		

	public ProcessGroupVO(){
	
	}

	public ProcessGroupVO(long id,String name,String remark){
		this.id = id;		
		this.name = name;		
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
		
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark() {
		return remark;
	}	
		
}
