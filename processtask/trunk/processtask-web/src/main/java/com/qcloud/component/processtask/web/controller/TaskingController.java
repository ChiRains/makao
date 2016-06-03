package com.qcloud.component.processtask.web.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qcloud.component.organization.OrganizationClient;
import com.qcloud.component.organization.QClerk;
import com.qcloud.component.organization.web.helper.ClerkHelper;
import com.qcloud.component.permission.model.Organization;
import com.qcloud.component.processtask.model.Tasking;
import com.qcloud.component.processtask.model.key.TypeEnum.TaskStartStateType;
import com.qcloud.component.processtask.model.query.TaskingQuery;
import com.qcloud.component.processtask.service.TaskingService;
import com.qcloud.component.processtask.web.handler.TaskingHandler;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.mvc.FrontAjaxView;
import com.qcloud.pirates.mvc.FrontPagingView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.NumberUtil;
import com.qcloud.pirates.util.RequestUtil;

@Controller
@RequestMapping(value = TaskingController.DIR)
public class TaskingController {

    public static final String DIR = "/tasking";

    @Autowired
    private TaskingService     taskingService;

    @Autowired
    private TaskingHandler     taskingHandler;

    @Autowired
    private ClerkHelper        clerkHelper;

    @Autowired
    private OrganizationClient organizationClient;

    @RequestMapping
    public FrontPagingView list(HttpServletRequest request, TaskingQuery query, Integer pageNum, Integer pageSize) {

        if (StringUtils.isEmpty(query.getDepartment())) {
            query.setDepartment(query.getKeywords());
        }
        if (StringUtils.isEmpty(query.getClerk())) {
            query.setClerk(query.getKeywords());
        }
        if (StringUtils.isEmpty(query.getProcess())) {
            query.setProcess(query.getKeywords());
        }
        QClerk clerk = clerkHelper.getClerkModel(request);
        query.setClerkId(clerk.getId());
        final int PAGE_SIZE = pageSize == null || pageSize <= 0 ? 10 : pageSize;
        pageNum = RequestUtil.getPageid(pageNum);
        int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
        Page<Tasking> page = taskingService.page(query, 0, start, PAGE_SIZE);
        FrontPagingView view = new FrontPagingView(pageNum, pageSize, page.getCount());
        view.addObject("list", taskingHandler.toVOList(page.getData()));
        return view;
    }

    /**
     * 我的
     * @param request
     * @param query
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping
    public FrontAjaxView listMyApplying(HttpServletRequest request, TaskingQuery query, Integer pageNum, Integer pageSize) {

        return list(request, query, 1, pageNum, pageSize);
    }

    /**
     * 我的待审批列表---别人的申请
     * @param request
     * @param query
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping
    public FrontAjaxView listMyApproving(HttpServletRequest request, TaskingQuery query, Integer pageNum, Integer pageSize) {

        return list(request, query, 2, pageNum, pageSize);
    }

    private FrontAjaxView list(HttpServletRequest request, TaskingQuery query, int type, Integer pageNum, Integer pageSize) {

        QClerk clerk = clerkHelper.getClerkModel(request);
        query.setClerkId(clerk.getId());
        final int PAGE_SIZE = pageSize == null || pageSize <= 0 ? 10 : pageSize;
        pageNum = RequestUtil.getPageid(pageNum);
        int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
        Page<Tasking> page = taskingService.page(query, type, start, PAGE_SIZE);
        FrontAjaxView view = new FrontAjaxView();
        view.addObject("list", taskingHandler.toVOList4App(page.getData()));
        view.addObject("allNumber", page.getCount());
        return view;
    }

    @RequestMapping
    public FrontAjaxView delete(Long id) {

        AssertUtil.greatZero(id, "待办任务id不能为空");
        Tasking tasking = taskingService.get(id);
        AssertUtil.assertNotNull(tasking, "待办任务不存在.");
        AssertUtil.assertTrue(tasking.getStart() == TaskStartStateType.START.getKey(), "不允许删除,待办任务状态不正确");
        taskingService.delete(id);
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("删除成功");
        return view;
    }

    @RequestMapping
    public FrontAjaxView getNextExecutor(Long formInstanceId) {

        AssertUtil.greatZero(formInstanceId, "待办任务id不能为空");
        List<Tasking> list = taskingService.getNextExecutor(formInstanceId);
        String nextExecutor = "";
        for (int i = 0; i < list.size(); i++) {
            Tasking tasking = list.get(0);
            QClerk clerk = organizationClient.getClerk(tasking.getClerkId());
            if (i == list.size() - 1) {
                nextExecutor += clerk.getName();
            } else {
                nextExecutor += clerk.getName() + ",";
            }
        }
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("下一步执行人.");
        view.addObject("nextExecutor", nextExecutor);
        return view;
    }
}
