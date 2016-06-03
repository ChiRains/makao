package com.qcloud.component.permission.model;

import java.util.Date;
import java.math.BigDecimal;

import com.qcloud.component.permission.model.key.TypeEnum.AccountEnableType;

public class Account {

	// 主键
	private long id;

	// 账号名称
	private String name;

	// 账号代码 最好使用手机号
	private String code;

	// 账号是否启用
	private int enable = AccountEnableType.DISABLE.getKey();

	// 组织
	private long orgId;

	public Account() {

	}

	public Account(long id, String name, String code, int enable, long orgId) {
		this.id = id;
		this.name = name;
		this.code = code;
		this.enable = enable;
		this.orgId = orgId;
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

	public void setEnable(int enable) {
		this.enable = enable;
	}

	public int getEnable() {
		return enable;
	}

	public void setOrgId(long orgId) {
		this.orgId = orgId;
	}

	public long getOrgId() {
		return orgId;
	}

}
