package com.qcloud.project.macaovehicle.web.vo.admin;

import java.util.Date;
import java.math.BigDecimal;

public class AdminCarOwnerVO {

    // ID
    private long   id;

    private long   userId;

    // 身份证号码
    private String idcardNumber;

    // 居住地址
    private String address;

    // 户口所在地
    private String residence;

    // 身份证反面
    private String idcardBack;

    // 身份证正面
    private String idcardFace;

    private String birthday;

    // 1务工2在住3企业
    private int    type;
	private int clerkType;		
	private String mobile;		
	private String email;		
	private String name;		
	private int certificateType;		
	private String certificateNo;		
	private Date certificateDate;		
	private String certificateUrl;		
	private int sex;		
	private String idCardValidTime;		

	public AdminCarOwnerVO(){
	
	}

	public AdminCarOwnerVO(long id,long userId,String idcardNumber,String address,String residence,String idcardBack,String idcardFace,String birthday,int type,int clerkType,String mobile,String email,String name,int certificateType,String certificateNo,Date certificateDate,String certificateUrl,int sex,String idCardValidTime){
		this.id = id;		
		this.userId = userId;		
		this.idcardNumber = idcardNumber;		
		this.address = address;		
		this.residence = residence;		
		this.idcardBack = idcardBack;		
		this.idcardFace = idcardFace;		
		this.birthday = birthday;		
		this.type = type;		
		this.clerkType = clerkType;		
		this.mobile = mobile;		
		this.email = email;		
		this.name = name;		
		this.certificateType = certificateType;		
		this.certificateNo = certificateNo;		
		this.certificateDate = certificateDate;		
		this.certificateUrl = certificateUrl;		
		this.sex = sex;		
		this.idCardValidTime = idCardValidTime;		
	}
	
	public void setId(long id) {
		this.id = id;
	}

    public long getId() {

        return id;
    }

    public void setUserId(long userId) {

        this.userId = userId;
    }

    public long getUserId() {

        return userId;
    }

    public void setIdcardNumber(String idcardNumber) {

        this.idcardNumber = idcardNumber;
    }

    public String getIdcardNumber() {

        return idcardNumber;
    }

    public void setAddress(String address) {

        this.address = address;
    }

    public String getAddress() {

        return address;
    }

    public void setResidence(String residence) {

        this.residence = residence;
    }

    public String getResidence() {

        return residence;
    }

    public void setIdcardBack(String idcardBack) {

        this.idcardBack = idcardBack;
    }

    public String getIdcardBack() {

        return idcardBack;
    }

    public void setIdcardFace(String idcardFace) {

        this.idcardFace = idcardFace;
    }

    public String getIdcardFace() {

        return idcardFace;
    }

    public void setType(int type) {

        this.type = type;
    }

    public int getType() {

        return type;
    }

    public String getBirthday() {

        return birthday;
    }

    public void setBirthday(String birthday) {

        this.birthday = birthday;
    }
}
