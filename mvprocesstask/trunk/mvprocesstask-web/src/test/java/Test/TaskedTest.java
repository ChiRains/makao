package Test;

import java.util.HashMap;
import java.util.Map;
import com.qcloud.pirates.util.HttpUtils;


public class TaskedTest {

    /**
     * @param args
     */
    public static void main(String[] args) {

      list();
    }

    private static void list() {

        Map<String, String> map = new HashMap<String, String>();
        map.put("clerkId", "1010012000010402");
        map.put("type", null);
        map.put("name", null);
        map.put("idCard", null);
        map.put("companyName", "后");
        map.put("companyCode", null);
        map.put("plateNumber", null);
        map.put("applyTimeFront", "2015-11-01 21:32:42");
        map.put("applyTimeBack", "2015-11-05 21:32:43");
      
        System.out.println(HttpUtils.doPost("http://127.0.0.1:8081" +
        		"/tasked/list.do?format=true", map));

    }
}
