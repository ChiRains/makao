package com.qcloud.project.macaovehicle.model;

import java.util.Date;
import java.math.BigDecimal;

public class DepartmentRole {
	
	//ID
	private long id;		
	
	//角色id
	private long roleId;		
	
	//部门id
	private long departmentId;		
	
	//描述
	private String desc;		
	
	//状态(1启用  2停用)
	private int status;		
	
	//创建人
	private long creator;		
	
	//创建时间
	private Date createDate;		

	public DepartmentRole(){
	
	}

	public DepartmentRole(long id,long roleId,long departmentId,String desc,int status,long creator,Date createDate){
		this.id = id;		
		this.roleId = roleId;		
		this.departmentId = departmentId;		
		this.desc = desc;		
		this.status = status;		
		this.creator = creator;		
		this.createDate = createDate;		
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}	
		
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public long getRoleId() {
		return roleId;
	}	
		
	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}

	public long getDepartmentId() {
		return departmentId;
	}	
		
	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}	
		
	public void setStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}	
		
	public void setCreator(long creator) {
		this.creator = creator;
	}

	public long getCreator() {
		return creator;
	}	
		
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getCreateDate() {
		return createDate;
	}	
		
}
