package com.qcloud.component.publicservice.web.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.qcloud.component.publicservice.model.HelpConfig;
import com.qcloud.component.publicservice.service.HelpConfigService;
import com.qcloud.pirates.mvc.AceAjaxView;

@Controller
@RequestMapping(value = "/" + AdminHelpController.DIR)
public class AdminHelpController {

    public final static String DIR = "admin/helpConfig";

    @Autowired
    public HelpConfigService   helpConfigService;

    @RequestMapping
    public ModelAndView getHelpConfig() {

        HelpConfig config = helpConfigService.get();
        ModelAndView modelAndView = new ModelAndView("/admin/publicservice-HelpConfig-edit");
        modelAndView.addObject("config", config);
        return modelAndView;
    }

    @RequestMapping
    public AceAjaxView setHelpConfig(HelpConfig helpConfig) {

        System.out.println(helpConfig.getHelpSetting());
        helpConfigService.set(helpConfig);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("修改成功");
        aceAjaxView.setUrl(DIR + "/getHelpConfig");
        return aceAjaxView;
    }
}
