package com.qcloud.component.form.web.vo.admin;

import java.util.Date;
import java.math.BigDecimal;

public class AdminElementFieldMappingVO {
	
	//ID
	private long id;		
	
	//元素id
	private long elementId;		
	
	//属性id
	private long fieldId;		

	public AdminElementFieldMappingVO(){
	
	}

	public AdminElementFieldMappingVO(long id,long elementId,long fieldId){
		this.id = id;		
		this.elementId = elementId;		
		this.fieldId = fieldId;		
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}	
		
	public void setElementId(long elementId) {
		this.elementId = elementId;
	}

	public long getElementId() {
		return elementId;
	}	
		
	public void setFieldId(long fieldId) {
		this.fieldId = fieldId;
	}

	public long getFieldId() {
		return fieldId;
	}	
		
}
