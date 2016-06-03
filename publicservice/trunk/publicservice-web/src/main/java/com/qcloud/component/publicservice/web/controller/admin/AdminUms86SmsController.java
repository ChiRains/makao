package com.qcloud.component.publicservice.web.controller.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.qcloud.component.parameter.ParamType;
import com.qcloud.component.parameter.ParameterClient;
import com.qcloud.component.publicservice.SmsClient;
import com.qcloud.component.publicservice.SmsMessageLimitClient;
import com.qcloud.component.publicservice.VerificationCodeClient;
import com.qcloud.component.publicservice.exception.PublicServiceException;
import com.qcloud.component.publicservice.model.SmsTemplate;
import com.qcloud.component.publicservice.model.Ums86Config;
import com.qcloud.component.publicservice.service.SmsTemplateService;
import com.qcloud.component.publicservice.service.Ums86ConfigService;
import com.qcloud.component.publicservice.web.form.SmsTemplateForm;
import com.qcloud.pirates.mvc.AceAjaxView;

@Controller
@RequestMapping(value = "/" + AdminUms86SmsController.DIR)
public class AdminUms86SmsController {

    public final static String     DIR = "admin/umsConfig";

    @Autowired
    private Ums86ConfigService     ums86ConfigService;

    @Autowired
    private SmsClient              smsClient;

    @Autowired
    private VerificationCodeClient verificationCodeClient;

    @Autowired
    private SmsMessageLimitClient  smsMessageLimitClient;

    @Autowired
    private SmsTemplateService     smsTemplateService;

    @Autowired
    private ParameterClient        parameterClient;

    // 获取短信参数
    @RequestMapping
    public ModelAndView getUmsConfig() {

        Ums86Config ums86Config = ums86ConfigService.get();
        ModelAndView modelAndView = new ModelAndView("/admin/publicservice-UmsConfig-edit");
        modelAndView.addObject("enterpriseNumber", ums86Config.getEnterpriseNumber());
        modelAndView.addObject("adminName", ums86Config.getAdminName());
        modelAndView.addObject("adminPsw", ums86Config.getAdminPsw());
        modelAndView.addObject("testMobiles", ums86Config.getTestMobiles());
        return modelAndView;
    }

    // 设置短信参数
    @RequestMapping
    public AceAjaxView setUmsConfig(Ums86Config config) {

        ums86ConfigService.set(config);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setUrl(DIR + "/getUmsConfig");
        aceAjaxView.setMessage("保存成功");
        return aceAjaxView;
    }

    @RequestMapping
    public ModelAndView toTest(String code) {

        ModelAndView view = new ModelAndView("/admin/publicservice-UmsConfig-test");
        view.addObject("code",code);
        return view;
    }

    @RequestMapping
    public ModelAndView list() {

        List<SmsTemplate> list = smsTemplateService.list();
        System.out.println(list.size());
        ModelAndView view = new ModelAndView("/admin/publicservice-UmsConfig-list");
        view.addObject("result", list);
        return view;
    }

    @RequestMapping
    public AceAjaxView save(SmsTemplateForm form) {

        List<SmsTemplate> smsTemplates = form.getSmsTemplates();
        for (SmsTemplate smsTemplate : smsTemplates) {
            parameterClient.reg(smsTemplate.getCode(), smsTemplate.getValue(), ParamType.STRING);
        }
        AceAjaxView view = new AceAjaxView();
        view.setUrl(DIR + "/list");
        view.setMessage("保存成功");
        return view;
    }

    @RequestMapping
    public AceAjaxView test(String code, String mobile) {
        String value=smsTemplateService.getByCode(code);
        String content = "123456";
        Map<String, String> map = new HashMap<String, String>();
        List<String> stringList=analysisTemplate(value);
        for (String string : stringList) {
            map.put(string, content);
        }
        smsClient.send(code, mobile, map);
        AceAjaxView view = new AceAjaxView();
        view.setUrl(DIR + "/list");
        view.setMessage("测试短信发送成功");
        return view;
    }

    public static List<String> analysisTemplate(String value) {
        //code的格式例如 ： orderNumber ,不包含{}
        List<String> stringList = new ArrayList<String>();
        boolean flag = true;
        while (flag) {
            int firstIndex = value.indexOf("{");
            int secondIndex = value.indexOf("}");
            if (firstIndex == -1 || secondIndex == -1) {
                flag = false;
                break;
            }
            String temp = value.substring(firstIndex+1, secondIndex );
            stringList.add(temp);
            value = value.substring(secondIndex + 1);
        }
        return stringList;
    }

}
