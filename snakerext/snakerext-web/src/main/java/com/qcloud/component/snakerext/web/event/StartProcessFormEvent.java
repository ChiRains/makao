package com.qcloud.component.snakerext.web.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.snaker.engine.access.QueryFilter;
import org.snaker.engine.entity.Order;
import org.snaker.engine.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.form.EventContext;
import com.qcloud.component.form.FormEvent;
import com.qcloud.component.snaker.ISnakerClient;
import com.qcloud.pirates.util.AssertUtil;

@Component
public class StartProcessFormEvent implements FormEvent {

    private Log           logger = LogFactory.getLog(getClass());

    @Autowired
    private ISnakerClient snakerClient;

    @Override
    public void doEvent(FormEventType type, EventContext context) {

        logger.info("StartProcess");
        logger.info(type);
        logger.info("FormId         " + context.getFormId());
        logger.info("FormInstId     " + context.getFormInstId());
        logger.info("FormHistId     " + context.getFormHistId());
        logger.info("ProcessId      " + context.getProcessId());
        logger.info("ProcessInstId  " + context.getProcessInstId());
        logger.info("WorkitemId     " + context.getWorkitemId());
        logger.info("TaskId         " + context.getTaskId());
        logger.info("ParameterMap   " + context.getParameterMap());
        logger.info("StartProcess");
        String processInstId = context.getProcessInstId();
        if (StringUtils.isEmpty(processInstId)) {
            String processId = context.getProcessId();
            AssertUtil.assertNotEmpty(processId, "流程ID不能为空.");
            Map<String, Object> map = new HashMap<String, Object>();
            map.putAll(context.getParameterMap());
            Order order = snakerClient.startInstanceById(processId, String.valueOf(context.getClerkId()), map);
            List<Task> tasks = snakerClient.query().getActiveTasks(new QueryFilter().setOrderId(order.getId()));
            if (tasks != null && tasks.size() > 0) {
                Task task = tasks.get(0);
                List<String> workitemList = new ArrayList<String>();
                workitemList.add(task.getId());
                context.addReturnResult(EventContext.WORKITEM_ID, task.getId());
                context.addReturnResult("Process-NextWorkitemList", workitemList);
            }
            context.addReturnResult(EventContext.PROCESS_INST_ID, order.getId());
        } else {
            Order order = snakerClient.query().getOrder(processInstId);
            AssertUtil.assertNotNull(order, "流程实例不为空,但是流程实例不存在." + processInstId);
            Task task = snakerClient.query().getTask(context.getWorkitemId());
            AssertUtil.assertNotNull(task, "流程任务不存在." + context.getWorkitemId());
        }
    }
}
