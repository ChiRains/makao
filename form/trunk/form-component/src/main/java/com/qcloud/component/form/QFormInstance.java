package com.qcloud.component.form;

import java.util.Date;

public interface QFormInstance {

	long getId();

	long getFormId();

	long getDataId();

	String getCode();

	Date getEditTime();
}
