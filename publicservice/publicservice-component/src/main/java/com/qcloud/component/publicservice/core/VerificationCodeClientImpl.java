package com.qcloud.component.publicservice.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.publicservice.VerificationCodeClient;
import com.qcloud.component.publicservice.service.VerificationCodeService;

@Component
public class VerificationCodeClientImpl implements VerificationCodeClient {

    @Autowired
    private VerificationCodeService verificationCodeService;

    @Override
    public String create(String target, int minutes) {

        return verificationCodeService.create(target, minutes).getCode();
    }

    @Override
    public boolean verification(String target, String code) {

        return verificationCodeService.verification(target, code);
    }

    @Override
    public boolean remove(String target, String code) {

        return verificationCodeService.remove(target, code);
    }
}
