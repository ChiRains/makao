package com.qcloud.component.snakerext.web.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.snaker.engine.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.form.EventContext;
import com.qcloud.component.form.FormEvent;
import com.qcloud.component.snaker.ISnakerClient;
import com.qcloud.pirates.util.AssertUtil;

@Component
public class SendNextActivityFormEvent implements FormEvent {

    private Log   logger = LogFactory.getLog(getClass());

    @Autowired
    ISnakerClient snakerClient;

    @Override
    public void doEvent(FormEventType type, EventContext context) {

        logger.info("SendNextActivity");
        logger.info(type);
        logger.info("FormId         " + context.getFormId());
        logger.info("FormInstId     " + context.getFormInstId());
        logger.info("FormHistId     " + context.getFormHistId());
        logger.info("ProcessId      " + context.getProcessId());
        logger.info("ProcessInstId  " + context.getProcessInstId());
        logger.info("WorkitemId     " + context.getWorkitemId());
        logger.info("TaskId         " + context.getTaskId());
        logger.info("ParameterMap   " + context.getParameterMap());
        logger.info("SendNextActivity");
        String workitemId = context.getWorkitemId();
        Map<String, Object> map = new HashMap<String, Object>();
        map.putAll(context.getParameterMap());
        AssertUtil.assertNotEmpty(workitemId, "流程任务不能为空");
        List<Task> list = snakerClient.executeTask(workitemId, String.valueOf(context.getClerkId()), map);
        List<String> workitemList = new ArrayList<String>();
        for (Task task : list) {
            workitemList.add(task.getId());
        }
        context.addReturnResult("Process-NextWorkitemList", workitemList);
    }
}
