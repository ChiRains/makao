package com.qcloud.component.publicservice.util;

import java.sql.Timestamp;

public class RedisValueUtils {

    /**
     * @param accessToken
     * @param t
     * @return
     */
    public static String getWeixinAccessTokenValue(String accessToken, Timestamp t) {

        return accessToken + "#" + t.getTime();
    }

    public static String getWeixinJsapiTicketValue(String jsapiTicket, Timestamp t) {

        return jsapiTicket + "#" + t.getTime();
    }
}
