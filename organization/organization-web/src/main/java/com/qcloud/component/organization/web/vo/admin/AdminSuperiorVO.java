package com.qcloud.component.organization.web.vo.admin;

import java.util.Date;
import java.math.BigDecimal;

public class AdminSuperiorVO {
	
	//ID
	private long id;		
	
	//职员id
	private long clerkId;		
	
	//上级领导id
	private long leaderId;		

	public AdminSuperiorVO(){
	
	}

	public AdminSuperiorVO(long id,long clerkId,long leaderId){
		this.id = id;		
		this.clerkId = clerkId;		
		this.leaderId = leaderId;		
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}	
		
	public void setClerkId(long clerkId) {
		this.clerkId = clerkId;
	}

	public long getClerkId() {
		return clerkId;
	}	
		
	public void setLeaderId(long leaderId) {
		this.leaderId = leaderId;
	}

	public long getLeaderId() {
		return leaderId;
	}	
		
}
