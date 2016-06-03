package com.qcloud.component.organization.model;

import java.util.Date;
import java.math.BigDecimal;

public class UsergroupUser {
	
	private long id;		
	
	//用户组ID
	private long groupId;		
	
	//用户ID
	private long userId;		

	public UsergroupUser(){
	
	}

	public UsergroupUser(long id,long groupId,long userId){
		this.id = id;		
		this.groupId = groupId;		
		this.userId = userId;		
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}	
		
	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}

	public long getGroupId() {
		return groupId;
	}	
		
	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getUserId() {
		return userId;
	}	
		
}
