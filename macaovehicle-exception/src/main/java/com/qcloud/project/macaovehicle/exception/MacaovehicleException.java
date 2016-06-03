package com.qcloud.project.macaovehicle.exception;

import com.qcloud.pirates.exception.PiratesRuntimeException;

public class MacaovehicleException extends PiratesRuntimeException {

	public MacaovehicleException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public MacaovehicleException(String message) {
		super(message);
	}
}
