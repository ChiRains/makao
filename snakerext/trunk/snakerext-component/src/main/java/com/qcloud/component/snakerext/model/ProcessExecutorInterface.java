package com.qcloud.component.snakerext.model;

import java.util.Date;
import java.math.BigDecimal;

public class ProcessExecutorInterface {
	
	//ID
	private long id;		
	
	//流程标识
	private String name;		
	
	//接口方法
	private String method;		

	public ProcessExecutorInterface(){
	
	}

	public ProcessExecutorInterface(long id,String name,String method){
		this.id = id;		
		this.name = name;		
		this.method = method;		
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
		
	public void setMethod(String method) {
		this.method = method;
	}

	public String getMethod() {
		return method;
	}	
		
}
