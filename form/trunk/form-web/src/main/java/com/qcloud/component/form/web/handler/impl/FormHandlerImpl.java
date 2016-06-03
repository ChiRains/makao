package com.qcloud.component.form.web.handler.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.qcloud.component.form.entity.ChildForm;
import com.qcloud.component.form.entity.ChildFormData;
import com.qcloud.component.form.entity.FormData;
import com.qcloud.component.form.entity.MainForm;
import com.qcloud.component.form.entity.MainFormData;
import com.qcloud.component.form.model.ElementDef;
import com.qcloud.component.form.web.handler.FormHandler;
import com.qcloud.component.form.web.vo.ChildFormDataVO;
import com.qcloud.component.form.web.vo.ChildFormVO;
import com.qcloud.component.form.web.vo.FormDataVO;
import com.qcloud.component.form.web.vo.MainFormDataVO;
import com.qcloud.component.form.web.vo.MainFormVO;
import com.qcloud.pirates.util.AssertUtil;

@Component
public class FormHandlerImpl implements FormHandler {

    @Override
    public MainFormDataVO toVO(MainFormData mainFormData) {

        Map<ChildForm, ChildFormVO> mapping = new HashMap<ChildForm, ChildFormVO>();
        MainForm mainForm = mainFormData.getMainForm();
        MainFormDataVO mainFormDataVO = new MainFormDataVO();
        MainFormVO mainFormVO = toVO(mainForm);
        List<ChildFormVO> children = new ArrayList<ChildFormVO>();
        for (ChildForm childForm : mainForm.getChildren()) {
            ChildFormVO childFormVO = toVO(childForm);
            children.add(childFormVO);
            mapping.put(childForm, childFormVO);
        }
        mainFormVO.setChildren(children);
        mainFormDataVO.setMainForm(mainFormVO);
        mainFormDataVO.setFormData(toVO(mainFormData.getFormData()));
        List<ChildFormData> childFormDataList = mainFormData.getChildren();
        List<ChildFormDataVO> childDataList = new ArrayList<ChildFormDataVO>();
        for (ChildFormData childFormData : childFormDataList) {
            ChildFormVO childFormVO = mapping.get(childFormData.getChildForm());
            AssertUtil.assertNotNull(childFormVO, "表单数据子表单定义在主表单不存在." + childFormData.getChildForm().getName());
            ChildFormDataVO childFormDataVO = toVO(childFormData, childFormVO);
            childDataList.add(childFormDataVO);
        }
        mainFormDataVO.setChildren(childDataList);
        return mainFormDataVO;
    }

    private MainFormVO toVO(MainForm mainForm) {

        MainFormVO mainFormVO = new MainFormVO();
        mainFormVO.setFormId(mainForm.getFormDef().getId());
        mainFormVO.setFormName(mainForm.getFormDef().getName());
        mainFormVO.setFormCode(mainForm.getFormDef().getCode());
        mainFormVO.setAttributeList(eleToAttrKeys(mainForm.getElementList()));
        return mainFormVO;
    }

    private ChildFormVO toVO(ChildForm childForm) {

        ChildFormVO childFormVO = new ChildFormVO();
        childFormVO.setFormId(childForm.getFormDef().getId());
        childFormVO.setFormName(childForm.getFormDef().getName());
        childFormVO.setFormCode(childForm.getFormDef().getCode());
        childFormVO.setAttributeList(eleToAttrKeys(childForm.getElementList()));
        return childFormVO;
    }

    private FormDataVO toVO(FormData formData) {

        FormDataVO formDataVO = new FormDataVO();
        formDataVO.setAttributeList(eleToAttrKeys(formData.getElementList()));
        Map<String, Object> map = new HashMap<String, Object>();
        for (ElementDef element : formData.getElementList()) {
            map.put(element.getCode(), formData.getDataMap().get(element));
        }
        formDataVO.setDataMap(map);
        return formDataVO;
    }

    private ChildFormDataVO toVO(ChildFormData childFormData, ChildFormVO childForm) {

        ChildFormDataVO childFormDataVO = new ChildFormDataVO();
        childFormDataVO.setChildForm(childForm);
        List<FormData> list = childFormData.getFormDataList();
        List<FormDataVO> formDataList = new ArrayList<FormDataVO>();
        for (FormData formData : list) {
            formDataList.add(toVO(formData));
        }
        childFormDataVO.setFormDataList(formDataList);
        return childFormDataVO;
    }

    private List<String> eleToAttrKeys(List<ElementDef> eleList) {

        List<String> keys = new ArrayList<String>();
        for (ElementDef element : eleList) {
            keys.add(element.getCode());
        }
        return keys;
    }
}
