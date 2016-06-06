package com.qcloud.component.publicservice;

import java.util.Map;

public interface SmsClient {

    /**
     * 
     * @param receiver 手机号码
     * @param content 短信内容,不能超过70个字
     * @return
     */
    @Deprecated
    boolean[] send(String content, String... receivers);

    /**
     * 
     * @param code
     * @param receiver
     * @param map
     * @return
     */
    boolean send(String code, String receiver, Map<String, String> map);

}
