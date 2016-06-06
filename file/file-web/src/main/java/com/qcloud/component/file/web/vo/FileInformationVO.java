package com.qcloud.component.file.web.vo;

import java.util.Date;
import java.math.BigDecimal;

public class FileInformationVO {
	
	private long id;		
	
	private String code;		
	
	private String url;		
	
	private Date time;		
	
	private String remark;

	public FileInformationVO(){
	
	}

	public FileInformationVO(long id,String code,String url,Date time){
		this.id = id;		
		this.code = code;		
		this.url = url;		
		this.time = time;		
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
		
	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}	
		
	public void setTime(Date time) {
		this.time = time;
	}

	public Date getTime() {
		return time;
	}

    
    public String getRemark() {
    
        return remark;
    }

    
    public void setRemark(String remark) {
    
        this.remark = remark;
    }	
		
}
