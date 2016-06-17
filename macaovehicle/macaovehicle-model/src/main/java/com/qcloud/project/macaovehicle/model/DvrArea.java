package com.qcloud.project.macaovehicle.model;

import java.util.Date;
import java.math.BigDecimal;

public class DvrArea {

	private long id;

	// 区域名称
	private String name;

	// 是否启用(1启用, 0不启用)
	private int status;

	public DvrArea() {

	}

	public DvrArea(long id, String name, int status) {
		this.id = id;

		this.name = name;
		this.status = status;
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

	public void setStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

}
