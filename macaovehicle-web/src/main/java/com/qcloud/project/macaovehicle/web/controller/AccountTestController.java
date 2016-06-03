package com.qcloud.project.macaovehicle.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qcloud.pirates.mvc.FrontAjaxView;

@Controller
@RequestMapping(value = AccountTestController.DIR)
public class AccountTestController {

    public static final String DIR = "/test/account";

    @RequestMapping
    public FrontAjaxView reg() {

        FrontAjaxView view = new FrontAjaxView();
        return view;
    }

    @RequestMapping
    public FrontAjaxView reg2() {

        FrontAjaxView view = new FrontAjaxView();
        return view;
    }

    @RequestMapping
    public FrontAjaxView exist() {

        FrontAjaxView view = new FrontAjaxView();
        return view;
    }

    @RequestMapping
    public FrontAjaxView canEntrySystem() {

        FrontAjaxView view = new FrontAjaxView();
        return view;
    }

    @RequestMapping
    public FrontAjaxView getByAccount() {

        FrontAjaxView view = new FrontAjaxView();
        return view;
    }
}