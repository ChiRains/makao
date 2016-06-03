package com.qcloud.component.processtask.web.controller.app;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qcloud.component.organization.QClerk;
import com.qcloud.component.organization.web.helper.ClerkHelper;
import com.qcloud.component.processtask.model.Tasked;
import com.qcloud.component.processtask.model.query.TaskedQuery;
import com.qcloud.component.processtask.service.TaskedService;
import com.qcloud.component.processtask.web.handler.TaskedHandler;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.mvc.FrontAjaxView;
import com.qcloud.pirates.util.NumberUtil;
import com.qcloud.pirates.util.RequestUtil;

@Controller
@RequestMapping(value = AppTaskedController.DIR)
public class AppTaskedController {

    public static final String DIR = "/app/tasked";

    @Autowired
    private TaskedService      taskedService;

    @Autowired
    private TaskedHandler      taskedHandler;

    @Autowired
    private ClerkHelper        clerkHelper;

    @RequestMapping
    public FrontAjaxView list(HttpServletRequest request, TaskedQuery query, Integer pageNum, Integer pageSize) {

        return list(request, query, 0, pageNum, pageSize);
    }

    /**
     * 我提交的申请 ---还在审批中的
     * @param request
     * @param query
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping
    public FrontAjaxView listMyApplyedApproving(HttpServletRequest request, TaskedQuery query, Integer pageNum, Integer pageSize) {

        return list(request, query, 1, pageNum, pageSize);
    }

    /**
     * 我提交的申请 ---已经审批完的
     * @param request
     * @param query
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping
    public FrontAjaxView listMyApplyedApproved(HttpServletRequest request, TaskedQuery query, Integer pageNum, Integer pageSize) {

        return list(request, query, 2, pageNum, pageSize);
    }

    /**
     * 我已经审批过的---别人的申请
     * @param request
     * @param query
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping
    public FrontAjaxView listMyApproved(HttpServletRequest request, TaskedQuery query, Integer pageNum, Integer pageSize) {

        return list(request, query, 3, pageNum, pageSize);
    }

    private FrontAjaxView list(HttpServletRequest request, TaskedQuery query, int type, Integer pageNum, Integer pageSize) {

        QClerk clerk = clerkHelper.getClerkModel(request);
        query.setClerkId(clerk.getId());
        final int PAGE_SIZE = pageSize == null || pageSize <= 0 ? 10 : pageSize;
        pageNum = RequestUtil.getPageid(pageNum);
        int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
        Page<Tasked> page = taskedService.page(query, type, start, PAGE_SIZE);
        FrontAjaxView view = new FrontAjaxView();
        view.addObject("list", taskedHandler.toVOList4App(page.getData()));
        return view;
    }
}
