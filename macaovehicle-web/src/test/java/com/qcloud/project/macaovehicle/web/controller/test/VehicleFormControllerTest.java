package com.qcloud.project.macaovehicle.web.controller.test;

import java.util.HashMap;
import java.util.Map;
import com.qcloud.component.test.HttpTest;
import com.qcloud.pirates.util.HttpUtils;

public class VehicleFormControllerTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
//for (int index = 0; index < 5; index++) {
    testSave();
//}
        
//         listNextExecutors();
//         testSubmit();
//         tesGet();
        // tesGetHist();
    }

    public static void testSave() {

        Map<String, String> map = new HashMap<String, String>();
        map.put("formId", "1010012000010001");
        map.put("processId", "719b217ecac244458dbdeec4889558dd");
        map.put("saveAndSubmit", "true");
//<<<<<<< .mine
         map.put("formInstanceId", "1010012000024202");
         map.put("processInstId", "91048bee799b4d78b0c14404b3e3d086");
         map.put("workitemId", "738b141ea40641308adf1e5588d71352");
         map.put("taskId", "1010012000024604");
//=======
        
//        map.put("formInstanceId", "1010012000010202");
//        map.put("processInstId", "54c2923ac0e646db8b51a37b4ff65201");
//        map.put("workitemId", "ceae4aada3c644f0a6bd870514b6c828");
//        map.put("taskId", "1010012000010002");
//>>>>>>> .r1357
        //
//<<<<<<< .mine
//        map.put("vehicle", "1010012000012803");
//        map.put("drivers", "1010012000013403");
        //
//        map.put("person.qc_inner_number", "0");
//        map.put("person[0].id", "1010012000010001");
//        map.put("person[0].name", "索隆");
        // map.put("person[1].name", "龙马");
//=======
//        map.put("person.qc_inner_number", "2");
//        map.put("person[0].id", "1010012000010001");
//        map.put("person[0].name", "索隆");
//        map.put("person[1].name", "龙马");
        
//>>>>>>> .r1357
        //
        // map.put("id", "1010007000005801");
        // map.put("userId", "1010007000003201");
        // map.put("qc_oc_clerk", "1010007000003201");
        // map.put("userName", "索隆");
        // map.put("departmantId", "1010007000001001");
        // map.put("qc_od_department", "1010007000001001");
        // map.put("departmentName", "开发部");
        // map.put("postId", "1010007000001001");
        // map.put("qc_op_post", "1010007000000001");
        // map.put("postName", "业务员");
        // map.put("startTime", "2015-08-09 08:00:00");
        // map.put("endTime", "2015-08-09 16:00:00");
        // map.put("reason", "明天我要泡妞。。。");
        // map.put("type", "事假");
        // take care
        // map.put("qc_notion_leave.qc_inner_number", "1");
        // take care
        // map.put("qc_notion_leave[0].id", "1010007000001403");
        // map.put("qc_notion_leave[0].qc_sw_workitem", "cb21ef2cc2f3445db21d8dff6aedae7d");
        // map.put("qc_notion_leave[0].content", "同意");
        // map.put("qc_notion_approve[1].id", "1010007000002002");
        // map.put("qc_notion_approve[1].content", "同意。。");
         
         map.put("notion_reason", "行");
         map.put("notion_result", "1");
//         
//         map.put("type", "1");
//         map.put("carOwnerId", "1010012000010801");         
        System.out.println(HttpTest.testAppLoginUrl("/app/form/save.do", map));
    }

    public static void testSubmit() {

        Map<String, String> map = new HashMap<String, String>();
        // map.put("formInstanceId", "1010007000001201");
        map.put("formId", "1010012000010001");
        map.put("processId", "00d8f2f4621e44f6afd18e336dbf0a95");
        map.put("formInstanceId", "1010012000015803");
        map.put("processInstId", "ffb3ddd93e3e4a3bb36e26cd5dcf6444");
        map.put("workitemId", "0a912f8ad44f40d8964db66826c0d506");
        map.put("taskId", "1010012000015604");
        //
        map.put("qc_cmcpre", "1010012000010001");
        map.put("executorKeys", "qc_cmcpre");
        System.out.println(HttpTest.testAppLoginUrl("/app/form/submit.do?format=true", map));
        
        
    }

    public static void tesGet() {

        Map<String, String> map = new HashMap<String, String>();
        map.put("formInstanceId", "1010012000020401");
//        System.out.println(HttpUtils.doPost("http://127.0.0.1:8081/form/get.do?format=true", map));
        System.out.println(HttpTest.testAppLoginUrl("/app/form/get.do", map));
//        System.out.println(HttpTest.testAppLoginUrl("/app/form/get4Flat.do", map));
    }

    public static void tesGetHist() {

        Map<String, String> map = new HashMap<String, String>();
        map.put("formInstanceHistId", "1010007000004801");
        System.out.println(HttpUtils.doPost("http://127.0.0.1/form/getHist.do?format=true", map));
    }

    public static void listNextExecutors() {

        Map<String, String> map = new HashMap<String, String>();
        map.put("taskId", "1010012000011004");
        System.out.println(HttpTest.testAppLoginUrl("/app/processExecutor/listNextExecutors.do?format=true", map));
    }
}
