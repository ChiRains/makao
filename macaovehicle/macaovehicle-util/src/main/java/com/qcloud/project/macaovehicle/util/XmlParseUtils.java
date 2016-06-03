package com.qcloud.project.macaovehicle.util;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.springframework.util.StringUtils;
import org.xml.sax.InputSource;

public class XmlParseUtils {

    /**
     * @param args
     */
    public static void main(String[] args) {

        // TODO Auto-generated method stub
        String xmlString = "<?xml version=\"1.0\" encoding=\"utf-8\"?><postData> <postUrl>driver</postUrl>  <driver> <driverIc>TDriver000018950</driverIc> <driverName>张三</driverName> <sex>1</sex> <birthday>2011-09-01T00:00:00-03:00</birthday> <nationality>中国</nationality> <corpName>盛视科技</corpName> <registerNo>N023123421</registerNo> <drivingValidityDate>2010-04-17T09:00:00</drivingValidityDate> <commonFlag>1</commonFlag> <residentcardValidityDate>2010-04-17T09:00:00</residentcardValidityDate> <leftHandFingerprint>1</leftHandFingerprint> <rightHandFingerprint>2</rightHandFingerprint> <imageEignvalues>3</imageEignvalues> <certificateNo>4</certificateNo> <validityEndDate>2010-04-17T09:00:00</validityEndDate> <creator>Mark.huang</creator> <createDate>2010-04-17T09:00:00</createDate> <modifier>huangzz</modifier> <modifyDate>2010-04-17T09:00:00</modifyDate> <cityCode>深圳</cityCode> <nation>壮族</nation> <tel>13568877897</tel> <visaCode>21212121</visaCode> <subscriberCode>签发机关代码</subscriberCode> <visaValidityDate>2010-04-17T09:00:00</visaValidityDate> <icCode>IC卡号</icCode> <toCountry>前往国</toCountry> <fromCountry>来自国</fromCountry> <licenseCode>许可证号</licenseCode> <idCard>身份证号</idCard> <secondName>第2姓名</secondName> <secondBirthday>2010-04-17T09:00:00</secondBirthday> <secondCertificateNo>第二证件号码</secondCertificateNo> <secondCertificateType>第二证件类别代码</secondCertificateType> <visaNo>签证号</visaNo> <stayPeriod>停留期(天)</stayPeriod> <residentcardValidityDate>2010-04-17T09:00:00</residentcardValidityDate> <returnCardNo>回乡证号</returnCardNo> <pass>通行证号</pass> <drivingLicense>驾驶证</drivingLicense> <customCode>自定义代码</customCode> <visaCity>证件签发地</visaCity> <certificateType>01</certificateType> <certificateCode>健康证编号</certificateCode> <subscribeDate>2010-04-17T09:00:00</subscribeDate> <passportNo>护照号</passportNo> <transactType>01</transactType> <isAvoidInspect>N</isAvoidInspect> <isPriorityInspect>N</isPriorityInspect> <remark>备注</remark> <driverPhoto>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</driverPhoto> <leftHandFingerprintImg/> <rightHandFingerprintImg/> <imageA/> <imageB/> <imageC/> <imageD/> </driver> <vehicle> <ric>riccard1212121</ric> <foreignNo>dededeaas</foreignNo> </vehicle> <vehicleRDriver> </vehicleRDriver> </postData>";
        XmlToMap(xmlString);
    }

    public static Map<String, Map<String, Object>> XmlToList(String xmlString) {

        Map<String, Map<String, Object>> map = new LinkedHashMap<String, Map<String, Object>>();
        // 创建一个新的字符串
        StringReader read = new StringReader(xmlString);
        // 创建新的输入源SAX 解析器将使用 InputSource 对象来确定如何读取 XML 输入
        InputSource source = new InputSource(read);
        // 创建一个新的SAXBuilder
        SAXBuilder saxbBuilder = new SAXBuilder();
        try {
            // 通过输入源构造一个Document
            Document doc = saxbBuilder.build(source);
            // 取的根元素
            Element root = doc.getRootElement();
            List<?> node = root.getChildren();
            String postUrl = "";
            for (int i = 0; i < node.size(); i++) {
                Element element = (Element) node.get(i);
                if (element.getName().equals("postUrl")) {
                    postUrl = element.getValue();
                }
                if (!StringUtils.isEmpty(postUrl) && element.getName().equals(postUrl)) {
                    Map<String, Object> paramData = new HashMap<String, Object>();
                    List<?> subNode = element.getChildren();
                    for (int j = 0; j < subNode.size(); j++) {
                        Element subElement = (Element) subNode.get(j);
                        paramData.put(subElement.getName(), subElement.getValue());
                    }
                    map.put(postUrl, paramData);
                }
            }
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    public static Map<String, Object> XmlToMap(String xmlString) {

        Map<String, Object> map = new LinkedHashMap<String, Object>();
        // 创建一个新的字符串
        StringReader read = new StringReader(xmlString);
        // 创建新的输入源SAX 解析器将使用 InputSource 对象来确定如何读取 XML 输入
        InputSource source = new InputSource(read);
        // 创建一个新的SAXBuilder
        SAXBuilder saxbBuilder = new SAXBuilder();
        try {
            // 通过输入源构造一个Document
            Document doc = saxbBuilder.build(source);
            // 取的根元素
            Element root = doc.getRootElement();
            List<?> node = root.getChildren();
            for (int i = 0; i < node.size(); i++) {
                Element element = (Element) node.get(i);
                Map<String, Object> paramData = new HashMap<String, Object>();
                List<?> subNode = element.getChildren();
                for (int j = 0; j < subNode.size(); j++) {
                    Element subElement = (Element) subNode.get(j);
                    paramData.put(subElement.getName(), subElement.getValue());
                }
                if (paramData.size() > 0) {
                    map.put(element.getName(), paramData);
                } else {
                    map.put(element.getName(), element.getValue());
                }
            }
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}