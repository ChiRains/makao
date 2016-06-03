package com.qcloud.project.macaovehicle.web.controller.test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.util.HttpUtils;
import com.qcloud.project.macaovehicle.util.DesUtils;
import com.qcloud.project.macaovehicle.util.SignUtils;

public class EportControllerTest {

    /**
     * @param args
     */
    public static void main(String[] args) {

        // test();
        // test1();
    }

    public static void test() {

        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "张三");
        map.put("name2", "李四");
        map.put("name3", "王五");
        map.put("sign", SignUtils.sign("test", "张三", "李四", "王五"));
        // System.out.println(HttpUtils.doPost("http://dhq-ot.qi-cloud.net/eport/eportTest", map));
        // System.out.println(HttpUtils.doPost("http://127.0.0.1:8081/eport/eportTest", map));
    }

    public static void test1() {

        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "张三");
        map.put("name2", "李四");
        map.put("name3", "王五");
        map.put("sign", SignUtils.sign("test1", "张三2", "李四", "王五"));
        System.out.println(HttpUtils.doPost("http://120.25.12.206:8100/MacaoCarClearance/Receive", map));
    }
}
