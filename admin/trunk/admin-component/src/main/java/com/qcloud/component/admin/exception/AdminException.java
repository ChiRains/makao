package com.qcloud.component.admin.exception;

import com.qcloud.pirates.exception.PiratesRuntimeException;

public class AdminException extends PiratesRuntimeException {

	public AdminException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public AdminException(String message) {
		super(message);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -4229440292104971000L;

}
