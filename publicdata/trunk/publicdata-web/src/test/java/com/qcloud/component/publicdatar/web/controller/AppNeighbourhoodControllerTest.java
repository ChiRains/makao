package com.qcloud.component.publicdatar.web.controller;


import java.util.HashMap;
import java.util.Map;
import com.qcloud.pirates.util.AppParamEncryptUtil;
import com.qcloud.pirates.util.HttpUtils;

public class AppNeighbourhoodControllerTest {

    /**
     * @param args
     */
    public static void main(String[] args) {

//         testSendMsgForRegister();
//         testRegisterByMobile();
       // testLogin();
        testList();
    }

    //获取中心区域
    public static void testList(){
        Map<String, String> map=new HashMap<String, String>();
        map.put("pageNum", "1");
        map.put("pageSize", "10");
        //map.put("qc_app_token", "2_C2894BBB54E84B6CBF01CCE8C60D164C");
        
        map.put("qc_app_str", AppParamEncryptUtil.encryptCharStr());
        map.put("qc_app_sign",AppParamEncryptUtil.signParamStr(map.get("qc_app_str"), "exy") );
        System.out.println(map.get("qc_app_str"));
        System.out.println(map.get("qc_app_sign"));
        System.out.println(HttpUtils.doPost("http://heartsource.qi-cloud.net/app/neighbourhood/centerList.do?format=true", map));
    }
    public static void testLogin() {

        Map<String, String> map = new HashMap<String, String>();
        String str = AppParamEncryptUtil.encryptCharStr();
        String sign = AppParamEncryptUtil.signParamStr(str, "exy");
        map.put("username", "13232282158");
        map.put("pwd", "123456");
        map.put("qc_app_str", str);
        map.put("qc_app_sign", sign);
        System.out.println(HttpUtils.doPost("http://127.0.0.1/app/user/login.do?format=true", map));
//        System.out.println(HttpUtils.doPost("http://heartsource.qi-cloud.net/app/user/login.do?format=true", map));
//        System.out.println(HttpUtils.doPost("http://10.10.11.143/app/user/login.do?format=true", map));
    }
}
