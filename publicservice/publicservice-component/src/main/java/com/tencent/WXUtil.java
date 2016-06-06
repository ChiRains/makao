package com.tencent;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.commons.lang.CharUtils;
import com.qcloud.component.filesdk.QFile;
import com.qcloud.pirates.core.json.Json;
import com.tencent.common.Configure;
import com.tencent.entity.WXUserEntity;

/**
 * 微信通用类
 */
public class WXUtil {

    /**
     * 获取用户的AcessToken, 此微信接口有次数上线
     * @param appid
     * @param appsecret
     * @return
     */
    public static String getAccessToken(String appid, String appsecret) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("grant_type", "client_credential");
        param.put("appid", appid);
        param.put("secret", appsecret);
        String url = mapToUrl(Configure.ACCESS_TOKEN_API, param);
        Map<String, Object> map = Json.toMap(getHttpMessage(url));
        return (String) map.get("access_token");
    }

    /**
     * 获取用户的openId
     * @param appid
     * @param appsecret
     * @return
     */
    public static String getOpenId(String appid, String appsecret, String code) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("appid", appid);
        param.put("secret", appsecret);
        param.put("code", code);
        param.put("grant_type", "authorization_code");
        String url = mapToUrl(Configure.OPENID_API, param);
        Map<String, Object> map = Json.toMap(getHttpMessage(url));
        return (String) map.get("openid");
    }

    /**
     * 获取jsapi_ticket
     * @param accessToken
     * @return
     */
    public static String getJsapiTicket(String accessToken) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("access_token", accessToken);
        param.put("type", "jsapi");
        String url = mapToUrl(Configure.TICKET_API, param);
        Map<String, Object> map = Json.toMap(getHttpMessage(url));
        return (String) map.get("ticket");
    }

    /**
     * 获取微信图片
     * @param media_id      媒体文件ID
     * @return
     */
    public static QFile getImageFile(String media_id, String accessToken) {

        System.out.println("media_id:" + media_id);
        System.out.println("accessToken:" + accessToken);
        java.net.URLConnection connection = null;
        java.net.URL reqUrl = null;
        InputStream in = null;
        Map<String, Object> param = new LinkedHashMap<String, Object>();
        param.put("access_token", accessToken);
        param.put("media_id", media_id);
        QFile qFile = new QFile();
        try {
            String url = mapToUrl(Configure.MEDIA_API, param);
            System.out.println("url:" + url);
            reqUrl = new java.net.URL(url);
            connection = reqUrl.openConnection();
            connection.setDoOutput(true);
            in = connection.getInputStream();
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];
            int n = 0;
            while (-1 != (n = in.read(buffer))) {
                output.write(buffer, 0, n);
            }
            qFile.setName(media_id + ".jpg");
            qFile.setContent(output.toByteArray());
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return qFile;
    }

    public static WXUserEntity getUserInfo(String accessToken, String openid) {

        System.out.println("getUserInfo:openid" + openid);
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("access_token", accessToken);
        param.put("openid", openid);
        param.put("lang", "zh_CN");
        String url = mapToUrl(Configure.USERINFO_API, param);
        Map<String, Object> map = Json.toMap(getHttpMessage(url));
        WXUserEntity userEntity = new WXUserEntity();
        userEntity.setSubscribe(map.get("subscribe") != null ? (Integer) map.get("subscribe") : 1);
        userEntity.setOpenid(map.get("openid") != null ? (String) map.get("openid") : "");
        if (userEntity.getSubscribe() > 0) {
            userEntity.setNickname((String) map.get("nickname"));
            userEntity.setSex(map.get("sex") != null ? (Integer) map.get("sex") : 3);
            userEntity.setCity((String) map.get("city"));
            userEntity.setCountry((String) map.get("country"));
            userEntity.setProvince((String) map.get("province"));
            userEntity.setLanguage((String) map.get("language"));
            userEntity.setHeadimgurl((String) map.get("headimgurl"));
            userEntity.setSubscribe_time(map.get("subscribe_time") != null ? (Long.valueOf(map.get("subscribe_time").toString())) : 0);
        }
        return userEntity;
    }

    /**
     * 获取sha1签名， 对所有待签名参数按照字段名的ASCII 码从小到大排序（字典序）后，使用URL键值对的格式（即key1=value1&key2=value2…）拼接成字符串string1。
     * @param map
     * @return
     */
    public static String getJSSDKSign(Map<String, Object> param) {

        StringBuilder sb = new StringBuilder();
        Iterator<Entry<String, Object>> it = param.entrySet().iterator();
        while (it.hasNext()) {
            Entry<String, Object> entry = it.next();
            String paramStr = entry.getKey() + "=" + entry.getValue();
            sb.append(paramStr).append("&");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
        return sha1(sb.toString()).toLowerCase();
    }

    /**
     * 获取sha1签名， 对所有待签名参数按照字段名的ASCII 码从小到大排序（字典序）后，使用URL键值对的格式（即key1=value1&key2=value2…）拼接成字符串string1。
     * @param map
     * @return
     */
    public static String getJSSDKSign(String jsapi_ticket, String noncestr, long timestamp, String url) {

        String[] paramArr = new String[] { "jsapi_ticket=" + jsapi_ticket, "timestamp=" + timestamp, "noncestr=" + noncestr, "url=" + url};
        Arrays.sort(paramArr);
        // 将排序后的结果拼接成一个字符串
        String content = paramArr[0].concat("&" + paramArr[1]).concat("&" + paramArr[2]).concat("&" + paramArr[3]);
        System.out.println(content);
        return sha1(content);
    }

    /**
     * sha1算法签名
     * @param str
     * @return
     */
    public static String sha1(String str) {

        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-1");
            md.update(str.getBytes("UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        byte[] result = md.digest();
        StringBuffer sb = new StringBuffer();
        for (byte b : result) {
            int i = b & 0xff;
            if (i < 0xf) {
                sb.append(0);
            }
            sb.append(Integer.toHexString(i));
        }
        return sb.toString();
    }

    /**
     * http协议获取页面返回值
     * @param url
     * @return
     */
    public static String getHttpMessage(String url) {

        StringBuffer responseMessage = null;
        java.net.URLConnection connection = null;
        java.net.URL reqUrl = null;
        OutputStreamWriter reqOut = null;
        InputStream in = null;
        BufferedReader br = null;
        try {
            responseMessage = new StringBuffer();
            reqUrl = new java.net.URL(url);
            connection = reqUrl.openConnection();
            connection.setDoOutput(true);
            reqOut = new OutputStreamWriter(connection.getOutputStream());
            reqOut.flush();
            int charCount = -1;
            in = connection.getInputStream();
            br = new BufferedReader(new InputStreamReader(in, "utf-8"));
            while ((charCount = br.read()) != -1) {
                responseMessage.append((char) charCount);
            }
            System.out.println(responseMessage);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                in.close();
                reqOut.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return responseMessage.toString();
    }

    public static String mapToUrl(String apiUrl, Map<String, Object> param) {

        StringBuilder sb = new StringBuilder();
        Iterator<Entry<String, Object>> it = param.entrySet().iterator();
        while (it.hasNext()) {
            Entry<String, Object> entry = it.next();
            String paramStr = entry.getKey() + "=" + entry.getValue();
            sb.append(paramStr).append("&");
        }
        sb.deleteCharAt(sb.length() - 1);
        String url = apiUrl + "?" + sb.toString();
        return url;
    }

    public static QFile getHttpQFile(String fileName, String url) {

        java.net.URLConnection connection = null;
        java.net.URL reqUrl = null;
        InputStream in = null;
        QFile qFile = new QFile();
        try {
            reqUrl = new java.net.URL(url);
            System.out.println("reqUrl:" + reqUrl);
            connection = reqUrl.openConnection();
            connection.setDoOutput(true);
            in = connection.getInputStream();
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];
            int n = 0;
            while (-1 != (n = in.read(buffer))) {
                output.write(buffer, 0, n);
            }
            qFile.setName(fileName + ".jpg");
            qFile.setContent(output.toByteArray());
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return qFile;
    }

    /**
     * 四字节字符串替换空串
     * @param str
     * @return
     */
    public static String transEncoding4Code(String str) {

        byte[] t1 = null;
        try {
            t1 = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < t1.length;) {
            byte tt = t1[i];
            if (CharUtils.isAscii((char) tt)) {
                byte[] ba = new byte[1];
                ba[0] = tt;
                i++;
            }
            if ((tt & 0xF0) == 0xE0) {
                byte[] ba = new byte[3];
                ba[0] = tt;
                ba[1] = t1[i + 1];
                ba[2] = t1[i + 2];
                i++;
                i++;
                i++;
                String result = new String(ba);
                System.out.println("3个字节的字符");
                System.out.println("字符为：" + result);
            }
            if ((tt & 0xF8) == 0xF0) {
                byte[] ba = new byte[4];
                ba[0] = tt;
                ba[1] = t1[i + 1];
                ba[2] = t1[i + 2];
                ba[3] = t1[i + 3];
                i++;
                i++;
                i++;
                i++;
                String result = new String(ba);
                System.out.println("4个字节的字符");
                System.out.println("字符为：" + result);
                str = str.replace(result, "");
            }
        }
        return str;
    }
}
