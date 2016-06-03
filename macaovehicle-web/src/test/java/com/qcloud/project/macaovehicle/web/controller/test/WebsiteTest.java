package com.qcloud.project.macaovehicle.web.controller.test;

import java.util.HashMap;
import java.util.Map;
import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.util.HttpUtils;
import com.qcloud.project.macaovehicle.util.SignUtils;

public class WebsiteTest {

    /**
     * @param args
     */
    public static void main(String[] args) {

        test();
    }

    public static void test() {

        Map<String, String> map = new HashMap<String, String>();
        map.put("txtuname", "1881232");
        map.put("txtuserpassword", "999999");
        map.put("sign", SignUtils.sign("test", "1881232", "999999"));
        System.out.println(HttpUtils.doPost("http://www.hengqin.gov.cn/webapp/zhihui/registerCar.jsp", map));
    }
}
