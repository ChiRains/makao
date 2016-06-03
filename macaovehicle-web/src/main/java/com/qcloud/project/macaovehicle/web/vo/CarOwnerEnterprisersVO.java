package com.qcloud.project.macaovehicle.web.vo;

import java.util.Date;
import java.math.BigDecimal;

public class CarOwnerEnterprisersVO {

    private long   id;

    private long   carOwnerId;

    // 公司名称
    private String company;

    // 公司代码
    private String code;

    // 经营范围
    private String operate;

    // 企业规模
    private String scale;

    // 法人代表
    private String represent;

    // 联系电话
    private String phone;

    // 地址
    private String address;

    // 成立时间
    private String   time;

    // 营业执照(图片)
    private String license;

    private String licenseUid;

    private String tax;

    private String letter;
    
	private Date operatingPeriod;	
	
	private String organs;	
	
	private String representID;		

	//企业联系人
	private String contacts;	
	
	//身份证正面
	private String positiveUrl;		
	
	private String positiveUrlUid;	
	
	//身份证反面
	private String oppositeUrl;	
	
	private String oppositeUrlUid;	
	
	private String paymentUrlUid;
	
    private String commitmentUrlUid;
    
    private String commitmentUrl;
    
    private String paymentUrl;
	
	public String getPaymentUrl() {
		return paymentUrl;
	}

	public void setPaymentUrl(String paymentUrl) {
		this.paymentUrl = paymentUrl;
	}

	public String getCommitmentUrl() {
		return commitmentUrl;
	}

	public void setCommitmentUrl(String commitmentUrl) {
		this.commitmentUrl = commitmentUrl;
	}

	public String getPaymentUrlUid() {
		return paymentUrlUid;
	}

	public void setPaymentUrlUid(String paymentUrlUid) {
		this.paymentUrlUid = paymentUrlUid;
	}

	public String getCommitmentUrlUid() {
		return commitmentUrlUid;
	}

	public void setCommitmentUrlUid(String commitmentUrlUid) {
		this.commitmentUrlUid = commitmentUrlUid;
	}

	public String getPositiveUrlUid() {
		return positiveUrlUid;
	}

	public void setPositiveUrlUid(String positiveUrlUid) {
		this.positiveUrlUid = positiveUrlUid;
	}

	public String getOppositeUrlUid() {
		return oppositeUrlUid;
	}

	public void setOppositeUrlUid(String oppositeUrlUid) {
		this.oppositeUrlUid = oppositeUrlUid;
	}


	private String operatingPeriodFormat;
	

    public String getOperatingPeriodFormat() {
		return operatingPeriodFormat;
	}

	public void setOperatingPeriodFormat(String operatingPeriodFormat) {
		this.operatingPeriodFormat = operatingPeriodFormat;
	}

	public Date getOperatingPeriod() {
		return operatingPeriod;
	}

	public void setOperatingPeriod(Date operatingPeriod) {
		this.operatingPeriod = operatingPeriod;
	}

	public String getOrgans() {
		return organs;
	}

	public void setOrgans(String organs) {
		this.organs = organs;
	}

	public String getRepresentID() {
		return representID;
	}

	public void setRepresentID(String representID) {
		this.representID = representID;
	}

	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	public String getPositiveUrl() {
		return positiveUrl;
	}

	public void setPositiveUrl(String positiveUrl) {
		this.positiveUrl = positiveUrl;
	}

	public String getOppositeUrl() {
		return oppositeUrl;
	}

	public void setOppositeUrl(String oppositeUrl) {
		this.oppositeUrl = oppositeUrl;
	}

	public CarOwnerEnterprisersVO() {

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


    public void setLicense(String license) {

        this.license = license;
    }

    public String getLicense() {

        return license;
    }

    public String getLicenseUid() {

        return licenseUid;
    }

    public void setLicenseUid(String licenseUid) {

        this.licenseUid = licenseUid;
    }

    public String getTax() {

        return tax;
    }

    public void setTax(String tax) {

        this.tax = tax;
    }

    public String getLetter() {

        return letter;
    }

    public void setLetter(String letter) {

        this.letter = letter;
    }

    
    public void setTime(String time) {
    
        this.time = time;
    }

    
    public String getTime() {
    
        return time;
    }
}
