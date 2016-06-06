package com.qcloud.component.snakerext.exception;

import com.qcloud.pirates.exception.PiratesRuntimeException;

public class SnakerExtException extends PiratesRuntimeException {

	public SnakerExtException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public SnakerExtException(String message) {
		super(message);
	}
}
