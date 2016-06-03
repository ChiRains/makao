package com.qcloud.project.macaovehicle.web.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qcloud.component.organization.model.Clerk;
import com.qcloud.component.organization.web.helper.ClerkHelper;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.mvc.FrontPagingView;
import com.qcloud.pirates.web.page.PPage;
import com.qcloud.project.macaovehicle.model.InstanceMessage;
import com.qcloud.project.macaovehicle.model.query.InstanceMessageQuery;
import com.qcloud.project.macaovehicle.service.InstanceMessageService;
import com.qcloud.project.macaovehicle.web.handler.InstanceMessageHandler;
import com.qcloud.project.macaovehicle.web.vo.InstanceMessageVO;

@Controller
@RequestMapping(value = InstanceMessageController.DIR)
public class InstanceMessageController {

    public static final String     DIR = "/instanceMessage";

    @Autowired
    private InstanceMessageService instanceMessageService;

    @Autowired
    private InstanceMessageHandler instanceMessageHandler;

    @Autowired
    private ClerkHelper            clerkHelper;

    @RequestMapping
    public FrontPagingView list(HttpServletRequest request, InstanceMessageQuery query, PPage pPage) {

        Clerk clerk = clerkHelper.getClerk(request);
        query.setClerkId(clerk.getId());
        Page<InstanceMessage> page = instanceMessageService.page(query, pPage.getPageStart(), pPage.getPageSize());
        List<InstanceMessageVO> voList = instanceMessageHandler.toVOList(page.getData());
        FrontPagingView view = new FrontPagingView(pPage.getPageNum(), pPage.getPageSize(), page.getCount());
        view.addObject("result", voList);
        return view;
    }
}
