package com.qcloud.component.publicdata.exception;

import com.qcloud.pirates.exception.PiratesRuntimeException;

public class PublicdataException extends PiratesRuntimeException {

	public PublicdataException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public PublicdataException(String message) {
		super(message);
	}
}
