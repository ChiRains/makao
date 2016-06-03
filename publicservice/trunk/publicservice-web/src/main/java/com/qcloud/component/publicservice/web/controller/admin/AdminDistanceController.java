package com.qcloud.component.publicservice.web.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.qcloud.component.publicservice.model.DistanceConfig;
import com.qcloud.component.publicservice.service.DistanceConfigService;
import com.qcloud.pirates.mvc.AceAjaxView;

@Controller
@RequestMapping(value = "/" + AdminDistanceController.DIR)
public class AdminDistanceController {

    public final static String     DIR = "admin/distanceConfig";
    
    @Autowired
    public DistanceConfigService distanceConfigService;

    
    @RequestMapping
    public ModelAndView getDistanceConfig(){
        DistanceConfig config=distanceConfigService.get();
        ModelAndView modelAndView=new ModelAndView("/admin/publicservice-DistanceConfig-edit");
        modelAndView.addObject("config",config);
        return modelAndView;
    }
    
    @RequestMapping
    public AceAjaxView setDistanceConfig(DistanceConfig distanceConfig){
        System.out.println(distanceConfig.getDistanceSetting());
        distanceConfigService.set(distanceConfig);
        AceAjaxView aceAjaxView=new AceAjaxView();
        aceAjaxView.setMessage("修改成功");
        aceAjaxView.setUrl(DIR+"/getDistanceConfig");
        return aceAjaxView;
    }

}
