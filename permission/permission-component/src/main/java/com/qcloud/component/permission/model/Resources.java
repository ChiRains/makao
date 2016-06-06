package com.qcloud.component.permission.model;

import java.util.Date;
import java.math.BigDecimal;

public class Resources {
	
	//主键
	private long id;		
	
	//资源名称
	private String name;		
	
	//资源代号
	private String code;		
	
	//请求地址
	private String uri;		
	
	//分类id
	private long classifyId;		

	public Resources(){
	
	}

	public Resources(long id,String name,String code,String uri,long classifyId){
		this.id = id;		
		this.name = name;		
		this.code = code;		
		this.uri = uri;		
		this.classifyId = classifyId;		
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
		
	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}	
		
	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getUri() {
		return uri;
	}	
		
	public void setClassifyId(long classifyId) {
		this.classifyId = classifyId;
	}

	public long getClassifyId() {
		return classifyId;
	}	
		
}
