package com.qcloud.project.macaovehicle.web.vo.admin;

import java.util.Date;
import java.math.BigDecimal;

public class AdminIllegalPoliceRecordVO {
	
	private long id;		
	
	//车辆号码
	private String plateNumber;		
	
	//临时号牌
	private String tplateNumber;		
	
	//违章时间
	private Date violationTime;		
	
	//违章代码
	private String violationCode;		
	
	//违章地址
	private String violationAddress;		
	
	//违章行为
	private String violationDesc;		
	
	//部门
	private long departmentId;		
	
	//创建时间
	private Date createTime;		
	
	//职工id
	private long clerkId;		

	public AdminIllegalPoliceRecordVO(){
	
	}

	public AdminIllegalPoliceRecordVO(long id,String plateNumber,String tplateNumber,Date violationTime,String violationCode,String violationAddress,String violationDesc,long departmentId,Date createTime,long clerkId){
		this.id = id;		
		this.plateNumber = plateNumber;		
		this.tplateNumber = tplateNumber;		
		this.violationTime = violationTime;		
		this.violationCode = violationCode;		
		this.violationAddress = violationAddress;		
		this.violationDesc = violationDesc;		
		this.departmentId = departmentId;		
		this.createTime = createTime;		
		this.clerkId = clerkId;		
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}	
		
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public String getPlateNumber() {
		return plateNumber;
	}	
		
	public void setTplateNumber(String tplateNumber) {
		this.tplateNumber = tplateNumber;
	}

	public String getTplateNumber() {
		return tplateNumber;
	}	
		
	public void setViolationTime(Date violationTime) {
		this.violationTime = violationTime;
	}

	public Date getViolationTime() {
		return violationTime;
	}	
		
	public void setViolationCode(String violationCode) {
		this.violationCode = violationCode;
	}

	public String getViolationCode() {
		return violationCode;
	}	
		
	public void setViolationAddress(String violationAddress) {
		this.violationAddress = violationAddress;
	}

	public String getViolationAddress() {
		return violationAddress;
	}	
		
	public void setViolationDesc(String violationDesc) {
		this.violationDesc = violationDesc;
	}

	public String getViolationDesc() {
		return violationDesc;
	}	
		
	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}

	public long getDepartmentId() {
		return departmentId;
	}	
		
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return createTime;
	}	
		
	public void setClerkId(long clerkId) {
		this.clerkId = clerkId;
	}

	public long getClerkId() {
		return clerkId;
	}	
		
}
