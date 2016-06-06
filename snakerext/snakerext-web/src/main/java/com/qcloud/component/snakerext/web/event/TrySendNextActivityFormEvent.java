package com.qcloud.component.snakerext.web.event;

import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.snaker.engine.entity.Order;
import org.snaker.engine.entity.Process;
import org.snaker.engine.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.form.EventContext;
import com.qcloud.component.form.FormEvent;
import com.qcloud.component.form.engine.FormEngineService;
import com.qcloud.component.form.entity.EventContextEntity;
import com.qcloud.component.form.entity.MainForm;
import com.qcloud.component.form.model.FormInstance;
import com.qcloud.component.form.model.FormInstanceHist;
import com.qcloud.component.form.service.FormInstanceService;
import com.qcloud.component.organization.OrganizationClient;
import com.qcloud.component.organization.QClerk;
import com.qcloud.component.processtask.ProcesstaskClient;
import com.qcloud.component.processtask.QTask;
import com.qcloud.component.snaker.ISnakerClient;
import com.qcloud.component.snakerext.model.Executor;
import com.qcloud.component.snakerext.service.ProcessExecutorService;
import com.qcloud.pirates.util.AssertUtil;

@Component
public class TrySendNextActivityFormEvent implements FormEvent {

    private Log               logger = LogFactory.getLog(getClass());

    @Autowired
    ProcessExecutorService    processExecutorService;

    @Autowired
    OrganizationClient        organizationClient;

    @Autowired
    ProcesstaskClient         processtaskClient;

    @Autowired
    ISnakerClient             snakerClient;

    @Autowired
    SendNextActivityFormEvent sendNextActivityFormEvent;

    @Autowired
    FormEngineService         formEngineService;

    @Autowired
    FormInstanceService       formInstanceService;

    @Override
    public void doEvent(FormEventType type, EventContext context) {

        boolean send = context.isSaveAndSubmit();
        logger.info("save and submit " + send);
        context.addReturnResult(EventContext.SAVE_SENDED, "false");
        if (send) {
            QClerk clerk = organizationClient.getClerk(context.getClerkId());
            QTask t = processtaskClient.getTask(context.getTaskId());
            Task task = snakerClient.query().getTask(t.getWorkitem());
            AssertUtil.assertNotNull(task, "流程任务不存在." + t.getWorkitem());
            Order order = snakerClient.query().getOrder(task.getOrderId());
            AssertUtil.assertNotNull(order, "流程实例不存在." + task.getOrderId());
            Process process = snakerClient.process().getProcessById(order.getProcessId());
            AssertUtil.assertNotNull(process, "流程定义不存在." + order.getProcessId());
            List<Executor> voList = processExecutorService.list(process, order, task, t, clerk);
            if (voList.size() == 1) {
                Executor executor = voList.get(0);
                if (executor.getExecutorList().size() == 1) {
                    logger.info("保存马上发送......");
                    EventContextEntity sc = new EventContextEntity();
                    sc.addParameter(executor.getExecutorKey(), executor.getExecutorList().get(0).getKey());
                    FormInstance formInstance = formInstanceService.get(context.getFormInstId());
                    MainForm mainForm = formEngineService.getForm(formInstance.getFormId());
                    sc.setProcessId(context.getProcessId());
                    sc.setProcessInstId(context.getProcessInstId());
                    sc.setWorkitemId(context.getWorkitemId());
                    sc.setTaskId(context.getTaskId());
                    sc.setMainForm(mainForm);
                    sc.setFormInstId(context.getFormInstId());
                    sc.setClerkId(clerk.getId());
                    sc.setDepartmentId(clerk.getDepartmentId());
                    sc.setPostId(clerk.getPostId());
                    sc.setClerkName(clerk.getName());
                    FormInstanceHist formInstanceHist = formEngineService.submit(formInstance, sc);
                    context.addReturnResult(EventContext.SAVE_SENDED, "true");
                    context.addReturnResult(EventContext.FORM_HIST_ID, formInstanceHist.getId());
                    context.addReturnResult(EventContext.TASKED_ID, sc.getTaskedId());
                    // //
                    // String key = (String) sc.getParameter("Next-Task-Key");
                    // if (StringUtils.isNotEmpty(key)) {
                    // context.addReturnResult("Next-Task-Key", key);
                    // String[] keys = key.split(";");
                    // for (String str : keys) {
                    // context.addReturnResult(key, sc.getParameter(str));
                    // }
                    // } else {
                    // context.addReturnResult("Next-Task-Key", "Next-Task-" + context.getWorkitemId());
                    // context.addReturnResult("Next-Task-" + context.getWorkitemId(), sc.getParameter("Process-Task-Next-List"));
                    // }
                    //
                    String taskKey = (String) sc.getParameter("Next-Task-Key");
                    if (StringUtils.isEmpty(taskKey)) {
                        context.addReturnResult("Next-Task-Key", "Next-Task-" + context.getWorkitemId());
                        context.addReturnResult("Next-Task-" + context.getWorkitemId(), sc.getParameter("Process-Task-Next-List"));
                    } else {
                        taskKey += ";" + "Next-Task-" + context.getWorkitemId();
                        String[] keys = taskKey.split(";");
                        context.addReturnResult("Next-Task-Key", taskKey);
                        for (String str : keys) {
                            if (("Next-Task-" + context.getWorkitemId()).equals(str)) {
                                context.addReturnResult(str, sc.getParameter("Process-Task-Next-List"));
                            } else {
                                context.addReturnResult(str, sc.getParameter(str));
                            }
                        }
                    }
                } else if (executor.getExecutorList().size() == 0 && processExecutorService.isEndProcessActivity(process, task, t)) {
                    logger.info("结束,保存马上发送......");
                    EventContextEntity sc = new EventContextEntity();
                    FormInstance formInstance = formInstanceService.get(context.getFormInstId());
                    MainForm mainForm = formEngineService.getForm(formInstance.getFormId());
                    sc.setProcessId(context.getProcessId());
                    sc.setProcessInstId(context.getProcessInstId());
                    sc.setWorkitemId(context.getWorkitemId());
                    sc.setTaskId(context.getTaskId());
                    sc.setMainForm(mainForm);
                    sc.setFormInstId(context.getFormInstId());
                    sc.setClerkId(clerk.getId());
                    sc.setDepartmentId(clerk.getDepartmentId());
                    sc.setPostId(clerk.getPostId());
                    sc.setClerkName(clerk.getName());
                    FormInstanceHist formInstanceHist = formEngineService.submit(formInstance, sc);
                    context.addReturnResult(EventContext.SAVE_SENDED, "true");
                    context.addReturnResult(EventContext.FORM_HIST_ID, formInstanceHist.getId());
                    context.addReturnResult(EventContext.TASKED_ID, sc.getTaskedId());
                }
            }
        }
    }
}
