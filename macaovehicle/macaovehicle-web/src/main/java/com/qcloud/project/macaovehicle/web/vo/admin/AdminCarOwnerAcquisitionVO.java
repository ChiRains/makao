package com.qcloud.project.macaovehicle.web.vo.admin;

import java.util.Date;
import java.math.BigDecimal;

public class AdminCarOwnerAcquisitionVO {
	
	private long id;		
	
	private long carOwnerId;		
	
	//购地用途
	private String application;		
	
	//购地用地年限
	private int deadline;		
	
	//购买日期
	private Date buyTime;		
	
	//用地出让权使用合同图片
	private String contractUrl;		

	public AdminCarOwnerAcquisitionVO(){
	
	}

	public AdminCarOwnerAcquisitionVO(long id,long carOwnerId,String application,int deadline,Date buyTime,String contractUrl){
		this.id = id;		
		this.carOwnerId = carOwnerId;		
		this.application = application;		
		this.deadline = deadline;		
		this.buyTime = buyTime;		
		this.contractUrl = contractUrl;		
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
		
	public void setApplication(String application) {
		this.application = application;
	}

	public String getApplication() {
		return application;
	}	
		
	public void setDeadline(int deadline) {
		this.deadline = deadline;
	}

	public int getDeadline() {
		return deadline;
	}	
		
	public void setBuyTime(Date buyTime) {
		this.buyTime = buyTime;
	}

	public Date getBuyTime() {
		return buyTime;
	}	
		
	public void setContractUrl(String contractUrl) {
		this.contractUrl = contractUrl;
	}

	public String getContractUrl() {
		return contractUrl;
	}	
		
}
