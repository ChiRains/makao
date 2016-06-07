package com.qcloud.component.piratesship.model;

import java.util.Date;
import java.math.BigDecimal;

public class CallMe {
	
	//ID
	private long id;		
	
	//项目
	private String project;		
	
	//发起人
	private String fromSeaman;		
	
	//找谁
	private String toSeaman;		
	
	//处理人
	private String receiveSeaman;		
	
	//主题
	private String subject;		
	
	//状态 1提问 2承接 3完成  4关闭
	private int state;		
	
	//提问时间
	private Date callDate;		
	
	//更新时间
	private Date updateDate;		

	public CallMe(){
	
	}

	public CallMe(long id,String project,String fromSeaman,String toSeaman,String receiveSeaman,String subject,int state,Date callDate,Date updateDate){
		this.id = id;		
		this.project = project;		
		this.fromSeaman = fromSeaman;		
		this.toSeaman = toSeaman;		
		this.receiveSeaman = receiveSeaman;		
		this.subject = subject;		
		this.state = state;		
		this.callDate = callDate;		
		this.updateDate = updateDate;		
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}	
		
	public void setProject(String project) {
		this.project = project;
	}

	public String getProject() {
		return project;
	}	
		
	public void setFromSeaman(String fromSeaman) {
		this.fromSeaman = fromSeaman;
	}

	public String getFromSeaman() {
		return fromSeaman;
	}	
		
	public void setToSeaman(String toSeaman) {
		this.toSeaman = toSeaman;
	}

	public String getToSeaman() {
		return toSeaman;
	}	
		
	public void setReceiveSeaman(String receiveSeaman) {
		this.receiveSeaman = receiveSeaman;
	}

	public String getReceiveSeaman() {
		return receiveSeaman;
	}	
		
	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getSubject() {
		return subject;
	}	
		
	public void setState(int state) {
		this.state = state;
	}

	public int getState() {
		return state;
	}	
		
	public void setCallDate(Date callDate) {
		this.callDate = callDate;
	}

	public Date getCallDate() {
		return callDate;
	}	
		
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}	
		
}
