package com.qcloud.component.permission.model;

import java.util.Date;
import java.math.BigDecimal;

public class Menu {
	
	private long id;		
	
	private String name;		
	
	private String code;		
	
	private int order;		
	
	private String url;		
	
	private long catalogId;		

	public Menu(){
	
	}

	public Menu(long id,String name,String code,int order,String url,long catalogId){
		this.id = id;		
		this.name = name;		
		this.code = code;		
		this.order = order;		
		this.url = url;		
		this.catalogId = catalogId;		
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
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
		
	public void setOrder(int order) {
		this.order = order;
	}

	public int getOrder() {
		return order;
	}	
		
	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}	
		
	public void setCatalogId(long catalogId) {
		this.catalogId = catalogId;
	}

	public long getCatalogId() {
		return catalogId;
	}	
		
}
