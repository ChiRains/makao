package com.qcloud.component.permission.model;

import java.util.Date;
import java.math.BigDecimal;

public class Catalog {
	
	private long id;		
	
	private String name;		
	
	private int order;		
	
	private int type;		

	public Catalog(){
	
	}

	public Catalog(long id,String name,int order,int type){
		this.id = id;		
		this.name = name;		
		this.order = order;		
		this.type = type;		
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
		
	public void setOrder(int order) {
		this.order = order;
	}

	public int getOrder() {
		return order;
	}	
		
	public void setType(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}	
		
}
