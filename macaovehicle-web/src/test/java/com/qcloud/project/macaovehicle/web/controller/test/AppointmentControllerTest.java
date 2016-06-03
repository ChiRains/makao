package com.qcloud.project.macaovehicle.web.controller.test;

import java.util.HashMap;
import java.util.Map;
import com.qcloud.component.test.HttpTest;
import com.qcloud.pirates.util.HttpUtils;

public class AppointmentControllerTest {

    /**
     * @param args
     */
    public static void main(String[] args) {

        notityCarReservation();
//        notityDriverReservation();
//        notityCarFirstInstallation();
//        notityDriverFirstInstallation();
//        notityCarInstallation();
//        notityDriverInstallation();
    }

    public static void notityCarReservation() {

        Map<String, String> mp = new HashMap<String, String>();
//        mp.put("a", "1111");
//        mp.put("b", "2222");
        System.out.println(HttpUtils.doPost("http://10.0.112.40:8081/appointment/notityCarReservation?appCode=12345&toFixAt=横琴长隆海洋王国一号停车场&toFixDate=20151222080000&sign=52c820d48d498f09758b4b9c62d7374a", mp));
//        System.out.println(HttpTest.testAppWhiteUrl("/appointment/notifyWarning"));
    }

    public static void notityDriverReservation() {

        Map<String, String> mp = new HashMap<String, String>();
        mp.put("a", "1111");
        mp.put("b", "2222");
//        System.out.println(HttpUtils.doPost("http://120.25.12.206:8888/MacaoCarClearance/Receive", mp));
    }

    public static void notityCarFirstInstallation() {

    }

    public static void notityDriverFirstInstallation() {

    }

    public static void notityCarInstallation() {

    }

    public static void notityDriverInstallation() {

    }
}
