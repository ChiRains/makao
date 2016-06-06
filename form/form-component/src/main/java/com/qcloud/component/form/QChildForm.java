package com.qcloud.component.form;

import java.util.List;

public interface QChildForm {

    List<QFormElement> elements();

    QMainForm getMainForm();

    String getName();

    String getCode();
}
