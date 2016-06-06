package com.qcloud.component.form.model;

import java.util.Date;
import java.math.BigDecimal;

public class FormInstanceHist {
	
	//ID
	private long id;		
	
	//表单id
	private long formId;		
	
	//表单实例id
	private long formInstanceId;		
	
	//表单编码
	private String code;		
	
	//数据id
	private long dataId;		
	
	//编辑时间
	private Date editTime;		
	
	//备份时间
	private Date backTime;		

	public FormInstanceHist(){
	
	}

	public FormInstanceHist(long id,long formId,long formInstanceId,String code,long dataId,Date editTime,Date backTime){
		this.id = id;		
		this.formId = formId;		
		this.formInstanceId = formInstanceId;		
		this.code = code;		
		this.dataId = dataId;		
		this.editTime = editTime;		
		this.backTime = backTime;		
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
		
	public void setFormInstanceId(long formInstanceId) {
		this.formInstanceId = formInstanceId;
	}

	public long getFormInstanceId() {
		return formInstanceId;
	}	
		
	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}	
		
	public void setDataId(long dataId) {
		this.dataId = dataId;
	}

	public long getDataId() {
		return dataId;
	}	
		
	public void setEditTime(Date editTime) {
		this.editTime = editTime;
	}

	public Date getEditTime() {
		return editTime;
	}	
		
	public void setBackTime(Date backTime) {
		this.backTime = backTime;
	}

	public Date getBackTime() {
		return backTime;
	}	
		
}
