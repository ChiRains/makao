package com.qcloud.project.macaovehicle.model;

import java.util.Date;
import java.math.BigDecimal;

public class CarOwnerEnterprisers {
	
	private long id;		
	
	private long carOwnerId;		
	
	//公司名称
	private String company;		
	
	//公司代码
	private String code;		
	
	//经营范围
	private String operate;		
	
	//企业规模
	private String scale;		
	
	//法人代表
	private String represent;		
	
	//联系电话
	private String phone;		
	
	//地址
	private String address;		
	
	//成立时间
	private String time;		
	
	//营业执照(图片)
	private String license;		
	
	private String tax;		
	
	private String letter;		
	
	//经营期限
	private Date operatingPeriod;		
	
	//登记机关
	private String organs;		
	
	//企业联系人
	private String contacts;		
	
	//缴费证明图片
	private String paymentUrl;		
	
	//缴费承诺书图片
	private String commitmentUrl;		
	
	//法人代表身份证号码
	private String representID;		
	
	//身份证正面
	private String positiveUrl;		
	
	//身份证反面
	private String oppositeUrl;		

	public CarOwnerEnterprisers(){
	
	}

	public CarOwnerEnterprisers(long id,long carOwnerId,String company,String code,String operate,String scale,String represent,String phone,String address,String time,String license,String tax,String letter,Date operatingPeriod,String organs,String contacts,String paymentUrl,String commitmentUrl,String representID,String positiveUrl,String oppositeUrl){
		this.id = id;		
		this.carOwnerId = carOwnerId;		
		this.company = company;		
		this.code = code;		
		this.operate = operate;		
		this.scale = scale;		
		this.represent = represent;		
		this.phone = phone;		
		this.address = address;		
		this.time = time;		
		this.license = license;		
		this.tax = tax;		
		this.letter = letter;		
		this.operatingPeriod = operatingPeriod;		
		this.organs = organs;		
		this.contacts = contacts;		
		this.paymentUrl = paymentUrl;		
		this.commitmentUrl = commitmentUrl;		
		this.representID = representID;		
		this.positiveUrl = positiveUrl;		
		this.oppositeUrl = oppositeUrl;		
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
		
	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}	
		
	public void setOperate(String operate) {
		this.operate = operate;
	}

	public String getOperate() {
		return operate;
	}	
		
	public void setScale(String scale) {
		this.scale = scale;
	}

	public String getScale() {
		return scale;
	}	
		
	public void setRepresent(String represent) {
		this.represent = represent;
	}

	public String getRepresent() {
		return represent;
	}	
		
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone() {
		return phone;
	}	
		
	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}	
		
	public void setTime(String time) {
		this.time = time;
	}

	public String getTime() {
		return time;
	}	
		
	public void setLicense(String license) {
		this.license = license;
	}

	public String getLicense() {
		return license;
	}	
		
	public void setTax(String tax) {
		this.tax = tax;
	}

	public String getTax() {
		return tax;
	}	
		
	public void setLetter(String letter) {
		this.letter = letter;
	}

	public String getLetter() {
		return letter;
	}	
		
	public void setOperatingPeriod(Date operatingPeriod) {
		this.operatingPeriod = operatingPeriod;
	}

	public Date getOperatingPeriod() {
		return operatingPeriod;
	}	
		
	public void setOrgans(String organs) {
		this.organs = organs;
	}

	public String getOrgans() {
		return organs;
	}	
		
	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	public String getContacts() {
		return contacts;
	}	
		
	public void setPaymentUrl(String paymentUrl) {
		this.paymentUrl = paymentUrl;
	}

	public String getPaymentUrl() {
		return paymentUrl;
	}	
		
	public void setCommitmentUrl(String commitmentUrl) {
		this.commitmentUrl = commitmentUrl;
	}

	public String getCommitmentUrl() {
		return commitmentUrl;
	}	
		
	public void setRepresentID(String representID) {
		this.representID = representID;
	}

	public String getRepresentID() {
		return representID;
	}	
		
	public void setPositiveUrl(String positiveUrl) {
		this.positiveUrl = positiveUrl;
	}

	public String getPositiveUrl() {
		return positiveUrl;
	}	
		
	public void setOppositeUrl(String oppositeUrl) {
		this.oppositeUrl = oppositeUrl;
	}

	public String getOppositeUrl() {
		return oppositeUrl;
	}	
		
}
