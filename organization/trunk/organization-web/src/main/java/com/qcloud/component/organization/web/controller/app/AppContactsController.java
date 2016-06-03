package com.qcloud.component.organization.web.controller.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qcloud.component.organization.web.controller.ContactsController;
import com.qcloud.component.organization.web.form.ContactsForm;
import com.qcloud.pirates.mvc.FrontAjaxView;
import com.qcloud.pirates.mvc.FrontPagingView;

@Controller
@RequestMapping(value = AppContactsController.DIR)
public class AppContactsController {

    public static final String DIR = "/app/contacts";

    @Autowired
    private ContactsController contactsController;

    @RequestMapping
    public FrontPagingView list(ContactsForm query) {

        Integer pageSize = Integer.MAX_VALUE;
        Integer pageNum = 0;
        return contactsController.list(pageNum, query, pageSize);
    }

    @RequestMapping
    public FrontAjaxView departmentKeyValue(String name) {

        return contactsController.departmentKeyValue(name);
    }
}
