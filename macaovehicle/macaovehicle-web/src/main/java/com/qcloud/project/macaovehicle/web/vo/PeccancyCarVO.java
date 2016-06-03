package com.qcloud.project.macaovehicle.web.vo;

import java.util.Date;
import java.math.BigDecimal;

public class PeccancyCarVO {
	
	private long id;		
	
	//境外车牌
	private String outsidePlate;		
	
	//临时车牌
	private String temporaryPlate;		
	
	//违章时间
	private Date time;		
	
	private String timeFormat;
	
	//违章代码
	private String code;		
	
	//违章地点
	private String place;		
	
	//违章行为
	private String behavior;		
	
	//是否发布到首页
	private int isPublish;		
	
	//创建者Id
	private long creatorId;		
	
	//创建时间
	private Date createTime;		
	
	private long carOwnerId;

	public PeccancyCarVO(){
	
	}

	public PeccancyCarVO(long id,String outsidePlate,String temporaryPlate,Date time,String code,String place,String behavior,int isPublish,long creatorId,Date createTime){
		this.id = id;		
		this.outsidePlate = outsidePlate;		
		this.temporaryPlate = temporaryPlate;		
		this.time = time;		
		this.code = code;		
		this.place = place;		
		this.behavior = behavior;		
		this.isPublish = isPublish;		
		this.creatorId = creatorId;		
		this.createTime = createTime;		
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}	
		
	public void setOutsidePlate(String outsidePlate) {
		this.outsidePlate = outsidePlate;
	}

	public String getOutsidePlate() {
		return outsidePlate;
	}	
		
	public void setTemporaryPlate(String temporaryPlate) {
		this.temporaryPlate = temporaryPlate;
	}

	public String getTemporaryPlate() {
		return temporaryPlate;
	}	
		
	public void setTime(Date time) {
		this.time = time;
	}

	public Date getTime() {
		return time;
	}	
		
	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}	
		
	public void setPlace(String place) {
		this.place = place;
	}

	public String getPlace() {
		return place;
	}	
		
	public void setBehavior(String behavior) {
		this.behavior = behavior;
	}

	public String getBehavior() {
		return behavior;
	}	
		
	public void setIsPublish(int isPublish) {
		this.isPublish = isPublish;
	}

	public int getIsPublish() {
		return isPublish;
	}	
		
	public void setCreatorId(long creatorId) {
		this.creatorId = creatorId;
	}

	public long getCreatorId() {
		return creatorId;
	}	
		
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return createTime;
	}	
	
	public String getTimeFormat() {
		return timeFormat;
	}

	public void setTimeFormat(String timeFormat) {
		this.timeFormat = timeFormat;
	}
	

	public long getCarOwnerId() {
		return carOwnerId;
	}

	public void setCarOwnerId(long carOwnerId) {
		this.carOwnerId = carOwnerId;
	}
		
}
