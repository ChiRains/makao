package com.qcloud.project.macaovehicle.web.controller.test;

import com.qcloud.component.test.HttpTest;

public class CardControllerTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        card_send();
    }

    public static void card_send() {

        System.out.println(HttpTest.testAppWhiteUrl("/card/sendCard/TGSQ20151206005802/CARD1000001/2015-12-04%2014:10:22"));
    }

   

}
