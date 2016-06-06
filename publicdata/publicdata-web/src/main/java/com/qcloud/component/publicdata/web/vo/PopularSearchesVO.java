package com.qcloud.component.publicdata.web.vo;

import java.util.Date;
import java.math.BigDecimal;

public class PopularSearchesVO {
	
	private long id;		
	
	//搜索关键字
	private String keywords;		
	
	//次数
	private long times;		
	
	private int type;		

	public PopularSearchesVO(){
	
	}

	public PopularSearchesVO(long id,String keywords,long times,int type){
		this.id = id;		
		this.keywords = keywords;		
		this.times = times;		
		this.type = type;		
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}	
		
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getKeywords() {
		return keywords;
	}	
		
	public void setTimes(long times) {
		this.times = times;
	}

	public long getTimes() {
		return times;
	}	
		
	public void setType(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}	
		
}
