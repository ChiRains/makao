package com.qcloud.component.mvprocesstask.core;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.form.FormClient;
import com.qcloud.component.mvprocesstask.entity.TaskEntity;
import com.qcloud.component.mvprocesstask.model.Tasked;
import com.qcloud.component.mvprocesstask.model.Tasking;
import com.qcloud.component.mvprocesstask.model.key.TypeEnum.ProcessStateType;
import com.qcloud.component.mvprocesstask.service.TaskedService;
import com.qcloud.component.mvprocesstask.service.TaskingService;
import com.qcloud.component.organization.OrganizationClient;
import com.qcloud.component.processtask.ProcesstaskClient;
import com.qcloud.component.processtask.QTask;
import com.qcloud.pirates.util.AssertUtil;

@Service
public class ProcesstaskClientImpl implements ProcesstaskClient {

    // @Autowired
    // private ISnakerClient snakerClient;
    @Autowired
    private TaskingService     taskingService;

    @Autowired
    private TaskedService      taskedService;

    @Autowired
    private FormClient         formClient;

    @Autowired
    private OrganizationClient organizationClient;

    // @Autowired
    // private FormClient formClient;
    // @Override
    // public Long createTask(Long clerkId, String processId, String name, String processInstId, String workitemId, Long formId, Long formInstId) {
    //
    // Process process = snakerClient.process().getProcessById(processId);
    // Order order = snakerClient.query().getOrder(processInstId);
    // FormDef formDef = formClient.getFormDef(formId);
    // Tasking tasking = new Tasking();
    // tasking.setApplyTime(DateUtil.str2Date(order.getCreateTime()));
    // tasking.setCreator(Long.parseLong(order.getCreator()));
    // tasking.setName(name);
    // tasking.setClerkId(clerkId);
    // tasking.setType(process.getType());
    // tasking.setFormId(formId);
    // tasking.setFormInstanceId(formInstId);
    // tasking.setProcessId(processId);
    // tasking.setProcessInstId(processInstId);
    // tasking.setWorkitemId(workitemId);
    // tasking.setPcPageUrl(formDef.getPcPageUrl());
    // taskingService.add(tasking);
    // return tasking.getId();
    // }
    @Override
    public Long doTask(Long taskId, Long formHistId, boolean pass) {

        // TODO
        Tasking tasking = taskingService.get(taskId);
        AssertUtil.assertNotNull(tasking, "待办任务不存在" + taskId);
        Tasked tasked = new Tasked();
        tasked.setTaskingId(tasking.getId());
        tasked.setType(tasking.getType());
        tasked.setClerkId(tasking.getClerkId());
        tasked.setDepartmentId(tasking.getDepartmentId());
        tasked.setName(tasking.getName());
        tasked.setFormId(tasking.getFormId());
        tasked.setFormInstanceId(tasking.getFormInstanceId());
        String formInstCode = formClient.getFormInstCode(tasking.getFormInstanceId());
        tasked.setFormInstCode(formInstCode);
        tasked.setFormInstanceHistId(formHistId);
        tasked.setProcessId(tasking.getProcessId());
        tasked.setProcessInstId(tasking.getProcessInstId());
        tasked.setWorkitemId(tasking.getWorkitemId());
        tasked.setCreator(tasking.getCreator());
        tasked.setApplyTime(tasking.getApplyTime());
        tasked.setReceiveTime(tasking.getReceiveTime());
        tasked.setPcPageUrl(tasking.getPcPageUrl());
        //
        tasked.setCode(tasking.getCode());
        tasked.setCompanyName(tasking.getCompanyName());
        tasked.setCompanyCode(tasking.getCompanyCode());
        tasked.setApplyType(tasking.getApplyType());
        tasked.setClerkType(tasking.getClerkType());
        tasked.setIdCard(tasking.getIdCard());
        tasked.setPlateNumber(tasking.getPlateNumber());
        //
        tasked.setIndicatorsNo(tasking.getIndicatorsNo());
        tasked.setIndicatorsTime(tasking.getIndicatorsTime());
        tasked.setIndicatorsPeriod(tasking.getIndicatorsPeriod());
        //
        tasked.setOwnerName(tasking.getOwnerName());
        tasked.setVehicleType(tasking.getVehicleType());
        tasked.setSpecification(tasking.getSpecification());
        tasked.setEngineNo(tasking.getEngineNo());
        tasked.setFrameNumber(tasking.getFrameNumber());
        tasked.setPermittedWeight(tasking.getPermittedWeight());
        tasked.setPassengers(tasking.getPassengers());
        tasked.setBrand(tasking.getBrand());
        //
        tasked.setStatus(pass ? ProcessStateType.PASS.getKey() : ProcessStateType.REFUSE.getKey());
        // tasking.getClerkId()后面修改成部门的形式，不能采用此代码.
        tasked.setOperatorClerkId(tasking.getClerkId());
        tasked.setRecordTime(new Date());
        tasked.setTemporaryplate(tasking.getTemporaryplate());
        taskedService.add(tasked);
        taskingService.delete(tasking.getId());
        return tasked.getId();
    }

    @Override
    public QTask getTask(Long id) {

        Tasking tasking = taskingService.get(id);
        TaskEntity taskEntity = new TaskEntity();
        if (tasking == null) {
            Tasked tasked = taskedService.get(id);
            if (tasked == null) {
                return null;
            } else {
                taskEntity.setClerk(tasked.getClerkId());
                taskEntity.setFormInstance(tasked.getFormInstanceId());
                taskEntity.setName(tasked.getName());
                taskEntity.setTasking(false);
                taskEntity.setWorkitem(tasked.getWorkitemId());
            }
        } else {
            taskEntity.setClerk(tasking.getClerkId());
            taskEntity.setFormInstance(tasking.getFormInstanceId());
            taskEntity.setName(tasking.getName());
            taskEntity.setTasking(true);
            taskEntity.setWorkitem(tasking.getWorkitemId());
        }
        return taskEntity;
    }

    @Override
    public List<QTask> listTaskedByProcessInst(String processInstId) {

        List<QTask> qList = new ArrayList<QTask>();
        List<Tasked> list = taskedService.listTaskedByProcessInst(processInstId);
        for (Tasked tasked : list) {
            qList.add(taskedToEntity(tasked));
        }
        return qList;
    }

    @Override
    public QTask getTaskByWorkitem(String workitemId) {

        Tasking tasking = taskingService.getByWorkitem(workitemId);
        if (tasking == null) {
            Tasked tasked = taskedService.getByWorkitem(workitemId);
            if (tasked == null) {
                return null;
            } else {
                return taskedToEntity(tasked);
            }
        } else {
            return taskingToEntity(tasking);
        }
    }

    private TaskEntity taskedToEntity(Tasked tasked) {

        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setClerk(tasked.getClerkId());
        taskEntity.setFormInstance(tasked.getFormInstanceId());
        taskEntity.setName(tasked.getName());
        taskEntity.setTasking(false);
        taskEntity.setWorkitem(tasked.getWorkitemId());
        taskEntity.setDoneTime(tasked.getDealTime());
        taskEntity.setPass(ProcessStateType.PASS.getKey() == tasked.getTaskState());
        return taskEntity;
    }

    private TaskEntity taskingToEntity(Tasking tasking) {

        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setClerk(tasking.getClerkId());
        taskEntity.setFormInstance(tasking.getFormInstanceId());
        taskEntity.setName(tasking.getName());
        taskEntity.setTasking(true);
        taskEntity.setWorkitem(tasking.getWorkitemId());
        taskEntity.setDoneTime(null);
        taskEntity.setPass(ProcessStateType.PASS.getKey() == ProcessStateType.PASS.getKey());
        return taskEntity;
    }

    @Override
    public boolean updateTaskedProcessStateByProcessInst(String processInstId, boolean pass) {

        List<Tasked> list = taskedService.listTaskedByProcessInst(processInstId);
        for (Tasked tasked : list) {
            tasked.setProcessState(pass ? ProcessStateType.PASS.getKey() : ProcessStateType.REFUSE.getKey());
            taskedService.update(tasked);
        }
        return true;
    }
}