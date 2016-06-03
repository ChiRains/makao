package com.qcloud.component.publicdata.web.vo;

import java.util.Date;
import java.math.BigDecimal;

public class DataDictionaryVO {
	
	private long id;		
	
	//类型
	private String type;		
	
	//存储键值
	private long key;		
	
	//显示名称
	private String value;		

	public DataDictionaryVO(){
	
	}

	public DataDictionaryVO(long id,String type,long key,String value){
		this.id = id;		
		this.type = type;		
		this.key = key;		
		this.value = value;		
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}	
		
	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}	
		
	public void setKey(long key) {
		this.key = key;
	}

	public long getKey() {
		return key;
	}	
		
	public void setValue(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}	
		
}
