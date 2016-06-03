package com.qcloud.component.permission.model;

import java.util.Date;
import java.math.BigDecimal;

public class RolePermission {
	
	//主键
	private long id;		
	
	//权限点Id
	private long permissionId;		
	
	//角色Id
	private long roleId;		

	public RolePermission(){
	
	}

	public RolePermission(long id,long permissionId,long roleId){
		this.id = id;		
		this.permissionId = permissionId;		
		this.roleId = roleId;		
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}	
		
	public void setPermissionId(long permissionId) {
		this.permissionId = permissionId;
	}

	public long getPermissionId() {
		return permissionId;
	}	
		
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public long getRoleId() {
		return roleId;
	}	
		
}
