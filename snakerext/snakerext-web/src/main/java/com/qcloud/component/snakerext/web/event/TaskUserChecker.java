package com.qcloud.component.snakerext.web.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.form.EventContext;
import com.qcloud.component.form.FormEvent;
import com.qcloud.component.organization.OrganizationClient;
import com.qcloud.component.organization.QClerk;
import com.qcloud.component.processtask.ProcesstaskClient;
import com.qcloud.component.processtask.QTask;
import com.qcloud.component.snakerext.exception.SnakerExtException;
import com.qcloud.pirates.util.AssertUtil;

@Component
public class TaskUserChecker implements FormEvent {

    @Autowired
    private ProcesstaskClient  processtaskClient;

    @Autowired
    private OrganizationClient organizationClient;

    @Override
    public void doEvent(FormEventType type, EventContext context) {

        Long taskId = context.getTaskId();
        if (taskId == null || taskId <= 0) {
            return;
        }
        QTask task = processtaskClient.getTask(taskId);
        if (task == null) {
            throw new SnakerExtException("待办任务不存在." + taskId);
        }
        if (!task.isTasking()) {
            throw new SnakerExtException("已办任务不允许操作数据." + taskId);
        }
        if (task.getClerk().longValue() != context.getClerkId()) {
            QClerk clerk = organizationClient.getClerk(task.getClerk());
            AssertUtil.assertNotNull(clerk, "用户不存在." + task.getClerk());
            throw new SnakerExtException("不允许处理其他用户的待办表单数据." + clerk.getName());
        }
    }
}
