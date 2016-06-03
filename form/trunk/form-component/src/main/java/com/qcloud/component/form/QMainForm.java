package com.qcloud.component.form;

import java.util.List;

public interface QMainForm {

    List<QChildForm> children();

    List<QFormElement> elements();

    Long getId();

    String getName();

    String getCode();

    String getPcApplyViewUrl();

    String getPcTaskingViewUrl();

    String getPcTaskedViewUrl();

    String getMobileApplyViewUrl();

    String getMobileTaskingViewUrl();

    String getMobileTaskedViewUrl();
}
