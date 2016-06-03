package com.qcloud.project.macaovehicle.web.controller.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.AuthSchemes;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class FormDataTest2 {

    public static void main(String[] args) throws Exception {

        RequestConfig defaultRequestConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).setExpectContinueEnabled(true).setTargetPreferredAuthSchemes(Arrays.asList(AuthSchemes.NTLM, AuthSchemes.DIGEST)).setProxyPreferredAuthSchemes(Arrays.asList(AuthSchemes.BASIC)).build();
        CloseableHttpClient httpclient = HttpClients.custom().setDefaultRequestConfig(defaultRequestConfig).build();
        RequestConfig requestConfig = RequestConfig.copy(defaultRequestConfig).setSocketTimeout(100000)// 毫秒
                .setConnectTimeout(100000)// 毫秒
                .setConnectionRequestTimeout(100000)// 毫秒
                .build();
        try {
            HttpPost httpPost = new HttpPost("http://61.143.38.105:18888/MacaoCarClearance/Receive");// 电子口岸数据交换平台接收数据地址
            httpPost.setConfig(requestConfig);
            FileBody driverPhoto = new FileBody(new File("H://images/111.jpeg"));
            StringBody driverIc = new StringBody("TDriver000018950", ContentType.TEXT_PLAIN);
            StringBody driverName = new StringBody("张三", ContentType.TEXT_PLAIN);
            StringBody sex = new StringBody("1", ContentType.TEXT_PLAIN);
            StringBody birthday = new StringBody("1989-11-12 00:00:00", ContentType.TEXT_PLAIN);
            StringBody nationality = new StringBody("中国", ContentType.TEXT_PLAIN);
            StringBody corpName = new StringBody("盛视科技", ContentType.TEXT_PLAIN);
            StringBody registerNo = new StringBody("N023123421", ContentType.TEXT_PLAIN);
            StringBody drivingValidityDate = new StringBody("2012-11-12 00:00:00", ContentType.TEXT_PLAIN);
            StringBody commonFlag = new StringBody("1", ContentType.TEXT_PLAIN);
            StringBody residentcardValidityDate = new StringBody("1989-11-12 00:00:00", ContentType.TEXT_PLAIN);
            StringBody leftHandFingerprint = new StringBody("1", ContentType.TEXT_PLAIN);
            StringBody rightHandFingerprint = new StringBody("1", ContentType.TEXT_PLAIN);
            StringBody imageEignvalues = new StringBody("1", ContentType.TEXT_PLAIN);
            StringBody certificateNo = new StringBody("1", ContentType.TEXT_PLAIN);
            StringBody validityEndDate = new StringBody("2016-10-11 00:00:00", ContentType.TEXT_PLAIN);
            StringBody creator = new StringBody("Mark.Li", ContentType.TEXT_PLAIN);
            StringBody createDate = new StringBody("2016-10-11 00:00:00", ContentType.TEXT_PLAIN);
            StringBody transactType = new StringBody("01", ContentType.TEXT_PLAIN);
            HttpEntity reqEntity = MultipartEntityBuilder.create().addPart("driverIc", driverIc).addPart("driverName", driverName).addPart("sex", sex).addPart("birthday", birthday).addPart("nationality", nationality).addPart("corpName", corpName).addPart("registerNo", registerNo).addPart("drivingValidityDate", drivingValidityDate).addPart("commonFlag", commonFlag).addPart("residentcardValidityDate", residentcardValidityDate).addPart("leftHandFingerprint", leftHandFingerprint).addPart("rightHandFingerprint", rightHandFingerprint).addPart("imageEignvalues", imageEignvalues).addPart("certificateNo", certificateNo).addPart("validityEndDate", validityEndDate).addPart("creator", creator).addPart("createDate", createDate).addPart("transactType", transactType).addPart("driverPhoto", driverPhoto)
                    .build();
            
            System.out.println(EntityUtils.getContentCharSet(reqEntity));
            httpPost.setEntity(reqEntity);
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
                StringBuffer buffer = new StringBuffer();
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
            httpclient.close();
        }
    }
}
