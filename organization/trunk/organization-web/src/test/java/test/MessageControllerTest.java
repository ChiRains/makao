package test;

import java.util.HashMap;
import java.util.Map;
import com.qcloud.pirates.util.AppParamEncryptUtil;
import com.qcloud.pirates.util.HttpUtils;

public class MessageControllerTest {

    /**
     * @param args
     */
    public static void main(String[] args) {

//        testSend();
//         testList();
//         testGet();
//         testRead();
//         testDelete();
         testCountAll();
         testCountUnread();
    }

    public static void testSend() {

        for (int i = 0; i < 100; i++) {
            Map<String, String> map = new HashMap<String, String>();
            String str = AppParamEncryptUtil.encryptCharStr();
            String sign = AppParamEncryptUtil.signParamStr(str, "jjwl");
            map.put("clerkId", "1010007000003201");
            map.put("title", "这是一条测试的消息");
            map.put("content", "XX测试消息测试消息测试消息测试消息测试消息测试消息测试消息测试消息测试消息测试消息测试消息测试消息测试消息测试消息测试消息测试消息测试消息测试消息测试消息测试消息测试消息测试消息测试消息测试消息测试消息测试消息测试消息测试消息测试消息测试消息测试消息测试消息");
            System.out.println(HttpUtils.doPost("http://127.0.0.1/admin/clerkMessage/send.do?format=true", map));
        }
    }

    public static void testList() {

        Map<String, String> map = new HashMap<String, String>();
        String str = AppParamEncryptUtil.encryptCharStr();
        String sign = AppParamEncryptUtil.signParamStr(str, "jjwl");
        map.put("qc_app_str", str);
        map.put("qc_app_sign", sign);
        map.put("qc_app_token", "2_603A99F68EED425E960149229691E0F8");
        map.put("pageNum", "2");
        map.put("pageSize", "3");
        System.out.println(HttpUtils.doPost("http://127.0.0.1/app/clerkMessage/list.do?format=true", map));
    }

    public static void testCountAll() {

        Map<String, String> map = new HashMap<String, String>();
        String str = AppParamEncryptUtil.encryptCharStr();
        String sign = AppParamEncryptUtil.signParamStr(str, "jjwl");
        map.put("qc_app_str", str);
        map.put("qc_app_sign", sign);
        map.put("qc_app_token", "2_603A99F68EED425E960149229691E0F8");
        System.out.println(HttpUtils.doPost("http://127.0.0.1/app/clerkMessage/countAll.do?format=true", map));
    }

    public static void testCountUnread() {

        Map<String, String> map = new HashMap<String, String>();
        String str = AppParamEncryptUtil.encryptCharStr();
        String sign = AppParamEncryptUtil.signParamStr(str, "jjwl");
        map.put("qc_app_str", str);
        map.put("qc_app_sign", sign);
        map.put("qc_app_token", "2_603A99F68EED425E960149229691E0F8");
        System.out.println(HttpUtils.doPost("http://127.0.0.1/app/clerkMessage/countUnread.do?format=true", map));
    }

    public static void testGet() {

        Map<String, String> map = new HashMap<String, String>();
        String str = AppParamEncryptUtil.encryptCharStr();
        String sign = AppParamEncryptUtil.signParamStr(str, "jjwl");
        map.put("qc_app_str", str);
        map.put("qc_app_sign", sign);
        map.put("qc_app_token", "2_603A99F68EED425E960149229691E0F8");
        map.put("id", "1010007000001050");
        System.out.println(HttpUtils.doPost("http://127.0.0.1/app/clerkMessage/get.do?format=true", map));
    }

    public static void testRead() {

        Map<String, String> map = new HashMap<String, String>();
        String str = AppParamEncryptUtil.encryptCharStr();
        String sign = AppParamEncryptUtil.signParamStr(str, "jjwl");
        map.put("qc_app_str", str);
        map.put("qc_app_sign", sign);
        map.put("qc_app_token", "2_603A99F68EED425E960149229691E0F8");
        map.put("id", "1010007000001050");
        System.out.println(HttpUtils.doPost("http://127.0.0.1/app/clerkMessage/read.do?format=true", map));
    }

    public static void testDelete() {

        Map<String, String> map = new HashMap<String, String>();
        String str = AppParamEncryptUtil.encryptCharStr();
        String sign = AppParamEncryptUtil.signParamStr(str, "jjwl");
        map.put("qc_app_str", str);
        map.put("qc_app_sign", sign);
        map.put("qc_app_token", "2_603A99F68EED425E960149229691E0F8");
        map.put("id", "1010007000001050");
        System.out.println(HttpUtils.doPost("http://127.0.0.1/app/clerkMessage/delete.do?format=true", map));
    }
}
