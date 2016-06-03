package com.qcloud.component.form.entity;

import com.qcloud.component.form.FormEvent;

public class EventDefination {

	FormEvent.FormEventType type;

	String beanId;

	public FormEvent.FormEventType getType() {
		return type;
	}

	public void setType(FormEvent.FormEventType type) {
		this.type = type;
	}

	public String getBeanId() {
		return beanId;
	}

	public void setBeanId(String beanId) {
		this.beanId = beanId;
	}

}
