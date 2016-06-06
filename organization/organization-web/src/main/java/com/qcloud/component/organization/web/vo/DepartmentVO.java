package com.qcloud.component.organization.web.vo;

import java.util.Date;
import java.math.BigDecimal;

public class DepartmentVO {
	
	//ID
	private long id;		
	
	private long parentId;		
	
	//树编码
	private String bsid;		
	
	//名称
	private String name;		
	
	//经理
	private long manager;		
	
	//显示级层名称
	private String displayName;		

	public DepartmentVO(){
	
	}

	public DepartmentVO(long id,long parentId,String bsid,String name,long manager,String displayName){
		this.id = id;		
		this.parentId = parentId;		
		this.bsid = bsid;		
		this.name = name;		
		this.manager = manager;		
		this.displayName = displayName;		
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}	
		
	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	public long getParentId() {
		return parentId;
	}	
		
	public void setBsid(String bsid) {
		this.bsid = bsid;
	}

	public String getBsid() {
		return bsid;
	}	
		
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}	
		
	public void setManager(long manager) {
		this.manager = manager;
	}

	public long getManager() {
		return manager;
	}	
		
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}	
		
}
