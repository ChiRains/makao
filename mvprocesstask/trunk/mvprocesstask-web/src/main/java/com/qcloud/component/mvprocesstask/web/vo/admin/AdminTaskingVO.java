package com.qcloud.component.mvprocesstask.web.vo.admin;

import java.util.Date;
import java.math.BigDecimal;

public class AdminTaskingVO {
	
	//ID
	private long id;		
	
	//处理人ID
	private long clerkId;		
	
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
	
	//PC页面
	private String pcPageUrl;		
	
	//表单编号
	private String code;		
	
	//申请类型
	private String applyType;		
	
	//职员姓名
	private String clerkName;		
	
	//身份证号
	private String idCard;		
	
	//公司名称
	private String companyName;		
	
	//公司代码
	private String companyCode;		
	
	//车牌号
	private String plateNumber;		

	public AdminTaskingVO(){
	
	}

	public AdminTaskingVO(long id,long clerkId,long creator,String name,String type,Date applyTime,Date receiveTime,long formId,long formInstanceId,String processId,String processInstId,String workitemId,String pcPageUrl,String code,String applyType,String clerkName,String idCard,String companyName,String companyCode,String plateNumber){
		this.id = id;		
		this.clerkId = clerkId;		
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
		this.pcPageUrl = pcPageUrl;		
		this.code = code;		
		this.applyType = applyType;		
		this.clerkName = clerkName;		
		this.idCard = idCard;		
		this.companyName = companyName;		
		this.companyCode = companyCode;		
		this.plateNumber = plateNumber;		
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}	
		
	public void setClerkId(long clerkId) {
		this.clerkId = clerkId;
	}

	public long getClerkId() {
		return clerkId;
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
		
	public void setPcPageUrl(String pcPageUrl) {
		this.pcPageUrl = pcPageUrl;
	}

	public String getPcPageUrl() {
		return pcPageUrl;
	}	
		
	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}	
		
	public void setApplyType(String applyType) {
		this.applyType = applyType;
	}

	public String getApplyType() {
		return applyType;
	}	
		
	public void setClerkName(String clerkName) {
		this.clerkName = clerkName;
	}

	public String getClerkName() {
		return clerkName;
	}	
		
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getIdCard() {
		return idCard;
	}	
		
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyName() {
		return companyName;
	}	
		
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getCompanyCode() {
		return companyCode;
	}	
		
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public String getPlateNumber() {
		return plateNumber;
	}	
		
}
