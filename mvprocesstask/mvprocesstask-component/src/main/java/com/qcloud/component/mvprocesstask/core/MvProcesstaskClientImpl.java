package com.qcloud.component.mvprocesstask.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.mvprocesstask.model.Tasked;
import com.qcloud.component.mvprocesstask.model.Tasking;
import com.qcloud.component.mvprocesstask.service.TaskedService;
import com.qcloud.component.mvprocesstask.service.TaskingService;

@Service
public class MvProcesstaskClientImpl implements MvProcesstaskClient {

    @Autowired
    private TaskingService taskingService;

    @Autowired
    private TaskedService  taskedService;

    @Override
    public Tasking getTaskingByWorkitem(String workitemId) {

        return taskingService.getByWorkitem(workitemId);
    }

    @Override
    public Tasked getTaskedByWorkitem(String workitemId) {

        return taskedService.getByWorkitem(workitemId);
    }
}