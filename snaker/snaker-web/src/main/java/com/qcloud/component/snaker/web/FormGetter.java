package com.qcloud.component.snaker.web;

import org.snaker.engine.entity.Process;

public interface FormGetter {

    Long getForm(Process process);

    String getPcApplyUrl(Long formId);

    String getMobileApplyUrl(Long formId);

    String getMobileDomain();
}
