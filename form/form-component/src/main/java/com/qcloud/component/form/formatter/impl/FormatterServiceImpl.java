package com.qcloud.component.form.formatter.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import com.qcloud.component.form.entity.MainFormData;
import com.qcloud.component.form.formatter.FormatService;
import com.qcloud.component.form.formatter.Formatter;
import com.qcloud.component.form.formatter.FormatterContext;
import com.qcloud.pirates.core.context.PiratesBeanFactoryAware;

@Component
public class FormatterServiceImpl implements FormatService {

    private static List<Formatter> list = new ArrayList<Formatter>();
    static {
        Formatter dateFormatter = (Formatter) PiratesBeanFactoryAware.getBeanFactory().getBean("dateFormatter");
        Formatter fileFormatter = (Formatter) PiratesBeanFactoryAware.getBeanFactory().getBean("fileFormatter");
        Formatter organizationFormatter = (Formatter) PiratesBeanFactoryAware.getBeanFactory().getBean("organizationFormatter");
        Formatter processFormatter = (Formatter) PiratesBeanFactoryAware.getBeanFactory().getBean("processFormatter");
        Formatter notionFormatter = (Formatter) PiratesBeanFactoryAware.getBeanFactory().getBean("notionFormatter");
        list.add(dateFormatter);
        list.add(fileFormatter);
        list.add(organizationFormatter);
        // 意见需要放到最后面
        list.add(processFormatter);
        // 意见需要放到最后面
        list.add(notionFormatter);
    }

    @Override
    public void formatSaveFormData(FormatterContext context, MainFormData mainFormData) {

        for (Formatter formatter : list) {
            formatter.format4Save(context, mainFormData);
        }
    }

    @Override
    public void formatViewFormData(MainFormData mainFormData) {

        for (Formatter formatter : list) {
            formatter.format4View(mainFormData);
        }
    }
}
