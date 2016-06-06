package com.qcloud.component.mvprocesstask.exception;

import com.qcloud.pirates.exception.PiratesRuntimeException;

public class MvprocesstaskException extends PiratesRuntimeException {

	public MvprocesstaskException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public MvprocesstaskException(String message) {
		super(message);
	}
}
