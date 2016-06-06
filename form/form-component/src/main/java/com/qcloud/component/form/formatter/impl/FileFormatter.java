package com.qcloud.component.form.formatter.impl;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.filesdk.FileSDKClient;
import com.qcloud.component.form.entity.ChildFormData;
import com.qcloud.component.form.entity.FormData;
import com.qcloud.component.form.entity.MainFormData;
import com.qcloud.component.form.formatter.Formatter;
import com.qcloud.component.form.formatter.FormatterContext;
import com.qcloud.component.form.model.ElementDef;
import com.qcloud.component.form.model.key.TypeEnum.ElementType;

@Component
public class FileFormatter implements Formatter {

    @Autowired
    private FileSDKClient fileSDKClient;

    @Override
    public void format4Save(FormatterContext context, MainFormData mainFormData) {

        List<ElementDef> list = mainFormData.getMainForm().getElementList();
        format4Save(list, mainFormData.getFormData());
        for (ChildFormData childFormData : mainFormData.getChildren()) {
            for (FormData formData : childFormData.getFormDataList()) {
                format4Save(childFormData.getChildForm().getElementList(), formData);
            }
        }
    }

    public void format4Save(List<ElementDef> list, FormData formData) {

        for (ElementDef elementDef : list) {
            if (ElementType.FILE.getKey() == elementDef.getType()) {
                String str = (String) formData.getDataMap().get(elementDef);
                if (StringUtils.isNotEmpty(str)) {
                    formData.put(elementDef, fileSDKClient.uidToUrl(str));
                }
            }
        }
    }

    @Override
    public void format4View(MainFormData mainFormData) {

        List<ElementDef> list = mainFormData.getMainForm().getElementList();
        List<ElementDef> urlList = addFileUrlEleList(list);
        mainFormData.getMainForm().getElementList().addAll(urlList);
        format4View(list, mainFormData.getFormData());
        for (ChildFormData childFormData : mainFormData.getChildren()) {
            List<ElementDef> childrenUrlList = addFileUrlEleList(childFormData.getChildForm().getElementList());
            childFormData.getChildForm().getElementList().addAll(childrenUrlList);
            for (FormData formData : childFormData.getFormDataList()) {
                format4View(childFormData.getChildForm().getElementList(), formData);
            }
        }
    }

    private List<ElementDef> addFileUrlEleList(List<ElementDef> list) {

        List<ElementDef> fileUrlList = new ArrayList<ElementDef>();
        for (ElementDef elementDef : list) {
            if (ElementType.FILE.getKey() == elementDef.getType()) {
                ElementDef urlEle = new ElementDef();
                urlEle.setFormId(elementDef.getFormId());
                urlEle.setId(-1L);
                urlEle.setName(elementDef.getName() + "_file_url");
                urlEle.setType(-1);
                urlEle.setCode(elementDef.getCode() + "_file_url");
                fileUrlList.add(urlEle);
            }
        }
        return fileUrlList;
    }

    private void format4View(List<ElementDef> list, FormData formData) {

        for (ElementDef elementDef : list) {
            if (ElementType.FILE.getKey() == elementDef.getType()) {
                String str = (String) formData.getDataMap().get(elementDef);
                if (StringUtils.isNotEmpty(str)) {
                    ElementDef urlDef = getFileUrlEle(list, elementDef);
                    formData.put(urlDef, fileSDKClient.getFileServerUrl() + str);
                    formData.put(elementDef, fileSDKClient.urlToUid(str));
                }
            }
        }
    }

    private ElementDef getFileUrlEle(List<ElementDef> list, ElementDef fileElementDef) {

        for (ElementDef elementDef : list) {
            if ((fileElementDef.getCode() + "_file_url").equals(elementDef.getCode())) {
                return elementDef;
            }
        }
        return null;
    }
}
