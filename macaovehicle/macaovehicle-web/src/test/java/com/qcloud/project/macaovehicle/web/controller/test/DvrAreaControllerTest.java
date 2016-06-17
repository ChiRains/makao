package com.qcloud.project.macaovehicle.web.controller.test;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.qcloud.pirates.util.HttpUtils;
import com.qcloud.project.macaovehicle.util.SignUtils;

public class DvrAreaControllerTest {
	public static void main(String[] args) {
//		addTest();
		bigForest();
	}
	
	public static void addTest(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("name","Transkei");
		map.put("status","1");
		System.out.println(HttpUtils.doPost("http://127.0.0.1/dvrArea/add.do?format=true", map));
	}
	
	public static void bigForest() {
		String time = String.valueOf(new Date().getTime());
        Map<String, String> param = new LinkedHashMap<String, String>();
        param.put("pushDataBatch", "189");
        for(int i = 0; i < 250; i++) {
            param.put("insiderCardNos["+ i +"]", "100100543423");
        }
        param.put("timestamp", time);
        param.put("sign", SignUtils.sign("d9f9daf88d2992e67d9f2e102486f65a", time));
        System.out.println(HttpUtils.doPost("http://127.0.0.1:8080/cmxInsiderIf/list", param));
	}
}
