package com.qcloud.component.snakerext.web.event;

import java.util.HashMap;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.form.EventContext;
import com.qcloud.component.form.FormEvent;
import com.qcloud.component.form.entity.EventContextEntity;
import com.qcloud.component.form.web.form.Form;
import com.qcloud.component.form.web.form.NotionForm;
import com.qcloud.component.form.web.helper.FormSaverHelper;
import com.qcloud.component.organization.OrganizationClient;
import com.qcloud.component.organization.QClerk;
import com.qcloud.component.processtask.ProcesstaskClient;
import com.qcloud.component.processtask.QTask;
import com.qcloud.component.snaker.ISnakerClient;
import com.qcloud.component.snakerext.service.ProcessExecutorService;

// 办理完后 如果下一步执行人只有一个并且已经办理过了,那么继续发送处理
@Component
public class TrySendNextContinueFormEvent implements FormEvent {

    private Log                    logger = LogFactory.getLog(getClass());

    @Autowired
    private ProcesstaskClient      processtaskClient;

    @Autowired
    private ProcessExecutorService processExecutorService;

    @Autowired
    private OrganizationClient     organizationClient;

    @Autowired
    private ISnakerClient          snakerClient;

    @Autowired
    private FormSaverHelper        formSaverHelper;

    @Override
    public void doEvent(FormEventType type, EventContext context) {

        logger.info("save and submit continue ");
        List<Long> taskList = (List<Long>) context.getParameter("Process-Task-Next-List");
        if (CollectionUtils.isNotEmpty(taskList)) {
            String processInstId = context.getProcessInstId();
            List<QTask> taskedList = processtaskClient.listTaskedByProcessInst(processInstId);
            for (Long key : taskList) {
                QTask tasking = processtaskClient.getTask(key);
                if (!tasking.isTasking()) {
                    return;
                }
                for (QTask qTask : taskedList) {
                    // 已经处理过
                    if (qTask.getClerk() != null && qTask.getClerk().equals(tasking.getClerk())) {
                        logger.info("done again " + qTask.getClerk() + " " + key);
                        Form form = new Form();
                        form.setFormId(context.getFormId());
                        form.setFormInstanceId(context.getFormInstId());
                        form.setProcessId(context.getProcessId());
                        form.setProcessInstId(context.getProcessInstId());
                        form.setWorkitemId(tasking.getWorkitem());
                        form.setTaskId(key);
                        form.setSaveAndSubmit(Boolean.TRUE.toString());
                        //
                        NotionForm notionForm = new NotionForm();
                        notionForm.setNotion_result(1);
                        notionForm.setNotion_reason("系统自动发送:通过!");
                        QClerk clerk = organizationClient.getClerk(tasking.getClerk());
                        EventContextEntity eventContextEntity = formSaverHelper.save(new HashMap<String, String>(), clerk, form, notionForm);
                        //
                        String taskKey = (String) eventContextEntity.getParameter("Next-Task-Key");
                        if (StringUtils.isNotEmpty(taskKey)) {
                            String[] keys = taskKey.split(";");
                            context.addReturnResult("Next-Task-Key", taskKey);
                            for (String str : keys) {
                                context.addReturnResult(str, eventContextEntity.getParameter(str));
                            }
                        }
                        // 发送一次足矣
                        break;
                    }
                }
            }
        }
    }
}
