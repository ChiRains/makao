package com.qcloud.component.publicservice.dao;

import com.qcloud.component.publicservice.model.VerificationCode;

public interface VerificationCodeDao {

    boolean add(VerificationCode verificationCode);

    boolean exist(String target, String code);

    VerificationCode get(String target, String code);

    boolean remove(String target, String code);
}
