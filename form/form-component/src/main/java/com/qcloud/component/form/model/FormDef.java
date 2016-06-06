package com.qcloud.component.form.model;

import java.util.Date;
import java.math.BigDecimal;

public class FormDef {
	
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
	
	//PC页面
	private String pcPageUrl;		
	
	//移动端入口
	private String mobilePageUrl;		

	public FormDef(){
	
	}

	public FormDef(long id,long mainFormId,String name,String code,String remark,String pcPageUrl,String mobilePageUrl){
		this.id = id;		
		this.mainFormId = mainFormId;		
		this.name = name;		
		this.code = code;		
		this.remark = remark;		
		this.pcPageUrl = pcPageUrl;		
		this.mobilePageUrl = mobilePageUrl;		
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
		
	public void setPcPageUrl(String pcPageUrl) {
		this.pcPageUrl = pcPageUrl;
	}

	public String getPcPageUrl() {
		return pcPageUrl;
	}	
		
	public void setMobilePageUrl(String mobilePageUrl) {
		this.mobilePageUrl = mobilePageUrl;
	}

	public String getMobilePageUrl() {
		return mobilePageUrl;
	}	
		
}
