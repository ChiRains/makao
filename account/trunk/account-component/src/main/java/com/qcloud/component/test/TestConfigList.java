package com.qcloud.component.test;

import java.util.ArrayList;
import java.util.List;
import com.qcloud.pirates.core.xml.Xml;
import com.qcloud.pirates.core.xml.XmlFactory;
import com.qcloud.pirates.core.xml.XmlItem;
import com.qcloud.pirates.exception.PiratesRuntimeException;
import com.qcloud.pirates.util.StringUtil;

class TestConfigList {

    private static List<TestConfig> list = new ArrayList<TestConfig>();
    //
    static {
        Xml xml = XmlFactory.get("test-project-list");
        if (xml != null) {
            List<XmlItem> list = xml.getItemList();
            for (XmlItem xmlItem : list) {
                String code = xmlItem.getAttrMap().get("code");
                String url = xmlItem.getAttrMap().get("url");
                String appKey = xmlItem.getAttrMap().get("appKey");
                String token = xmlItem.getAttrMap().get("token");
                code = StringUtil.nullToEmpty(code);
                url = StringUtil.nullToEmpty(url);
                appKey = StringUtil.nullToEmpty(appKey);
                token = StringUtil.nullToEmpty(token);
                TestConfig tc = new TestConfig();
                tc.setUrl(url);
                tc.setToken(token);
                tc.setCode(code);
                tc.setAppKey(appKey);
                tc.setNow(false);
                TestConfigList.list.add(tc);
            }
        }
        Xml now = XmlFactory.get("test-project");
        if (now != null && now.getItemList().size() == 1) {
            String code = now.getItemList().get(0).getAttrMap().get("code");
            for (TestConfig tc : list) {
                if (tc.getCode().equals(code)) {
                    tc.setNow(true);
                    break;
                }
            }
        }
    }

    static TestConfig get() {

        for (TestConfig tc : TestConfigList.list) {
            if (tc.isNow()) {
                return tc;
            }
        }
        throw new PiratesRuntimeException("尚未配置当前测试项目");
    }
}
