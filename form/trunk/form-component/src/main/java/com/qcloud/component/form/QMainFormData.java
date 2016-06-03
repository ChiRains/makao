package com.qcloud.component.form;

import java.util.List;
import java.util.Map;

public interface QMainFormData {

    QMainForm getMainForm();

    QFormData getFormData();

    List<QChildFormData> children();

    Map<String, Object> toMap();
}
