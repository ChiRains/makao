package com.qcloud.component.organization.web.vo;

import java.util.Date;
import java.math.BigDecimal;

public class PostVO {
	
	//ID
	private long id;		
	
	//名称
	private String name;
	
	private int number;

	public PostVO(){
	
	}

	public PostVO(long id,String name,int number){
		this.id = id;		
		this.name = name;	
		this.number = number;
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

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}	
		
}
