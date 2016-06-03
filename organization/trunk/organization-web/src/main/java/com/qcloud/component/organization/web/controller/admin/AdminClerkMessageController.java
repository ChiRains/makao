package com.qcloud.component.organization.web.controller.admin;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.qcloud.component.organization.ClerkMessageType;
import com.qcloud.component.organization.OrganizationClient;
import com.qcloud.component.organization.model.Clerk;
import com.qcloud.component.organization.service.ClerkService;
import com.qcloud.pirates.mvc.AceAjaxView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.StringUtil;

@Controller
@RequestMapping(value = "/" + AdminClerkMessageController.DIR)
public class AdminClerkMessageController {

    public static final String DIR = "admin/clerkMessage";

    @Autowired
    private OrganizationClient organizationClient;

    @Autowired
    private ClerkService       clerkService;

    @RequestMapping
    public ModelAndView toSend(Long clerkId, String name) {

        ModelAndView model = new ModelAndView("/admin/organization-ClerkMessage-send");
        model.addObject("clerkId", clerkId);
        model.addObject("name", null == name ? name : "");
        return model;
    }

    @RequestMapping
    public ModelAndView toSelectClerk(String clerkId_send) {

        List<Clerk> list = clerkService.listAll();
        ModelAndView model = new ModelAndView("/admin/organization-ClerkMessage-toSelectClerk");
        model.addObject("clerkList", list);
        if (!"".equals(clerkId_send) && !clerkId_send.equals("0")) {
            String[] clerkId = clerkId_send.split(",");
            List<Clerk> checkedList = new ArrayList<Clerk>();
            for (int i = 0; i < clerkId.length; i++) {
                if (!"".equals(clerkId[i])) {
                    Long id = Long.parseLong(clerkId[i]);
                    Clerk clerk = clerkService.get(id);
                    AssertUtil.assertNotNull(clerk, "消息接收人不存在." + id);
                    checkedList.add(clerk);
                }
            }
            model.addObject("result", checkedList);
        }
        return model;
    }

    @RequestMapping
    public AceAjaxView send(String clerkId_send, String title, String content) {

        String[] clerkId = clerkId_send.split(",");
        for (int i = 0; i < clerkId.length; i++) {
            Long id = Long.parseLong(clerkId[i]);
            Clerk clerk = clerkService.get(id);
            AssertUtil.assertNotNull(clerk, "消息接收人不存在." + id);
            organizationClient.sendMsg(id, ClerkMessageType.INSIDE_LETTER, title, content);
        }
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("发送消息成功");
        return aceAjaxView;
    }
}
