package com.qcloud.component.publicservice.web.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.qcloud.component.publicservice.model.WeiXinConfig;
import com.qcloud.component.publicservice.service.WeiXinConfigService;
import com.qcloud.pirates.mvc.AceAjaxView;

@Controller
@RequestMapping(value = "/" + AdminWeiXinController.DIR)
public class AdminWeiXinController {

    public final static String     DIR = "admin/weixinConfig";

    @Autowired
    private WeiXinConfigService configService;
    
    @RequestMapping
    public ModelAndView getWeiXinConfig(){
        ModelAndView modelAndView=new ModelAndView("/admin/publicservice-WeiXinConfig-edit");
        WeiXinConfig config=configService.get();
        modelAndView.addObject("appId",config.getAppId());
        modelAndView.addObject("appSecret",config.getAppSecret());
        modelAndView.addObject("mchId",config.getMchID());
        modelAndView.addObject("certPassword",config.getCertPassword());
        modelAndView.addObject("key",config.getKey());
        return modelAndView;
    }
    
    @RequestMapping
    public AceAjaxView setWeiXinConfig(String appId,String appSecret,String mchId,String certPassword,String key){
        WeiXinConfig config=new WeiXinConfig();
        config.setAppId(appId);
        config.setAppSecret(appSecret);
        config.setCertPassword(certPassword);
        config.setKey(key);
        config.setMchID(mchId);
        configService.set(config);
        AceAjaxView aceAjaxView=new AceAjaxView();
        aceAjaxView.setMessage("参数修改成功");
        aceAjaxView.setUrl(DIR+"/getWeiXinConfig");
        return aceAjaxView;
    }

}
