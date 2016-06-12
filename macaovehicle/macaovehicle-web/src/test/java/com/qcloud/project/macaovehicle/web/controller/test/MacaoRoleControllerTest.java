package com.qcloud.project.macaovehicle.web.controller.test;

import java.util.HashMap;
import java.util.Map;
import com.qcloud.pirates.util.HttpUtils;

public class MacaoRoleControllerTest {

    public static void main(String[] args) {

        // do1();
        do2();
    }

    public static void do1() {

        Map<String, String> map = new HashMap<String, String>();
        map.put("roleName", "张思");
        map.put("departmentId", "1010012000010003");
        map.put("desc", "这是一个描述");
        map.put("classifyIds[0]", "1010012000010001");
        map.put("classifyIds[1]", "1010012000010201");
        System.out.println(HttpUtils.doPost("http://127.0.0.1:8081/departmentRole/add.do?format=true", map));
    }

    public static void do2() {

        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "LIANG卫生");
        map.put("laborNumber", "1002");
        map.put("sex", "2");
        map.put("mobile", "13752231344");
        map.put("roleId", "1010012000000402");
        map.put("departmentId", "1010012000010003");
        map.put("pwd1", "123456");
        map.put("pwd2", "123456");
        System.out.println(HttpUtils.doPost("http://127.0.0.1:8081/macClerk/addClerk.do?format=true", map));
    }

    public static void do3() {

        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "LIANG卫生");
        map.put("laborNumber", "1002");
        map.put("sex", "2");
        map.put("mobile", "13752231344");
        map.put("roleId", "1010012000000402");
        map.put("departmentId", "1010012000010003");
        map.put("pwd1", "123456");
        map.put("pwd2", "123456");
        System.out.println(HttpUtils.doPost("http://127.0.0.1:8081/macClerk/addClerk.do?format=true", map));
    }
}
