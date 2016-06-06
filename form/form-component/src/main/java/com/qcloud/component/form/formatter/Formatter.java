package com.qcloud.component.form.formatter;

import com.qcloud.component.form.entity.MainFormData;

public interface Formatter {

    void format4Save(FormatterContext context, MainFormData mainFormData);

    void format4View(MainFormData mainFormData);
}
