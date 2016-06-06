package com.qcloud.component.form.web.controller;

import java.util.HashMap;
import java.util.Map;
import com.qcloud.component.test.HttpTest;

public class Org4FormControllerTest {

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<String, String>();
        map.put("userToken", "Ml8yMTAxQTg2QThGQTI0NkY4QTMxQjNBNUUyNEY4MUEwQQ==");
        System.out.println(HttpTest.testAppWhiteUrl("/org4form/getClerk.do?format=true", map));
        System.out.println(HttpTest.testAppWhiteUrl("/org4form/clerkKeyValue.do?format=true", map));
        System.out.println(HttpTest.testAppWhiteUrl("/org4form/listPost.do?format=true", map));
        System.out.println(HttpTest.testAppWhiteUrl("/org4form/listDepartment.do?format=true", map));
    }
}
