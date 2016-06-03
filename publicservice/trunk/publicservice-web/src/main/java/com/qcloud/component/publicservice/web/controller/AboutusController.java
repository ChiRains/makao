package com.qcloud.component.publicservice.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qcloud.component.publicservice.model.AboutusConfig;
import com.qcloud.component.publicservice.service.AboutusConfigService;
import com.qcloud.pirates.mvc.FrontAjaxView;
import com.qcloud.pirates.mvc.HtmlView;
import com.qcloud.pirates.util.StringUtil;

@Controller
@RequestMapping(value = AboutusController.DIR)
public class AboutusController {

    public final static String  DIR = "/aboutusConfig";

    @Autowired
    public AboutusConfigService aboutusConfigService;

    @RequestMapping
    public FrontAjaxView getAboutus() {

        AboutusConfig aboutusConfig = aboutusConfigService.get();
        FrontAjaxView view = new FrontAjaxView();
        view.addObject("aboutus", StringUtil.nullToEmpty(aboutusConfig.getAboutusSetting()));
        return view;
    }

    @RequestMapping
    public HtmlView getHtmlAboutus() {

        AboutusConfig aboutusConfig = aboutusConfigService.get();
        HtmlView view = new HtmlView("<style>img{width:100%;} </style>" + StringUtil.nullToEmpty(aboutusConfig.getAboutusSetting()));
        return view;
    }
}
