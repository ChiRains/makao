package com.qcloud.component.processtask.web.controller.app;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qcloud.component.organization.QClerk;
import com.qcloud.component.organization.web.helper.ClerkHelper;
import com.qcloud.component.processtask.model.Tasking;
import com.qcloud.component.processtask.model.query.TaskingQuery;
import com.qcloud.component.processtask.service.TaskingService;
import com.qcloud.component.processtask.web.handler.TaskingHandler;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.mvc.FrontAjaxView;
import com.qcloud.pirates.util.NumberUtil;
import com.qcloud.pirates.util.RequestUtil;

@Controller
@RequestMapping(value = AppTaskingController.DIR)
public class AppTaskingController {

    public static final String DIR = "/app/tasking";

    @Autowired
    private TaskingService     taskingService;

    @Autowired
    private TaskingHandler     taskingHandler;

    @Autowired
    private ClerkHelper        clerkHelper;

    @RequestMapping
    public FrontAjaxView list(HttpServletRequest request, TaskingQuery query, Integer pageNum, Integer pageSize) {

        return list(request, query, 0, pageNum, pageSize);
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
        return view;
    }
}
