package com.qcloud.component.snakerext.model;

import java.util.Date;
import java.math.BigDecimal;

public class TaskFormAccess {
	
	//ID
	private long id;		
	
	//流程标识id
	private String processId;		
	
	//任务活动名称
	private String taskName;		
	
	//表单id
	private long formId;		
	
	//表单元素id
	private long elementId;		
	
	//表单类型(0:主表单 1:子表单)
	private int formType;		
	
	//是否可写(0:不可写 1:可写)
	private int status;

	public TaskFormAccess(){
	
	}

	public TaskFormAccess(long id,String processId,String taskName,long formId,long elementId,int formType,int status){
		this.id = id;		
		this.processId = processId;		
		this.taskName = taskName;		
		this.formId = formId;		
		this.elementId = elementId;		
		this.formType = formType;		
		this.status = status;		
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}	
		
	public void setProcessId(String processId) {
		this.processId = processId;
	}

	public String getProcessId() {
		return processId;
	}	
		
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskName() {
		return taskName;
	}	
		
	public void setFormId(long formId) {
		this.formId = formId;
	}

	public long getFormId() {
		return formId;
	}	
		
	public void setElementId(long elementId) {
		this.elementId = elementId;
	}

	public long getElementId() {
		return elementId;
	}	
		
	public void setFormType(int formType) {
		this.formType = formType;
	}

	public int getFormType() {
		return formType;
	}	
		
	public void setStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}	
		
}
