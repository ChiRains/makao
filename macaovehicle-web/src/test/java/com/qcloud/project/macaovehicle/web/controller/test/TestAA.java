package com.qcloud.project.macaovehicle.web.controller.test;

import org.springframework.web.client.RestTemplate;
import com.qcloud.pirates.core.json.Json;

public class TestAA {

    /**
     * @param args
     */
    public static void main(String[] args) {

        // System.out.println(HttpUtils.doPost("http://10.10.11.143:8081/card/sendCarCard/TGSQ20151218051601/8051601/75b9bb5a29b78ff61fcf965de2119b49", new HashMap<String, String>()));
        RestTemplate template = new RestTemplate();
        ControllerJsonMessageForDhqWSResult str = template.postForObject("http://10.10.11.143:8081/card/sendCarCard/TGSQ20151218051601/8051601/75b9bb5a29b78ff61fcf965de2119b49", null, ControllerJsonMessageForDhqWSResult.class);
        System.out.println(str);
//        ControllerJsonMessageForDhqWSResult controllerJsonMessageForDhqWSResult = Json.toObject(str, ControllerJsonMessageForDhqWSResult.class, true);
//        System.out.println(controllerJsonMessageForDhqWSResult);
    }
}
