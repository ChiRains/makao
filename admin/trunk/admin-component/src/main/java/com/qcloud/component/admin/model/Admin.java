package com.qcloud.component.admin.model;

import com.qcloud.component.admin.model.key.TypeEnum.AdminEnableType;

public class Admin {

	private long id;

	// 姓名
	private String name;

	// 账号
	private String account;

	// 密码
	private String password;

	private int enable = AdminEnableType.ENABLE.getKey();

	public int getEnable() {
		return enable;
	}

	public void setEnable(int enable) {
		this.enable = enable;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
