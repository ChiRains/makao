package com.qcloud.component.publicdata.model;

import java.util.Date;
import java.math.BigDecimal;

public class Options {
	
	private long id;		
	
	private long questionId;		
	
	private long questionnaireId;		
	
	//选项序号
	private String serialNumber;		
	
	//题目名称
	private String content;		

	public Options(){
	
	}

	public Options(long id,long questionId,long questionnaireId,String serialNumber,String content){
		this.id = id;		
		this.questionId = questionId;		
		this.questionnaireId = questionnaireId;		
		this.serialNumber = serialNumber;		
		this.content = content;		
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}	
		
	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}

	public long getQuestionId() {
		return questionId;
	}	
		
	public void setQuestionnaireId(long questionnaireId) {
		this.questionnaireId = questionnaireId;
	}

	public long getQuestionnaireId() {
		return questionnaireId;
	}	
		
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getSerialNumber() {
		return serialNumber;
	}	
		
	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}	
		
}
