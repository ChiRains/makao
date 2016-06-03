package com.qcloud.component.processtask.web.event;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.snaker.engine.entity.Order;
import org.snaker.engine.entity.Process;
import org.snaker.engine.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.form.EventContext;
import com.qcloud.component.form.FormClient;
import com.qcloud.component.form.FormEvent;
import com.qcloud.component.form.model.FormDef;
import com.qcloud.component.organization.OrganizationClient;
import com.qcloud.component.organization.QClerk;
import com.qcloud.component.organization.QDepartment;
import com.qcloud.component.processtask.exception.ProcesstaskException;
import com.qcloud.component.processtask.model.Tasking;
import com.qcloud.component.processtask.model.key.TypeEnum.TaskStartStateType;
import com.qcloud.component.processtask.service.TaskingService;
import com.qcloud.component.snaker.ISnakerClient;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.DateUtil;

@Component
public class CreateTaskFormEvent implements FormEvent {

    private Log                logger = LogFactory.getLog(getClass());

    @Autowired
    private ISnakerClient      snakerClient;

    @Autowired
    private OrganizationClient organizationClient;

    @Autowired
    private TaskingService     taskingService;

    @Autowired
    private FormClient         formClient;

    @SuppressWarnings("unchecked")
    @Override
    public void doEvent(FormEventType type, EventContext context) {

        logger.info("CreateTask");
        logger.info(type);
        logger.info("FormId         " + context.getFormId());
        logger.info("FormInstId     " + context.getFormInstId());
        logger.info("FormHistId     " + context.getFormHistId());
        logger.info("ProcessId      " + context.getProcessId());
        logger.info("ProcessInstId  " + context.getProcessInstId());
        logger.info("WorkitemId     " + context.getWorkitemId());
        logger.info("TaskId         " + context.getTaskId());
        logger.info("ParameterMap   " + context.getParameterMap());
        logger.info("CreateTask");
        List<String> workitemList = (List<String>) context.getParameter("Process-NextWorkitemList");
        List<Long> taskList = new ArrayList<Long>();
        if (workitemList != null && !workitemList.isEmpty()) {
            for (String workitemId : workitemList) {
                String processId = context.getProcessId();
                String processInstId = context.getProcessInstId();
                Long formId = context.getFormId();
                Long formInstId = context.getFormInstId();
                Process process = snakerClient.process().getProcessById(processId);
                AssertUtil.assertNotNull(process, "流程不存在" + processId);
                Order order = snakerClient.query().getOrder(context.getProcessInstId());
                Long creator = Long.parseLong(order.getCreator());
                QClerk clerk = organizationClient.getClerk(creator);
                Task task = snakerClient.query().getTask(workitemId);
                AssertUtil.assertNotNull(task, "流程任务不存在" + workitemId);
                QDepartment department = organizationClient.getDepartment(clerk.getDepartmentId());
                AssertUtil.assertNotNull(department, "部门不存在." + clerk.getDepartmentId());
                // 如果performType = any 则只允许选择一个执行人,如果performType = all 允许多选,全部任务都执行了才往下走
                String[] actors = snakerClient.query().getTaskActorsByTaskId(workitemId);
                if (actors == null) {
                    throw new ProcesstaskException("任务执行人不能为空.");
                }
                if (actors.length > 1) {
                    StringBuffer sb = new StringBuffer();
                    for (String str : actors) {
                        sb.append(str).append(";");
                    }
                    throw new ProcesstaskException("任务执行人不能为空只能是一个." + sb.toString());
                }
                Long actor = Long.parseLong(actors[0]);
                FormDef formDef = formClient.getFormDef(formId);
                TaskStartStateType start = TaskStartStateType.START;
                if ("start".equals(task.getParentTaskId())) {
                    start = TaskStartStateType.START;
                } else {
                    start = TaskStartStateType.APPROVAL;
                }
                Tasking tasking = new Tasking();
                tasking.setApplyTime(DateUtil.str2Date(order.getCreateTime()));
                tasking.setCreator(Long.parseLong(order.getCreator()));
                tasking.setName(clerk.getName() + "的【" + process.getDisplayName() + "】");
                tasking.setClerkId(actor);
                tasking.setType(process.getType());
                tasking.setFormId(formId);
                tasking.setFormInstanceId(formInstId);
                tasking.setProcessId(processId);
                tasking.setProcessInstId(processInstId);
                tasking.setWorkitemId(workitemId);
                tasking.setPcPageUrl(formDef.getPcPageUrl());
                tasking.setMobilePageUrl(formDef.getMobilePageUrl());
                tasking.setCreatorName(clerk.getName());
                tasking.setDepartmantName(department.getName());
                tasking.setProcessName(process.getDisplayName());
                tasking.setStart(start.getKey());
                taskingService.add(tasking);
                Long taskId = tasking.getId();
                taskList.add(taskId);
                context.addReturnResult(EventContext.TASK_ID, taskId);
            }
        }
        context.addReturnResult("Process-Task-Next-List", taskList);
    }
}
