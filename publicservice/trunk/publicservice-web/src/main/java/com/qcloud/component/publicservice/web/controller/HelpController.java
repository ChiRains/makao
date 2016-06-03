package com.qcloud.component.publicservice.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qcloud.component.publicservice.model.HelpConfig;
import com.qcloud.component.publicservice.service.HelpConfigService;
import com.qcloud.pirates.mvc.FrontAjaxView;
import com.qcloud.pirates.mvc.HtmlView;
import com.qcloud.pirates.util.StringUtil;

@Controller
@RequestMapping(value = HelpController.DIR)
public class HelpController {

    public final static String DIR = "/helpConfig";

    @Autowired
    public HelpConfigService   helpConfigService;

    @RequestMapping
    public FrontAjaxView getHelp() {

        HelpConfig helpConfig = helpConfigService.get();
        FrontAjaxView view = new FrontAjaxView();
        view.addObject("help", StringUtil.nullToEmpty(helpConfig.getHelpSetting()));
        return view;
    }

    @RequestMapping
    public HtmlView getHtmlHelp() {

        HelpConfig helpConfig = helpConfigService.get();
        HtmlView view = new HtmlView("<style>img{width:100%;} </style>" + StringUtil.nullToEmpty(helpConfig.getHelpSetting()));
        return view;
    }
}
