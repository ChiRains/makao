package com.qcloud.component.account.model;

import java.util.Date;
import java.math.BigDecimal;

public class CertificateType {
	
	//ID
	private long id;		
	
	//编码
	private String code;		
	
	//名称
	private String name;		

	public CertificateType(){
	
	}

	public CertificateType(long id,String code,String name){
		this.id = id;		
		this.code = code;		
		this.name = name;		
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
		
}
