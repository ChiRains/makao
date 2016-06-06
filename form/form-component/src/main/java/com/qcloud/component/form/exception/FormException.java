package com.qcloud.component.form.exception;

import com.qcloud.pirates.exception.PiratesRuntimeException;

public class FormException extends PiratesRuntimeException {

	public FormException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public FormException(String message) {
		super(message);
	}
}
