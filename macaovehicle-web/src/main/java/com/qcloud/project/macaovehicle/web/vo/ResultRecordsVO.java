package com.qcloud.project.macaovehicle.web.vo;

import java.util.Date;
import java.math.BigDecimal;

public class ResultRecordsVO {
	
	private long id;		
	
	private long resultsId;		
	
	//旧状态
	private int state;		
	
	//新状态
	private int newState;		
	
	private Date time;		

	public ResultRecordsVO(){
	
	}

	public ResultRecordsVO(long id,long resultsId,int state,int newState,Date time){
		this.id = id;		
		this.resultsId = resultsId;		
		this.state = state;		
		this.newState = newState;		
		this.time = time;		
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}	
		
	public void setResultsId(long resultsId) {
		this.resultsId = resultsId;
	}

	public long getResultsId() {
		return resultsId;
	}	
		
	public void setState(int state) {
		this.state = state;
	}

	public int getState() {
		return state;
	}	
		
	public void setNewState(int newState) {
		this.newState = newState;
	}

	public int getNewState() {
		return newState;
	}	
		
	public void setTime(Date time) {
		this.time = time;
	}

	public Date getTime() {
		return time;
	}	
		
}
