package com.qcloud.component.publicservice.util;

public class RedisKeyUtils {

    // key定义前缀规则：String->s;Hash-->m;List-->l;Set-->s;SortedSet-->x;
    /**
     * token key
     * 
     * @param tokenId
     * @return
     */
    public static String getVerificationCodeKey(String code) {

        return "s:vc:" + code;
    }

    /**
     * token key
     * 
     * @param tokenId
     * @return
     */
    public static String getSmsMessageLimitTimeKey(String mobile) {

        return "s:st:" + mobile;
    }

    /**
     * token key
     * 
     * @param tokenId
     * @return
     */
    public static String getSmsMessageLimitNumberKey(String mobile) {

        return "s:vn:" + mobile;
    }

    /**
     * token key
     * 
     * @param tokenId
     * @return
     */
    public static String getMessageNewNumberKey(String code, long receiver) {

        return "s:mn:" + code + "_" + receiver;
    }

    public static String getWeixinAccessTokenKey(String appid) {

        return "s:accessToken:" + appid;
    }

    public static String getWeixinJsapiTicketKey(String appid) {

        return "s:jsapiTicke:" + appid;
    }
}
