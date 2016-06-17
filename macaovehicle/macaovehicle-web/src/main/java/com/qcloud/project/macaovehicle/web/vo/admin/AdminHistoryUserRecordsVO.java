package com.qcloud.project.macaovehicle.web.vo.admin;

import java.util.Date;
import java.math.BigDecimal;

public class AdminHistoryUserRecordsVO {
	
	//id
	private long id;		
	
	//车辆id
	private long vehicleId;		
	
	//类型 （1:入境申请  2:补办电子车卡  3:补办临时号牌  4:添加驾驶员申请  5:续期申请  6:注销车辆）
	private int type;		
	
	//申请时间
	private Date applyTime;		
	
	//完成时间
	private Date finishTime;		

	public AdminHistoryUserRecordsVO(){
	
	}

	public AdminHistoryUserRecordsVO(long id,long vehicleId,int type,Date applyTime,Date finishTime){
		this.id = id;		
		this.vehicleId = vehicleId;		
		this.type = type;		
		this.applyTime = applyTime;		
		this.finishTime = finishTime;		
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}	
		
	public void setVehicleId(long vehicleId) {
		this.vehicleId = vehicleId;
	}

	public long getVehicleId() {
		return vehicleId;
	}	
		
	public void setType(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}	
		
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	public Date getApplyTime() {
		return applyTime;
	}	
		
	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	public Date getFinishTime() {
		return finishTime;
	}	
		
}
