package com.qcloud.component.file.exception;

import com.qcloud.pirates.exception.PiratesRuntimeException;

public class FileException extends PiratesRuntimeException {

	public FileException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public FileException(String message) {
		super(message);
	}
}
