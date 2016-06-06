package com.qcloud.component.form;

import java.util.Date;
import java.util.Map;

public interface EventContext {

    Long getClerkId();

    String getProcessId();

    String getProcessInstId();

    String getWorkitemId();

    Long getTaskId();

    Long getTaskedId();

    Long getFormId();

    String getFormCode();

    Long getFormInstId();

    String getFormInstCode();

    Long getFormHistId();

    boolean isSaveAndSubmit();

    String getNotionReason();

    Integer getNotionResult();

    Integer getNotionResult(String notionEleName);

    boolean isPass(String... notionEleName);

    Date getSystemUnifiedDate();

    void setClerkId(Long clerkId);

    // 与流程 ,任务相关的返回值的key
    String PROCESS_INST_ID = "QCloud-Form-ProcessInstId";

    String WORKITEM_ID     = "QCloud-Form-WorkitemId";

    String TASK_ID         = "QCloud-Form-TaskId";

    String TASKED_ID       = "QCloud-Form-TaskedId";

    String SAVE_SENDED     = "QCloud-Form-SaveSended";

    String FORM_HIST_ID    = "QCloud-Form-FormHistId";

    Map<String, Object> getParameterMap();

    Object getParameter(String key);

    void addReturnResult(String key, Object obj);
}
