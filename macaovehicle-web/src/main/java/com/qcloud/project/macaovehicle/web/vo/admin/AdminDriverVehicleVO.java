package com.qcloud.project.macaovehicle.web.vo.admin;

import java.util.Date;
import java.math.BigDecimal;

public class AdminDriverVehicleVO {
	
	private long id;		
	
	//电子车牌号（16位）
	private String ric;		
	
	//司机IC识别卡号
	private String driverIc;		
	
	//是否为主司机，（1是，0不是）
	private int isPrimary;		
	
	//创建者
	private String creator;		
	
	//创建时间
	private Date createDate;		
	
	//修改人
	private String modifier;		
	
	//修改日期，格式"1989-11-12 00:00:00"
	private Date modifyDate;		

	public AdminDriverVehicleVO(){
	
	}

	public AdminDriverVehicleVO(long id,String ric,String driverIc,int isPrimary,String creator,Date createDate,String modifier,Date modifyDate){
		this.id = id;		
		this.ric = ric;		
		this.driverIc = driverIc;		
		this.isPrimary = isPrimary;		
		this.creator = creator;		
		this.createDate = createDate;		
		this.modifier = modifier;		
		this.modifyDate = modifyDate;		
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}	
		
	public void setRic(String ric) {
		this.ric = ric;
	}

	public String getRic() {
		return ric;
	}	
		
	public void setDriverIc(String driverIc) {
		this.driverIc = driverIc;
	}

	public String getDriverIc() {
		return driverIc;
	}	
		
	public void setIsPrimary(int isPrimary) {
		this.isPrimary = isPrimary;
	}

	public int getIsPrimary() {
		return isPrimary;
	}	
		
	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getCreator() {
		return creator;
	}	
		
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getCreateDate() {
		return createDate;
	}	
		
	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	public String getModifier() {
		return modifier;
	}	
		
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}	
		
}
