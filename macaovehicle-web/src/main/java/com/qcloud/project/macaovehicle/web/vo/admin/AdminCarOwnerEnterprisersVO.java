package com.qcloud.project.macaovehicle.web.vo.admin;

import java.util.Date;
import java.math.BigDecimal;

public class AdminCarOwnerEnterprisersVO {
	
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
	private Date time;		
	
	//营业执照(图片)
	private String license;		
	
	private String tax;		
	
	private String letter;		

	public AdminCarOwnerEnterprisersVO(){
	
	}

	public AdminCarOwnerEnterprisersVO(long id,long carOwnerId,String company,String code,String operate,String scale,String represent,String phone,String address,Date time,String license,String tax,String letter){
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
		
	public void setTime(Date time) {
		this.time = time;
	}

	public Date getTime() {
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
		
}
