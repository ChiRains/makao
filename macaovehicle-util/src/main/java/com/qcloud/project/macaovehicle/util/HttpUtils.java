package com.qcloud.project.macaovehicle.util;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.AuthSchemes;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import com.qcloud.component.filesdk.QFile;

public class HttpUtils {

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
            qFile.setName(fileName);
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

    public static boolean httpDownload(String httpUrl, String saveFile) {

        // 下载网络文件
        int bytesum = 0;
        int byteread = 0;
        URL url = null;
        try {
            url = new URL(httpUrl);
        } catch (MalformedURLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
            return false;
        }
        URLConnection conn = null;
        InputStream inStream = null;
        FileOutputStream fs = null;
        try {
            conn = url.openConnection();
            inStream = conn.getInputStream();
            fs = new FileOutputStream(saveFile);
            byte[] buffer = new byte[1204];
            while ((byteread = inStream.read(buffer)) != -1) {
                bytesum += byteread;
                fs.write(buffer, 0, byteread);
            }
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (fs != null) {
                    fs.close();
                }
                if (inStream != null) {
                    inStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * form-data形式
     * @param postUrl
     * @param param
     * @return
     */
    public static String formDataPost(String postUrl, Map<String, Object> param) {

        StringBuffer buffer = new StringBuffer();
        RequestConfig defaultRequestConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).setExpectContinueEnabled(true).setTargetPreferredAuthSchemes(Arrays.asList(AuthSchemes.NTLM, AuthSchemes.DIGEST)).setProxyPreferredAuthSchemes(Arrays.asList(AuthSchemes.BASIC)).build();
        CloseableHttpClient httpclient = HttpClients.custom().setDefaultRequestConfig(defaultRequestConfig).build();
        RequestConfig requestConfig = RequestConfig.copy(defaultRequestConfig).setSocketTimeout(100000)// 毫秒
                .setConnectTimeout(100000)// 毫秒
                .setConnectionRequestTimeout(100000)// 毫秒
                .build();
        try {
            HttpPost httpPost = new HttpPost(postUrl);
            // HttpPost httpPost = new HttpPost("http://61.143.38.105:18888/MacaoCarClearance/Receive");// 电子口岸数据交换平台接收数据地址
            httpPost.setConfig(requestConfig);
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            for (Entry<String, Object> entry : param.entrySet()) {
                ContentBody contentBody = null;
                if (entry.getValue() instanceof byte[]) {
                    contentBody = new ByteArrayBody((byte[]) entry.getValue(), ContentType.TEXT_PLAIN, entry.getKey() + ".jpg");
                } else if (entry.getValue() instanceof Integer) {
                    contentBody = new StringBody((String) entry.getValue(), ContentType.TEXT_PLAIN);
                } else if (entry.getValue() instanceof Long) {
                    contentBody = new StringBody(String.valueOf((Long) entry.getValue()), ContentType.TEXT_PLAIN);
                } else if (entry.getValue() instanceof Double) {
                    contentBody = new StringBody(String.valueOf((Double) entry.getValue()), ContentType.TEXT_PLAIN);
                }
                builder.addPart(entry.getKey(), contentBody);
            }
            httpPost.setEntity(builder.build());
            System.out.println("executing request " + httpPost.getRequestLine());
            long startTimeMillis = System.currentTimeMillis();
            System.out.println("请求开始时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(startTimeMillis));
            CloseableHttpResponse response = httpclient.execute(httpPost);
            long endTimeMillis = System.currentTimeMillis();
            try {
                System.out.println("----------------------------------------");
                System.out.println(response.getStatusLine());
                HttpEntity resEntity = response.getEntity();
                InputStream is = response.getEntity().getContent();
                BufferedReader in = new BufferedReader(new InputStreamReader(is));
                String line = "";
                while ((line = in.readLine()) != null) {
                    buffer.append(line);
                }
                System.out.println("发送消息收到的返回：" + buffer.toString());
                EntityUtils.consume(resEntity);
                System.out.println("请求结束时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(endTimeMillis));
                System.out.println("请求共耗时间：" + (endTimeMillis - startTimeMillis) + "毫秒");
            } finally {
                response.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return buffer.toString();
    }
}
