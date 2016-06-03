package com.qcloud.component.publicservice.model;

public class WeiXinPayReqData {

    private String device_info      = "WEB";

    private String body             = "";

    private String out_trade_no     = "";

    private int    total_fee        = 0;

    private String spbill_create_ip = "";

    private String time_start       = "";

    private String time_expire      = "";

    private String auth_code        = "";

    private String attach           = "";

    /**
     * @param authCode 这个是扫码终端设备从用户手机上扫取到的支付授权号，这个号是跟用户用来支付的银行卡绑定的，有效期是1分钟
     * @param body 要支付的商品的描述信息，用户会在支付成功页面里看到这个信息
     * @param attach 支付订单里面可以填的附加数据，API会将提交的这个附加数据原样返回
     * @param outTradeNo 商户系统内部的订单号,32个字符内可包含字母, 确保在商户系统唯一
     * @param totalFee 订单总金额，单位为“分”，只能整数
     * @param deviceInfo 商户自己定义的扫码支付终端设备号，方便追溯这笔交易发生在哪台终端设备上
     * @param spBillCreateIP 订单生成的机器IP
     * @param timeStart 订单生成时间， 格式为yyyyMMddHHmmss，如2009年12 月25 日9 点10 分10 秒表示为20091225091010。时区为GMT+8 beijing。该时间取自商户服务器
     * @param timeExpire 订单失效时间，格式同上
     * @param goodsTag 商品标记，微信平台配置的商品标记，用于优惠券或者满减使用
     */
    public WeiXinPayReqData(String body, String attach, String outTradeNo, int totalFee, String deviceInfo, String spBillCreateIP, String timeStart, String timeExpire, String goodsTag) {

        // 这个是扫码终端设备从用户手机上扫取到的支付授权号，这个号是跟用户用来支付的银行卡绑定的，有效期是1分钟
        // 调试的时候可以在微信上打开“钱包”里面的“刷卡”，将扫码页面里的那一串14位的数字输入到这里来，进行提交验证
        // 记住out_trade_no这个订单号可以将这一笔支付进行退款
//        setAuth_code(authCode);
        // 要支付的商品的描述信息，用户会在支付成功页面里看到这个信息
        setBody(body);
        // 商户系统内部的订单号,32个字符内可包含字母, 确保在商户系统唯一
        setOut_trade_no(outTradeNo);
        // 订单总金额，单位为“分”，只能整数
        setTotal_fee(totalFee);
        // 商户自己定义的扫码支付终端设备号，方便追溯这笔交易发生在哪台终端设备上
        setDevice_info(deviceInfo);
        // 订单生成的机器IP
        setSpbill_create_ip(spBillCreateIP);
        // 订单生成时间， 格式为yyyyMMddHHmmss，如2009年12 月25 日9 点10 分10 秒表示为20091225091010。时区为GMT+8 beijing。该时间取自商户服务器
        setTime_start(timeStart);
        // 订单失效时间，格式同上
        setTime_expire(timeExpire);
        
        setAttach(attach);
    }
    
    

    
    public String getAttach() {
    
        return attach;
    }



    
    public void setAttach(String attach) {
    
        this.attach = attach;
    }



    public String getDevice_info() {

        return device_info;
    }

    public void setDevice_info(String device_info) {

        this.device_info = device_info;
    }

    public String getBody() {

        return body;
    }

    public void setBody(String body) {

        this.body = body;
    }

    public String getOut_trade_no() {

        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {

        this.out_trade_no = out_trade_no;
    }

    public int getTotal_fee() {

        return total_fee;
    }

    public void setTotal_fee(int total_fee) {

        this.total_fee = total_fee;
    }

    public String getSpbill_create_ip() {

        return spbill_create_ip;
    }

    public void setSpbill_create_ip(String spbill_create_ip) {

        this.spbill_create_ip = spbill_create_ip;
    }

    public String getTime_start() {

        return time_start;
    }

    public void setTime_start(String time_start) {

        this.time_start = time_start;
    }

    public String getTime_expire() {

        return time_expire;
    }

    public void setTime_expire(String time_expire) {

        this.time_expire = time_expire;
    }

    public String getAuth_code() {

        return auth_code;
    }

    public void setAuth_code(String auth_code) {

        this.auth_code = auth_code;
    }
}
