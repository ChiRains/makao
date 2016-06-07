package com.qcloud.component.piratesship.exception;

import com.qcloud.pirates.exception.PiratesRuntimeException;

public class PiratesshipException extends PiratesRuntimeException {

	public PiratesshipException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public PiratesshipException(String message) {
		super(message);
	}
}
