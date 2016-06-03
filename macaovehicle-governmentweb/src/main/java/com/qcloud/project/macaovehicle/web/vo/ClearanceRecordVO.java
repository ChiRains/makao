package com.qcloud.project.macaovehicle.web.vo;

import java.util.Date;
import java.math.BigDecimal;

public class ClearanceRecordVO {
	
	//ID
	private long id;		

	public ClearanceRecordVO(){
	
	}

	public ClearanceRecordVO(long id){
		this.id = id;		
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}	
		
}
