package com.qcloud.component.form.entity;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import com.qcloud.component.form.formatter.FormatterContext;

public class EventContextEntity implements FormatterContext {

    private Long                clerkId;

    private String              clerkName;

    private Long                departmentId;

    private String              departmentName;

    private Long                postId;

    private String              postName;

    private String              processId;

    private Long                formInstId;

    private String              formInstCode;

    private Long                formHistId;

    private boolean             saveAndSubmit;

    private MainForm            mainForm;

    private String              notionReason;

    private Integer             notionResult;

    private Map<String, Object> parameterMap = new HashMap<String, Object>();

    private Map<String, Object> returnMap    = new HashMap<String, Object>();

    private Date                now          = new Date();

    public boolean isSaveAndSubmit() {

        return saveAndSubmit;
    }

    public void setSaveAndSubmit(boolean saveAndSubmit) {

        this.saveAndSubmit = saveAndSubmit;
        parameterMap.put(SAVE_AND_SUBMIT, saveAndSubmit);
    }

    public String getProcessId() {

        return processId;
    }

    public void setProcessId(String processId) {

        this.processId = processId;
        parameterMap.put(PROCESS_ID, processId);
    }

    public String getProcessInstId() {

        return (String) getParameter(PROCESS_INST_ID);
    }

    public void setProcessInstId(String processInstId) {

        parameterMap.put(PROCESS_INST_ID, processInstId);
    }

    public String getWorkitemId() {

        return (String) getParameter(WORKITEM_ID);
    }

    public void setWorkitemId(String workitemId) {

        parameterMap.put(WORKITEM_ID, workitemId);
    }

    public Long getTaskId() {

        return (Long) getParameter(TASK_ID);
    }

    public void setTaskId(Long taskId) {

        parameterMap.put(TASK_ID, taskId);
    }

    public Long getFormInstId() {

        return formInstId;
    }

    public void setFormInstId(Long formInstId) {

        this.formInstId = formInstId;
        parameterMap.put(FORM_INST_ID, formInstId);
    }

    public Long getFormHistId() {

        return formHistId;
    }

    public void setFormHistId(Long formHistId) {

        this.formHistId = formHistId;
        parameterMap.put(FORM_HIST_ID, formHistId);
    }

    public MainForm getMainForm() {

        return mainForm;
    }

    public void setMainForm(MainForm mainForm) {

        this.mainForm = mainForm;
        parameterMap.put(FORM_ID, mainForm.getFormDef().getId());
        parameterMap.put(FORM_CODE, mainForm.getFormDef().getCode());
    }

    @Override
    public void addReturnResult(String key, Object obj) {

        returnMap.put(key, obj);
    }

    @Override
    public Long getFormId() {

        return mainForm == null ? null : mainForm.getFormDef().getId();
    }

    public String getFormCode() {

        return mainForm == null ? null : mainForm.getFormDef().getCode();
    }

    public void addParameter(String key, Object obj) {

        parameterMap.put(key, obj);
    }

    public Map<String, Object> getParameterMap() {

        return Collections.unmodifiableMap(parameterMap);
    }

    public Map<String, Object> getReturnMap() {

        return returnMap;
    }

    public Long getClerkId() {

        return clerkId;
    }

    public void setClerkId(Long clerkId) {

        this.clerkId = clerkId;
        parameterMap.put(CLERK_ID, clerkId);
    }

    public String getClerkName() {

        return clerkName;
    }

    public void setClerkName(String clerkName) {

        this.clerkName = clerkName;
        parameterMap.put(CLERK_NAME, clerkName);
    }

    @Override
    public Object getParameter(String key) {

        return parameterMap.get(key);
    }

    public Long getTaskedId() {

        return (Long) getParameter(TASKED_ID);
    }

    public Long getDepartmentId() {

        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {

        this.departmentId = departmentId;
        parameterMap.put(DEPARTMENT_ID, departmentId);
    }

    public String getDepartmentName() {

        return departmentName;
    }

    public void setDepartmentName(String departmentName) {

        this.departmentName = departmentName;
        parameterMap.put(DEPARTMENT_NAME, departmentName);
    }

    public Long getPostId() {

        return postId;
    }

    public void setPostId(Long postId) {

        this.postId = postId;
        parameterMap.put(POST_ID, postId);
    }

    public String getPostName() {

        return postName;
    }

    public void setPostName(String postName) {

        this.postName = postName;
        parameterMap.put(POST_NAME, postName);
    }

    public void setParameterMap(Map<String, Object> parameterMap) {

        this.parameterMap = parameterMap;
    }

    public void setReturnMap(Map<String, Object> returnMap) {

        this.returnMap = returnMap;
    }

    @Override
    public String getFormInstCode() {

        return formInstCode;
    }

    public void setFormInstCode(String formInstCode) {

        this.formInstCode = formInstCode;
        parameterMap.put(FORM_INST_CODE, formInstCode);
    }

    public String getNotionReason() {

        return notionReason;
    }

    public void setNotionReason(String notionReason) {

        this.notionReason = notionReason;
    }

    public Integer getNotionResult() {

        return notionResult;
    }

    public void setNotionResult(Integer notionResult) {

        this.notionResult = notionResult;
    }

    @Override
    public boolean isPass(String... notionEleName) {

        if (notionEleName == null || notionEleName.length == 0) {
            return false;
        }
        boolean result = true;
        for (String str : notionEleName) {
            Integer size = (Integer) getParameterMap().get(str + ".qc_inner_number");
            if (size == null) {
                continue;
            }
            for (int index = 0; index < size; index++) {
                Integer nr = (Integer) getParameterMap().get(str + "[" + index + "].result");
                if (nr != null && nr == 2) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    public static final String CLERK_ID        = "QCloud-Form-ClerkId";

    public static final String CLERK_NAME      = "QCloud-Form-ClerkName";

    public static final String DEPARTMENT_ID   = "QCloud-Form-DepartmentId";

    public static final String DEPARTMENT_NAME = "QCloud-Form-DepartmentName";

    public static final String POST_ID         = "QCloud-Form-PostId";

    public static final String POST_NAME       = "QCloud-Form-PostName";

    public static final String PROCESS_ID      = "QCloud-Form-ProcessId";

    public static final String FORM_ID         = "QCloud-Form-FormId";

    public static final String FORM_CODE       = "QCloud-Form-FormCode";

    public static final String FORM_INST_ID    = "QCloud-Form-FormInstId";

    public static final String FORM_INST_CODE  = "QCloud-Form-FormInstCode";

    public static final String SAVE_AND_SUBMIT = "QCloud-Form-SaveAndSubmit";

    @Override
    public Integer getNotionResult(String notionEleName) {

        String workitemId = getWorkitemId();
        Integer number = (Integer) getParameter(notionEleName + ".qc_inner_number");
        if (number != null && number > 0) {
            for (int index = 0; index < number; index++) {
                if (workitemId.equals(getParameter(notionEleName + "[" + index + "].qc_sw_workitem"))) {
                    return (Integer) getParameter(notionEleName + "[" + index + "].result");
                }
            }
        }
        return 1;
    }

    @Override
    public Date getSystemUnifiedDate() {

        return now;
    }
}
