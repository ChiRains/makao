package com.qcloud.project.macaovehicle.web.vo.admin;

import java.util.Date;
import java.math.BigDecimal;

public class AdminDvrAreaVO {
	
	private long id;		
	
	//区域代号(与下拉菜单对应)
	private String code;		
	
	//区域名称
	private String name;		
	
	//是否启用(1启用, 0不启用)
	private int status;		

	public AdminDvrAreaVO(){
	
	}

	public AdminDvrAreaVO(long id,String code,String name,int status){
		this.id = id;		
		this.code = code;		
		this.name = name;		
		this.status = status;		
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}	
		
	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}	
		
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}	
		
	public void setStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}	
		
}
