package com.qcloud.project.macaovehicle.web.controller.test;

import java.util.HashMap;
import java.util.Map;
import com.qcloud.pirates.util.HttpUtils;


public class VehicleTest {
    static String uri = "http://127.0.0.1:8081";

    public static void main(String[] args) {

   add();
   // list();
    
//    get();
    //detete();
 }



 private static void detete() {

         Map<String, String> map = new HashMap<String, String>();   
         map.put("id", "1010012000010201");
         System.out.println(HttpUtils.doPost(uri + "/vehicle/delete.do?format=true",map));
       
    }



private static void get() {
     Map<String, String> map = new HashMap<String, String>();   
     map.put("id", "1010012000010602");
     System.out.println(HttpUtils.doPost(uri + "/vehicle/get.do?format=true",map));
    }



private static void list() {

     Map<String, String> map = new HashMap<String, String>();        
     map.put("plateNumber", "A87777");
     map.put("models","1");
     map.put("licenseNumber","A89999d000111");
     map.put("carOwnerId","1010012000010402");
     System.out.println(HttpUtils.doPost(uri + "/vehicle/list.do?format=true",map));

    }



private static void add() {
     Map<String, String> map = new HashMap<String, String>();
     map.put("carOwnerId", "1010012000010801");
     map.put("plateNumber", "A877774");
     map.put("licenseNumber","A89999d000111");
     map.put("licenseImage","2F19057B76C04ED39351AA5C328E0972");
     map.put("specification","C111");
     map.put("brand","宝马");
     map.put("models","1");
     map.put("ownerName","美丽");
     map.put("ownerPhone","13726542369");
     map.put("authority","澳门");
     map.put("buyTime","2011-10-10 12:10:22");
     map.put("ownerAddress","珠海市香洲区拱北莲花路11号");
     map.put("engineNumber","1");
     map.put("frameNumber","2");
     map.put("steeringWheel","2");
     map.put("startTime","2011-10-10 12:10:22");
     
     map.put("weight","12");
     map.put("length","34");
     map.put("height","1");
     map.put("width","3");
     map.put("color","红色");
     map.put("type","1");
     map.put("seat","4");
     map.put("backupWheel","2");
     map.put("faceWheel","2");
     map.put("backWheel","2");
     map.put("registTime","2011-10-10 12:10:22");
     map.put("faceImage","2F19057B76C04ED39351AA5C328E0972");
     map.put("leftfaceImage","2F19057B76C04ED39351AA5C328E0972");
     map.put("rightfaceImage","2F19057B76C04ED39351AA5C328E0972");
     map.put("leftbackImage","2F19057B76C04ED39351AA5C328E0972");
     map.put("rightbackImage","2F19057B76C04ED39351AA5C328E0972");
     
     System.out.println(HttpUtils.doPost(uri + "/vehicle/add.do?format=true",map));
       
   }

}
