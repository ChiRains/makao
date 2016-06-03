package com.qcloud.component.publicdata.web.vo;


public class ProvinceVO {
	
	private long id;		
	
	//省
	private String name;		

	public ProvinceVO(){
	
	}

	public ProvinceVO(long id,String name){
		this.id = id;		
		this.name = name;		
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
		
}
