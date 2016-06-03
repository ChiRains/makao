package com.qcloud.project.macaovehicle.web.vo;

import java.util.Date;
import java.math.BigDecimal;

public class PersonnelWarehouseVO {
	
	//ID
	private long id;		

	public PersonnelWarehouseVO(){
	
	}

	public PersonnelWarehouseVO(long id){
		this.id = id;		
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}	
		
}
