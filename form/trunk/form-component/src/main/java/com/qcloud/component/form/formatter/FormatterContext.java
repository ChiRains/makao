package com.qcloud.component.form.formatter;

import com.qcloud.component.form.EventContext;

public interface FormatterContext extends EventContext {

    String getClerkName();

    Long getDepartmentId();

    String getDepartmentName();

    Long getPostId();

    String getPostName();
}
