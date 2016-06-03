package com.qcloud.component.organization.web.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qcloud.component.organization.ClerkMessageType;
import com.qcloud.component.organization.model.Clerk;
import com.qcloud.component.organization.model.key.TypeEnum;
import com.qcloud.component.organization.web.handler.ClerkMessageHandler;
import com.qcloud.component.organization.web.helper.ClerkHelper;
import com.qcloud.component.organization.web.vo.ClerkMessageVO;
import com.qcloud.component.piratesship.web.form.ListForm;
import com.qcloud.component.publicservice.MessageClient;
import com.qcloud.component.publicservice.QMessage;
import com.qcloud.pirates.mvc.FrontAjaxView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.NumberUtil;
import com.qcloud.pirates.util.RequestUtil;

@Controller
@RequestMapping(value = ClerkMessageController.DIR)
public class ClerkMessageController {

    public static final String  DIR = "/clerkMessage";

    @Autowired
    private MessageClient       messageClient;

    @Autowired
    private ClerkMessageHandler clerkMessageHandler;

    @Autowired
    private ClerkHelper         clerkHelper;

    @RequestMapping
    public FrontAjaxView list(HttpServletRequest request, Integer pageNum, Integer pageSize) {

        final int PAGE_SIZE = pageSize == null || pageSize <= 0 ? 10 : pageSize;
        pageNum = RequestUtil.getPageid(pageNum);
        int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
        Clerk clerk = clerkHelper.getClerk(request);
        List<QMessage> list = messageClient.listByReceiver(TypeEnum.CLERK_MESSAGE_CODE, ClerkMessageType.INSIDE_LETTER.getKey(), clerk.getId(), start, PAGE_SIZE);
        List<ClerkMessageVO> voList = clerkMessageHandler.toVOList(list);
        int allNumber = messageClient.countByReceiver(TypeEnum.CLERK_MESSAGE_CODE, ClerkMessageType.INSIDE_LETTER.getKey(), clerk.getId());
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("查询我的消息成功.");
        view.addObject("list", voList);
        view.addObject("allNumber", allNumber);
        return view;
    }

    @RequestMapping
    public FrontAjaxView listContent(HttpServletRequest request, Integer pageNum, Integer pageSize) {

        final int PAGE_SIZE = pageSize == null || pageSize <= 0 ? 10 : pageSize;
        pageNum = RequestUtil.getPageid(pageNum);
        int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
        Clerk clerk = clerkHelper.getClerk(request);
        List<QMessage> list = messageClient.listContentByReceiver(TypeEnum.CLERK_MESSAGE_CODE, ClerkMessageType.INSIDE_LETTER.getKey(), clerk.getId(), start, PAGE_SIZE);
        List<ClerkMessageVO> voList = clerkMessageHandler.toVOList(list);
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("查询我的消息成功.");
        view.addObject("list", voList);
        return view;
    }

    @RequestMapping
    public FrontAjaxView countAll(HttpServletRequest request) {

        Clerk clerk = clerkHelper.getClerk(request);
        int number = messageClient.countByReceiver(TypeEnum.CLERK_MESSAGE_CODE, ClerkMessageType.INSIDE_LETTER.getKey(), clerk.getId());
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("查询我的消息条数成功.");
        view.addObject("total", number);
        return view;
    }

    @RequestMapping
    public FrontAjaxView countUnread(HttpServletRequest request) {

        Clerk clerk = clerkHelper.getClerk(request);
        int number = messageClient.countUnreadByReceiver(TypeEnum.CLERK_MESSAGE_CODE, ClerkMessageType.INSIDE_LETTER.getKey(), clerk.getId());
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("查询我的消息未读条数成功.");
        view.addObject("unreadTotal", number);
        return view;
    }

    @RequestMapping
    public FrontAjaxView get(HttpServletRequest request, Long id) {

        Clerk clerk = clerkHelper.getClerk(request);
        QMessage message = messageClient.get(TypeEnum.CLERK_MESSAGE_CODE, clerk.getId(), id);
        AssertUtil.assertNotNull(message, "消息不存在." + id);
        ClerkMessageVO clerkMessageVO = clerkMessageHandler.toVO(message);
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("获取我的一条消息成功.");
        view.addObject("message", clerkMessageVO);
        return view;
    }

    @RequestMapping
    public FrontAjaxView read(HttpServletRequest request, Long id) {

        Clerk clerk = clerkHelper.getClerk(request);
        messageClient.read(TypeEnum.CLERK_MESSAGE_CODE, clerk.getId(), id);
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("设置一条消息为已读成功.");
        return view;
    }

    @RequestMapping
    public FrontAjaxView delete(HttpServletRequest request, Long id) {

        Clerk clerk = clerkHelper.getClerk(request);
        messageClient.delete(TypeEnum.CLERK_MESSAGE_CODE, clerk.getId(), id);
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("删除一条消息成功.");
        return view;
    }

    @RequestMapping
    public FrontAjaxView deleteList(HttpServletRequest request, ListForm form) {

        Clerk clerk = clerkHelper.getClerk(request);
        for (Long id : form.getLongList()) {
            messageClient.delete(TypeEnum.CLERK_MESSAGE_CODE, clerk.getId(), id);
        }
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("删除消息成功.");
        return view;
    }
}
