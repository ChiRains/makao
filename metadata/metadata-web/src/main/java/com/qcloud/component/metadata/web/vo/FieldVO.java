package com.qcloud.component.metadata.web.vo;

import java.util.Date;
import java.math.BigDecimal;

public class FieldVO {
	
	//ID
	private long id;		
	
	//表
	private long tableId;		
	
	//名称
	private String label;		
	
	//表名
	private String name;		
	
	//类型
	private int type;		
	
	//长度
	private int length;		
	
	//精度
	private int precision;		
	
	//描述
	private String remark;		

	public FieldVO(){
	
	}

	public FieldVO(long id,long tableId,String label,String name,int type,int length,int precision,String remark){
		this.id = id;		
		this.tableId = tableId;		
		this.label = label;		
		this.name = name;		
		this.type = type;		
		this.length = length;		
		this.precision = precision;		
		this.remark = remark;		
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}	
		
	public void setTableId(long tableId) {
		this.tableId = tableId;
	}

	public long getTableId() {
		return tableId;
	}	
		
	public void setLabel(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}	
		
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}	
		
	public void setType(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}	
		
	public void setLength(int length) {
		this.length = length;
	}

	public int getLength() {
		return length;
	}	
		
	public void setPrecision(int precision) {
		this.precision = precision;
	}

	public int getPrecision() {
		return precision;
	}	
		
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark() {
		return remark;
	}	
		
}
