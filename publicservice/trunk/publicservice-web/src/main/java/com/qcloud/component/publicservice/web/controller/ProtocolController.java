package com.qcloud.component.publicservice.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qcloud.component.publicservice.model.ProtocolConfig;
import com.qcloud.component.publicservice.service.ProtocolConfigService;
import com.qcloud.pirates.mvc.FrontAjaxView;
import com.qcloud.pirates.mvc.HtmlView;
import com.qcloud.pirates.util.StringUtil;

@Controller
@RequestMapping(value = ProtocolController.DIR)
public class ProtocolController {

    public final static String   DIR = "/protocolConfig";

    @Autowired
    public ProtocolConfigService protocolConfigService;

    @RequestMapping
    public HtmlView getHtmlProtocol() {

        ProtocolConfig protocolConfig = protocolConfigService.get();
        HtmlView view = new HtmlView("<style>img{width:100%;} </style>" + StringUtil.nullToEmpty(protocolConfig.getProtocolSetting()));
        return view;
    }

    @RequestMapping
    public FrontAjaxView getProtocol() {

        ProtocolConfig protocolConfig = protocolConfigService.get();
        FrontAjaxView view = new FrontAjaxView();
        view.addObject("protocolConfig", StringUtil.nullToEmpty(protocolConfig.getProtocolSetting()));
        return view;
    }
}
