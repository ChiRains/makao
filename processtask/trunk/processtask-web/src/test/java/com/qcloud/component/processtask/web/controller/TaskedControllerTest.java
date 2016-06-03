package com.qcloud.component.processtask.web.controller;

import java.util.HashMap;
import java.util.Map;
import com.qcloud.component.test.HttpTest;

public class TaskedControllerTest {

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<String, String>();
        map.put("process", "");
        System.out.println(HttpTest.testAppLoginUrl("/app/tasked/listMyApplyedApproving.do?pageNum=1&pageSize=2", map));
        System.out.println(HttpTest.testAppLoginUrl("/app/tasked/listMyApplyedApproved.do?pageNum=1&pageSize=2", map));
        System.out.println(HttpTest.testAppLoginUrl("/app/tasked/listMyApproved.do?pageNum=1&pageSize=2", map));
    }
}
