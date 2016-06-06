package com.qcloud.component.organization.web.controller.app;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qcloud.component.organization.web.controller.ClerkMessageController;
import com.qcloud.component.piratesship.web.form.ListForm;
import com.qcloud.pirates.mvc.FrontAjaxView;

@Controller
@RequestMapping(value = AppClerkMessageController.DIR)
public class AppClerkMessageController {

    public static final String DIR = "/app/clerkMessage";

    @Autowired
    ClerkMessageController     clerkMessageController;

    @RequestMapping
    public FrontAjaxView list(HttpServletRequest request, Integer pageNum, Integer pageSize) {

        return clerkMessageController.list(request, pageNum, pageSize);
    }

    @RequestMapping
    public FrontAjaxView countAll(HttpServletRequest request) {

        return clerkMessageController.countAll(request);
    }

    @RequestMapping
    public FrontAjaxView countUnread(HttpServletRequest request) {

        return clerkMessageController.countUnread(request);
    }

    @RequestMapping
    public FrontAjaxView get(HttpServletRequest request, Long id) {

        return clerkMessageController.get(request, id);
    }

    @RequestMapping
    public FrontAjaxView read(HttpServletRequest request, Long id) {

        return clerkMessageController.read(request, id);
    }

    @RequestMapping
    public FrontAjaxView delete(HttpServletRequest request, Long id) {

        return clerkMessageController.delete(request, id);
    }

    @RequestMapping
    public FrontAjaxView deleteList(HttpServletRequest request, ListForm form) {

        return clerkMessageController.deleteList(request, form);
    }
}
