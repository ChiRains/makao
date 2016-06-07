package com.qcloud.project.macaovehicle.web.controller.test;

import java.util.HashMap;
import java.util.Map;
import com.qcloud.pirates.util.HttpUtils;

public class MacaoRoleControllerTest {

    public static void main(String[] args) {

        register();
    }

    public static void register() {

        Map<String, String> map = new HashMap<String, String>();
        
        System.out.println(HttpUtils.doPost("http://127.0.0.1:8081/macaoUser/register.do?format=true", map));
    }
}
