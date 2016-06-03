package com.qcloud.component.processtask.core;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.processtask.ProcesstaskClient;
import com.qcloud.component.processtask.QTask;
import com.qcloud.component.processtask.entity.TaskEntity;
import com.qcloud.component.processtask.model.Tasked;
import com.qcloud.component.processtask.model.Tasking;
import com.qcloud.component.processtask.model.key.TypeEnum.ProcessStateType;
import com.qcloud.component.processtask.service.TaskedService;
import com.qcloud.component.processtask.service.TaskingService;
import com.qcloud.pirates.util.AssertUtil;

@Service
public class ProcesstaskClientImpl implements ProcesstaskClient {

    @Autowired
    private TaskingService taskingService;

    @Autowired
    private TaskedService  taskedService;

    @Override
    public Long doTask(Long taskId, Long formHistId, boolean pass) {

        Tasking tasking = taskingService.get(taskId);
        AssertUtil.assertNotNull(tasking, "待办任务不存在" + taskId);
        Tasked tasked = new Tasked();
        tasked.setTaskingId(tasking.getId());
        tasked.setType(tasking.getType());
        tasked.setClerkId(tasking.getClerkId());
        tasked.setName(tasking.getName());
        tasked.setFormId(tasking.getFormId());
        tasked.setFormInstanceId(tasking.getFormInstanceId());
        tasked.setFormInstanceHistId(formHistId);
        tasked.setProcessId(tasking.getProcessId());
        tasked.setProcessInstId(tasking.getProcessInstId());
        tasked.setWorkitemId(tasking.getWorkitemId());
        tasked.setCreator(tasking.getCreator());
        tasked.setApplyTime(tasking.getApplyTime());
        tasked.setReceiveTime(tasking.getReceiveTime());
        tasked.setPcPageUrl(tasking.getPcPageUrl());
        tasked.setMobilePageUrl(tasking.getMobilePageUrl());
        tasked.setCreatorName(tasking.getCreatorName());
        tasked.setDepartmantName(tasking.getDepartmantName());
        tasked.setProcessName(tasking.getProcessName());
        tasked.setProcessState(ProcessStateType.DOING.getKey());
        tasked.setTaskState(pass ? ProcessStateType.PASS.getKey() : ProcessStateType.REFUSE.getKey());
        tasked.setStart(tasking.getStart());
        taskedService.add(tasked);
        taskingService.delete(tasking.getId());
        return tasked.getId();
    }

    @Override
    public QTask getTask(Long id) {

        Tasking tasking = taskingService.get(id);
        if (tasking == null) {
            Tasked tasked = taskedService.get(id);
            if (tasked == null) {
                return null;
            } else {
                return taskedToEntity(tasked);
            }
        } else {
            return taskingToEntity(tasking);
        }
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