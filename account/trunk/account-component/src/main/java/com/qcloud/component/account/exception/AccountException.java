package com.qcloud.component.account.exception;

import com.qcloud.pirates.exception.PiratesRuntimeException;

public class AccountException extends PiratesRuntimeException {

	public AccountException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public AccountException(String message) {
		super(message);
	}
}
