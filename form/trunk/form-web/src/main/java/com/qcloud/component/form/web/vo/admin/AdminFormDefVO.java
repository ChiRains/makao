package com.qcloud.component.form.web.vo.admin;

import java.util.Date;
import java.math.BigDecimal;

public class AdminFormDefVO {
	
	//ID
	private long id;		
	
	//主表ID
	private long mainFormId;		
	
	//表单名
	private String name;		
	
	//编码
	private String code;		
	
	//描述
	private String remark;		

	public AdminFormDefVO(){
	
	}

	public AdminFormDefVO(long id,long mainFormId,String name,String code,String remark){
		this.id = id;		
		this.mainFormId = mainFormId;		
		this.name = name;		
		this.code = code;		
		this.remark = remark;		
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}	
		
	public void setMainFormId(long mainFormId) {
		this.mainFormId = mainFormId;
	}

	public long getMainFormId() {
		return mainFormId;
	}	
		
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}	
		
	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}	
		
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark() {
		return remark;
	}	
		
}
