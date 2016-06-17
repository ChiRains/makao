package com.qcloud.project.macaovehicle.model;

import java.util.Date;
import java.math.BigDecimal;

public class DvrDetail {

	private long id;

	// DVR区域表的id
	private long areaId;

	// DVR用户名
	private String username;

	// DVR密码
	private String password;

	// DVR设备名称
	private String name;

	// DVR设备IP地址
	private String ip;

	// DVR设备端口
	private String port;

	// DVR设备生产厂家
	private String vendor;

	// 拍摄方向
	private String direction;
	
	// 操作人
	private String operator;
	
	// 最后修改时间
	private Date lastModifiedTime;

	// 是否启用(1启用, 0不启用)
	private int status;

	public DvrDetail() {

	}

	public DvrDetail(long id, long areaId, String username, String password, String name, String ip, String port,
			String vendor, String direction, String operator, Date lastModifiedTime, int status) {
		this.id = id;
		this.areaId = areaId;
		this.username = username;
		this.password = password;
		this.name = name;
		this.ip = ip;
		this.vendor = vendor;
		this.direction = direction;
		this.operator = operator;
		this.lastModifiedTime = lastModifiedTime;
		this.status = status;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setAreaId(long areaId) {
		this.areaId = areaId;
	}

	public long getAreaId() {
		return areaId;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getIp() {
		return ip;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getVendor() {
		return vendor;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getDirection() {
		return direction;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Date getLastModifiedTime() {
		return lastModifiedTime;
	}

	public void setLastModifiedTime(Date lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

}
