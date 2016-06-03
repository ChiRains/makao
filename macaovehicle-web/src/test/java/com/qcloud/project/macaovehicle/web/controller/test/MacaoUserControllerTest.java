package com.qcloud.project.macaovehicle.web.controller.test;

import java.util.HashMap;
import java.util.Map;
import com.qcloud.pirates.util.HttpUtils;

public class MacaoUserControllerTest {

    public static void main(String[] args) {

        register();
//        login();
//        myInfo();
    }

    public static void register() {

        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "ryuma");
        map.put("password", "123456");
        map.put("sex", "1");
        map.put("mobile", "15876309014");
        map.put("idcardNumber", "441823121112111211");
        map.put("address", "广东省珠海市唐家");
        map.put("residence", "广东清远");
        map.put("idcardBack", "");
        map.put("idcardFace", "");
        map.put("type", "1");//务工
        map.put("workers.company", "程序猿星球");
        map.put("workers.fixedLine", "400-400-400");
        map.put("workers.address", "就不告诉你");
        map.put("workers.phone", "12345678911");
        map.put("workers.consignee", "程序猿老大");
        map.put("workers.position", "程序猿鼓励师");
        map.put("workers.workCertificate", "");
//
//        map.put("name", "zoro");
//        map.put("password", "123456");
//        map.put("sex", "1");
//        map.put("mobile", "13232282158");
//        map.put("idcardNumber", "441823121112111213");
//        map.put("address", "广东省珠海市唐家");
//        map.put("residence", "广西");
//        map.put("idcardBack", "");
//        map.put("idcardFace", "");
//        map.put("type", "2");//企业
//        map.put("housers.property", "居住");
//        map.put("housers.application", "居住");
//        map.put("housers.situation", "共有");
//        map.put("housers.code", "250250250");
//        map.put("housers.time", "2015-01-01");
//        map.put("housers.located", "都说了不告诉你了,还问！！！");
//        map.put("housers.structure", "高科技");
//        map.put("housers.floor", "19");
//        map.put("housers.buildArea", "100");
//        map.put("housers.totalArea", "1900");
//        
//        map.put("name", "rebecca");
//        map.put("password", "123456");
//        map.put("sex", "1");
//        map.put("mobile", "13553949858");
//        map.put("idcardNumber", "441823121112111212");
//        map.put("address", "广东省珠海市唐家");
//        map.put("residence", "广东清远");
//        map.put("idcardBack", "");
//        map.put("idcardFace", "");
//        map.put("type", "3");//企业
//        map.put("enterprisers.company", "程序猿星球");
//        map.put("enterprisers.code", "250250250");
//        map.put("enterprisers.operate", "全都经营");
//        map.put("enterprisers.scale", "50-100人");
//        map.put("enterprisers.represent", "程序猿CEO");
//        map.put("enterprisers.phone", "15876309014");
//        map.put("enterprisers.address", "都说了不告诉你了,还问！！！");
//        map.put("enterprisers.time", "2015-01-01");
//        map.put("enterprisers.license", "");
        
        System.out.println(HttpUtils.doPost("http://127.0.0.1:8081/macaoUser/register.do?format=true", map));
    }
    
    
    public static void login() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("username", "15876309014");
        map.put("pwd", "123456");
        System.out.println(HttpUtils.doPost("http://127.0.0.1:8081/clerk/login.do?format=true", map));
    }
    
    public static void myInfo(){
        
        Map<String, String> map = new HashMap<String, String>();
        
        System.out.println(HttpUtils.doPost("http://127.0.0.1:8081/carOwner/myInfo.do?format=true", map));
        
    }
}
