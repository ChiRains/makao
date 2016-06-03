package com.qcloud.component.form.core;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.form.FormClient;
import com.qcloud.component.form.QFormInstance;
import com.qcloud.component.form.QMainForm;
import com.qcloud.component.form.QMainFormData;
import com.qcloud.component.form.engine.FormEngineService;
import com.qcloud.component.form.entity.FormInstanceEntity;
import com.qcloud.component.form.model.ElementDef;
import com.qcloud.component.form.model.FormDef;
import com.qcloud.component.form.model.FormInstance;
import com.qcloud.component.form.model.FormInstanceHist;
import com.qcloud.component.form.model.query.ElementDefQuery;
import com.qcloud.component.form.model.query.FormDefQuery;
import com.qcloud.component.form.service.ElementDefService;
import com.qcloud.component.form.service.FormDefService;
import com.qcloud.component.form.service.FormInstanceHistService;
import com.qcloud.component.form.service.FormInstanceService;
import com.qcloud.pirates.core.reflect.BeanUtils;
import com.qcloud.pirates.core.xml.Xml;
import com.qcloud.pirates.core.xml.XmlFactory;
import com.qcloud.pirates.core.xml.XmlItem;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.StringUtil;

@Service
public class FormClientImpl implements FormClient {

    @Autowired
    private FormDefService          formDefService;

    @Autowired
    private ElementDefService       elementDefService;

    @Autowired
    private FormInstanceService     formInstanceService;

    @Autowired
    private FormInstanceHistService formInstanceHistService;

    @Autowired
    private FormEngineService       formEngineService;

    @Override
    public List<FormDef> listAll(FormDefQuery query) {

        return formDefService.listAll(query);
    }

    @Override
    public FormDef getFormDef(Long id) {

        return formDefService.get(id);
    }

    @Override
    public List<ElementDef> listAllElementDef(ElementDefQuery query) {

        return elementDefService.listAll(BeanUtils.transBean2Map(query));
    }

    @Override
    public QMainFormData get(Long formInstanceId) {

        AssertUtil.assertNotNull(formInstanceId, "表单实例ID不能为空,获取表单数据失败.");
        FormInstance formInstance = formInstanceService.get(formInstanceId);
        AssertUtil.assertNotNull(formInstance, "表单实例不存在,获取表单数据失败." + formInstanceId);
        return formEngineService.get(formInstance);
    }

    @Override
    public QMainFormData getHist(Long formInstanceHistId) {

        AssertUtil.assertNotNull(formInstanceHistId, "表单历史实例ID不能为空,获取表单历史数据失败.");
        FormInstanceHist formInstanceHist = formInstanceHistService.get(formInstanceHistId);
        AssertUtil.assertNotNull(formInstanceHist, "表单历史实例不存在,获取表单数据失败." + formInstanceHistId);
        return formEngineService.get(formInstanceHist);
    }

    @Override
    public String getFormInstCode(Long formInstanceId) {

        AssertUtil.assertNotNull(formInstanceId, "表单实例ID不能为空,获取表单数据失败.");
        FormInstance formInstance = formInstanceService.get(formInstanceId);
        AssertUtil.assertNotNull(formInstance, "表单实例不存在,获取表单数据失败." + formInstanceId);
        return formInstance.getCode();
    }

    @Override
    public QMainForm getForm(Long formId) {

        return formEngineService.getForm(formId);
    }

    @Override
    public String getMobileDomain() {

        String domian = "";
        Xml xml = XmlFactory.get("qi-cloud-FormMobileViewPageDomain");
        if (xml != null && !xml.getItemList().isEmpty()) {
            XmlItem xmlItem = xml.getItemList().get(0);
            domian = StringUtil.nullToEmpty(xmlItem.getAttrMap().get("url")).trim();
        }
        return domian;
    }

    @Override
    public QFormInstance getByCode(String code) {

        FormInstance formInstance = formInstanceService.getByCode(code);
        FormInstanceEntity entity = new FormInstanceEntity();
        entity.setId(formInstance.getId());
        entity.setFormId(formInstance.getFormId());
        entity.setDataId(formInstance.getDataId());
        entity.setCode(formInstance.getCode());
        entity.setEditTime(formInstance.getEditTime());
        return entity;
    }
}