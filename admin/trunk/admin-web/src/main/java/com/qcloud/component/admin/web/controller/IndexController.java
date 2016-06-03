package com.qcloud.component.admin.web.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = IndexController.DIR)
public class IndexController {

    public static final String DIR = "";

    @Autowired
    AdminIndexController       adminIndexController;

    @RequestMapping(value = { "/", "/admin", "/admin/"})
    public ModelAndView index(HttpServletRequest request) {

        return adminIndexController.toLogin(request);
    }
}
