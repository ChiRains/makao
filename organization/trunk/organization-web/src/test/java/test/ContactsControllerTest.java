package test;

import java.util.HashMap;
import java.util.Map;


import com.qcloud.pirates.util.HttpUtils;


public class ContactsControllerTest {
	  static String uri = "http://127.0.0.1";

		 public static void main(String[] args) {
//testd();
//departmentKeyValue();
	testList();
	// export();
	  }


	  private static void departmentKeyValue() {
		  
	      System.out.println(HttpUtils.doPost(uri + "/app/contacts/departmentKeyValue.do?format=true"));
			
		}

		public static void testd() {

		      Map<String, String> map = new HashMap<String, String>();
		      map.put("name",null);
		      map.put("departmentId",null);
		      System.out.println(HttpUtils.doPost(uri + "/app/contacts/list.do?format=true", map));
		  }
		
	public static void testList() {

	      Map<String, String> map = new HashMap<String, String>();
	      map.put("name",null);
	      map.put("departmentId",null);
	      System.out.println(HttpUtils.doPost(uri + "/contacts/list.do?format=true&pageSize=2", map));
	  }
	  
	  public static void export(){
		  Map<String, String> map = new HashMap<String, String>();

	      map.put("name","索隆");
	      map.put("departmentId","1010007000001001");
	 
	      System.out.println(HttpUtils.doPost(uri + "/contacts/export.do?format=true&pageSize=2", map));
	  }
}
