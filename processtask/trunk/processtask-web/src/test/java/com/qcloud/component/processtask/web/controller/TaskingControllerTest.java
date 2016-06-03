package com.qcloud.component.processtask.web.controller;

import java.util.HashMap;
import java.util.Map;
import com.qcloud.component.test.HttpTest;

public class TaskingControllerTest {

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<String, String>();
        map.put("department", "");
        System.out.println(HttpTest.testAppLoginUrl("/app/tasking/list.do?pageNum=1&pageSize=2", map));
        System.out.println(HttpTest.testAppLoginUrl("/app/tasking/listMyApplying.do?pageNum=1&pageSize=2", map));
        System.out.println(HttpTest.testAppLoginUrl("/app/tasking/listMyApproving.do?pageNum=1&pageSize=5", map));
    }
}
