package com.qcloud.component.publicservice.service;

import com.qcloud.component.publicservice.model.VerificationCode;

public interface VerificationCodeService {

    VerificationCode create(String target, int minutes);

    boolean verification(String target, String code);

    boolean remove(String target, String code);
}
