package com.qcloud.project.macaovehicle.web.controller.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;

public class FormDataTest {

    @SuppressWarnings("deprecation")
    public static void main(String args[]) throws Exception {

        MultipartEntity multipartEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE, "----------ThIs_Is_tHe_bouNdaRY_$", Charset.defaultCharset());
        // 字符串类型
        multipartEntity.addPart("driverIc", new StringBody("TDriver000018950", Charset.forName("UTF-8")));
        multipartEntity.addPart("driverName", new StringBody("张三", Charset.forName("UTF-8")));
        multipartEntity.addPart("sex", new StringBody("1", Charset.forName("UTF-8")));
        multipartEntity.addPart("birthday", new StringBody("1989-11-12 00:00:00", Charset.forName("UTF-8")));
        multipartEntity.addPart("nationality", new StringBody("中国", Charset.forName("UTF-8")));
        multipartEntity.addPart("corpName", new StringBody("盛视科技", Charset.forName("UTF-8")));
        multipartEntity.addPart("registerNo", new StringBody("N023123421", Charset.forName("UTF-8")));
        multipartEntity.addPart("drivingValidityDate", new StringBody("2012-11-12 00:00:00", Charset.forName("UTF-8")));
        multipartEntity.addPart("commonFlag", new StringBody("1", Charset.forName("UTF-8")));
        multipartEntity.addPart("residentcardValidityDate", new StringBody("1989-11-12 00:00:00", Charset.forName("UTF-8")));
        multipartEntity.addPart("leftHandFingerprint", new StringBody("1", Charset.forName("UTF-8")));
        multipartEntity.addPart("rightHandFingerprint", new StringBody("1", Charset.forName("UTF-8")));
        multipartEntity.addPart("imageEignvalues", new StringBody("1", Charset.forName("UTF-8")));
        multipartEntity.addPart("certificateNo", new StringBody("1", Charset.forName("UTF-8")));
        multipartEntity.addPart("validityEndDate", new StringBody("2016-10-11 00:00:00", Charset.forName("UTF-8")));
        multipartEntity.addPart("creator", new StringBody("Mark.Li", Charset.forName("UTF-8")));
        multipartEntity.addPart("createDate", new StringBody("2016-10-11 00:00:00", Charset.forName("UTF-8")));
        multipartEntity.addPart("transactType", new StringBody("01", Charset.forName("UTF-8")));
        // 文件类型
        File file = new File("H://images/111.jpeg");
        FileBody fileBody = new FileBody(file, "image/jpeg");
        multipartEntity.addPart("driverPhoto", fileBody);
        HttpPost request = new HttpPost("http://61.143.38.105:18888/MacaoCarClearance/Receive");// 电子口岸数据交换平台接收数据地址
        request.setEntity(multipartEntity);
        request.addHeader("Content-Type", "multipart/form-data; boundary=----------ThIs_Is_tHe_bouNdaRY_$");
        /*
         * Part[] parts = method.setRequestEntity(new MultipartRequestEntity(parts, method.get
         */
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpResponse response = httpClient.execute(request);
        InputStream is = response.getEntity().getContent();
        BufferedReader in = new BufferedReader(new InputStreamReader(is));
        StringBuffer buffer = new StringBuffer();
        String line = "";
        while ((line = in.readLine()) != null) {
            buffer.append(line);
        }
        System.out.println("发送消息收到的返回：" + buffer.toString());
    }
}