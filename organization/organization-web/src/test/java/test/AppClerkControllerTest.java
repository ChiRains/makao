package test;

import java.util.HashMap;
import java.util.Map;
import com.qcloud.pirates.util.AppParamEncryptUtil;
import com.qcloud.pirates.util.HttpUtils;

public class AppClerkControllerTest {

    /**
     * @param args
     */
    public static void main(String[] args) {

        // testSendMsgForRegister();
        // testRegisterByMobile();
        testLogin();
        // testGet();
    }

    public static void testGet() {

        Map<String, String> map = new HashMap<String, String>();
        String str = AppParamEncryptUtil.encryptCharStr();
        String sign = AppParamEncryptUtil.signParamStr(str, "mv");
        map.put("qc_app_str", str);
        map.put("qc_app_sign", sign);
        map.put("qc_app_token", "2_924140BC0C3749BA81EA129F7BF59637");
        System.out.println(HttpUtils.doPost("http://127.0.0.1/app/user/getUser.do?format=true", map));
        System.out.println(HttpUtils.doPost("http://exy-test.qi-cloud.net/app/user/getUser.do?format=true", map));
    }

    public static void testLogin() {

        Map<String, String> map = new HashMap<String, String>();
        String str = AppParamEncryptUtil.encryptCharStr();
        String sign = AppParamEncryptUtil.signParamStr(str, "jjwl");

//        // 艾斯
//        map.put("username", "13756987458");
//        // 索隆
        map.put("username", "13232282000");
//        // 一万
//        map.put("username", "13759698712");
//        // 妮可
//        map.put("username", "13800138000");
        // 刘汉
//        map.put("username", "13756464646");
//        map.put("username", "137989612181");
//        map.put("username", "13232282159");  
//        map.put("username", "13232282158");  
        
        map.put("pwd", "654321");
        map.put("qc_app_str", str);
        map.put("qc_app_sign", sign);
        System.out.println(HttpUtils.doPost("http://127.0.0.1:8081/app/clerk/login.do?format=true", map));
    }

    public static void testSendMsgForRegister() {

        Map<String, String> map = new HashMap<String, String>();
        map.put("mobile", "13232282158");
        map.put("qc_app_str", "GCIRXEEWCKPU");
        map.put("qc_app_sign", "0d44d7cb4521a0404829c75bac381e9d");
        System.out.println(HttpUtils.doPost("http://127.0.0.1/app/user/sendMsgForRegister.do", map));
    }

    public static void testRegisterByMobile() {

        Map<String, String> map = new HashMap<String, String>();
        map.put("mobile", "13232282158");
        map.put("code", "154279");
        map.put("pwd", "123456");
        map.put("qc_app_str", "GCIRXEEWCKPU");
        map.put("qc_app_sign", "0d44d7cb4521a0404829c75bac381e9d");
        System.out.println(HttpUtils.doPost("http://127.0.0.1/app/user/registerByMobile.do?format=true", map));
    }
}
