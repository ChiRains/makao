package com.qcloud.component.publicdata.model;

import java.util.Date;
import java.math.BigDecimal;

public class Province {
	
	private long id;		
	
	//省
	private String name;		

	public Province(){
	
	}

	public Province(long id,String name){
		this.id = id;		
		this.name = name;		
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
		
}
