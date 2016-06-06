package com.qcloud.component.account.model;

import java.util.Date;
import java.math.BigDecimal;
import com.qcloud.component.account.QAccount;

public class EntryCertificate implements QAccount{
	
	//ID
	private long id;		
	
	//账号
	private String account;		
	
	//组
	private String group;		
	
	//编码
	private String code;		
	
	//密码
	private String password;		
	
	//账号名称
	private String name;		
	
	//登记时间
	private Date registTime;		
	
	//状态 1启用 2禁用 3冻结
	private int state;		
	
	//冻结开始时间
	private Date frozenTime;		

	public EntryCertificate(){
	
	}

	public EntryCertificate(long id,String account,String group,String code,String password,String name,Date registTime,int state,Date frozenTime){
		this.id = id;		
		this.account = account;		
		this.group = group;		
		this.code = code;		
		this.password = password;		
		this.name = name;		
		this.registTime = registTime;		
		this.state = state;		
		this.frozenTime = frozenTime;		
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}	
		
	public void setAccount(String account) {
		this.account = account;
	}

	public String getAccount() {
		return account;
	}	
		
	public void setGroup(String group) {
		this.group = group;
	}

	public String getGroup() {
		return group;
	}	
		
	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}	
		
	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}	
		
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}	
		
	public void setRegistTime(Date registTime) {
		this.registTime = registTime;
	}

	public Date getRegistTime() {
		return registTime;
	}	
		
	public void setState(int state) {
		this.state = state;
	}

	public int getState() {
		return state;
	}	
		
	public void setFrozenTime(Date frozenTime) {
		this.frozenTime = frozenTime;
	}

	public Date getFrozenTime() {
		return frozenTime;
	}	
		
}
