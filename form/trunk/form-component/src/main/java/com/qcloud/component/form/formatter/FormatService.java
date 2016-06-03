package com.qcloud.component.form.formatter;

import com.qcloud.component.form.entity.MainFormData;

public interface FormatService {

    void formatSaveFormData(FormatterContext context, MainFormData mainFormData);

    void formatViewFormData(MainFormData mainFormData);
}
