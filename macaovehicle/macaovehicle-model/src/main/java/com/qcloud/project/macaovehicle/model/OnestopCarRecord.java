package com.qcloud.project.macaovehicle.model;

import java.util.Date;
import java.math.BigDecimal;

public class OnestopCarRecord {
	
	//ID
	private long id;		
	
	//司机卡id
	private String dCardid;		
	
	//车辆卡id
	private String vCardid;		
	
	//时间
	private Date date;		
	
	//关口
	private String gate;		
	
	//类型(1:入境   2:出境)
	private int type;		

	public OnestopCarRecord(){
	
	}

	public OnestopCarRecord(long id,String dCardid,String vCardid,Date date,String gate,int type){
		this.id = id;		
		this.dCardid = dCardid;		
		this.vCardid = vCardid;		
		this.date = date;		
		this.gate = gate;		
		this.type = type;		
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}	
		
	public void setDCardid(String dCardid) {
		this.dCardid = dCardid;
	}

	public String getDCardid() {
		return dCardid;
	}	
		
	public void setVCardid(String vCardid) {
		this.vCardid = vCardid;
	}

	public String getVCardid() {
		return vCardid;
	}	
		
	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDate() {
		return date;
	}	
		
	public void setGate(String gate) {
		this.gate = gate;
	}

	public String getGate() {
		return gate;
	}	
		
	public void setType(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}	
		
}
