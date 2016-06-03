package com.qcloud.component.test;

import java.util.HashMap;
import java.util.Map;
import com.qcloud.pirates.util.AppParamEncryptUtil;

class TestParameterGenerator {

    static final Map<String, String> initAppWriteNameParameter() {

        Map<String, String> map = new HashMap<String, String>();
        String str = AppParamEncryptUtil.encryptCharStr();
        String sign = AppParamEncryptUtil.signParamStr(str, TestConfigList.get().getAppKey());
        map.put("qc_app_str", str);
        map.put("qc_app_sign", sign);
        map.put("format", Boolean.TRUE.toString());
        return map;
    }

    static final Map<String, String> initAppLoginParameter() {

        Map<String, String> map = initAppWriteNameParameter();
        map.put("qc_app_token", TestConfigList.get().getToken());
        return map;
    }
}
