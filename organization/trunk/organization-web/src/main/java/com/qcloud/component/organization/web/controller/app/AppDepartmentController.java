package com.qcloud.component.organization.web.controller.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qcloud.component.organization.web.controller.DepartmentController;
import com.qcloud.pirates.mvc.FrontAjaxView;

@Controller
@RequestMapping(value = AppDepartmentController.DIR)
public class AppDepartmentController {

    public static final String DIR = "/app/department";

    @Autowired
    DepartmentController       departmentController;

    @RequestMapping
    public FrontAjaxView list() {

        return departmentController.list();
    }
}
