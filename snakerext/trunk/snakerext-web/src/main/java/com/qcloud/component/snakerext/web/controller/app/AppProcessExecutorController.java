//package com.qcloud.component.snakerext.web.controller.app;
//
//import javax.servlet.http.HttpServletRequest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import com.qcloud.component.snakerext.web.controller.ProcessExecutorController;
//import com.qcloud.pirates.mvc.FrontAjaxView;
//
//@Controller
//@RequestMapping(value = AppProcessExecutorController.DIR)
//public class AppProcessExecutorController {
//
//    public static final String DIR = "/app/processExecutor";
//
//    @Autowired
//    ProcessExecutorController  processExecutorController;
//
//    @RequestMapping
//    public FrontAjaxView listNextExecutors(HttpServletRequest request, Long taskId) {
//
//        return processExecutorController.listNextExecutors(request, taskId);
//    }
//}
