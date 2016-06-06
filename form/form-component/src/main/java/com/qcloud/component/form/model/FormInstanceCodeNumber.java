package com.qcloud.component.form.model;

import java.util.Date;
import java.math.BigDecimal;

public class FormInstanceCodeNumber {
	
	//ID
	private long id;		
	
	//编码
	private String code;		
	
	//数据
	private long number;		

	public FormInstanceCodeNumber(){
	
	}

	public FormInstanceCodeNumber(long id,String code,long number){
		this.id = id;		
		this.code = code;		
		this.number = number;		
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
		
	public void setNumber(long number) {
		this.number = number;
	}

	public long getNumber() {
		return number;
	}	
		
}
