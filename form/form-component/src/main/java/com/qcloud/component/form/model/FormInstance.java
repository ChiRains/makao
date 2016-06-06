package com.qcloud.component.form.model;

import java.util.Date;
import java.math.BigDecimal;

public class FormInstance {
	
	//ID
	private long id;		
	
	//表单id
	private long formId;		
	
	//数据id
	private long dataId;		
	
	//表单编码
	private String code;		
	
	//编辑时间
	private Date editTime;		

	public FormInstance(){
	
	}

	public FormInstance(long id,long formId,long dataId,String code,Date editTime){
		this.id = id;		
		this.formId = formId;		
		this.dataId = dataId;		
		this.code = code;		
		this.editTime = editTime;		
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}	
		
	public void setFormId(long formId) {
		this.formId = formId;
	}

	public long getFormId() {
		return formId;
	}	
		
	public void setDataId(long dataId) {
		this.dataId = dataId;
	}

	public long getDataId() {
		return dataId;
	}	
		
	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}	
		
	public void setEditTime(Date editTime) {
		this.editTime = editTime;
	}

	public Date getEditTime() {
		return editTime;
	}	
		
}
