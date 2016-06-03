package com.qcloud.component.form.engine.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import com.qcloud.component.form.FormEvent;
import com.qcloud.component.form.FormEvent.FormEventType;
import com.qcloud.component.form.engine.FormEventService;
import com.qcloud.component.form.entity.EventContextEntity;
import com.qcloud.component.form.entity.EventDefination;
import com.qcloud.component.form.entity.MainFormData;
import com.qcloud.component.form.exception.FormException;
import com.qcloud.pirates.core.context.PiratesBeanFactoryAware;
import com.qcloud.pirates.core.xml.Xml;
import com.qcloud.pirates.core.xml.XmlFactory;
import com.qcloud.pirates.core.xml.XmlItem;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.StringUtil;

@Component
public class FormEventServiceImpl implements FormEventService {

    private String[]                                 unchangeKeys = new String[] {
                                                                  //
            EventContextEntity.CLERK_ID,
            //
            EventContextEntity.CLERK_NAME,
            //
            EventContextEntity.FORM_ID,
            //
            EventContextEntity.FORM_CODE,
            //
            EventContextEntity.FORM_INST_ID,
            //
            EventContextEntity.FORM_HIST_ID,
            //
            EventContextEntity.FORM_INST_CODE,
            //
            EventContextEntity.SAVE_AND_SUBMIT,
            //
            EventContextEntity.PROCESS_ID,
            //
            EventContextEntity.DEPARTMENT_ID,
            //
            EventContextEntity.DEPARTMENT_NAME,
            //
            EventContextEntity.POST_ID,
            //
            EventContextEntity.DEPARTMENT_NAME                    };

    private final Map<String, List<EventDefination>> eventMap     = new HashMap<String, List<EventDefination>>();

    private Log                                      logger       = LogFactory.getLog(getClass());

    @PostConstruct
    public void init() {

        Xml xml = XmlFactory.get("qi-cloud-FormEventCodeList");
        if (xml != null) {
            logger.info("load form event defination.");
            List<XmlItem> itemList = xml.getItemList();
            for (XmlItem xmlItem : itemList) {
                String eventCode = StringUtil.nullToEmpty(xmlItem.getText()).trim();
                load(eventCode);
            }
        } else {
            logger.info("form event defination is not exist.");
        }
    }

    private void load(String code) {

        Xml xml = XmlFactory.get(code);
        AssertUtil.assertNotNull(xml, "表单事件未定义." + code);
        List<XmlItem> itemList = xml.getItemList();
        List<EventDefination> list = new ArrayList<EventDefination>();
        for (XmlItem xmlItem : itemList) {
            EventDefination ed = new EventDefination();
            ed.setBeanId(xmlItem.getAttrMap().get("beanId"));
            ed.setType(getType(xmlItem.getAttrMap().get("type")));
            list.add(ed);
        }
        eventMap.put(code, list);
    }

    private FormEventType getType(String type) {

        if ("saveBefore".equals(type)) {
            return FormEventType.SAVE_BEFORE;
        } else if ("saveAfter".equals(type)) {
            return FormEventType.SAVE_AFTER;
        } else if ("submitBefore".equals(type)) {
            return FormEventType.SUBMIT_BEFORE;
        } else if ("submitAfter".equals(type)) {
            return FormEventType.SUBMIT_AFTER;
        } else if ("formatBefore".equals(type)) {
            return FormEventType.FORMAT_BEFORE;
        }
        throw new FormException("表单事件类型尚未支持." + type);
    }

    @Override
    public void doEvent(String formCode, FormEventType type, EventContextEntity context, MainFormData mainFormData) {

        if (mainFormData != null) {
            fillContext(context, mainFormData);
        }
        List<EventDefination> list = eventMap.get(formCode);
        if (list != null) {
            for (EventDefination eventDefination : list) {
                if (type.equals(eventDefination.getType())) {
                    FormEvent formEvent = (FormEvent) PiratesBeanFactoryAware.getBeanFactory().getBean(eventDefination.getBeanId());
                    formEvent.doEvent(type, context);
                    Map<String, Object> map = context.getReturnMap();
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        boolean change = true;
                        if (StringUtils.isNotEmpty(entry.getKey()) && entry.getKey().startsWith("QCloud-Form-")) {
                            for (String key : unchangeKeys) {
                                if (key.equals(entry.getKey())) {
                                    change = false;
                                    break;
                                }
                            }
                        }
                        if (change) {
                            context.addParameter(entry.getKey(), entry.getValue());
                            //
                        }
                    }
                }
            }
        }
    }

    // // 将表单对象从请求对象转化为模型对象
    // private void fillFormData(Map<String, Object> map, MainFormData mainFormData) {
    //
    // MainForm mainForm = mainFormData.getMainForm();
    // List<ElementDef> elementList = mainForm.getElementList();
    // FormData formData = mainFormData.getFormData();
    // for (ElementDef elementDef : elementList) {
    // if (map.containsKey(elementDef.getCode())) {
    // Object value = map.get(elementDef.getCode());
    // formData.put(elementDef, value);
    // }
    // }
    // mainFormData.setFormData(formData);
    // List<ChildForm> children = mainForm.getChildren();
    // List<ChildFormData> childFormDataList = mainFormData.getChildren();
    // for (ChildFormData childFormData : childFormDataList) {
    //
    // childFormData.get
    //
    // }
    // for (ChildForm childForm : children) {
    // ChildFormData childFormData = getChildFormData();
    // ChildFormData childFormData = new ChildFormData(mainFormData, childForm);
    // fillFormData(map, childFormData);
    // childFormDataList.add(childFormData);
    // }
    // mainFormData.setChildren(childFormDataList);
    // }
    // // 将子表单元素从请求对象转化为模型对象
    // private void fillFormData(Map<String, Object> map,ChildForm childForm, List<ChildFormData> childFormDataList) {
    //
    //
    // ChildFormData childFormData =
    //
    //
    // String numberStr = (String) map.get(childForm.getCode() + ".qc_inner_number");
    // if (StringUtils.isEmpty(numberStr)) {
    // return;
    // }
    // int number = Integer.parseInt(numberStr);
    // List<FormData> formDataList = new ArrayList<FormData>();
    // List<ElementDef> elementList = childForm.getElementList();
    // for (int index = 0; index < number; index++) {
    // FormData formData = new FormData(elementList);
    // for (ElementDef elementDef : elementList) {
    // String key = childForm.getCode() + "[" + index + "]." + elementDef.getCode();
    // if (map.containsKey(key)) {
    // Object value = map.get(key);
    // formData.put(elementDef, value);
    // }
    // }
    // formDataList.add(formData);
    // }
    // childFormData.setFormDataList(formDataList);
    // }
    // private ElementDef getElement(List<ElementDef> elementList, String elementCode) {
    //
    // ElementDef ele = null;
    // for (ElementDef elementDef : elementList) {
    // if (elementDef.getCode().equals(elementCode)) {
    // ele = elementDef;
    // break;
    // }
    // }
    // return ele;
    // }
    private void fillContext(EventContextEntity context, MainFormData mainFormData) {

        Map<String, Object> map = mainFormData.toMap();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            context.addParameter(entry.getKey(), entry.getValue());
        }
    }
}
