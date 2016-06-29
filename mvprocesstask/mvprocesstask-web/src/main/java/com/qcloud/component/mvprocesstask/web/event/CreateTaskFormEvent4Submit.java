package com.qcloud.component.mvprocesstask.web.event;

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
import com.qcloud.component.mvprocesstask.exception.MvprocesstaskException;
import com.qcloud.component.mvprocesstask.model.Tasking;
import com.qcloud.component.mvprocesstask.service.TaskingService;
import com.qcloud.component.organization.OrganizationClient;
import com.qcloud.component.organization.QClerk;
import com.qcloud.component.snaker.ISnakerClient;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.DateUtil;

@Component
public class CreateTaskFormEvent4Submit implements FormEvent {

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
        logger.info("Vehicle.qc_inner_number" + context.getParameterMap().get("vehicle.qc_inner_number"));
        logger.info("Person.qc_inner_number" + context.getParameterMap().get("person.qc_inner_number"));
        logger.info("Workers.qc_inner_number" + context.getParameterMap().get("workers.qc_inner_number"));
        logger.info("Housers.qc_inner_number" + context.getParameterMap().get("housers.qc_inner_number"));
        logger.info("Enterprisers.qc_inner_number" + context.getParameterMap().get("enterprisers.qc_inner_number"));
        logger.info("Driver.qc_inner_number" + context.getParameterMap().get("driver.qc_inner_number"));
        logger.info("Talent.qc_inner_number" + context.getParameterMap().get("talent.qc_inner_number"));
        logger.info("Purchase.qc_inner_number" + context.getParameterMap().get("purchase.qc_inner_number"));
        logger.info("CreateTask");
        List<String> workitemList = (List<String>) context.getParameter("Process-NextWorkitemList");
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
                // 如果performType = any 则只允许选择一个执行人,如果performType = all 允许多选,全部任务都执行了才往下走
                String[] actors = snakerClient.query().getTaskActorsByTaskId(workitemId);
                if (actors == null) {
                    throw new MvprocesstaskException("任务执行人不能为空.");
                }
                if (actors.length > 1) {
                    StringBuffer sb = new StringBuffer();
                    for (String str : actors) {
                        sb.append(str).append(";");
                    }
                    throw new MvprocesstaskException("任务执行人不能为空只能是一个." + sb.toString());
                }
                Long actor = Long.parseLong(actors[0]);
                FormDef formDef = formClient.getFormDef(formId);
                Tasking tasking = new Tasking();
                tasking.setApplyTime(DateUtil.str2Date(order.getCreateTime()));
                tasking.setCreator(Long.parseLong(order.getCreator()));
                tasking.setName(clerk.getName() + "的【" + process.getDisplayName() + "】");
                tasking.setClerkId(actor);
                QClerk actorClerk = organizationClient.getClerk(actor);
                tasking.setDepartmentId(actorClerk.getDepartmentId());
                tasking.setType(process.getType());
                tasking.setFormId(formId);
                tasking.setFormInstanceId(formInstId);
                tasking.setProcessId(processId);
                tasking.setProcessInstId(processInstId);
                tasking.setWorkitemId(workitemId);
                tasking.setPcPageUrl(formDef.getPcPageUrl());
                String formInstCode = formClient.getFormInstCode(tasking.getFormInstanceId());
                tasking.setFormInstCode(formInstCode);
                //
                Integer personType = (Integer) context.getParameter("type");
                AssertUtil.assertNotNull(personType, "申请类型不能为空.");
                AssertUtil.assertTrue(personType == 1 || personType == 2 || personType == 3 || personType == 4 || personType == 5, "申请类型参数不合法." + personType);
                String typeStr = "";
                switch (personType) {
                case 1:
                    typeStr = "务工";
                    break;
                case 2:
                    typeStr = "购房";
                    break;
                case 3:
                    typeStr = "投资";
                    break;
                case 4:
                    typeStr = "人才";
                    break;
                case 5:
                    typeStr = "购地";
                    break;
                }
                tasking.setApplyType(typeStr);
                Integer clerkType = (Integer) context.getParameter("clerkType");
                String clerkTypeStr = "";
                String ownerName = (String) context.getParameter("vehicle[0].ownerName");
                switch (clerkType) {
                case 1:
                    clerkTypeStr = "个人";
                    tasking.setCode("--");
                    tasking.setClerkName((String) context.getParameter("person[0].name"));
                    tasking.setIdCard((String) context.getParameter("person[0].idcardNumber"));
                    tasking.setCompanyName("--");
                    tasking.setCompanyCode("--");
                    break;
                case 2:
                    clerkTypeStr = "企业";
                    tasking.setCode("--");
                    tasking.setIdCard("--");
                    ownerName = "--";
                    tasking.setCompanyName((String) context.getParameter("enterprisers[0].company"));
                    tasking.setCompanyCode((String) context.getParameter("enterprisers[0].code"));
                    break;
                default:
                    throw new MvprocesstaskException("申请类型参数不合法." + clerkType);
                }
                tasking.setClerkType(clerkTypeStr);
                tasking.setPlateNumber((String) context.getParameter("vehicle[0].plateNumber"));
                tasking.setOwnerName(ownerName);
                tasking.setVehicleType((String) context.getParameter("vehicle[0].models"));
                tasking.setSpecification((String) context.getParameter("vehicle[0].specification"));
                tasking.setEngineNo((String) context.getParameter("vehicle[0].engineNo"));
                tasking.setFrameNumber((String) context.getParameter("vehicle[0].frameNumber"));
                tasking.setPermittedWeight((String) context.getParameter("vehicle[0].permittedWeight"));
                tasking.setPassengers((String) context.getParameter("vehicle[0].passengers"));
                tasking.setBrand((String) context.getParameter("vehicle[0].brand"));
                if (context.getParameter("vehicle[0].temporaryplate") != null) {
                    tasking.setTemporaryplate((String) context.getParameter("vehicle[0].temporaryplate"));
                }
                taskingService.add(tasking);
                Long taskId = tasking.getId();
                context.addReturnResult(EventContext.TASK_ID, taskId);
            }
        }
    }
}
