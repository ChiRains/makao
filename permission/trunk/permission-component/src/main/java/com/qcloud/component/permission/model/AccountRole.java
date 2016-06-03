package com.qcloud.component.permission.model;

import java.util.Date;
import java.math.BigDecimal;

public class AccountRole {
	
	//主键
	private long id;		
	
	//帐号Id
	private long accountId;		
	
	//角色Id
	private long roleId;		

	public AccountRole(){
	
	}

	public AccountRole(long id,long accountId,long roleId){
		this.id = id;		
		this.accountId = accountId;		
		this.roleId = roleId;		
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}	
		
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public long getAccountId() {
		return accountId;
	}	
		
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public long getRoleId() {
		return roleId;
	}	
		
}
