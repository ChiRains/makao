package com.qcloud.component.snakerext.web.event;

import java.util.List;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.form.EventContext;
import com.qcloud.component.form.FormEvent;
import com.qcloud.component.organization.OrganizationClient;
import com.qcloud.component.organization.QClerk;
import com.qcloud.component.processtask.ProcesstaskClient;
import com.qcloud.component.processtask.QTask;

@Component
public class SendNextActivityTipEvent implements FormEvent {

    @Autowired
    ProcesstaskClient  processtaskClient;

    @Autowired
    OrganizationClient organizationClient;

    @Override
    public void doEvent(FormEventType type, EventContext context) {

        String nextTip = "";
        if (FormEventType.SAVE_AFTER.equals(type)) {
            if (Boolean.valueOf((String) context.getParameterMap().get(EventContext.SAVE_SENDED))) {
                String taskKey = (String) context.getParameter("Next-Task-Key");
                if (StringUtils.isNotEmpty(taskKey)) {
                    String[] keys = taskKey.split(";");
                    for (String str : keys) {
                        List<Long> list = (List<Long>) context.getParameter(str);
                        if (CollectionUtils.isNotEmpty(list)) {
                            for (Long taskId : list) {
                                QTask task = processtaskClient.getTask(taskId);
                                if (task != null && task.isTasking()) {
                                    Long clerkId = task.getClerk();
                                    QClerk clerk = organizationClient.getClerk(clerkId);
                                    nextTip += clerk.getName() + ";";
                                }
                            }
                        }
                    }
                }
            }
        } else if (FormEventType.SUBMIT_AFTER.equals(type)) {
            String taskKey = (String) context.getParameter("Next-Task-Key");
            if (StringUtils.isNotEmpty(taskKey)) {
                String[] keys = taskKey.split(";");
                for (String str : keys) {
                    List<Long> list = (List<Long>) context.getParameter(str);
                    if (CollectionUtils.isNotEmpty(list)) {
                        for (Long taskId : list) {
                            QTask task = processtaskClient.getTask(taskId);
                            if (task != null && task.isTasking()) {
                                nextTip += task.getName() + ";";
                            }
                        }
                    }
                }
            } else {
                List<Long> list = (List<Long>) context.getParameter("Process-Task-Next-List");
                if (CollectionUtils.isNotEmpty(list)) {
                    for (Long taskId : list) {
                        QTask task = processtaskClient.getTask(taskId);
                        if (task != null && task.isTasking()) {
                            Long clerkId = task.getClerk();
                            QClerk clerk = organizationClient.getClerk(clerkId);
                            nextTip += clerk.getName() + ";";
                        }
                    }
                }
            }
        }
        if (StringUtils.isNotEmpty(nextTip)) {
            nextTip = "流程已经发送至 " + nextTip;
        }
        context.addReturnResult("Next-Task-Tip", nextTip);
    }
}
