package com.qcloud.component.publicservice.dao.outside;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import com.qcloud.component.publicservice.dao.WeiXinPayDao;
import com.qcloud.component.publicservice.exception.PublicServiceException;
import com.qcloud.component.publicservice.model.WeiXinPayReqData;
import com.qcloud.pirates.util.DateUtil;
import com.tencent.WXPay;
import com.tencent.common.Configure;
import com.tencent.common.Signature;
import com.tencent.common.XMLParser;
import com.tencent.protocol.pay_protocol.UnifiederPayReqData;

@Repository
public class WeiXinPayDaoOutSideImpl implements WeiXinPayDao {

    private Log logger = LogFactory.getLog(getClass());

    public String request(WeiXinPayReqData data) {

        //
        try {
            UnifiederPayReqData unifiederPayReqData = new UnifiederPayReqData(data.getBody(), "", data.getOut_trade_no(), data.getTotal_fee(), data.getDevice_info(), data.getSpbill_create_ip(), data.getTime_start(), data.getTime_expire(), "");
            // UnifiederPayReqData unifiederPayReqData = new UnifiederPayReqData("", "", "", "", 1, "", "", "", "", "");
            // // -------------官网例子------------------
            // // unifiederPayReqData.setAppid("wx2421b1c4370ec43b");
            // // unifiederPayReqData.setAttach("支付测试");
            // // unifiederPayReqData.setBody("JSAPI支付测试");
            // // unifiederPayReqData.setMch_id("10000100");
            // // unifiederPayReqData.setNonce_str("1add1a30ac87aa2db72f57a2375d8fec");
            // // unifiederPayReqData.setNotify_url("http://wxpay.weixin.qq.com/pub_v2/pay/notify.v2.php");
            // // unifiederPayReqData.setOpenid("oUpF8uMuAJO_M2pxb1Q9zNjWeS6o");
            // // unifiederPayReqData.setOut_trade_no("1415659990");
            // // unifiederPayReqData.setSpbill_create_ip("14.23.150.211");
            // // unifiederPayReqData.setTotal_fee(1);
            // // unifiederPayReqData.setTrade_type("JSAPI");
            // // unifiederPayReqData.setSign("");
            // // System.out.println(unifiederPayReqData.toMap());
            // // System.out.println(Signature.getSign(unifiederPayReqData.toMap()));
            // // unifiederPayReqData.setSign("0CB01533B8C1EF103065174F50BCA001");
            // // // unifiederPayReqData.setSign(Signature.getSign(unifiederPayReqData.toMap()));
            // // unifiederPayReqData.setSdk_version("");
            // // unifiederPayReqData.setFee_type("");
            // // --------------end------------------
            // //
            // // --------------旗云科技例子------------------
            unifiederPayReqData.setAppid("wx3fd5da72655f8c3c");
            unifiederPayReqData.setAttach("支付测试");
            unifiederPayReqData.setBody("JSAPI支付测试");
            unifiederPayReqData.setMch_id("1234237002");
            // unifiederPayReqData.setNonce_str("1add1a30ac87aa2db72f57a2375d8fec");//
            unifiederPayReqData.setNotify_url("http://wxpay.weixin.qq.com/pub_v2/pay/notify.v2.php");
            unifiederPayReqData.setOpenid("oL37bt_QsidECFOlcLLgneOeCGao");
            unifiederPayReqData.setOut_trade_no("2015041116273z4084145");//
            unifiederPayReqData.setTotal_fee(1);
            unifiederPayReqData.setTrade_type("JSAPI");
            unifiederPayReqData.setSign("");
            // unifiederPayReqData.setSdk_version("");
            unifiederPayReqData.setFee_type("");
            System.out.println(unifiederPayReqData.toMap());
            System.out.println(Signature.getSign(unifiederPayReqData.toMap()));
            unifiederPayReqData.setSign(Signature.getSign(unifiederPayReqData.toMap()));
            // // --------------end------------------
            // unifiederPayReqData.setSdk_version("");
            // unifiederPayReqData.setAppid("wxd2ecba8bd0665e47");
            // unifiederPayReqData.setMch_id("1228803102");
            // unifiederPayReqData.setOpenid("oext9uF-KtPrgiP8vyhEcoRlTqQU");
            // unifiederPayReqData.setOpenid("oUpF8uMuAJO_M2pxb1Q9zNjWeS6o");
            String result = WXPay.requestUnifiederPayService(unifiederPayReqData);
            if (Signature.checkIsSignValidFromResponseString(result)) {
                Map<String, Object> resultMap = XMLParser.getMapFromXML(result);
                if ("SUCCESS".equals(resultMap.get("result_code"))) {
                    String prepayId = (String) resultMap.get("prepay_id");
                    return prepayId;
                } else {
                    throw new PublicServiceException("申请微信支付失败,微信接口返回申请支付不成功" + result);
                }
            } else {
                throw new PublicServiceException("申请微信支付失败.返回数据校验签名失败." + result);
            }
            //
            //
            // <xml><return_code><![CDATA[SUCCESS]]></return_code>
            // <return_msg><![CDATA[OK]]></return_msg>
            // <appid><![CDATA[wx3fd5da72655f8c3c]]></appid>
            // <mch_id><![CDATA[1234237002]]></mch_id>
            // <nonce_str><![CDATA[6TGQ8E9HyBqIYHph]]></nonce_str>
            // <sign><![CDATA[383D650DC41DEEEADCA5D94283B3DBE9]]></sign>
            // <result_code><![CDATA[SUCCESS]]></result_code>
            // <prepay_id><![CDATA[wx20150816153408f3bde947b10315468372]]></prepay_id>
            // <trade_type><![CDATA[JSAPI]]></trade_type>
            // </xml>
            // logger.info("请求微信统一支付." + result);
            // System.out.println("========================");
            // System.out.println(result);
            // return result;
        } catch (Exception e) {
            throw new PublicServiceException("申请微信支付失败." + e.getMessage(), e);
        }
    }

    @Override
    public String request(WeiXinPayReqData data, String notifyUrl, String appid, String appsecret, String opneId) {

        try {
            UnifiederPayReqData unifiederPayReqData = new UnifiederPayReqData(data.getBody(), data.getAttach(), data.getOut_trade_no(), data.getTotal_fee(), data.getDevice_info(), data.getSpbill_create_ip(), data.getTime_start(), data.getTime_expire(), "");
            unifiederPayReqData.setNotify_url(notifyUrl);
            unifiederPayReqData.setOpenid(opneId);
            unifiederPayReqData.setSign("");
            String sign = Signature.getSign(unifiederPayReqData.toMap());
            unifiederPayReqData.setSign(sign);
            String result = WXPay.requestUnifiederPayService(unifiederPayReqData);
            logger.info("wx request pay result ");
            logger.info(result);
            logger.info("");
            if (Signature.checkIsSignValidFromResponseString(result)) {
                Map<String, Object> resultMap = XMLParser.getMapFromXML(result);
                if ("SUCCESS".equals(resultMap.get("result_code"))) {
                    String prepayId = (String) resultMap.get("prepay_id");
                    return prepayId;
                } else {
                    throw new PublicServiceException("申请微信支付失败,微信接口返回申请支付不成功" + result);
                }
            } else {
                throw new PublicServiceException("申请微信支付失败.返回数据校验签名失败." + result);
            }
        } catch (Exception e) {
            throw new PublicServiceException("微信支付失败.", e);
        }
    }

    @Override
    public String request4Web(WeiXinPayReqData data, String notifyUrl, String appid, String appsecret) {

        try {
            UnifiederPayReqData unifiederPayReqData = new UnifiederPayReqData(data.getBody(), data.getAttach(), data.getOut_trade_no(), data.getTotal_fee(), data.getDevice_info(), data.getSpbill_create_ip(), data.getTime_start(), data.getTime_expire(), "");
            unifiederPayReqData.setNotify_url(notifyUrl);
            unifiederPayReqData.setTrade_type("NATIVE");
            unifiederPayReqData.setSign("");
            String sign = Signature.getSign(unifiederPayReqData.toMap());
            unifiederPayReqData.setSign(sign);
            String result = WXPay.requestUnifiederPayService(unifiederPayReqData);
            logger.info("wx request pay result ");
            logger.info(result);
            logger.info("");
            if (Signature.checkIsSignValidFromResponseString(result)) {
                Map<String, Object> resultMap = XMLParser.getMapFromXML(result);
                if ("SUCCESS".equals(resultMap.get("result_code"))) {
                    String codeUrl = (String) resultMap.get("code_url");
                    return codeUrl;
                } else {
                    throw new PublicServiceException("申请微信支付失败,微信接口返回申请支付不成功" + result);
                }
            } else {
                throw new PublicServiceException("申请微信支付失败.返回数据校验签名失败." + result);
            }
        } catch (Exception e) {
            throw new PublicServiceException("微信支付失败.", e);
        }
    }

    @Override
    public String request4App(WeiXinPayReqData data, String notifyUrl, String appid, String appsecret) {

        try {
            UnifiederPayReqData unifiederPayReqData = new UnifiederPayReqData(data.getBody(), data.getAttach(), data.getOut_trade_no(), data.getTotal_fee(), data.getDevice_info(), data.getSpbill_create_ip(), data.getTime_start(), data.getTime_expire(), "");
            unifiederPayReqData.setNotify_url(notifyUrl);
            unifiederPayReqData.setTrade_type("APP");
            unifiederPayReqData.setSign("");
            String sign = Signature.getSign(unifiederPayReqData.toMap());
            unifiederPayReqData.setSign(sign);
            String result = WXPay.requestUnifiederPayService(unifiederPayReqData);
            logger.info("wx app request pay result ");
            logger.info(result);
            logger.info("");
            if (Signature.checkIsSignValidFromResponseString(result)) {
                Map<String, Object> resultMap = XMLParser.getMapFromXML(result);
                if ("SUCCESS".equals(resultMap.get("result_code"))) {
                    String prepayId = (String) resultMap.get("prepay_id");
                    return prepayId;
                } else {
                    throw new PublicServiceException("申请微信支付失败,微信接口返回申请支付不成功" + result);
                }
            } else {
                throw new PublicServiceException("申请微信支付失败.返回数据校验签名失败." + result);
            }
        } catch (Exception e) {
            throw new PublicServiceException("微信支付失败.", e);
        }
    }

    public static void main(String[] args) throws IllegalAccessException {

        Configure.setCertLocalPath("E:/apiclient_cert.p12");
        Configure.setCertLocalPath("G:/data/shuiqi/config/apiclient_cert.p12");
        Configure.setCertPassword("1234237002");
        Configure.setAppID("wx3fd5da72655f8c3c");
        Configure.setMchID("1234237002");
        Configure.setKey("526t2Jx9IVXY2t70JVaG8I87635sso8U");
        Date startTime = new Date();
        Date endTime = DateUtil.addTime(startTime, 180);
        System.out.println("timeStamp:" + startTime.getTime());
        // WeiXinPayReqData data = new WeiXinPayReqData(authCode, body, attach, outTradeNo, totalFee, deviceInfo, spBillCreateIP, timeStart, timeExpire, goodsTag);
        WeiXinPayReqData data = new WeiXinPayReqData("测试商品1", "abc123456", "", 1, "", "172.16.0.1", DateUtil.date2String(startTime, "yyyyMMddHHmmss"), DateUtil.date2String(endTime, "yyyyMMddHHmmss"), "");
        new WeiXinPayDaoOutSideImpl().request(data);
        // String a = "appId=wx3fd5da72655f8c3c&nonceStr=0ySZPYAGQ1uJljHQ&package=prepay_id=wx2015081519401004c0f2e5f60773116483&signType=MD5&timeStamp=1439638783702&key=526t2Jx9IVXY2t70JVaG8I87635sso8U";
        // System.out.println(MD5.MD5Encode(a).toUpperCase());
        Map<String, String> map = new HashMap<String, String>();
        map.put("appId", "wx3fd5da72655f8c3c");
        map.put("nonceStr", "0ySZPYAGQ1uJljHQ");
        map.put("package", "prepay_id=wx201508151949058a6b4bd9270331351542");
        map.put("signType", "MD5");
        map.put("timeStamp", "1439639318961");
        map.put("key", "526t2Jx9IVXY2t70JVaG8I87635sso8U");
        System.out.println(Signature.getSign(map));
    }
}
