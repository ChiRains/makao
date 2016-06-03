package com.qcloud.project.macaovehicle.dao.outside;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.filesdk.FileSDKClient;
import com.qcloud.component.filesdk.QFile;
import com.qcloud.pirates.util.DateUtil;
import com.qcloud.project.macaovehicle.dao.ApprovalOutsideDao;
import com.qcloud.project.macaovehicle.dao.ApprovalResultsDao;
import com.qcloud.project.macaovehicle.dao.CarOwnerDao;
import com.qcloud.project.macaovehicle.dao.DriverDao;
import com.qcloud.project.macaovehicle.dao.EportDao;
import com.qcloud.project.macaovehicle.dao.VehicleDao;
import com.qcloud.project.macaovehicle.model.ApprovalOutside;
import com.qcloud.project.macaovehicle.model.ApprovalResults;
import com.qcloud.project.macaovehicle.model.CarOwner;
import com.qcloud.project.macaovehicle.model.Driver;
import com.qcloud.project.macaovehicle.model.Vehicle;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ApprovalCardType;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ApprovalResultState;
import com.qcloud.project.macaovehicle.util.HttpUtils;
import com.qcloud.project.macaovehicle.util.MessageGetter;
import com.qcloud.project.macaovehicle.util.XmlParseUtils;

@Component
public class EportDaoOutsideImpl implements EportDao {

    @Autowired
    private DriverDao          driverDao;

    @Autowired
    private VehicleDao         vehicleDao;

    @Autowired
    private CarOwnerDao        carOwnerDao;

    @Autowired
    private FileSDKClient      fileSDKClient;

    @Autowired
    private ApprovalOutsideDao approvalOutsideDao;

    final String               cipPostURL     = "http://120.25.12.206:8888/DeclMsg/Ciq";

    final String               customsPostURL = "http://120.25.12.206:8888/DeclMsg/Customs";

    @Autowired
    private ApprovalResultsDao approvalResultsDao;

    private Log                logger         = LogFactory.getLog(getClass());

    @Override
    public void ciqPost(Long vehicleId, Long driverId, String formInstanceCode) {

        ciqDriverPost(driverId, formInstanceCode);
        ciqVehiclePost(vehicleId, formInstanceCode);
        vehicleDriverPost(driverId, vehicleId);
    }

    private boolean ciqDriverPost(Long driverId, String formInstanceCode) {

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
        param.put("driverPhoto", "");
        String dataStr = MessageGetter.sendMessage(param, "driver", cipPostURL);
        // 录入数据成功
        Map<String, Object> map = XmlParseUtils.XmlToMap(dataStr);
        if (map.containsKey("message")) {
            String message = (String) map.get("message");
            if (message.equals("true")) {
                ApprovalOutside approvalOutside = new ApprovalOutside();
                approvalOutside.setCode("driver");
                // approvalOutside.setRic();
                approvalOutside.setDriverIc((String) map.get("driverIc"));
                approvalOutside.setXml(dataStr);
                approvalOutside.setType(1);
                approvalOutside.setSubType(1);
                approvalOutside.setRecordTime(new Date());
                approvalOutsideDao.add(approvalOutside);
            }
        }
        return true;
    }

    private boolean ciqVehiclePost(Long vehicleId, String formInstanceCode) {

        Map<String, Object> param = new LinkedHashMap<String, Object>();
        param.put("ric", "C0900000000347736701");
        param.put("nationality", "02");
        param.put("vehicleHeight", "3.5");
        param.put("portCode", "02");
        param.put("portPassEndtime", "2020-11-12T00:00:00");
        param.put("registerNo", "TGSQ201604270004");
        param.put("firstWord", "粤");
        param.put("bank", "开户银行");
        param.put("bankAccount", "624571254678128");
        param.put("quotaCode", "TGSQ201604270004");
        param.put("quotaType", "01");
        param.put("approveFile", "N051");
        param.put("foreignNo", "澳");
        param.put("preForeignNo", "45");
        param.put("midForeignNo", "13");
        param.put("postForeignNo", "02");
        param.put("masterName", "陈一");
        param.put("usageCode", "01");
        param.put("inBear", "横琴");
        param.put("validityEndDate", "2020-11-12T00:00:00");
        param.put("sortCode", "01");
        param.put("brandCode", "06");
        param.put("tonnage", "2.5T");
        param.put("isExternal", "Y");
        param.put("colorCode", "03");
        param.put("engineNo", "358769");
        param.put("undercarriageNo", "7102054");
        param.put("creator", "陈一");
        param.put("createDate", "2016-04-27T00:00:00");
        param.put("specification", "T1142");
        param.put("validityBeginDate", "2016-04-27T00:00:00");
        param.put("steeringWheel", "L");
        param.put("deadWeight", "1.9");
        param.put("oilBox", "15");
        param.put("frontTyre", "正常");
        param.put("backTyre", "正常");
        param.put("standbyTyre", "有");
        param.put("startUsingYyyymm", "2016-4-27T11:12:53");
        param.put("inspectDate", "2016-4-28T11:12:53");
        param.put("vehicleType", "01");
        param.put("isAvoidInspect", "N");
        param.put("isPriorityInspect", "N");
        param.put("inBearRepresentative", "陈春香");
        param.put("inBearPhone", "13750013175");
        param.put("masterIdCard", "450874198711084525");
        param.put("warrantModeId", "01");
        param.put("warrantModeName", "01");
        param.put("warrantor", "陈希留");
        param.put("warrantMoney", "50000.00");
        param.put("warrantorTel", "6785941");
        param.put("warrantorMobile", "13726273487");
        param.put("warrantAddress", "珠海市香洲区");
        param.put("warrantBeginDate", "2015-10-10T00:00:00");
        param.put("warrantEndDate", "2018-10-10T00:00:00");
        param.put("appendix", "箱子");
        param.put("remark", "备注");
        param.put("transactType", "01");
        param.put("cityCode", "01");
        param.put("belongCorp", "火星集团");
        param.put("address", "珠海市");
        param.put("modifier", "李四");
        param.put("modifyDate", "2011-11-12T00:00:00");
        param.put("registerCapital", "内承单位注册资本");
        param.put("leftImage", "");
        param.put("rightImage", "");
        String dataStr = MessageGetter.sendMessage(param, "vehicle", cipPostURL);
        // 录入数据成功
        Map<String, Object> map = XmlParseUtils.XmlToMap(dataStr);
        if (map.containsKey("message")) {
            String message = (String) map.get("message");
            if (message.equals("true")) {
                ApprovalOutside approvalOutside = new ApprovalOutside();
                approvalOutside.setCode("vehicle");
                approvalOutside.setRic((String) map.get("ric"));
                // approvalOutside.setDriverIc((String) map.get("driverIc"));
                approvalOutside.setXml(dataStr);
                approvalOutside.setType(1);
                approvalOutside.setSubType(1);
                approvalOutside.setRecordTime(new Date());
                approvalOutsideDao.add(approvalOutside);
            }
        }
        return true;
    }

    private boolean vehicleDriverPost(Long driverId, Long vehicleId) {

        Map<String, Object> param = new LinkedHashMap<String, Object>();
        param.put("ric", "C0900000000347736701");
        param.put("driverIc", "C09000000002a6d32701");
        param.put("isPrimary", "1");
        param.put("creator", "陈一");
        param.put("createDate", "2016-04-27T00:00:00");
        param.put("modifier", "陈一");
        param.put("modifyDate", "2016-04-27T00:00:00");
        String dataStr = MessageGetter.sendMessage(param, "vehicleRDriver", cipPostURL);
        // 录入数据成功
        Map<String, Object> map = XmlParseUtils.XmlToMap(dataStr);
        if (map.containsKey("message")) {
            String message = (String) map.get("message");
            if (message.equals("true")) {
                ApprovalOutside approvalOutside = new ApprovalOutside();
                approvalOutside.setCode("vehicleRDriver");
                approvalOutside.setRic((String) map.get("ric"));
                approvalOutside.setDriverIc((String) map.get("driverIc"));
                approvalOutside.setXml(dataStr);
                approvalOutside.setType(1);
                approvalOutside.setSubType(1);
                approvalOutside.setRecordTime(new Date());
                approvalOutsideDao.add(approvalOutside);
            }
        }
        return true;
    }

    @Override
    public void customsPost(Long vehicleId, Long driverId, String formInstanceCode) {

        customsDriverPost(driverId, formInstanceCode);
        logger.info("customsDriverPost post...");
        customsVehiclePost(vehicleId, formInstanceCode);
        logger.info("customsVehiclePost post...");
        customsVehicleDriverPost(driverId, vehicleId);
        logger.info("customsVehicleDriverPost post...");
    }

    private boolean customsDriverPost(Long driverId, String formInstanceCode) {

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
        param.put("driverPhoto", "");
        MessageGetter.sendMessage(param, "driver", customsPostURL);
        return true;
    }

    private boolean customsVehiclePost(Long vehicleId, String formInstanceCode) {

        Map<String, Object> param = new LinkedHashMap<String, Object>();
        param.put("ric", "C0900000000347736701");
        param.put("nationality", "02");
        param.put("vehicleHeight", "3.5");
        param.put("portCode", "02");
        param.put("portPassEndtime", "2020-11-12T00:00:00");
        param.put("registerNo", "TGSQ201604270004");
        param.put("firstWord", "粤");
        param.put("bank", "开户银行");
        param.put("bankAccount", "624571254678128");
        param.put("quotaCode", "TGSQ201604270004");
        param.put("quotaType", "01");
        param.put("approveFile", "N051");
        param.put("foreignNo", "澳");
        param.put("preForeignNo", "45");
        param.put("midForeignNo", "13");
        param.put("postForeignNo", "02");
        param.put("masterName", "陈一");
        param.put("usageCode", "01");
        param.put("inBear", "横琴");
        param.put("validityEndDate", "2020-11-12T00:00:00");
        param.put("sortCode", "01");
        param.put("brandCode", "06");
        param.put("tonnage", "2.5T");
        param.put("isExternal", "Y");
        param.put("colorCode", "03");
        param.put("engineNo", "358769");
        param.put("undercarriageNo", "7102054");
        param.put("creator", "陈一");
        param.put("createDate", "2016-04-27T00:00:00");
        param.put("specification", "T1142");
        param.put("validityBeginDate", "2016-04-27T00:00:00");
        param.put("steeringWheel", "L");
        param.put("deadWeight", "1.9");
        param.put("oilBox", "15");
        param.put("frontTyre", "正常");
        param.put("backTyre", "正常");
        param.put("standbyTyre", "有");
        param.put("startUsingYyyymm", "2016-4-27T11:12:53");
        param.put("inspectDate", "2016-4-28T11:12:53");
        param.put("vehicleType", "01");
        param.put("isAvoidInspect", "N");
        param.put("isPriorityInspect", "N");
        param.put("inBearRepresentative", "陈春香");
        param.put("inBearPhone", "13750013175");
        param.put("masterIdCard", "450874198711084525");
        param.put("warrantModeId", "01");
        param.put("warrantModeName", "01");
        param.put("warrantor", "陈希留");
        param.put("warrantMoney", "50000.00");
        param.put("warrantorTel", "6785941");
        param.put("warrantorMobile", "13726273487");
        param.put("warrantAddress", "珠海市香洲区");
        param.put("warrantBeginDate", "2015-10-10T00:00:00");
        param.put("warrantEndDate", "2018-10-10T00:00:00");
        param.put("appendix", "箱子");
        param.put("remark", "备注");
        param.put("transactType", "01");
        param.put("cityCode", "01");
        param.put("belongCorp", "火星集团");
        param.put("address", "珠海市");
        param.put("modifier", "李四");
        param.put("modifyDate", "2011-11-12T00:00:00");
        param.put("registerCapital", "内承单位注册资本");
        param.put("leftImage", "");
        param.put("rightImage", "");
        MessageGetter.sendMessage(param, "vehicle", customsPostURL);
        return true;
    }

    private boolean customsVehicleDriverPost(Long driverId, Long vehicleId) {

        Map<String, Object> param = new LinkedHashMap<String, Object>();
        param.put("ric", "C0900000000347736701");
        param.put("driverIc", "C09000000002a6d32701");
        param.put("isPrimary", "1");
        param.put("creator", "陈一");
        param.put("createDate", "2016-04-27T00:00:00");
        param.put("modifier", "陈一");
        param.put("modifyDate", "2016-04-27T00:00:00");
        MessageGetter.sendMessage(param, "vehicleRDriver", customsPostURL);
        return true;
    }
}
