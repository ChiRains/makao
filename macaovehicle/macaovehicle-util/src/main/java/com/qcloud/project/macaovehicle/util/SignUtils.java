package com.qcloud.project.macaovehicle.util;

import java.security.MessageDigest;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class SignUtils {

    public static boolean checkSign(String key, String sign, String... params) {

        String checkSign = sign(key, params);
        return checkSign.equals(sign);
    }

    public static String sign(String key, String... params) {

        if (params == null || params.length == 0) {
            return md5("/" + key);
        }
        StringBuffer sb = new StringBuffer();
        for (String str : params) {
            sb.append("/").append(str);
        }
        sb.append("/").append(key);
        return md5(sb.toString());
    }

    public static String sign(String key, Map<String, Object> params) {

        if (params == null || params.size() == 0) {
            return md5("/" + key);
        }
        StringBuffer sb = new StringBuffer();
        Iterator<Entry<String, Object>> it = params.entrySet().iterator();
        while (it.hasNext()) {
            Entry<String, Object> entry = it.next();
            String value = "";
            if (entry.getValue() != null) {
                value = entry.getValue().toString();
            }
            sb.append("/").append(value);
        }
        sb.append("/").append(key);
        return md5(sb.toString());
    }

    public static void main(String[] a) {

        System.out.println(sign("test", "111", "222"));
        System.out.println(checkSign("test", "a647336fc896a6d61af8c7d689d8f7a3", "111", "222"));
    }

    public static String md5(String str) {

        String md5 = encode(str, "MD5").toLowerCase();
        return md5;
    }

    private static String encode(String str, String type) {

        try {
            MessageDigest alga = MessageDigest.getInstance(type);
            alga.update(str.getBytes());
            byte digesta[] = alga.digest();
            String hex = byte2hex(digesta);
            return hex;
        } catch (Exception e) {
        }
        return "";
    }

    private static String byte2hex(byte b[]) {

        StringBuilder sb = new StringBuilder();
        for (int n = 0; n < b.length; n++) {
            String stmp = Integer.toHexString(b[n] & 255);
            if (stmp.length() == 1) sb.append("0");
            sb.append(stmp);
        }
        return sb.toString().toUpperCase();
    }
}
