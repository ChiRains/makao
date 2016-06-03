package com.qcloud.component.publicdata.web.vo.admin;

import java.util.Date;
import java.math.BigDecimal;

public class AdminExpressVO {
	
	private long id;		
	
	//快递公司名称
	private String name;		
	
	//快递公司编码
	private String code;		
	
	//描述
	private String desc;		
	
	//快递公司图片
	private String logo;
	
	private String logoUid;
	
	//排序
	private long sort;		
	
	//首重重量
	private double firstWeight;		
	
	//首重费用
	private double firstPrice;		
	
	//续重重量
	private double continuedWeight;		
	
	//续重费用
	private double continuedPrice;		
	
	//是否启用 0否1是
	private long enable;		

	public AdminExpressVO(){
	
	}

	public AdminExpressVO(long id,String name,String code,String desc,String logo,long sort,double firstWeight,double firstPrice,double continuedWeight,double continuedPrice,long enable){
		this.id = id;		
		this.name = name;		
		this.code = code;		
		this.desc = desc;		
		this.logo = logo;		
		this.sort = sort;		
		this.firstWeight = firstWeight;		
		this.firstPrice = firstPrice;		
		this.continuedWeight = continuedWeight;		
		this.continuedPrice = continuedPrice;		
		this.enable = enable;		
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
		
	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}	
		
	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getLogo() {
		return logo;
	}	
		
	public void setSort(long sort) {
		this.sort = sort;
	}

	public long getSort() {
		return sort;
	}	
		
	public void setFirstWeight(double firstWeight) {
		this.firstWeight = firstWeight;
	}

	public double getFirstWeight() {
		return firstWeight;
	}	
		
	public void setFirstPrice(double firstPrice) {
		this.firstPrice = firstPrice;
	}

	public double getFirstPrice() {
		return firstPrice;
	}	
		
	public void setContinuedWeight(double continuedWeight) {
		this.continuedWeight = continuedWeight;
	}

	public double getContinuedWeight() {
		return continuedWeight;
	}	
		
	public void setContinuedPrice(double continuedPrice) {
		this.continuedPrice = continuedPrice;
	}

	public double getContinuedPrice() {
		return continuedPrice;
	}	
		
	public void setEnable(long enable) {
		this.enable = enable;
	}

	public long getEnable() {
		return enable;
	}

    
    public String getLogoUid() {
    
        return logoUid;
    }

    
    public void setLogoUid(String logoUid) {
    
        this.logoUid = logoUid;
    }	
		
}
