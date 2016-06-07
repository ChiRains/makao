package com.qcloud.component.mvprocesstask.web.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qcloud.component.mvprocesstask.model.Tasked;
import com.qcloud.component.mvprocesstask.model.key.TypeEnum.TaskType;
import com.qcloud.component.mvprocesstask.model.query.TaskedQuery;
import com.qcloud.component.mvprocesstask.service.TaskedService;
import com.qcloud.component.mvprocesstask.web.handler.TaskedHandler;
import com.qcloud.component.organization.QClerk;
import com.qcloud.component.organization.web.helper.ClerkHelper;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.mvc.FrontPagingView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.NumberUtil;
import com.qcloud.pirates.util.RequestUtil;

@Controller
@RequestMapping(value = TaskedController.DIR)
public class TaskedController {

    public static final String DIR = "/tasked";

    @Autowired
    private TaskedService      taskedService;

    @Autowired
    private TaskedHandler      taskedHandler;

    @Autowired
    private ClerkHelper        clerkHelper;

    @RequestMapping
    public FrontPagingView list(HttpServletRequest request, TaskedQuery query, Integer pageNum, Integer pageSize, String type) {

        AssertUtil.assertTrue(checkType(type), "流程类型非法." + type);
        QClerk clerk = clerkHelper.getClerkModel(request);
        query.setDepartmentId(clerk.getDepartmentId());
        // query.setClerkId(clerk.getId());
        query.setType(type);
        final int PAGE_SIZE = pageSize == null || pageSize <= 0 ? 10 : pageSize;
        pageNum = RequestUtil.getPageid(pageNum);
        int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
        Page<Tasked> page = taskedService.page(query, start, PAGE_SIZE);
        FrontPagingView view = new FrontPagingView(pageNum, pageSize, page.getCount());
        view.setList(taskedHandler.toVOList(page.getData()));
        return view;
    }

    @RequestMapping
    public FrontPagingView listDriverIncrease(HttpServletRequest request, TaskedQuery query, Integer pageNum, Integer pageSize) {

        QClerk clerk = clerkHelper.getClerkModel(request);
        // query.setClerkId(clerk.getId());
        query.setDepartmentId(clerk.getDepartmentId());
        query.setType(TaskType.CARPILOT.getKey());
        final int PAGE_SIZE = pageSize == null || pageSize <= 0 ? 10 : pageSize;
        pageNum = RequestUtil.getPageid(pageNum);
        int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
        Page<Tasked> page = taskedService.page(query, start, PAGE_SIZE);
        FrontPagingView view = new FrontPagingView(pageNum, pageSize, page.getCount());
        view.setList(taskedHandler.toVOList(page.getData()));
        return view;
    }

    private boolean checkType(String type) {

        boolean isOK = false;
        for (TaskType taskType : TaskType.values()) {
            if (taskType.getKey().equals(type)) {
                isOK = true;
            }
        }
        return isOK;
    }
}
