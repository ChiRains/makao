package cn.com.flaginfo.ws;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.axis2.AxisFault;
import org.apache.axis2.transport.http.HTTPConstants;


public class Test {

	public static SmsStub stub = null;
	
	static{
		try {
			stub = new SmsStub("http://localhost:8896/sms/services/Sms?wsdl");//高并发时注意使用单实例
			stub._getServiceClient().getOptions().setProperty(HTTPConstants.REUSE_HTTP_CLIENT, true);//高并发时设置成true
		} catch (AxisFault e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
			//发送接口,高并发请采用多线程提交
			SmsStub.Sms sms0 = new SmsStub.Sms();
			sms0.setIn0("004811");//企业编号
			sms0.setIn1("admin");//登录名
			sms0.setIn2("111111");//密码
			sms0.setIn3("20");//短信内容
			sms0.setIn4("18616330318");//手机号码
			sms0.setIn5("000"+format.format(new Date()));
			sms0.setIn6("20130424180000");
			sms0.setIn7("1");
			sms0.setIn8("");
			sms0.setIn9("01");
			SmsStub.SmsResponse resp;
			try {
				resp = stub.Sms(sms0);
				stub.cleanup();//使用完后cleanup
				System.out.println(resp.getOut());
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			
			

			
		
	}
}
