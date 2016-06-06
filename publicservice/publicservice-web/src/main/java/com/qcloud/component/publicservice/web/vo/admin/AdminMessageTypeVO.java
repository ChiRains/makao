package com.qcloud.component.publicservice.web.vo.admin;

import java.util.Date;
import java.math.BigDecimal;

public class AdminMessageTypeVO {
	
	private long id;		
	
	//消息标题
	private String code;		
	
	//消息内容
	private String name;		
	
	//存储表数量,1 10 100
	private int tableNumber;		
	
	//多少个月
	private int storageTime;		

	public AdminMessageTypeVO(){
	
	}

	public AdminMessageTypeVO(long id,String code,String name,int tableNumber,int storageTime){
		this.id = id;		
		this.code = code;		
		this.name = name;		
		this.tableNumber = tableNumber;		
		this.storageTime = storageTime;		
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}	
		
	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}	
		
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}	
		
	public void setTableNumber(int tableNumber) {
		this.tableNumber = tableNumber;
	}

	public int getTableNumber() {
		return tableNumber;
	}	
		
	public void setStorageTime(int storageTime) {
		this.storageTime = storageTime;
	}

	public int getStorageTime() {
		return storageTime;
	}	
		
}
