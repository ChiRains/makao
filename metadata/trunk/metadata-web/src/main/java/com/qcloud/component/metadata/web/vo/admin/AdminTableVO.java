package com.qcloud.component.metadata.web.vo.admin;

import java.util.Date;
import java.math.BigDecimal;

public class AdminTableVO {
	
	//ID
	private long id;		
	
	//名称
	private String label;		
	
	//表名
	private String name;		
	
	//描述
	private String remark;		

	public AdminTableVO(){
	
	}

	public AdminTableVO(long id,String label,String name,String remark){
		this.id = id;		
		this.label = label;		
		this.name = name;		
		this.remark = remark;		
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}	
		
	public void setLabel(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
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
