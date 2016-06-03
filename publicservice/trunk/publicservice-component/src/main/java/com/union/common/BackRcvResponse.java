package com.union.common;

import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import javax.servlet.http.HttpServletRequest;
import com.qcloud.component.publicservice.exception.PublicServiceException;
import com.unionpay.acp.sdk.LogUtil;
import com.unionpay.acp.sdk.SDKConfig;
import com.unionpay.acp.sdk.SDKConstants;
import com.unionpay.acp.sdk.SDKUtil;

/**
 * 名称：商户后台通知类
 * 功能： 
 * 类属性：
 * 方法调用 版本：5.0 
 * 日期：2014-07 
 * 作者：中国银联ACP团队 
 * 版权：中国银联
 * 说明：以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。该代码仅供参考。
 * */
public class BackRcvResponse {

    public static Map<String, String> checkIsSignValidFromResponseString(HttpServletRequest req) {

        LogUtil.writeLog("BackRcvResponse接收后台通知开始");
        try {
            req.setCharacterEncoding("ISO-8859-1");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        String encoding = req.getParameter(SDKConstants.param_encoding);
        // 获取请求参数中所有的信息
        Map<String, String> reqParam = getAllRequestParam(req);
        // 打印请求报文
        LogUtil.printRequestLog(reqParam);
        Map<String, String> valideData = null;
        if (null != reqParam && !reqParam.isEmpty()) {
            Iterator<Entry<String, String>> it = reqParam.entrySet().iterator();
            valideData = new HashMap<String, String>(reqParam.size());
            while (it.hasNext()) {
                Entry<String, String> e = it.next();
                String key = (String) e.getKey();
                String value = (String) e.getValue();
                try {
                    value = new String(value.getBytes("ISO-8859-1"), encoding);
                } catch (UnsupportedEncodingException e1) {
                    e1.printStackTrace();
                }
                valideData.put(key, value);
            }
        }
        // 验证签名
        if (!SDKUtil.validate(valideData, encoding)) {
            LogUtil.writeLog("验证签名结果[失败].");
            throw new PublicServiceException("银联支付签名认证失败!");
        } else {
            LogUtil.writeLog("订单支付成功:" + valideData.get("orderId")); // 其他字段也可用类似方式获取
            LogUtil.writeLog("验证签名结果[成功].");
        }
        LogUtil.writeLog("BackRcvResponse接收后台通知结束");
        return valideData;
    }

    /**
     * 获取请求参数中所有的信息
     * 
     * @param request
     * @return
     */
    public static Map<String, String> getAllRequestParam(final HttpServletRequest request) {

        Map<String, String> res = new HashMap<String, String>();
        Enumeration<?> temp = request.getParameterNames();
        if (null != temp) {
            while (temp.hasMoreElements()) {
                String en = (String) temp.nextElement();
                String value = request.getParameter(en);
                res.put(en, value);
                // 在报文上送时，如果字段的值为空，则不上送<下面的处理为在获取所有参数数据时，判断若值为空，则删除这个字段>
                // System.out.println("ServletUtil类247行  temp数据的键=="+en+"     值==="+value);
                if (null == res.get(en) || "".equals(res.get(en))) {
                    res.remove(en);
                }
            }
        }
        return res;
    }
}
