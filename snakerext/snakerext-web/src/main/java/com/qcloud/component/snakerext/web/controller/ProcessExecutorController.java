package com.qcloud.component.snakerext.web.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import org.snaker.engine.entity.Order;
import org.snaker.engine.entity.Process;
import org.snaker.engine.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qcloud.component.organization.QClerk;
import com.qcloud.component.organization.web.helper.ClerkHelper;
import com.qcloud.component.processtask.ProcesstaskClient;
import com.qcloud.component.processtask.QTask;
import com.qcloud.component.publicdata.KeyValueVO;
import com.qcloud.component.snaker.ISnakerClient;
import com.qcloud.component.snakerext.model.Executor;
import com.qcloud.component.snakerext.service.ProcessExecutorService;
import com.qcloud.pirates.mvc.FrontAjaxView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.Base64;
import com.qcloud.pirates.web.mvc.annotation.PiratesApp;

@Controller
@RequestMapping(value = ProcessExecutorController.DIR)
public class ProcessExecutorController {

    public static final String     DIR = "/processExecutor";

    @Autowired
    private ISnakerClient          snakerClient;

    @Autowired
    private ProcesstaskClient      processtaskClient;

    @Autowired
    private ProcessExecutorService processExecutorService;

    @Autowired
    private ClerkHelper            clerkHelper;

    @PiratesApp
    @RequestMapping
    public FrontAjaxView listNextExecutors(HttpServletRequest request, Long taskId) {

        QClerk clerk = clerkHelper.getClerkModel(request);
        return listNextExecutors(request, clerk, taskId);
    }

    @RequestMapping
    public FrontAjaxView listNextExecutors4Token(HttpServletRequest request, Long taskId, String userToken) {

        AssertUtil.assertNotEmpty(userToken, "用户token不能为空.");
        String appToken = Base64.decode(userToken);
        QClerk clerk = clerkHelper.getClerkModel(appToken);
        AssertUtil.assertNotNull(clerk, "用户不存在.");
        return listNextExecutors(request, clerk, taskId);
    }

    private FrontAjaxView listNextExecutors(HttpServletRequest request, QClerk clerk, Long taskId) {

        QTask t = processtaskClient.getTask(taskId);
        AssertUtil.assertNotNull(t, "任务不存在.");
        AssertUtil.assertTrue(t.isTasking(), "任务已办." + t.getName() + "[" + taskId + "]");
        Task task = snakerClient.query().getTask(t.getWorkitem());
        AssertUtil.assertNotNull(task, "流程任务不存在." + t.getWorkitem());
        Order order = snakerClient.query().getOrder(task.getOrderId());
        AssertUtil.assertNotNull(order, "流程实例不存在." + task.getOrderId());
        Process process = snakerClient.process().getProcessById(order.getProcessId());
        AssertUtil.assertNotNull(process, "流程定义不存在." + order.getProcessId());
        List<Executor> list = processExecutorService.list(process, order, task, t, clerk);
        //
        List<KeyValueVO> voList = new ArrayList<KeyValueVO>();
        Set<String> keySet = new HashSet<String>();
        for (Executor executor : list) {
            for (KeyValueVO keyValue : executor.getExecutorList()) {
                if (!keySet.contains(keyValue.getKey())) {
                    keySet.add(keyValue.getKey());
                    voList.add(keyValue);
                }
            }
            executor.setExecutorList(voList);
        }
        AssertUtil.assertNotEmpty(list, "获取下一步流程任务失败." + t.getWorkitem());
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("获取下一步执行人成功.");
        view.addObject("executorList", list);
        return view;
    }
}
