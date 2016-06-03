package com.qcloud.component.publicservice.web.vo;

import java.util.Date;
import java.math.BigDecimal;

public class LoginLogVO {
	
	private long id;		
	
	//登录账户
	private long consumerId;		
	
	//1用户2职员
	private int consumerType;		
	
	//操作时间
	private Date time;		
	
	private String ip;		
	
	//1登录2注销
	private int operate;		

	public LoginLogVO(){
	
	}

	public LoginLogVO(long id,long consumerId,int consumerType,Date time,String ip,int operate){
		this.id = id;		
		this.consumerId = consumerId;		
		this.consumerType = consumerType;		
		this.time = time;		
		this.ip = ip;		
		this.operate = operate;		
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}	
		
	public void setConsumerId(long consumerId) {
		this.consumerId = consumerId;
	}

	public long getConsumerId() {
		return consumerId;
	}	
		
	public void setConsumerType(int consumerType) {
		this.consumerType = consumerType;
	}

	public int getConsumerType() {
		return consumerType;
	}	
		
	public void setTime(Date time) {
		this.time = time;
	}

	public Date getTime() {
		return time;
	}	
		
	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getIp() {
		return ip;
	}	
		
	public void setOperate(int operate) {
		this.operate = operate;
	}

	public int getOperate() {
		return operate;
	}	
		
}
