package com.qcloud.project.macaovehicle.web.controller.test;

import java.util.HashMap;
import java.util.Map;
import com.qcloud.pirates.util.HttpUtils;
import com.qcloud.project.macaovehicle.util.SignUtils;

public class OnestopControllerTest {

    /**
     * @param args
     */
    public static void main(String[] args) {

        test();
    }

    public static void test() {

        Map<String, String> map = new HashMap<String, String>();
        map.put("dCardid", "11112");
        map.put("vCardid", "22222");
        map.put("date", "20151203220801");
        map.put("gate", "hengqin");
        map.put("sign", SignUtils.sign("test", "11112", "22222", "20151203220801", "hengqin"));
        // System.out.println(HttpUtils.doPost("http://dhq-ot.qi-cloud.net/onestop/enterRecord", map));
//        System.out.println(HttpUtils.doPost("http://127.0.0.1:8081/onestop/enterRecord", map));
        System.out.println(HttpUtils.doPost("http://127.0.0.1:8081/onestop/outRecord", map));
        // System.out.println(HttpUtils.doPost("http://10.0.112.40:8081/onestop/enterRecord?rfid=111&date=20151203220801&gate=001&sign=e5c20a10b33f7df13ee8cbb0124a54c1", map));
        // System.out.println(HttpUtils.doPost("http://10.0.112.40:8081/onestop/outRecord?rfid=111&date=20151203220801&gate=002&sign=e5c20a10b33f7df13ee8cbb0124a54c1", map));
    }
}
