package com.qcloud.component.processtask.exception;

import com.qcloud.pirates.exception.PiratesRuntimeException;

public class ProcesstaskException extends PiratesRuntimeException {

	public ProcesstaskException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public ProcesstaskException(String message) {
		super(message);
	}
}
