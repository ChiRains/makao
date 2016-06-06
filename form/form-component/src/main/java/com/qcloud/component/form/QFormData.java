package com.qcloud.component.form;

import java.util.List;
import java.util.Map;
import com.qcloud.component.form.model.ElementDef;

public interface QFormData {

    List<QFormElement> elements();

//    Map<ElementDef, Object> toDataMap();
}
