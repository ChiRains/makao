package com.qcloud.component.publicservice.dao.outside;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.axis2.AxisFault;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import cn.com.flaginfo.ws.SmsStub;
import com.qcloud.component.publicservice.dao.SmsDao;
import com.qcloud.component.publicservice.exception.PublicServiceException;
import com.qcloud.component.publicservice.model.SmsResult;
import com.qcloud.component.publicservice.model.Ums86Config;

@Repository
public class Ums86SmsDaoOutSideImpl implements SmsDao {

    // private String enterpriseNumber = "223185";
    //
    // private String adminName = "admin2";
    //
    // private String adminPsw = "qcloud#@3399366";
    //
    private Log logger = LogFactory.getLog(getClass());

    public static void main(String[] args) {

//        Ums86Config config = new Ums86Config();
//        config.setEnterpriseNumber("223185");
//        config.setAdminName("admin2");
//        config.setAdminPsw("qcloud#@3399366");
//        SmsResult[] sms = new Ums86SmsDaoOutSideImpl().send(config, "您好，注册码是854569,有效时间2分钟,请使用!", "13232282158");
//        for (SmsResult smsResult : sms) {
//            System.out.println(smsResult.getReceiver());
//            System.out.println(smsResult.getMessage());
//            System.out.println(smsResult.getState());
//            System.out.println();
//        }
        
//        Ums86Config config = new Ums86Config();
//        config.setEnterpriseNumber("225904");                      //尊敬的会员您好!您找回密码的验证码为{code}请在2分钟内使用!谢谢!
//        config.setAdminName("admin3");                             //尊敬的会员您好!您本次的注册码为{code}请在2分钟内使用!谢谢!
//        config.setAdminPsw("yxy18928161717");                          //尊敬的会员您好您本次的注册码为444444请在2时间内使用谢谢
//        // 一次结缘{xx}一生相伴{xx}感谢您注册为心源网会员{xx}从此您的新生活从这里启航{xx}在这里您收获的不止是财富和健康{xx}还有更安全的保障{xx}注册会员验证码{xxxxxx}{xx}心源网祝您生活愉快{xx}
//     
//        // 一次结缘，一生相伴。您的会员卡激活码是787887。从此您的新生活从这里启航，在这里您收获的不止是财富和健康，还有更安全的保障。心源网祝您生活愉快！
//        
//        SmsResult[] sms = new Ums86SmsDaoOutSideImpl().send(config, "一次结缘，一生相伴，感谢您注册为心源网会员。从此您的新生活从这里启航，在这里您收获的不止是财富和健康，还有更安全的保障。注册会员验证码888888，心源网祝您生活愉快！", "18925303318");
//        SmsResult[] sms = new Ums86SmsDaoOutSideImpl().send(config, "一次结缘，一生相伴。您的会员卡激活码是787887。从此您的新生活从这里启航，在这里您收获的不止是财富和健康，还有更安全的保障。心源网祝您生活愉快！", "13326693085");
//        
//        //        SmsResult[] sms = new Ums86SmsDaoOutSideImpl().send(config, "尊敬的会员:您重置密码验证码777777。请尽快使用并重置密码！心源网祝您生活愉快！", "13427775936");
//        
//        
//        for (SmsResult smsResult : sms) {
//            System.out.println(smsResult.getReceiver());
//            System.out.println(smsResult.getMessage());
//            System.out.println(smsResult.getState());
//            System.out.println();
//        }
//        
        
    	
    	
//    	Ums86Config config = new Ums86Config();
//    	config.setEnterpriseNumber("224727");     
//        config.setAdminName("admin1");      
//        config.setAdminPsw("vanboos168");       
        
//        SmsResult[] sms = new Ums86SmsDaoOutSideImpl().send(config, "您好!您的团队为您创造了23.2342342342点财富值,系统已将财富值发送至您的钱包内,请注意查收,谢谢!", "13232282158");
//        SmsResult[] sms = new Ums86SmsDaoOutSideImpl().send(config, "您好!宝贝已打包发货,正以火箭般速度为您送达,请耐心等待并注意查收,谢谢!", "18676416282");
        
                     
        
//        SmsResult[] sms = new Ums86SmsDaoOutSideImpl().send(config, "您好！您已成功注册，可分享页面及二维码给他人进行绑定。您成功消费将返还２５％财富,二级成功消费返还给您５％财富。三级成功消费返还给您２％财富，财富可１：１兑现。", "13232282158");
//        SmsResult[] sms = new Ums86SmsDaoOutSideImpl().send(config, "您好！您已成功注册，可分享页面及二维码给他人进行绑定。您成功消费将返还２５％财富,二级成功消费返还给您５％财富。三级成功消费返还给您２％财富，财富可１：１兑现。", "13232282158");
        
        
        Ums86Config config = new Ums86Config();
        config.setEnterpriseNumber("103904");                      //尊敬的会员您好!您找回密码的验证码为{code}请在2分钟内使用!谢谢!
        config.setAdminName("htt_dqgs");                             //尊敬的会员您好!您本次的注册码为{code}请在2分钟内使用!谢谢!
        config.setAdminPsw("htt_123@abc$");   
//        SmsResult[] sms = new Ums86SmsDaoOutSideImpl().send(config, "您的验证码为123456", "15876309014");
        SmsResult[] sms = new Ums86SmsDaoOutSideImpl().send(config, "  你有一项编号为12345的事务需要处理.", "15876309014");
      
        
        for (SmsResult smsResult : sms) {
          System.out.println(smsResult.getReceiver());
          System.out.println(smsResult.getMessage());
          System.out.println(smsResult.getState());
          System.out.println();
      }
    }

    @Override
    public SmsResult[] send(Ums86Config config, String content, String... receivers) {

        if (receivers == null || receivers.length == 0) {
            return new SmsResult[0];
        }
        Map<String, SmsResult> map = new HashMap<String, SmsResult>();
        for (String str : receivers) {
            SmsResult smsResult = new SmsResult();
            smsResult.setReceiver(str);
            smsResult.setState(0);
            smsResult.setMessage(smsResultMapping.get(0));
            smsResult.setSuccess(true);
            map.put(str, smsResult);
        }
        String[] receiverStrs = splitReceivers(receivers, 800);
        for (int index = 0; index < receiverStrs.length; index++) {
            Map<String, Integer> m = sendSms(config, content, receiverStrs[index]);
            for (String str : m.keySet()) {
                int code = m.get(str);
                if (code != 0) {
                    map.get(str).setState(m.get(str));
                    map.get(str).setMessage(smsResultMapping.get(m.get(str)));
                    map.get(str).setSuccess(true);
                }
            }
        }
        return map.values().toArray(new SmsResult[map.values().size()]);
    }

    private Map<String, Integer> sendSms(Ums86Config config, String content, String receivers) {

        try {
            String[] receiverStrs = receivers.split(",");
            Map<String, Integer> map = new HashMap<String, Integer>();
            for (String str : receiverStrs) {
                map.put(str, 0);
            }
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMddhhmmssSSS");
            SmsStub stub = new SmsStub("http://gd.ums86.com:8899/sms_hb/services/Sms?wsdl");
            SmsStub.Sms sms = new SmsStub.Sms();
            sms.setIn0(config.getEnterpriseNumber());
            sms.setIn1(config.getAdminName());
            sms.setIn2(config.getAdminPsw());
            sms.setIn3(content);
            sms.setIn4(receivers);
            sms.setIn5("999" + format.format(new Date()));
            sms.setIn6("");
            sms.setIn7("1");
            sms.setIn8("");
            SmsStub.SmsResponse resp = stub.Sms(sms);
            String out = resp.getOut();
            logger.info("发送短信返回结果." + out + " ===== " + receivers);
            if (StringUtils.isNotEmpty(out)) {
                if (out.indexOf("result=0") != -1) {
                    String[] resultArray = out.split("&");
                    for (String str : resultArray) {
                        if (str.startsWith("faillist=") && str.length() > 9) {
                            String failMobileStr = str.substring(9, str.length());
                            String[] failMobiles = failMobileStr.split(",");
                            for (String mobile : failMobiles) {
                                map.put(mobile, 6);
                            }
                            break;
                        }
                    }
                } else {
                    String[] resultArray = out.split("&");
                    for (String str : resultArray) {
                        if (str.startsWith("result=") && str.length() > 7) {
                            String failCodeStr = str.substring(7, str.length());
                            int code = Integer.parseInt(failCodeStr);
                            for (String receiver : receiverStrs) {
                                map.put(receiver, code);
                            }
                            break;
                        }
                    }
                }
            }
            // 在这里处理异常.
            return map;
        } catch (AxisFault e) {
            throw new PublicServiceException("发送短信失败." + e.getMessage(), e);
        } catch (RemoteException e) {
            throw new PublicServiceException("发送短信失败." + e.getMessage(), e);
        }
    }

    private String[] splitReceivers(String[] receivers, int size) {

        List<String> list = new ArrayList<String>();
        StringBuffer sb = new StringBuffer();
        for (int index = 0; index < receivers.length; index++) {
            sb.append(receivers[index]);
            if (index % size == size - 1) {
                list.add(sb.toString());
                sb = new StringBuffer();
                continue;
            }
            if (index != receivers.length - 1) {
                sb.append(",");
            }
            if (index == receivers.length - 1) {
                list.add(sb.toString());
                sb = new StringBuffer();
            }
        }
        return list.toArray(new String[list.size()]);
    }

    private static Map<Integer, String> smsResultMapping = new HashMap<Integer, String>();
    static {
        smsResultMapping.put(0, "发送短信成功.");
        smsResultMapping.put(1, "提交参数不能为空.");
        smsResultMapping.put(2, "账户无效或者未开户.");
        smsResultMapping.put(3, "账号密码错误.");
        smsResultMapping.put(4, "预约发送时间格式不正确,应为yyyyMMddHHmmss");
        smsResultMapping.put(5, "IP不合法.");
        smsResultMapping.put(6, "号码中含有无效号码或不在规定的号段.");
        smsResultMapping.put(7, "非法关键字.");
        smsResultMapping.put(8, "内容长度超过上限,最大402字符.");
        smsResultMapping.put(9, "接受号码过多,最大1000.");
        smsResultMapping.put(11, "提交速度太快.");
        smsResultMapping.put(12, "您尚未订购[普通短信业务]，暂不能发送该类信息.");
        smsResultMapping.put(13, "您的[普通短信业务]剩余数量发送不足,暂不能发送该类信息.");
        smsResultMapping.put(14, "流水号格式不正确.");
        smsResultMapping.put(15, "流水号重复.");
        smsResultMapping.put(16, "超出发送上限（操作员帐户当日发送上限）.");
        smsResultMapping.put(17, "余额不足.");
        smsResultMapping.put(18, "扣费不成功.");
        smsResultMapping.put(20, "发送失败.");
        smsResultMapping.put(24, "账户状态不正常.");
        smsResultMapping.put(25, "账户权限不足.");
        smsResultMapping.put(26, "需要人工审核.");
        smsResultMapping.put(28, "发送内容与模板不符.");
        smsResultMapping.put(29, "扩展号太长或不是数字&accnum=.");
        smsResultMapping.put(32, "同一号码相同内容发送次数太多.");
    }
}
