package com.qcloud.component.publicservice.web.controller.admin;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.qcloud.component.parameter.ParamType;
import com.qcloud.component.parameter.ParameterClient;
import com.qcloud.component.publicservice.model.SmsTemplate;
import com.qcloud.component.publicservice.web.form.SmsTemplateForm;
import com.qcloud.pirates.core.xml.Xml;
import com.qcloud.pirates.core.xml.XmlFactory;
import com.qcloud.pirates.core.xml.XmlItem;
import com.qcloud.pirates.mvc.AceAjaxView;
import com.qcloud.pirates.util.StringUtil;

@Controller
@RequestMapping(value = "/" + AdminInsideMessageController.DIR)
public class AdminInsideMessageController {

    public final static String DIR = "admin/insideMessage";

    @Autowired
    private ParameterClient    parameterClient;

    @RequestMapping
    public ModelAndView list() {

        List<SmsTemplate> stList = new ArrayList<SmsTemplate>();
        Xml xml = XmlFactory.get("publicservice-inside-message");
        if (xml != null) {
            List<XmlItem> list = xml.getItemList();
            for (XmlItem xmlItem : list) {
                SmsTemplate smsTemplate = new SmsTemplate();
                smsTemplate.setName(StringUtil.nullToEmpty(xmlItem.getAttrMap().get("name")).trim());
                smsTemplate.setCode(StringUtil.nullToEmpty(xmlItem.getAttrMap().get("code")).trim());
                String value = parameterClient.get(smsTemplate.getCode());
                if (value == null) {
                    parameterClient.reg(smsTemplate.getCode(), "", ParamType.STRING);
                }
                smsTemplate.setValue(value);
                stList.add(smsTemplate);
            }
        }
        ModelAndView view = new ModelAndView("/admin/publicservice-InsideMessage-list");
        view.addObject("result", stList);
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

    public static List<String> analysisTemplate(String value) {

        // code的格式例如 ： orderNumber ,不包含{}
        List<String> stringList = new ArrayList<String>();
        boolean flag = true;
        while (flag) {
            int firstIndex = value.indexOf("{");
            int secondIndex = value.indexOf("}");
            if (firstIndex == -1 || secondIndex == -1) {
                flag = false;
                break;
            }
            String temp = value.substring(firstIndex + 1, secondIndex);
            stringList.add(temp);
            value = value.substring(secondIndex + 1);
        }
        return stringList;
    }
}
