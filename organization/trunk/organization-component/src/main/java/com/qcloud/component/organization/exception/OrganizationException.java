package com.qcloud.component.organization.exception;

import com.qcloud.pirates.exception.PiratesRuntimeException;

public class OrganizationException extends PiratesRuntimeException {

	public OrganizationException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public OrganizationException(String message) {
		super(message);
	}
}
