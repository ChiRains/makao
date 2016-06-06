package com.qcloud.component.snakerext.model;

import java.util.Date;
import java.math.BigDecimal;

public class ProcessExecutor {
	
	//ID
	private long id;		
	
	//流程标识
	private String processId;		
	
	//活动名称
	private String taskName;		
	
	//1:用户 2:角色 3:自定义接口
	private int type;		
	
	//目标执行人id
	private long memberId;		

	public ProcessExecutor(){
	
	}

	public ProcessExecutor(long id,String processId,String taskName,int type,long memberId){
		this.id = id;		
		this.processId = processId;		
		this.taskName = taskName;		
		this.type = type;		
		this.memberId = memberId;		
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
		
	public void setType(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}	
		
	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}

	public long getMemberId() {
		return memberId;
	}	
		
}
