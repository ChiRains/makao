package com.qcloud.project.macaovehicle.model;

import java.util.Date;
import java.math.BigDecimal;

public class ApprovalOutside {
	
	private long id;		
	
	//标识编码（driver、vehicle、vehicleRDriver）
	private String code;		
	
	//车卡id
	private String ric;		
	
	//司机卡id
	private String driverIc;		
	
	//返回的xml数据
	private String xml;		
	
	//类型 (1：国检  2： 海关)
	private int type;		
	
	//副类型（1备案  2审批）
	private int subType;		
	
	//当前时间
	private Date recordTime;		

	public ApprovalOutside(){
	
	}

	public ApprovalOutside(long id,String code,String ric,String driverIc,String xml,int type,int subType,Date recordTime){
		this.id = id;		
		this.code = code;		
		this.ric = ric;		
		this.driverIc = driverIc;		
		this.xml = xml;		
		this.type = type;		
		this.subType = subType;		
		this.recordTime = recordTime;		
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}	
		
	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
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
		
	public void setXml(String xml) {
		this.xml = xml;
	}

	public String getXml() {
		return xml;
	}	
		
	public void setType(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}	
		
	public void setSubType(int subType) {
		this.subType = subType;
	}

	public int getSubType() {
		return subType;
	}	
		
	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}

	public Date getRecordTime() {
		return recordTime;
	}	
		
}
