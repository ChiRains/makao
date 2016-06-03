package com.qcloud.component.processtask.web.vo.admin;

import java.util.Date;
import java.math.BigDecimal;

public class AdminTaskingVO {
	
	//ID
	private long id;		
	
	//处理人ID
	private long userId;		
	
	//流程申请ID
	private long creator;		
	
	//任务名称
	private String name;		
	
	//流程类型
	private String type;		
	
	//申请时间
	private Date applyTime;		
	
	//接收时间
	private Date receiveTime;		
	
	//表单实例ID
	private long formId;		
	
	//表单实例ID
	private long formInstanceId;		
	
	//流程实例ID
	private String processId;		
	
	//流程实例ID
	private String processInstId;		
	
	//流程任务ID
	private String workitemId;		

	public AdminTaskingVO(){
	
	}

	public AdminTaskingVO(long id,long userId,long creator,String name,String type,Date applyTime,Date receiveTime,long formId,long formInstanceId,String processId,String processInstId,String workitemId){
		this.id = id;		
		this.userId = userId;		
		this.creator = creator;		
		this.name = name;		
		this.type = type;		
		this.applyTime = applyTime;		
		this.receiveTime = receiveTime;		
		this.formId = formId;		
		this.formInstanceId = formInstanceId;		
		this.processId = processId;		
		this.processInstId = processInstId;		
		this.workitemId = workitemId;		
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}	
		
	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getUserId() {
		return userId;
	}	
		
	public void setCreator(long creator) {
		this.creator = creator;
	}

	public long getCreator() {
		return creator;
	}	
		
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}	
		
	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}	
		
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	public Date getApplyTime() {
		return applyTime;
	}	
		
	public void setReceiveTime(Date receiveTime) {
		this.receiveTime = receiveTime;
	}

	public Date getReceiveTime() {
		return receiveTime;
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
		
	public void setProcessId(String processId) {
		this.processId = processId;
	}

	public String getProcessId() {
		return processId;
	}	
		
	public void setProcessInstId(String processInstId) {
		this.processInstId = processInstId;
	}

	public String getProcessInstId() {
		return processInstId;
	}	
		
	public void setWorkitemId(String workitemId) {
		this.workitemId = workitemId;
	}

	public String getWorkitemId() {
		return workitemId;
	}	
		
}
