package com.qcloud.component.publicdata.model;

import java.util.Date;
import java.math.BigDecimal;

public class Questionnaire {
	
	private long id;		
	
	//问卷名称
	private String name;		
	
	//编码
	private String code;		

	public Questionnaire(){
	
	}

	public Questionnaire(long id,String name,String code){
		this.id = id;		
		this.name = name;		
		this.code = code;		
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
		
}
