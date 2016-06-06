package com.qcloud.component.permission.exception;

import com.qcloud.pirates.exception.PiratesRuntimeException;

public class PermissionException extends PiratesRuntimeException {

	private static final long serialVersionUID = 5081992038785944305L;

	public PermissionException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public PermissionException(String message) {
		super(message);
	}

}
