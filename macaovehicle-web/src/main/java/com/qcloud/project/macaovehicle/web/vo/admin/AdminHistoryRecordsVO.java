package com.qcloud.project.macaovehicle.web.vo.admin;

import java.util.Date;
import java.math.BigDecimal;

public class AdminHistoryRecordsVO {
	
	//id
	private long id;		
	
	private long carOwnerId;		
	
	//被修改项字段
	private String updateParam;		
	
	//被修改项
	private String updateParamStr;		
	
	//原有值
	private String oldValue;		
	
	//修改值
	private String newValue;		
	
	//更新时间
	private Date updateTime;		
	
	//操作人
	private String operator;		
	
	//类型（ 1务工 2购房 3企业-投资 4高级人才 5购地）
	private int type;		

	public AdminHistoryRecordsVO(){
	
	}

	public AdminHistoryRecordsVO(long id,long carOwnerId,String updateParam,String updateParamStr,String oldValue,String newValue,Date updateTime,String operator,int type){
		this.id = id;		
		this.carOwnerId = carOwnerId;		
		this.updateParam = updateParam;		
		this.updateParamStr = updateParamStr;		
		this.oldValue = oldValue;		
		this.newValue = newValue;		
		this.updateTime = updateTime;		
		this.operator = operator;		
		this.type = type;		
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
		
	public void setUpdateParam(String updateParam) {
		this.updateParam = updateParam;
	}

	public String getUpdateParam() {
		return updateParam;
	}	
		
	public void setUpdateParamStr(String updateParamStr) {
		this.updateParamStr = updateParamStr;
	}

	public String getUpdateParamStr() {
		return updateParamStr;
	}	
		
	public void setOldValue(String oldValue) {
		this.oldValue = oldValue;
	}

	public String getOldValue() {
		return oldValue;
	}	
		
	public void setNewValue(String newValue) {
		this.newValue = newValue;
	}

	public String getNewValue() {
		return newValue;
	}	
		
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}	
		
	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getOperator() {
		return operator;
	}	
		
	public void setType(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}	
		
}
