package com.qcloud.component.form.web.controller;

import java.util.HashMap;
import java.util.Map;
import com.qcloud.pirates.util.HttpUtils;

public class FormControllerTest {

    /**
     * @param args
     */
    public static void main(String[] args) {

        testSave();
        // testSubmit();
        // tesGet();
        // tesGetHist();
    }

    public static void testSave() {

        Map<String, String> map = new HashMap<String, String>();
        map.put("formId", "1010007000002801");
        // map.put("js_name", "路飞");
        // map.put("js_sex", "1");
        // map.put("js_age", "36");
        // map.put("kc.number", "2");
        // map.put("kc.delete", "");
        // map.put("kc[0].kc_name", "英语");
        // map.put("kc[0].time", "12");
        // map.put("kc[1].kc_name", "数学");
        // map.put("kc[1].time", "12");
        map.put("giveDate", "2015-08-20 17:04:58");
        map.put("month", "10");
        map.put("money", "100");
        map.put("desc", "少时诵诗书");
        //
        map.put("departmentPay.number", "2");
        map.put("departmentPay[0].administrativePay", "10");
        map.put("departmentPay[1].administrativePay", "100");
        // map.put("formId", "1010007000004001");
        // map.put("name", "张三");
        // map.put("age", "10");
        // map.put("sex", "1");
        System.out.println(HttpUtils.doPost("http://127.0.0.1:8081/form/save.do", map));
        
        
    }

    public static void testSubmit() {

        Map<String, String> map = new HashMap<String, String>();
        map.put("formInstanceId", "1010007000001201");
        System.out.println(HttpUtils.doPost("http://127.0.0.1/form/submit.do", map));
    }

    public static void tesGet() {

        Map<String, String> map = new HashMap<String, String>();
        map.put("formInstanceId", "1010007000001201");
        System.out.println(HttpUtils.doPost("http://127.0.0.1/form/get.do?format=true", map));
    }

    public static void tesGetHist() {

        Map<String, String> map = new HashMap<String, String>();
        map.put("formHistInstanceId", "1010007000001004");
        System.out.println(HttpUtils.doPost("http://127.0.0.1/form/getHist.do?format=true", map));
    }
}
