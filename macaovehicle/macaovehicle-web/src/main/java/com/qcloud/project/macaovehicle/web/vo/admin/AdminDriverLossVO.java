package com.qcloud.project.macaovehicle.web.vo.admin;

import java.util.Date;
import java.math.BigDecimal;

public class AdminDriverLossVO {
	
	//ID
	private long id;		
	
	//表单编码(不涉及流程)
	private String formInstCode;		
	
	//ID
	private long carOwnerId;		
	
	//车辆id
	private long driverId;		
	
	//旧电子车卡卡号
	private String oldRic;		
	
	//新电子车卡卡号
	private String newRic;		
	
	//挂失时间
	private Date lossTime;		
	
	//已标记时间
	private Date recordTime;		
	
	//类型（1 挂失  2补办  3已处理）
	private int type;		

	public AdminDriverLossVO(){
	
	}

	public AdminDriverLossVO(long id,String formInstCode,long carOwnerId,long driverId,String oldRic,String newRic,Date lossTime,Date recordTime,int type){
		this.id = id;		
		this.formInstCode = formInstCode;		
		this.carOwnerId = carOwnerId;		
		this.driverId = driverId;		
		this.oldRic = oldRic;		
		this.newRic = newRic;		
		this.lossTime = lossTime;		
		this.recordTime = recordTime;		
		this.type = type;		
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}	
		
	public void setFormInstCode(String formInstCode) {
		this.formInstCode = formInstCode;
	}

	public String getFormInstCode() {
		return formInstCode;
	}	
		
	public void setCarOwnerId(long carOwnerId) {
		this.carOwnerId = carOwnerId;
	}

	public long getCarOwnerId() {
		return carOwnerId;
	}	
		
	public void setDriverId(long driverId) {
		this.driverId = driverId;
	}

	public long getDriverId() {
		return driverId;
	}	
		
	public void setOldRic(String oldRic) {
		this.oldRic = oldRic;
	}

	public String getOldRic() {
		return oldRic;
	}	
		
	public void setNewRic(String newRic) {
		this.newRic = newRic;
	}

	public String getNewRic() {
		return newRic;
	}	
		
	public void setLossTime(Date lossTime) {
		this.lossTime = lossTime;
	}

	public Date getLossTime() {
		return lossTime;
	}	
		
	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}

	public Date getRecordTime() {
		return recordTime;
	}	
		
	public void setType(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}	
		
}
