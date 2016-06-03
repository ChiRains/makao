package com.qcloud.component.publicservice.web.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.qcloud.component.publicservice.model.PaySettingConfig;
import com.qcloud.component.publicservice.service.PaySettingConfigService;
import com.qcloud.pirates.mvc.AceAjaxView;

@Controller
@RequestMapping(value = "/" + AdminPaySettingController.DIR)
public class AdminPaySettingController {

    public final static String      DIR = "admin/paySetting";

    @Autowired
    private PaySettingConfigService configService;

    @RequestMapping
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("/admin/publicservice-PaySetting-list");
        PaySettingConfig config = configService.get();
        modelAndView.addObject("wxPay", config.getWxPaySetting());
        modelAndView.addObject("aliPay", config.getAliPaySetting());
        modelAndView.addObject("unionPay", config.getUnionPaySetting());
        modelAndView.addObject("paySettingTime", config.getPaySettingTime());
        return modelAndView;
    }

    @RequestMapping
    public AceAjaxView wxEnable() {

        configService.wxEnable();
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("开启成功");
        return aceAjaxView;
    }

    @RequestMapping
    public AceAjaxView wxDisable() {

        configService.wxDisable();
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("关闭成功");
        return aceAjaxView;
    }

    @RequestMapping
    public AceAjaxView alipayEnable() {

        configService.aliEnable();
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("开启成功");
        return aceAjaxView;
    }

    @RequestMapping
    public AceAjaxView alipayDisable() {

        configService.aliDisable();
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("关闭成功");
        return aceAjaxView;
    }

    @RequestMapping
    public AceAjaxView unionEnable() {

        configService.unionEnable();
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("开启成功");
        return aceAjaxView;
    }

    @RequestMapping
    public AceAjaxView unionDisable() {

        configService.unionDisable();
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("关闭成功");
        return aceAjaxView;
    }

    @RequestMapping
    public ModelAndView settingTime(){
        ModelAndView modelAndView = new ModelAndView("/admin/publicservice-PaySettingTime");
        PaySettingConfig config = configService.get();
        modelAndView.addObject("paySettingTime", config.getPaySettingTime());
        modelAndView.addObject("refundTime",config.getRefundTime());
        modelAndView.addObject("domain", config.getDomain());
        modelAndView.addObject("autoSignTime",config.getAutoSignTime());
        return modelAndView;
    }
    
    @RequestMapping
    public AceAjaxView update(PaySettingConfig config) {

        configService.set(config);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("修改成功");
        aceAjaxView.setUrl(DIR + "/settingTime");
        return aceAjaxView;
    }
}
