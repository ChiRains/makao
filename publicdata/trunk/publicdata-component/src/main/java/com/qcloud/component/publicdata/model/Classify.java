package com.qcloud.component.publicdata.model;

import java.util.Date;
import java.math.BigDecimal;

public class Classify {
	
	//ID
	private long id;		
	
	private long parentId;		
	
	//名称
	private String name;		
	
	//树编码
	private String bsid;		
	
	//分类类型
	private long type;		
	
	//图片
	private String image;		
	
	//描述
	private String remark;		
	
	private int enable;
	
	private int sort;

	public Classify(){
	
	}

	public Classify(long id,long parentId,String name,String bsid,long type,String image,String remark){
		this.id = id;		
		this.parentId = parentId;		
		this.name = name;		
		this.bsid = bsid;		
		this.type = type;		
		this.image = image;		
		this.remark = remark;		
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}	
		
	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	public long getParentId() {
		return parentId;
	}	
		
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}	
		
	public void setBsid(String bsid) {
		this.bsid = bsid;
	}

	public String getBsid() {
		return bsid;
	}	
		
	public void setType(long type) {
		this.type = type;
	}

	public long getType() {
		return type;
	}	
		
	public void setImage(String image) {
		this.image = image;
	}

	public String getImage() {
		return image;
	}	
		
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark() {
		return remark;
	}

    
    public int getEnable() {
    
        return enable;
    }

    
    public void setEnable(int enable) {
    
        this.enable = enable;
    }

    
    public int getSort() {
    
        return sort;
    }

    
    public void setSort(int sort) {
    
        this.sort = sort;
    }	
		
}
