package com.qcloud.project.macaovehicle.model;

import java.util.Date;
import java.math.BigDecimal;

public class InstanceMessage {
	
	//ID
	private long id;		
	
	//表单实例id
	private long formInstanceId;		
	
	//消息id
	private long messageClerkId;		
	
	private long clerkId;		
	
	//创建时间
	private Date createTime;		

	public InstanceMessage(){
	
	}

	public InstanceMessage(long id,long formInstanceId,long messageClerkId,long clerkId,Date createTime){
		this.id = id;		
		this.formInstanceId = formInstanceId;		
		this.messageClerkId = messageClerkId;		
		this.clerkId = clerkId;		
		this.createTime = createTime;		
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}	
		
	public void setFormInstanceId(long formInstanceId) {
		this.formInstanceId = formInstanceId;
	}

	public long getFormInstanceId() {
		return formInstanceId;
	}	
		
	public void setMessageClerkId(long messageClerkId) {
		this.messageClerkId = messageClerkId;
	}

	public long getMessageClerkId() {
		return messageClerkId;
	}	
		
	public void setClerkId(long clerkId) {
		this.clerkId = clerkId;
	}

	public long getClerkId() {
		return clerkId;
	}	
		
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return createTime;
	}	
		
}
