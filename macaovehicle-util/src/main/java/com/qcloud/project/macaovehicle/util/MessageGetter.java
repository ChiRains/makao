package com.qcloud.project.macaovehicle.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.Logger;

public class MessageGetter {

    private static Logger       logger      = Logger.getLogger(MessageGetter.class);

    // private static final String dataPostURL = "http://dhq-ot.qi-cloud.net/eport/eportTest";
    // private static final String dataPostURL = "http://120.25.12.206:8100/MacaoCarClearance/Receive";
    // private static final String dataPostURL = "http://gathert1.nat123.net/mq/save";
    // private static final String dataPostURL = "http://120.25.12.206:8888/DeclMsg/Customs";
    // private static final String dataPostURL = "http://120.25.12.206:8888/DeclMsgRec/Customs";
    private static final String dataPostURL = "http://127.0.0.1:8081/eport/customsXmlReceive.do";

    // private static final String dataPostURL = "http://120.25.12.206:8888/DeclMsg/Ciq";
    // private static final String dataPostURL = "http://120.25.12.206:8888/MacaoCarClearance/Decl";
    // private static final String dataPostURL = "http://shiliew.vicp.net/eport/xmlReceive.do";
    // private static final String dataPostURL = "http://120.25.12.206:8888/DeclMsg/Ciq";
    // private static final String dataPostURL = "http://61.143.38.105:18888/MacaoCarClearance/PostData";
    // private static final String dataPostURL = "http://61.143.38.105:18888/MacaoCarClearance/Receive";
    // private static final String dataPostURL = "http://120.25.12.206:9920/zhship/putdata";
    // private static final String dataPostURL = "http://mygather.nat123.net:22865/vehiclerdriver/save";//车辆司机对应关联保存
    // private static final String dataPostURL = "http://mygather.nat123.net:22865/vehicle/save";//车辆信息保存
    // private static final String dataPostURL = "http://120.25.13.118:28888/MeiShaSystemHTTPTestClient/PutData";//梅沙系统--提交数据
    // private static final String dataPostURL = "http://120.25.13.118:28888/MeiShaSystemHTTPTestClient/CancelData";//梅沙系统--提交数据
    // private static final String dataPostURL = "http://120.25.13.118:8888/zhship/putdata";//118Integrator--梅沙系统--提交数据
    // private static final String dataPostURL = "http://120.25.12.206:9920/zhship/putdata";//206Integrator--梅沙系统--提交数据
    private static HttpClient   client;

    private static HttpPost     post;

    public MessageGetter() {

        super();
        this.client = new DefaultHttpClient();
    }

    public static String sendXml(String xml, String url) {

        StringBuffer buffer = new StringBuffer();
        try {
            client = new DefaultHttpClient();
            post = new HttpPost(url);
            StringEntity stringEntity = new StringEntity(xml, "UTF-8");
            System.out.println(xml);
            stringEntity.setContentType("text/xml");
            post.setEntity(stringEntity);
            HttpResponse response = client.execute(post);// 执行Http Post
            System.out.println(response);
            // System.out.println(response.getStatusLine());
            if (null != response && 200 == response.getStatusLine().getStatusCode()) {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    // start 读取整个页面内容
                    InputStream is = entity.getContent();
                    BufferedReader in = new BufferedReader(new InputStreamReader(is));
                    String line = "";
                    while ((line = in.readLine()) != null) {
                        buffer.append(line);
                    }
                    // end 读取整个页面内容
                    System.out.println("response:" + buffer.toString());
                }
            }
        } catch (Exception e) {
            logger.error(e);
        }
        return buffer.toString();
    }

    public static String sendMessage(Map<String, Object> param, String postUrl, String url) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        stringBuilder.append("<postData>");
        stringBuilder.append("<postUrl>" + postUrl + "</postUrl>");
        stringBuilder.append("<message>true</message>");
        StringBuilder driverStr = new StringBuilder();
        StringBuilder vehicleStr = new StringBuilder();
        StringBuilder vehicleRDriverStr = new StringBuilder();
        StringBuilder dataStr = new StringBuilder();
        for (Entry<String, Object> entry : param.entrySet()) {
            dataStr.append("<").append(entry.getKey()).append(">");
            dataStr.append(entry.getValue());
            dataStr.append("</").append(entry.getKey()).append(">");
        }
        if (postUrl.equals("driver")) {
            driverStr.append(dataStr);
        } else if (postUrl.equals("vehicle")) {
            vehicleStr.append(dataStr);
        } else if (postUrl.equals("vehicleRDriver")) {
            vehicleRDriverStr.append(dataStr);
        }
        stringBuilder.append("<driver>");
        stringBuilder.append(driverStr);
        stringBuilder.append("</driver>");
        stringBuilder.append("<vehicle>");
        stringBuilder.append(vehicleStr);
        stringBuilder.append("</vehicle>");
        stringBuilder.append("<vehicleRDriver>");
        stringBuilder.append(vehicleRDriverStr);
        stringBuilder.append("</vehicleRDriver>");
        stringBuilder.append("</postData>");
        return sendXml(stringBuilder.toString(), url);
    }

    public static void main(String[] args) throws Exception {

        // StringBuilder stringBuilder = new StringBuilder();
        // stringBuilder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><auditData><url>vehicle</url><success>0</success><vehicle><ric>1000001</ric><reason>原因</reason><state>1</state></vehicle></auditData>");
        // System.out.println(stringBuilder.toString());
        // String dataPostURL = "http://120.25.12.206:8888/DeclMsg/Ciq";
        // MessageGetter.sendXml(stringBuilder.toString(), dataPostURL);
        Map<String, Object> param = new LinkedHashMap<String, Object>();
        param.put("driverIc", "C09000000002a6d32701");
        param.put("driverName", "陈一");
        param.put("sex", "1");
        param.put("birthday", "1991-09-01T00:00:00");
        param.put("nationality", "中国");
        param.put("corpName", "横琴企业");
        param.put("registerNo", "C0900000000347736701");
        param.put("drivingValidityDate", "2017-04-17T09:00:00");
        param.put("commonFlag", "1");
        param.put("residentcardValidityDate", "2014-04-27T09:00:00");
        param.put("leftHandFingerprint", "1");
        param.put("rightHandFingerprint", "2");
        param.put("imageEignvalues", "3");
        param.put("certificateNo", "4");
        param.put("validityEndDate", "2020-04-17T09:00:00");
        param.put("creator", "陈一");
        param.put("createDate", "2014-04-17T09:00:00");
        param.put("modifier", "陈一");
        param.put("modifyDate", "2014-04-17T09:00:00");
        param.put("cityCode", "广东");
        param.put("nation", "汉族");
        param.put("tel", "13568877897");
        param.put("visaCode", "21212121");
        param.put("subscriberCode", "7937");
        param.put("visaValidityDate", "2017-04-17T09:00:00");
        param.put("icCode", "TDriver000018950");
        param.put("toCountry", "中国");
        param.put("fromCountry", "中国");
        param.put("licenseCode", "168819");
        param.put("idCard", "440882199110254657");
        param.put("secondName", "陈三");
        param.put("secondBirthday", "1991-04-17T09:00:00");
        param.put("secondCertificateNo", "123456789");
        param.put("secondCertificateType", "03");
        param.put("visaNo", "123456789");
        param.put("stayPeriod", "180");
        param.put("residentcardValidityDate", "2017-04-27T09:00:00");
        param.put("returnCardNo", "123456789");
        param.put("pass", "123456789");
        param.put("drivingLicense", "422801197507232815");
        param.put("customCode", "12345");
        param.put("visaCity", "珠海");
        param.put("certificateType", "01");
        param.put("certificateCode", "12345678");
        param.put("subscribeDate", "2010-04-17T09:00:00");
        param.put("passportNo", "G20961897");
        param.put("transactType", "01");
        param.put("isAvoidInspect", "N");
        param.put("isPriorityInspect", "N");
        param.put("remark", "备注");
        String picSourcePath1 = "H://images/正面.jpg";
        // String picSourcePath1="H://images/1/1.jpg";
        String picSourcePath2 = "H://images/1/2.jpeg";
        String picSourcePath3 = "H://images/1/3.jpeg";
        String picSourcePath4 = "H://images/1/4.jpeg";
        String picSourcePath5 = "H://images/1/5.jpeg";
        String picSourcePath6 = "H://images/1/6.jpeg";
        param.put("driverPhoto", Base64PicUtil.GetImageStr(picSourcePath1));
        // param.put("imageA", Base64PicUtil.GetImageStr(picSourcePath2));
        // param.put("imageB", Base64PicUtil.GetImageStr(picSourcePath3));
        // param.put("imageC", Base64PicUtil.GetImageStr(picSourcePath4));
        // param.put("imageD", Base64PicUtil.GetImageStr(picSourcePath5));
        String dataStr = MessageGetter.sendMessage(param, "driver", dataPostURL);
        Map<String, Object> map = XmlParseUtils.XmlToMap(dataStr);
        System.out.println(dataStr);
        if (map.containsKey("message")) {
            String message = (String) map.get("message");
            if (message.equals("true")) {
                System.out.println("===================================================");
                System.out.println(map);
            }
        }
        System.out.println(dataStr);
    }
}