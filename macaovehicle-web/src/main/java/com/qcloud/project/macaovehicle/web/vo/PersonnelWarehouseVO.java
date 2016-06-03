package com.qcloud.project.macaovehicle.web.vo;

import java.util.Date;
import java.math.BigDecimal;

public class PersonnelWarehouseVO {
	
	//ID
	private long id;		
	
	//姓名
	private String name;		
	
	//手机号
	private String mobile;		
	
	//性别1男2女
	private int sex;		
	
	//居住地址
	private String address;		
	
	//邮箱
	private String email;		
	
	//身份证
	private String idcardNumber;		
	
	//户口所在地
	private String residence;		
	
	//录入时间
	private Date time;		
	
private int type ;
    
    private long departmentId;

	public PersonnelWarehouseVO(){
	
	}

	public PersonnelWarehouseVO(long id,String name,String mobile,int sex,String address,String email,String idcardNumber,String residence,Date time){
		this.id = id;		
		this.name = name;		
		this.mobile = mobile;		
		this.sex = sex;		
		this.address = address;		
		this.email = email;		
		this.idcardNumber = idcardNumber;		
		this.residence = residence;		
		this.time = time;		
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}	
		
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}	
		
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getMobile() {
		return mobile;
	}	
		
	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getSex() {
		return sex;
	}	
		
	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}	
		
	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}	
		
	public void setIdcardNumber(String idcardNumber) {
		this.idcardNumber = idcardNumber;
	}

	public String getIdcardNumber() {
		return idcardNumber;
	}	
		
	public void setResidence(String residence) {
		this.residence = residence;
	}

	public String getResidence() {
		return residence;
	}	
		
	public void setTime(Date time) {
		this.time = time;
	}

	public Date getTime() {
		return time;
	}

    
    public int getType() {
    
        return type;
    }

    
    public void setType(int type) {
    
        this.type = type;
    }

    
    public long getDepartmentId() {
    
        return departmentId;
    }

    
    public void setDepartmentId(long departmentId) {
    
        this.departmentId = departmentId;
    }	
		
}
