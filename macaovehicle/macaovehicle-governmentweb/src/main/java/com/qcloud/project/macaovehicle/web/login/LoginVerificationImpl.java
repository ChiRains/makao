package com.qcloud.project.macaovehicle.web.login;

import org.springframework.stereotype.Component;

import com.qcloud.component.admin.LoginVerification;

@Component
public class LoginVerificationImpl implements LoginVerification {

	@Override
	public boolean allow(String account, String password) {
		return false;
	}

	@Override
	public String[] getAccountCodes(String account) {
		return new String[] {};
	}

	@Override
	public String getIdentificationKey(String account) {		
		return null;		
	}
}
