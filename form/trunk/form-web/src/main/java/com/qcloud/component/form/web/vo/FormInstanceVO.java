package com.qcloud.component.form.web.vo;

import java.util.Date;
import java.math.BigDecimal;

public class FormInstanceVO {
	
	//ID
	private long id;		
	
	//表单id
	private long formId;		
	
	//数据id
	private long dataId;		
	
	//编辑时间
	private Date editTime;		

	public FormInstanceVO(){
	
	}

	public FormInstanceVO(long id,long formId,long dataId,Date editTime){
		this.id = id;		
		this.formId = formId;		
		this.dataId = dataId;		
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
		
	public void setEditTime(Date editTime) {
		this.editTime = editTime;
	}

	public Date getEditTime() {
		return editTime;
	}	
		
}
