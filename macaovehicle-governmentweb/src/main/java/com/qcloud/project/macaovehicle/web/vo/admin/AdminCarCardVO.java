package com.qcloud.project.macaovehicle.web.vo.admin;

import java.util.Date;
import java.math.BigDecimal;

public class AdminCarCardVO {
	
	//ID
	private long id;		

	public AdminCarCardVO(){
	
	}

	public AdminCarCardVO(long id){
		this.id = id;		
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}	
		
}
