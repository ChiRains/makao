package com.qcloud.component.admin;

public interface LoginVerification {

	boolean allow(String account, String password);

	String[] getAccountCodes(String account);

	String getIdentificationKey(String account);
}
