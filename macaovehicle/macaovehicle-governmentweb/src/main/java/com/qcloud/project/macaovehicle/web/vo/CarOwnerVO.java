package com.qcloud.project.macaovehicle.web.vo;

import java.util.Date;
import java.math.BigDecimal;

public class CarOwnerVO {
	
	//ID
	private long id;		

	public CarOwnerVO(){
	
	}

	public CarOwnerVO(long id){
		this.id = id;		
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}	
		
}
