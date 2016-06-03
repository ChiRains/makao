package com.qcloud.component.form.web.vo.admin;

import java.util.Date;
import java.math.BigDecimal;

public class AdminFormInstanceHistVO {
	
	//ID
	private long id;		
	
	//表单id
	private long formId;		
	
	//表单实例id
	private long formInstanceId;		
	
	//数据id
	private long dataId;		
	
	//编辑时间
	private Date editTime;		
	
	//备份时间
	private Date backTime;		

	public AdminFormInstanceHistVO(){
	
	}

	public AdminFormInstanceHistVO(long id,long formId,long formInstanceId,long dataId,Date editTime,Date backTime){
		this.id = id;		
		this.formId = formId;		
		this.formInstanceId = formInstanceId;		
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
