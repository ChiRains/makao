package com.qcloud.project.macaovehicle.web.extimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.mvprocesstask.web.handler.TaskedGetter;
import com.qcloud.project.macaovehicle.model.TaskingBorder;
import com.qcloud.project.macaovehicle.model.TaskingCiq;
import com.qcloud.project.macaovehicle.model.TaskingCustoms;
import com.qcloud.project.macaovehicle.service.TaskingBorderService;
import com.qcloud.project.macaovehicle.service.TaskingCiqService;
import com.qcloud.project.macaovehicle.service.TaskingCustomsService;

@Component
public class TaskedGetterImpl implements TaskedGetter {

    @Autowired
    private TaskingBorderService  taskingBorderService;

    @Autowired
    private TaskingCiqService     taskingCiqService;

    @Autowired
    private TaskingCustomsService taskingCustomsService;

    @Override
    public int getBorderStatus(long formInstanceId) {

        TaskingBorder taskingBorder = taskingBorderService.getByFormInstanceId(formInstanceId);
        return taskingBorder != null ? taskingBorder.getBorderStatus() : 0;
    }

    @Override
    public int getCiqStatus(long formInstanceId) {

        TaskingCiq taskingCiq = taskingCiqService.getByFormInstanceId(formInstanceId);
        return taskingCiq != null ? taskingCiq.getCiqStatus() : 0;
    }

    @Override
    public int getCustomsStatus(long formInstanceId) {

        TaskingCustoms taskingCustoms = taskingCustomsService.getByFormInstanceId(formInstanceId);
        return taskingCustoms != null ? taskingCustoms.getCustomsStatus() : 0;
    }
}
