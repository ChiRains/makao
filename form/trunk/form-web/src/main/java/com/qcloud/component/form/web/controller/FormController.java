package com.qcloud.component.form.web.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qcloud.component.form.EventContext;
import com.qcloud.component.form.engine.FormEngineService;
import com.qcloud.component.form.entity.EventContextEntity;
import com.qcloud.component.form.entity.MainForm;
import com.qcloud.component.form.entity.MainFormData;
import com.qcloud.component.form.model.FormInstance;
import com.qcloud.component.form.model.FormInstanceHist;
import com.qcloud.component.form.service.FormInstanceHistService;
import com.qcloud.component.form.service.FormInstanceService;
import com.qcloud.component.form.web.form.Form;
import com.qcloud.component.form.web.form.NotionForm;
import com.qcloud.component.form.web.handler.FormHandler;
import com.qcloud.component.form.web.helper.FormSaverHelper;
import com.qcloud.component.organization.OrganizationClient;
import com.qcloud.component.organization.QClerk;
import com.qcloud.component.organization.web.helper.ClerkHelper;
import com.qcloud.component.token.TokenClient;
import com.qcloud.pirates.mvc.FrontAjaxView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.Base64;
import com.qcloud.pirates.util.EncryptUtil;
import com.qcloud.pirates.util.StringUtil;
import com.qcloud.pirates.web.mvc.annotation.PiratesApp;

@RequestMapping(value = FormController.DIR)
@Controller
public class FormController {

    public static final String      DIR    = "/form";

    @Autowired
    private FormEngineService       formEngineService;

    @Autowired
    private FormInstanceService     formInstanceService;

    @Autowired
    private FormInstanceHistService formInstanceHistService;

    @Autowired
    private FormHandler             formHandler;

    @Autowired
    private OrganizationClient      organizationClient;

    @Autowired
    private ClerkHelper             clerkHelper;

    @Autowired
    private FormSaverHelper         formSaverHelper;

    @Value("${pirates.form.tokenKey}")
    private String                  tokenKey;

    private Log                     logger = LogFactory.getLog(getClass());

    /**
     * 保存表单数据
     * 
     * @param form
     * @return
     */
    @RequestMapping
    public FrontAjaxView save4Token(HttpServletRequest request, Form form, NotionForm notionForm, String formToken, String userToken) {

        AssertUtil.assertNotEmpty(formToken, "表单token不能为空.");
        AssertUtil.assertNotEmpty(userToken, "用户token不能为空.");
        String appToken = Base64.decode(userToken);
        String token = createSaveFormDataToken(form.getFormId(), form.getFormInstanceId(), form.getTaskId(), form.getProcessId(), form.getProcessInstId(), form.getWorkitemId(), appToken);
        AssertUtil.assertTrue(token.equals(formToken), "表单保存token不合法." + formToken);
        QClerk clerk = clerkHelper.getClerkModel(appToken);
        FrontAjaxView view = save(request, clerk, form, notionForm, appToken);
        return view;
    }

    /**
     * 保存表单数据
     * 
     * @param form
     * @return
     */
    @PiratesApp
    @RequestMapping
    public FrontAjaxView save(HttpServletRequest request, Form form, NotionForm notionForm) {

        AssertUtil.assertNotNull(form.getFormId(), "formId表单定义ID不能为空.");
        AssertUtil.assertNotEmpty(form.getProcessId(), "processId流程定义ID不能为空.");
        QClerk clerk = clerkHelper.getClerkModel(request);
        return save(request, clerk, form, notionForm, null);
    }

    /**
     * 保存表单数据
     * 
     * @param form
     * @return
     */
    private FrontAjaxView save(HttpServletRequest request, QClerk clerk, Form form, NotionForm notionForm, String appToken) {

        // 保存页面提交的信息,包含业务上的数据
        Map<String, String> map = new HashMap<String, String>();
        Enumeration<String> ens = request.getParameterNames();
        while (ens.hasMoreElements()) {
            String key = ens.nextElement();
            map.put(key, request.getParameter(key));
        }
        EventContextEntity context = formSaverHelper.save(map, clerk, form, notionForm);
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("保存表单数据成功.");
        view.addObject("formId", context.getFormId());
        view.addObject("formInstanceId", context.getFormInstId());
        view.addObject("processId", context.getProcessId());
        view.addObject("processInstId", context.getProcessInstId());
        view.addObject("workitemId", context.getWorkitemId());
        view.addObject("taskId", context.getTaskId());
        view.addObject("formHistId", context.getReturnMap().get(EventContext.FORM_HIST_ID));
        view.addObject("taskedId", context.getReturnMap().get(EventContext.TASKED_ID));
        view.addObject("send", context.getParameterMap().get(EventContext.SAVE_SENDED));
        if (StringUtils.isNotEmpty(appToken)) {
            String token = createSaveFormDataToken(context.getFormId(), context.getFormInstId(), context.getTaskId(), context.getProcessId(), context.getProcessInstId(), context.getWorkitemId(), appToken);
            view.addObject("formToken", token);
        }
        view.addObject("tip", context.getParameterMap().get("Next-Task-Tip"));
        logger.info("tip " + context.getParameterMap().get("Next-Task-Tip"));
        return view;
    }

    /**
     * 提交表单数据
     * 
     * @param form
     * @return
     */
    @RequestMapping
    public FrontAjaxView submit4Token(HttpServletRequest request, Form form, String formToken, String userToken) {

        AssertUtil.assertNotEmpty(formToken, "表单token不能为空.");
        AssertUtil.assertNotEmpty(userToken, "用户token不能为空.");
        String appToken = Base64.decode(userToken);
        String token = createSaveFormDataToken(form.getFormId(), form.getFormInstanceId(), form.getTaskId(), form.getProcessId(), form.getProcessInstId(), form.getWorkitemId(), appToken);
        AssertUtil.assertTrue(token.equals(formToken), "表单保存token不合法." + formToken);
        QClerk clerk = clerkHelper.getClerkModel(appToken);
        return submit(request, clerk, form);
    }

    /**
     * 提交表单数据
     * 
     * @param form
     * @return
     */
    @PiratesApp
    @RequestMapping
    public FrontAjaxView submit(HttpServletRequest request, Form form) {

        QClerk clerk = clerkHelper.getClerkModel(request);
        return submit(request, clerk, form);
    }

    /**
     * 提交表单数据
     * 
     * @param form
     * @return
     */
    private FrontAjaxView submit(HttpServletRequest request, QClerk clerk, Form form) {

        AssertUtil.assertNotNull(form.getFormId(), "formId表单定义ID不能为空.");
        AssertUtil.assertNotNull(form.getFormInstanceId(), "formInstanceId表单实例ID不能为空.");
        AssertUtil.assertNotEmpty(form.getProcessId(), "processId流程定义ID不能为空.");
        AssertUtil.assertNotEmpty(form.getProcessInstId(), "processInstId流程实例ID不能为空.");
        AssertUtil.assertNotEmpty(form.getWorkitemId(), "workitemId流程任务ID不能为空.");
        AssertUtil.assertNotNull(form.getTaskId(), "taskId任务ID不能为空.");
        // 执行人
        EventContextEntity context = new EventContextEntity();
        String executorKeys = request.getParameter("executorKeys");
        if (StringUtils.isNotEmpty(executorKeys)) {
            String[] executorKeyArray = executorKeys.split(",");
            for (String str : executorKeyArray) {
                String executors = request.getParameter(str);
                AssertUtil.assertNotEmpty(executors, "参数指定执行人未指定." + str);
                String[] executorArray = executors.split(",");
                for (String executorStr : executorArray) {
                    QClerk executor = organizationClient.getClerk(Long.valueOf(executorStr));
                    AssertUtil.assertNotNull(executor, "执行人不存在." + executorStr);
                }
                context.addParameter(str, executors);
            }
        }
        AssertUtil.assertNotNull(form.getFormInstanceId(), "表单实例ID不能为空,提交表单数据失败.");
        FormInstance formInstance = formInstanceService.get(form.getFormInstanceId());
        MainForm mainForm = formEngineService.getForm(formInstance.getFormId());
        AssertUtil.assertNotNull(formInstance, "表单实例不存在,提交表单数据失败." + form.getFormInstanceId());
        context.setProcessId(form.getProcessId());
        context.setProcessInstId(form.getProcessInstId());
        context.setWorkitemId(form.getWorkitemId());
        context.setTaskId(form.getTaskId());
        context.setMainForm(mainForm);
        context.setFormInstId(form.getFormInstanceId());
        context.setClerkId(clerk.getId());
        context.setDepartmentId(clerk.getDepartmentId());
        context.setPostId(clerk.getPostId());
        context.setClerkName(clerk.getName());
        formEngineService.submit(formInstance, context);
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("提交表单数据成功.");
        view.addObject("taskedId", context.getTaskedId());
        view.addObject("formInstanceHistId", context.getFormHistId());
        view.addObject("tip", context.getParameterMap().get("Next-Task-Tip"));
        logger.info("tip " + context.getParameterMap().get("Next-Task-Tip"));
        return view;
    }

    @Autowired
    TokenClient tokenClient;

    @RequestMapping
    public FrontAjaxView get4Token(Long formInstanceId, String userToken) {

        AssertUtil.assertNotEmpty(userToken, "用户token不能为空.");
        String appToken = Base64.decode(userToken);
        QClerk clerk = clerkHelper.getClerkModel(appToken);
        AssertUtil.assertNotNull(clerk, "用户不存在.");
        return get(formInstanceId);
    }

    /**
     * 获取表单数据
     * 
     * @param form
     * @return
     */
    @PiratesApp
    @RequestMapping
    public FrontAjaxView get(Long formInstanceId) {

        AssertUtil.assertNotNull(formInstanceId, "表单实例ID不能为空,获取表单数据失败.");
        FormInstance formInstance = formInstanceService.get(formInstanceId);
        AssertUtil.assertNotNull(formInstance, "表单实例不存在,获取表单数据失败." + formInstanceId);
        MainFormData data = formEngineService.get(formInstance);
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("查询表单数据成功.");
        view.addObject("data", formHandler.toVO(data));
        view.addObject("formInstCode", formInstance.getCode());
        return view;
    }

    @RequestMapping
    public FrontAjaxView getInFlat4Token(Long formInstanceId, String userToken) {

        AssertUtil.assertNotEmpty(userToken, "用户token不能为空.");
        String appToken = Base64.decode(userToken);
        QClerk clerk = clerkHelper.getClerkModel(appToken);
        AssertUtil.assertNotNull(clerk, "用户不存在.");
        return getInFlat(formInstanceId);
    }

    /**
     * 获取表单数据
     * 
     * @param form
     * @return
     */
    @PiratesApp
    @RequestMapping
    public FrontAjaxView getInFlat(Long formInstanceId) {

        AssertUtil.assertNotNull(formInstanceId, "表单实例ID不能为空,获取表单数据失败.");
        FormInstance formInstance = formInstanceService.get(formInstanceId);
        AssertUtil.assertNotNull(formInstance, "表单实例不存在,获取表单数据失败." + formInstanceId);
        MainFormData data = formEngineService.get(formInstance);
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("查询表单数据成功.");
        view.addObject("data", data.toMap());
        view.addObject("formInstCode", formInstance.getCode());
        return view;
    }

    @RequestMapping
    public FrontAjaxView getHist4Token(Long formInstanceHistId, String userToken) {

        AssertUtil.assertNotEmpty(userToken, "用户token不能为空.");
        String appToken = Base64.decode(userToken);
        QClerk clerk = clerkHelper.getClerkModel(appToken);
        AssertUtil.assertNotNull(clerk, "用户不存在.");
        return getHist(formInstanceHistId);
    }

    /**
     * 获取表单数据
     * 
     * @param form
     * @return
     */
    @PiratesApp
    @RequestMapping
    public FrontAjaxView getHist(Long formInstanceHistId) {

        AssertUtil.assertNotNull(formInstanceHistId, "表单历史实例ID不能为空,获取表单历史数据失败.");
        FormInstanceHist formInstanceHist = formInstanceHistService.get(formInstanceHistId);
        AssertUtil.assertNotNull(formInstanceHist, "表单历史实例不存在,获取表单数据失败." + formInstanceHistId);
        MainFormData data = formEngineService.get(formInstanceHist);
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("查询表单历史数据成功.");
        view.addObject("data", formHandler.toVO(data));
        view.addObject("formInstCode", formInstanceHist.getCode());
        return view;
    }

    @RequestMapping
    public FrontAjaxView getHistInFlat4Token(Long formInstanceHistId, String userToken) {

        AssertUtil.assertNotEmpty(userToken, "用户token不能为空.");
        String appToken = Base64.decode(userToken);
        QClerk clerk = clerkHelper.getClerkModel(appToken);
        AssertUtil.assertNotNull(clerk, "用户不存在.");
        return getHistInFlat(formInstanceHistId);
    }

    @PiratesApp
    @RequestMapping
    public FrontAjaxView getHistInFlat(Long formInstanceHistId) {

        AssertUtil.assertNotNull(formInstanceHistId, "表单历史实例ID不能为空,获取表单历史数据失败.");
        FormInstanceHist formInstanceHist = formInstanceHistService.get(formInstanceHistId);
        AssertUtil.assertNotNull(formInstanceHist, "表单历史实例不存在,获取表单数据失败." + formInstanceHistId);
        MainFormData data = formEngineService.get(formInstanceHist);
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("查询表单历史数据成功.");
        view.addObject("data", data.toMap());
        view.addObject("formInstCode", formInstanceHist.getCode());
        return view;
    }

    public String createSaveFormDataToken(Long formId, Long formInstanceId, Long taskId, String processId, String processInstId, String workitemId, String appToken) {

        AssertUtil.assertNotNull(formId, "表单ID不能为空.");
        AssertUtil.greatZero(formId, "表单ID必须大于零.");
        AssertUtil.assertNotEmpty(processId, "流程定义ID不能为空.");
        String tokenKey = StringUtil.nullToEmpty(this.tokenKey);
        formInstanceId = formInstanceId == null || formInstanceId <= 0 ? -1L : formInstanceId;
        taskId = taskId == null || taskId <= 0 ? -1L : taskId;
        processInstId = StringUtil.nullToEmpty(processInstId);
        workitemId = StringUtil.nullToEmpty(workitemId);
        String str = String.valueOf(formId) + "/" + String.valueOf(formInstanceId) + "/" + String.valueOf(taskId) + "/" + processId + "/" + processInstId + "/" + workitemId + "/" + appToken + "@" + tokenKey;
        logger.info("form token source " + str);
        logger.info("form token source " + EncryptUtil.md5(str));
        return EncryptUtil.md5(str);
    }
}
