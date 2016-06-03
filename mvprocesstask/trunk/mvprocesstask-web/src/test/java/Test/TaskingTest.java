package Test;

import java.util.HashMap;
import java.util.Map;
import com.qcloud.pirates.util.HttpUtils;


public class TaskingTest {

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
        map.put("idCard", "441823121112111210");
        map.put("companyName", null);
        map.put("companyCode", null);
        map.put("plateNumber", null);
        map.put("applyTimeFront", null);
        map.put("applyTimeBack",null);
      
        System.out.println(HttpUtils.doPost("http://127.0.0.1:8081" +
        		"/tasking/list.do?format=true", map));

    }
}
