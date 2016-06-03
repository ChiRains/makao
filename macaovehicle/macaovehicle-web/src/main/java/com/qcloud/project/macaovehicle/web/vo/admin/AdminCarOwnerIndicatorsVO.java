package com.qcloud.project.macaovehicle.web.vo.admin;

import java.util.Date;
import java.math.BigDecimal;

public class AdminCarOwnerIndicatorsVO {
	
	//id
	private long id;		
	
	private long carOwnerId;		
	
	//指标号
	private String indicatorsNo;		
	
	//指标所有人
	private String userName;		
	
	//有效期
	private Date validityPeriod;		

	public AdminCarOwnerIndicatorsVO(){
	
	}

	public AdminCarOwnerIndicatorsVO(long id,long carOwnerId,String indicatorsNo,String userName,Date validityPeriod){
		this.id = id;		
		this.carOwnerId = carOwnerId;		
		this.indicatorsNo = indicatorsNo;		
		this.userName = userName;		
		this.validityPeriod = validityPeriod;		
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}	
		
	public void setCarOwnerId(long carOwnerId) {
		this.carOwnerId = carOwnerId;
	}

	public long getCarOwnerId() {
		return carOwnerId;
	}	
		
	public void setIndicatorsNo(String indicatorsNo) {
		this.indicatorsNo = indicatorsNo;
	}

	public String getIndicatorsNo() {
		return indicatorsNo;
	}	
		
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}	
		
	public void setValidityPeriod(Date validityPeriod) {
		this.validityPeriod = validityPeriod;
	}

	public Date getValidityPeriod() {
		return validityPeriod;
	}	
		
}
