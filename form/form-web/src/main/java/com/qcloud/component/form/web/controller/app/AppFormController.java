package com.qcloud.component.form.web.controller.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qcloud.component.form.web.controller.FormController;
import com.qcloud.pirates.mvc.FrontAjaxView;
import com.qcloud.pirates.util.Base64;

@RequestMapping(value = AppFormController.DIR)
@Controller
public class AppFormController {

    public static final String DIR = "/app/form";

    @Autowired
    FormController             formController;

//    @RequestMapping
//    public FrontAjaxView save(HttpServletRequest request, Form form, NotionForm notionForm) {
//
//        return formController.save(request, form, notionForm);
//    }
//
//    @RequestMapping
//    public FrontAjaxView submit(HttpServletRequest request, Form form) {
//
//        return formController.submit(request, form);
//    }
//
//    @RequestMapping
//    public FrontAjaxView get(Long formInstanceId) {
//
//        return formController.get(formInstanceId);
//    }
//
//    @RequestMapping
//    public FrontAjaxView getInFlat(Long formInstanceId) {
//
//        return formController.getInFlat(formInstanceId);
//    }
//
//    @RequestMapping
//    public FrontAjaxView getHist(Long formInstanceHistId) {
//
//        return formController.getHist(formInstanceHistId);
//    }
//
//    @RequestMapping
//    public FrontAjaxView getHistInFlat(Long formInstanceHistId) {
//
//        return formController.getHistInFlat(formInstanceHistId);
//    }

    @RequestMapping
    public FrontAjaxView getHtmlSaveToken(Long formId, Long formInstanceId, Long taskId, String processId, String processInstId, String workitemId, String qc_app_token) {

         FrontAjaxView view = new FrontAjaxView();
        String str = formController.createSaveFormDataToken(formId, formInstanceId, taskId, processId, processInstId, workitemId, qc_app_token);
        view.addObject("formToken", str);
        view.addObject("userToken", Base64.encode(qc_app_token));
        return view;
    }
}
