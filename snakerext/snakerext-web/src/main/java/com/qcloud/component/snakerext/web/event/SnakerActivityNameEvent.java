package com.qcloud.component.snakerext.web.event;

import org.apache.commons.lang.StringUtils;
import org.snaker.engine.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.form.EventContext;
import com.qcloud.component.form.FormEvent;
import com.qcloud.component.snaker.ISnakerClient;
import com.qcloud.pirates.util.AssertUtil;

@Component
public class SnakerActivityNameEvent implements FormEvent {

    @Autowired
    ISnakerClient snakerClient;

    @Override
    public void doEvent(FormEventType type, EventContext context) {

        String workitem = context.getWorkitemId();
        if (StringUtils.isEmpty(workitem)) {
            return;
        }
        Task task = snakerClient.query().getTask(workitem);
        AssertUtil.assertNotNull(task, "流程任务不存在." + workitem);
        context.addReturnResult("snaker_task_name", task.getTaskName());
    }
}
