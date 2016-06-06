package com.qcloud.component.publicservice.web.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.qcloud.component.publicservice.model.AboutusConfig;
import com.qcloud.component.publicservice.service.AboutusConfigService;
import com.qcloud.pirates.mvc.AceAjaxView;

@Controller
@RequestMapping(value = "/" + AdminAboutusController.DIR)
public class AdminAboutusController {

    public final static String     DIR = "admin/aboutusConfig";
    
    @Autowired
    public AboutusConfigService aboutusConfigService;

    
    @RequestMapping
    public ModelAndView getAboutusConfig(){
        AboutusConfig config=aboutusConfigService.get();
        ModelAndView modelAndView=new ModelAndView("/admin/publicservice-AboutusConfig-edit");
        modelAndView.addObject("config",config);
        return modelAndView;
    }
    
    @RequestMapping
    public AceAjaxView setAboutusConfig(AboutusConfig aboutusConfig){
        System.out.println(aboutusConfig.getAboutusSetting());
        aboutusConfigService.set(aboutusConfig);
        AceAjaxView aceAjaxView=new AceAjaxView();
        aceAjaxView.setMessage("参数修改成功");
        aceAjaxView.setUrl(DIR+"/getAboutusConfig");
        return aceAjaxView;
    }

}
