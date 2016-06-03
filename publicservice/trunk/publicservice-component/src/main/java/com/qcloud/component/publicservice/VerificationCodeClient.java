package com.qcloud.component.publicservice;

public interface VerificationCodeClient {

    String create(String target, int minutes);

    boolean verification(String target, String code);

    boolean remove(String target, String code);
}
