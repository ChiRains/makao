package com.qcloud.component.form.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.qcloud.component.form.QFormData;
import com.qcloud.component.form.QFormElement;
import com.qcloud.component.form.QFormInstance;
import com.qcloud.component.form.model.ElementDef;

public class FormInstanceEntity implements QFormInstance {

	// ID
	private long id;

	// 表单id
	private long formId;

	// 数据id
	private long dataId;

	// 表单编码
	private String code;

	// 编辑时间
	private Date editTime;

	public FormInstanceEntity() {

	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setFormId(long formId) {
		this.formId = formId;
	}

	public long getFormId() {
		return formId;
	}

	public void setDataId(long dataId) {
		this.dataId = dataId;
	}

	public long getDataId() {
		return dataId;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setEditTime(Date editTime) {
		this.editTime = editTime;
	}

	public Date getEditTime() {
		return editTime;
	}

}
