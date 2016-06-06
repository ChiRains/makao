package com.qcloud.component.test;

import java.util.Map;
import com.qcloud.pirates.util.HttpUtils;

public class HttpTest {

    public static final String testAppWhiteUrl(String url) {

        Map<String, String> mp = TestParameterGenerator.initAppWriteNameParameter();
        return HttpUtils.doPost(TestConfigList.get().getUrl() + url, mp);
    }

    public static final String testAppWhiteUrl(String url, Map<String, String> map) {

        Map<String, String> mp = TestParameterGenerator.initAppWriteNameParameter();
        if (map != null && !map.isEmpty()) {
            mp.putAll(map);
        }
        return HttpUtils.doPost(TestConfigList.get().getUrl() + url, mp);
    }

    public static final String testAppLoginUrl(String url) {

        Map<String, String> mp = TestParameterGenerator.initAppLoginParameter();
        return HttpUtils.doPost(TestConfigList.get().getUrl() + url, mp);
    }

    public static final String testAppLoginUrl(String url, Map<String, String> map) {

        Map<String, String> mp = TestParameterGenerator.initAppLoginParameter();
        if (map != null && !map.isEmpty()) {
            mp.putAll(map);
        }
        return HttpUtils.doPost(TestConfigList.get().getUrl() + url, mp);
    }
}
