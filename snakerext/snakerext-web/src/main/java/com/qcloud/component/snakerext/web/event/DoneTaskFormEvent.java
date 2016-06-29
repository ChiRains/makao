package com.qcloud.component.snakerext.web.event;

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
import com.qcloud.component.form.web.event.NotionFillEvent;
import com.qcloud.component.processtask.ProcesstaskClient;
import com.qcloud.component.processtask.QTask;
import com.qcloud.component.snaker.ISnakerClient;
import com.qcloud.component.snakerext.service.ProcessExecutorService;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.StringUtil;

@Component
public class DoneTaskFormEvent implements FormEvent {

    private Log            logger = LogFactory.getLog(getClass());

    @Autowired
    ISnakerClient          snakerClient;

    @Autowired
    ProcesstaskClient      processtaskClient;

    @Autowired
    ProcessExecutorService processExecutorService;

    @Override
    public void doEvent(FormEventType type, EventContext context) {

        logger.info("DoneTask");
        logger.info(type);
        logger.info("FormId         " + context.getFormId());
        logger.info("FormInstId     " + context.getFormInstId());
        logger.info("FormHistId     " + context.getFormHistId());
        logger.info("ProcessId      " + context.getProcessId());
        logger.info("ProcessInstId  " + context.getProcessInstId());
        logger.info("WorkitemId     " + context.getWorkitemId());
        logger.info("TaskId         " + context.getTaskId());
        logger.info("ParameterMap   " + context.getParameterMap());
        logger.info("DoneTask");
        Long taskId = context.getTaskId();
        AssertUtil.assertNotNull(taskId, "待办任务不能为空");
        Long formHistId = context.getFormHistId();
        AssertUtil.assertNotNull(formHistId, "表单历史不能为空");
        //
        QTask t = processtaskClient.getTask(context.getTaskId());
        Task st = snakerClient.query().getTask(context.getWorkitemId());
        AssertUtil.assertNotNull(st, "流程任务不存在." + t.getWorkitem());
        Order order = snakerClient.query().getOrder(st.getOrderId());
        AssertUtil.assertNotNull(order, "流程实例不存在." + st.getOrderId());
        Process process = snakerClient.process().getProcessById(order.getProcessId());
        AssertUtil.assertNotNull(process, "流程定义不存在." + order.getProcessId());
        boolean end = processExecutorService.isEndProcessActivity(process, st, t);
        context.addReturnResult("Process-End-Activity", end);
        //
        boolean pass = false;
        if ("start".equals(st.getParentTaskId())) {
            pass = true;
        } else {
            String notionCode = NotionFillEvent.getNotionName(st.getTaskName(), context.getFormCode());
            if (StringUtils.isNotEmpty(notionCode)) {
                int result = context.getNotionResult(notionCode);
                pass = result == 1;
            } else {
                pass = true;
            }
        }
        Long taskedId = processtaskClient.doTask(taskId, formHistId, pass, context.getClerkId());
        context.addReturnResult(EventContext.TASKED_ID, taskedId);
    }
}
