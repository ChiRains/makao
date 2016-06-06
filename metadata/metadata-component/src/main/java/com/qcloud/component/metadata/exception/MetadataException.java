package com.qcloud.component.metadata.exception;

import com.qcloud.pirates.exception.PiratesRuntimeException;

public class MetadataException extends PiratesRuntimeException {

	/**
     * 
     */
    private static final long serialVersionUID = -5180946488642364298L;

    public MetadataException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public MetadataException(String message) {
		super(message);
	}
}
