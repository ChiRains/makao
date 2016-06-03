package com.qcloud.component.publicservice.exception;

import com.qcloud.pirates.exception.PiratesRuntimeException;

public class PublicServiceException extends PiratesRuntimeException {

	/**
     * 
     */
    private static final long serialVersionUID = -7746957459644187873L;

    public PublicServiceException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public PublicServiceException(String message) {
		super(message);
	}
}
