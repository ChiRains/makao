package com.qcloud.component.form.model;

import com.qcloud.component.form.QFormElement;

public class ElementDef implements QFormElement{
	
	//ID
	private long id;		
	
	//表单id
	private long formId;		
	
	//元素名
	private String name;		
	
	//编码
	private String code;		
	
	//类型
	private int type;		

	public ElementDef(){
	
	}

	public ElementDef(long id,long formId,String name,String code,int type){
		this.id = id;		
		this.formId = formId;		
		this.name = name;		
		this.code = code;		
		this.type = type;		
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
		
	public void setType(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}	
		
}
