package com.qcloud.project.macaovehicle.web.vo.admin;

import java.util.Date;
import java.math.BigDecimal;

public class AdminApprovalResultsVO {
	
	private long id;		
	
	private long formInstanceId;		
	
	private String appointmentNumber;		
	
	private String cardNumber;		
	
	private int type;		
	
	private int state;		
	
	private Date time;		

	public AdminApprovalResultsVO(){
	
	}

	public AdminApprovalResultsVO(long id,long formInstanceId,String appointmentNumber,String cardNumber,int type,int state,Date time){
		this.id = id;		
		this.formInstanceId = formInstanceId;		
		this.appointmentNumber = appointmentNumber;		
		this.cardNumber = cardNumber;		
		this.type = type;		
		this.state = state;		
		this.time = time;		
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
		
	public void setAppointmentNumber(String appointmentNumber) {
		this.appointmentNumber = appointmentNumber;
	}

	public String getAppointmentNumber() {
		return appointmentNumber;
	}	
		
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardNumber() {
		return cardNumber;
	}	
		
	public void setType(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}	
		
	public void setState(int state) {
		this.state = state;
	}

	public int getState() {
		return state;
	}	
		
	public void setTime(Date time) {
		this.time = time;
	}

	public Date getTime() {
		return time;
	}	
		
}
