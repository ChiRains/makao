package com.qcloud.component.permission.model;

import java.util.Date;
import java.math.BigDecimal;

public class Organization {
	
	//主键
	private long id;		
	
	//组织名称
	private String name;		
	
	private long parentId;		

	public Organization(){
	
	}

	public Organization(long id,String name,long parentId){
		this.id = id;		
		this.name = name;		
		this.parentId = parentId;		
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
		
	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	public long getParentId() {
		return parentId;
	}	
		
}
