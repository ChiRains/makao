package com.qcloud.project.macaovehicle.model;

import java.util.Date;
import java.math.BigDecimal;

public class CarOwnerWorkers {
	
	private long id;		
	
	//车主ID
	private long carOwnerId;		
	
	//单位名称
	private String company;		
	
	//单位电话
	private String fixedLine;		
	
	//单位地址
	private String address;		
	
	//联系电话
	private String phone;		
	
	//联系人
	private String consignee;		
	
	//职务
	private String position;		
	
	//工作证明（图片）
	private String workCertificate;		
	
	//公司代码
	private String code;		
	
	private String time;		
	
	private String entryTime;		
	
	//劳务合同图片
	private String contractUrl;		
	
	//参保费用证明图片
	private String insuranceFeeUrl;		

	public CarOwnerWorkers(){
	
	}

	public CarOwnerWorkers(long id,long carOwnerId,String company,String fixedLine,String address,String phone,String consignee,String position,String workCertificate,String code,String time,String entryTime,String contractUrl,String insuranceFeeUrl){
		this.id = id;		
		this.carOwnerId = carOwnerId;		
		this.company = company;		
		this.fixedLine = fixedLine;		
		this.address = address;		
		this.phone = phone;		
		this.consignee = consignee;		
		this.position = position;		
		this.workCertificate = workCertificate;		
		this.code = code;		
		this.time = time;		
		this.entryTime = entryTime;		
		this.contractUrl = contractUrl;		
		this.insuranceFeeUrl = insuranceFeeUrl;		
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
		
	public void setCompany(String company) {
		this.company = company;
	}

	public String getCompany() {
		return company;
	}	
		
	public void setFixedLine(String fixedLine) {
		this.fixedLine = fixedLine;
	}

	public String getFixedLine() {
		return fixedLine;
	}	
		
	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}	
		
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone() {
		return phone;
	}	
		
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	public String getConsignee() {
		return consignee;
	}	
		
	public void setPosition(String position) {
		this.position = position;
	}

	public String getPosition() {
		return position;
	}	
		
	public void setWorkCertificate(String workCertificate) {
		this.workCertificate = workCertificate;
	}

	public String getWorkCertificate() {
		return workCertificate;
	}	
		
	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}	
		
	public void setTime(String time) {
		this.time = time;
	}

	public String getTime() {
		return time;
	}	
		
	public void setEntryTime(String entryTime) {
		this.entryTime = entryTime;
	}

	public String getEntryTime() {
		return entryTime;
	}	
		
	public void setContractUrl(String contractUrl) {
		this.contractUrl = contractUrl;
	}

	public String getContractUrl() {
		return contractUrl;
	}	
		
	public void setInsuranceFeeUrl(String insuranceFeeUrl) {
		this.insuranceFeeUrl = insuranceFeeUrl;
	}

	public String getInsuranceFeeUrl() {
		return insuranceFeeUrl;
	}	
		
}
