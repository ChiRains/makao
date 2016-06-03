package com.qcloud.project.macaovehicle.web.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.qcloud.component.filesdk.web.controller.FileController;
import com.qcloud.component.publicservice.VerificationCodeClient;
import com.qcloud.pirates.core.json.DateJson;
import com.qcloud.pirates.core.xml.Xml;
import com.qcloud.pirates.core.xml.XmlFactory;
import com.qcloud.pirates.core.xml.XmlItem;
import com.qcloud.pirates.mvc.FrontAjaxView;
import com.qcloud.pirates.mvc.HtmlView;
import com.qcloud.pirates.util.AssertUtil;

@Controller
@RequestMapping(value = MVFileController.DIR)
public class MVFileController {

    public static final String     DIR = "/mvFile";

    @Autowired
    FileController                 fileController;

    @Autowired
    private VerificationCodeClient verificationCodeClient;

    @RequestMapping
    public HtmlView addFile4Html(MultipartHttpServletRequest request) {

        String code = request.getParameter("code");
        String email = request.getParameter("email");
        boolean verification = verificationCodeClient.verification(email, code);
        AssertUtil.assertTrue(verification || enableEmail(), "验证码不正确,请重新获取.");
        System.out.println("code  ================" + code);
        System.out.println("email ================" + email);
        FrontAjaxView fView = null;
        try {
            fView = fileController.addFile(request);
        } catch (Exception e) {
            Map<String, Object> result = new HashMap<String, Object>();
            result.put("status", "-599");
            result.put("message", e.getMessage());
            result.put("data", new HashMap<String, String>());
            HtmlView view = new HtmlView("<script>parent.doresult(" + DateJson.toFormatJson(result) + ");</script>");
            return view;
        }
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("status", fView.getStatus());
        result.put("message", fView.getMessage());
        result.put("data", fView.getData());
        HtmlView view = new HtmlView("<script>parent.doresult(" + DateJson.toFormatJson(result) + ");</script>");
        return view;
    }

    private boolean enableEmail() {

        Xml xml = XmlFactory.get("hasEmailCode");
        List<XmlItem> list = xml.getItemList();
        for (XmlItem xmlItem : list) {
            if ("code".equals(xmlItem.getAttrMap().get("key")) 
                    && Boolean.valueOf(xmlItem.getAttrMap().get("enable"))
                    && ("666666").equals(xmlItem.getText())) {
                return true;
            }
        }
        return false;
    }
}
