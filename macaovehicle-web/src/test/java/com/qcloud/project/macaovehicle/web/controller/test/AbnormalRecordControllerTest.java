package com.qcloud.project.macaovehicle.web.controller.test;

import com.qcloud.component.test.HttpTest;

public class AbnormalRecordControllerTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
//        abnormal_add();
        record_add();
    }

    public static void abnormal_add() {

        System.out.println(HttpTest.testAppWhiteUrl("/abnormalRecord/add/1001/第一检测/2015-12-0414:10:22/1001/1002/abc/abc/1/RG5F45SD1FE21SFDQWE4SDF0SDF/1"));
    }

   
    
    public static void record_add() {

        System.out.println(HttpTest.testAppWhiteUrl("/record/add/1001/1002/2015-12-04%2017:20:22/关口1/1"));
    }

}
