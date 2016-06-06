package com.qcloud.component.form.engine.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.qcloud.component.autoid.UniqueCodeGenerator;
import com.qcloud.component.form.FormEvent.FormEventType;
import com.qcloud.component.form.engine.FormEngineService;
import com.qcloud.component.form.engine.FormEventService;
import com.qcloud.component.form.entity.ChildForm;
import com.qcloud.component.form.entity.ChildFormData;
import com.qcloud.component.form.entity.EventContextEntity;
import com.qcloud.component.form.entity.FormData;
import com.qcloud.component.form.entity.MainForm;
import com.qcloud.component.form.entity.MainFormData;
import com.qcloud.component.form.exception.FormException;
import com.qcloud.component.form.formatter.FormatService;
import com.qcloud.component.form.model.ElementDef;
import com.qcloud.component.form.model.ElementFieldMapping;
import com.qcloud.component.form.model.FormDef;
import com.qcloud.component.form.model.FormInstance;
import com.qcloud.component.form.model.FormInstanceHist;
import com.qcloud.component.form.model.FormTableMapping;
import com.qcloud.component.form.model.key.TypeEnum;
import com.qcloud.component.form.model.key.TypeEnum.ElementType;
import com.qcloud.component.form.service.ElementDefService;
import com.qcloud.component.form.service.ElementFieldMappingService;
import com.qcloud.component.form.service.FormDefService;
import com.qcloud.component.form.service.FormInstanceHistService;
import com.qcloud.component.form.service.FormInstanceService;
import com.qcloud.component.form.service.FormTableMappingService;
import com.qcloud.component.form.util.MetadataObjValueUtils;
import com.qcloud.component.metadata.MetadataClient;
import com.qcloud.component.metadata.QDataObject;
import com.qcloud.component.metadata.QDataView;
import com.qcloud.component.metadata.QField;
import com.qcloud.component.metadata.QTable;
import com.qcloud.component.metadata.QueryParam;
import com.qcloud.pirates.core.xml.Xml;
import com.qcloud.pirates.core.xml.XmlFactory;
import com.qcloud.pirates.core.xml.XmlItem;
import com.qcloud.pirates.util.AssertUtil;

@Service
public class FormEngineServiceImpl implements FormEngineService {

    @Autowired
    private FormDefService             formDefService;

    @Autowired
    private ElementDefService          elementDefService;

    @Autowired
    private MetadataClient             metadataClient;

    @Autowired
    private FormTableMappingService    formTableMappingService;

    @Autowired
    private ElementFieldMappingService elementFieldMappingService;

    @Autowired
    private FormInstanceService        formInstanceService;

    @Autowired
    private FormInstanceHistService    formInstanceHistService;

    @Autowired
    private FormEventService           formEventService;

    @Autowired
    private FormatService              formatService;

    @Autowired
    private UniqueCodeGenerator        uniqueCodeGenerator;

    private Log                        logger = LogFactory.getLog(getClass());

    // ************************************************************保存表单数据*****************************************************
    @Transactional
    @Override
    public boolean save(FormInstance formInstance, MainFormData mainFormData, EventContextEntity context) {

        formatService.formatSaveFormData(context, mainFormData);
        formEventService.doEvent(context.getFormCode(), FormEventType.SAVE_BEFORE, context, mainFormData);
        FormInstance fi = formInstanceService.get(formInstance.getId());
        if (fi == null) {
            formInstance.setEditTime(new Date());
            formInstance.setCode(uniqueCodeGenerator.generate("pirates-form-inst-code", new HashMap<String, String>()));
            formInstanceService.add(formInstance);
        } else {
            formInstance.setCode(fi.getCode());
            ElementDef elementDef = getElement(mainFormData.getFormData().getElementList(), TypeEnum.QC_MD_ID);
            AssertUtil.assertNotNull(elementDef, "元素未定义:" + TypeEnum.QC_MD_ID);
            mainFormData.getFormData().put(elementDef, String.valueOf(fi.getDataId()));
            boolean result = formInstanceService.update(formInstance);
            if (!result) {
                throw new FormException("表单数据已被其他用户更新,请重新获取.");
            }
        }
        synchronized (String.valueOf(formInstance.getId())) {
            long masterId = save(mainFormData.getMainForm(), mainFormData.getFormData());
            List<ChildFormData> childFormDataList = mainFormData.getChildren();
            for (ChildFormData childFormData : childFormDataList) {
                // TODO 在这里处理子表只读,可写
                save(childFormData.getChildForm(), childFormData.getFormDataList(), masterId);
            }
            formInstance.setDataId(masterId);
            formInstanceService.update(formInstance);
        }
        //
        context.setFormInstId(formInstance.getId());
        context.setFormInstCode(formInstance.getCode());
        formEventService.doEvent(context.getFormCode(), FormEventType.SAVE_AFTER, context, mainFormData);
        return true;
    }

    // private String calculateCode(Long formId) {
    //
    // Xml xml = XmlFactory.get("qi-cloud-FormInstCodeVariableList");
    // if (xml == null) {
    // return "";
    // }
    // StringBuffer sb = new StringBuffer("");
    // List<XmlItem> list = xml.getItemList();
    // for (XmlItem xmlItem : list) {
    // if ("string".equals(xmlItem.getAttrMap().get("type"))) {
    // sb.append(StringUtil.nullToEmpty(xmlItem.getText()).trim());
    // } else if ("time".equals(xmlItem.getAttrMap().get("type"))) {
    // String timeStr = StringUtil.nullToEmpty(xmlItem.getText()).trim();
    // String time = DateUtil.date2String(new Date(), timeStr);
    // sb.append(time);
    // } else if ("number".equals(xmlItem.getAttrMap().get("type"))) {
    // String val = StringUtil.nullToEmpty(xmlItem.getText()).trim();
    // String str = sb.toString();
    // int number = formInstanceCodeNumberService.getNextNumber(str);
    // sb.append(StringUtils.leftPad(String.valueOf(number), val.length(), "0"));
    // }
    // }
    // return sb.toString();
    // }
    private Long save(MainForm mainForm, FormData formData) {

        logger.info("begin save main form." + mainForm.getName());
        List<ElementFieldMapping> list = elementFieldMappingService.listByForm(mainForm.getFormDef().getId());
        ElementDef elementDef = getElement(mainForm.getElementList(), TypeEnum.QC_MD_ID);
        AssertUtil.assertNotNull(elementDef, "元素未定义:" + TypeEnum.QC_MD_ID);
        String value = (String) formData.getDataMap().get(elementDef);
        QDataView dataView = initDataView(mainForm.getFormDef(), mainForm.getElementList(), list, TypeEnum.QC_MD_ID, value);
        QDataObject dataObject = exchangeData(mainForm.getFormDef(), mainForm.getElementList(), list, formData, dataView);
        metadataClient.update(dataObject.getDataView());
        logger.info("finish save main form." + mainForm.getName());
        return dataObject.getPrimaryValue();
    }

    private boolean save(ChildForm childForm, List<FormData> formDataList, long masterId) {

        List<ElementFieldMapping> list = elementFieldMappingService.listByForm(childForm.getFormDef().getId());
        ElementDef elementDef = getElement(childForm.getElementList(), TypeEnum.QC_MD_MASTERID);
        AssertUtil.assertNotNull(elementDef, "元素未定义:" + TypeEnum.QC_MD_MASTERID);
        ElementFieldMapping mapping = getElementFieldMapping(list, elementDef);
        AssertUtil.assertNotNull(mapping, "表单" + childForm.getName() + " 元素" + elementDef.getName() + " 没有映射.");
        QField field = metadataClient.getFieldModel(mapping.getFieldId());
        AssertUtil.assertNotNull(field, "字段定义不存在." + mapping.getFieldId());
        QDataView dataView = initDataView(childForm.getFormDef(), childForm.getElementList(), list, TypeEnum.QC_MD_MASTERID, String.valueOf(masterId));
        for (FormData formData : formDataList) {
            QDataObject dataObject = exchangeData(childForm.getFormDef(), childForm.getElementList(), list, formData, dataView);
            // 设置外键值关联
            dataObject.setDataAttr(field.getName(), masterId);
            if (formData.isDelete()) {
                dataObject.setDelete();
            }
            dataView = dataObject.getDataView();
        }
        if (dataView != null) {
            metadataClient.update(dataView);
        }
        return true;
    }

    private QDataView initDataView(FormDef formDef, List<ElementDef> elementList, List<ElementFieldMapping> list, String masterKey, String value) {

        QDataView dataView = null;
        ElementDef elementDef = getElement(elementList, masterKey);
        AssertUtil.assertNotNull(elementDef, "元素未定义:" + masterKey);
        FormTableMapping formTableMapping = formTableMappingService.getByForm(formDef.getId());
        AssertUtil.assertNotNull(formTableMapping, "表单尚未映射元数据:" + formDef.getName());
        long tableId = formTableMapping.getTableId();
        if (StringUtils.isEmpty(value)) {
            dataView = metadataClient.newView(tableId);
        } else {
            QueryParam queryParam = new QueryParam();
            ElementFieldMapping mapping = getElementFieldMapping(list, elementDef);
            AssertUtil.assertNotNull(mapping, "表单" + formDef.getName() + " 元素" + elementDef.getName() + " 没有映射.");
            QField field = metadataClient.getFieldModel(mapping.getFieldId());
            AssertUtil.assertNotNull(field, "字段定义不存在." + mapping.getFieldId());
            queryParam.addParam(field.getName(), value);
            dataView = metadataClient.select(tableId, queryParam);
        }
        return dataView;
    }

    private QDataObject exchangeData(FormDef formDef, List<ElementDef> elementList, List<ElementFieldMapping> list, FormData formData, QDataView dataView) {

        ElementDef idEle = getPrimaryElement(elementList);
        AssertUtil.assertNotNull(idEle, "ID元素未定义:" + formDef.getName());
        String id = (String) formData.getDataMap().get(idEle);
        // 获取到当前对象
        QDataObject dataObject = null;
        if (StringUtils.isEmpty(id)) {
            dataObject = dataView.addDataObject();
        } else {
            dataObject = dataView.get(Long.parseLong(id));
            AssertUtil.assertNotNull(dataObject, "数据不存在:" + formDef.getName() + " " + id);
        }
        for (ElementDef elementDef : elementList) {
            if (!elementDef.equals(idEle) && ElementType.PARAMETER.getKey() != elementDef.getType() && elementDef.getType() > 0 && formData.isSave(elementDef)) {
                ElementFieldMapping elementFieldMapping = getElementFieldMapping(list, elementDef);
                AssertUtil.assertNotNull(elementFieldMapping, "表单" + formDef.getName() + " 元素" + elementDef.getName() + " 没有映射.");
                QField field = getField(dataObject.getTable(), elementFieldMapping.getFieldId());
                AssertUtil.assertNotNull(field, "字段定义不存在." + elementFieldMapping.getFieldId());
//                logger.info(elementDef.getName());
                // TODO 在这里处理元素只读,可写
                dataObject.setDataAttr(field.getName(), MetadataObjValueUtils.getFieldObject(field, (String) formData.getDataMap().get(elementDef)));
            }
        }
        return dataObject;
    }

    // *************************************************************************************************************************
    // ************************************************************提交表单数据*****************************************************
    @Transactional
    @Override
    public FormInstanceHist submit(FormInstance formInstance, EventContextEntity context) {

        // 获取表单数据
        MainFormData mainFormData = get(formInstance, false);
        context.setFormInstId(formInstance.getId());
        context.setFormInstCode(formInstance.getCode());
        formEventService.doEvent(context.getFormCode(), FormEventType.SUBMIT_BEFORE, context, mainFormData);
        long masterId = submit(mainFormData.getMainForm(), mainFormData.getFormData());
        // 比较实例与历史之间的定义来达成
        for (ChildFormData childFormData : mainFormData.getChildren()) {
            submit(childFormData.getChildForm(), childFormData.getFormDataList(), masterId);
        }
        FormInstanceHist formInstanceHist = new FormInstanceHist();
        formInstanceHist.setBackTime(new Date());
        formInstanceHist.setDataId(masterId);
        formInstanceHist.setEditTime(formInstance.getEditTime());
        formInstanceHist.setFormId(formInstance.getFormId());
        formInstanceHist.setFormInstanceId(formInstance.getId());
        formInstanceHist.setCode(formInstance.getCode());
        formInstanceHistService.add(formInstanceHist);
        context.setFormHistId(formInstanceHist.getId());
        formEventService.doEvent(context.getFormCode(), FormEventType.SUBMIT_AFTER, context, mainFormData);
        return formInstanceHist;
    }

    private Long submit(MainForm mainForm, FormData formData) {

        logger.info("begin submit main form." + mainForm.getName());
        List<ElementFieldMapping> list = elementFieldMappingService.listByForm(mainForm.getFormDef().getId());
        FormTableMapping formTableMapping = formTableMappingService.getByForm(mainForm.getFormDef().getId());
        AssertUtil.assertNotNull(formTableMapping, "表单尚未映射元数据:" + mainForm.getFormDef().getName());
        long tableId = formTableMapping.getTableId();
        QTable table = metadataClient.getTableModel(tableId);
        QDataView dataView = metadataClient.newView(table.getName() + "_hist");
        QDataObject dataObject = dataView.addDataObject();
        String idKey = "id";
        ElementDef idEle = getElement(mainForm.getElementList(), idKey);
        for (ElementDef elementDef : mainForm.getElementList()) {
            if (!elementDef.equals(idEle) && ElementType.PARAMETER.getKey() != elementDef.getType() && elementDef.getType() > 0) {
                ElementFieldMapping elementFieldMapping = getElementFieldMapping(list, elementDef);
                AssertUtil.assertNotNull(elementFieldMapping, "表单" + mainForm.getName() + " 元素" + elementDef.getName() + " 没有映射.");
                QField field = getField(table, elementFieldMapping.getFieldId());
                AssertUtil.assertNotNull(field, "字段定义不存在." + elementFieldMapping.getFieldId());
                dataObject.setDataAttr(field.getName(), formData.getDataMap().get(elementDef));
            }
        }
        metadataClient.update(dataObject.getDataView());
        logger.info("finish submit main form." + mainForm.getName());
        return dataObject.getPrimaryValue();
    }

    private void submit(ChildForm childForm, List<FormData> formDataList, long masterId) {

        logger.info("begin submit main form." + childForm.getName());
        List<ElementFieldMapping> list = elementFieldMappingService.listByForm(childForm.getFormDef().getId());
        FormTableMapping formTableMapping = formTableMappingService.getByForm(childForm.getFormDef().getId());
        AssertUtil.assertNotNull(formTableMapping, "表单尚未映射元数据:" + childForm.getFormDef().getName());
        long tableId = formTableMapping.getTableId();
        QTable table = metadataClient.getTableModel(tableId);
        QDataView dataView = metadataClient.newView(table.getName() + "_hist");
        String idKey = "id";
        ElementDef idEle = getElement(childForm.getElementList(), idKey);
        String masterKey = "masterId";
        ElementDef masterEle = getElement(childForm.getElementList(), masterKey);
        for (FormData formData : formDataList) {
            QDataObject dataObject = dataView.addDataObject();
            // 普通元素
            for (ElementDef elementDef : childForm.getElementList()) {
                if (!elementDef.equals(idEle) && ElementType.PARAMETER.getKey() != elementDef.getType() && elementDef.getType() > 0) {
                    ElementFieldMapping elementFieldMapping = getElementFieldMapping(list, elementDef);
                    AssertUtil.assertNotNull(elementFieldMapping, "表单" + childForm.getName() + " 元素" + elementDef.getName() + " 没有映射.");
                    QField field = getField(table, elementFieldMapping.getFieldId());
                    AssertUtil.assertNotNull(field, "字段定义不存在." + elementFieldMapping.getFieldId());
                    dataObject.setDataAttr(field.getName(), formData.getDataMap().get(elementDef));
                }
            }
            // 外键关联
            ElementFieldMapping masterMapping = getElementFieldMapping(list, masterEle);
            AssertUtil.assertNotNull(masterMapping, "表单" + childForm.getName() + " 元素" + masterEle.getName() + " 没有映射.");
            QField masterField = getField(table, masterMapping.getFieldId());
            AssertUtil.assertNotNull(masterField, "字段定义不存在." + masterMapping.getFieldId());
            dataObject.setDataAttr(masterField.getName(), masterId);
        }
        metadataClient.update(dataView);
        logger.info("finish submit main form." + childForm.getName());
    }

    // *************************************************************************************************************************
    // ************************************************************获取表单数据*****************************************************
    @Override
    public MainFormData get(FormInstance formInstance) {

        return get(formInstance, true);
    }

    private MainFormData get(FormInstance formInstance, boolean format) {

        return get(formInstance.getFormId(), formInstance.getDataId(), true, format);
    }

    @Override
    public MainFormData get(FormInstanceHist formInstanceHist) {

        return get(formInstanceHist.getFormId(), formInstanceHist.getDataId(), false, true);
    }

    private MainFormData get(long formId, long dataId, boolean instance, boolean format) {

        MainFormData mainFormData = get(formId, dataId, instance);
        if (format) {
            formatService.formatViewFormData(mainFormData);
        }
        return mainFormData;
    }

    /**
     * 
     * @param formId 表单ID
     * @param dataId  instance 
     * @param instance instance true 实例数据 false 历史数据
     * @return
     */
    private MainFormData get(long formId, long dataId, boolean instance) {

        String tableSuffix = instance ? "" : "_hist";
        MainForm mainForm = getForm(formId);
        MainFormData mainFormData = new MainFormData(mainForm);
        // 获取主表数据
        FormData formData = getMainFormData(mainForm, dataId, tableSuffix);
        mainFormData.setFormData(formData);
        // 获取从表数据
        List<ChildForm> childFormList = mainForm.getChildren();
        List<ChildFormData> children = new ArrayList<ChildFormData>();
        for (ChildForm childForm : childFormList) {
            List<FormData> childFormDataList = listChildFormData(childForm, dataId, tableSuffix);
            ChildFormData childFormData = new ChildFormData(mainFormData, childForm);
            childFormData.setFormDataList(childFormDataList);
            children.add(childFormData);
        }
        mainFormData.setChildren(children);
        return mainFormData;
    }

    private FormData getMainFormData(MainForm mainForm, long dataId, String tableSuffix) {

        String idKey = "id";
        List<ElementFieldMapping> mmList = elementFieldMappingService.listByForm(mainForm.getFormDef().getId());
        FormTableMapping formTableMapping = formTableMappingService.getByForm(mainForm.getFormDef().getId());
        AssertUtil.assertNotNull(formTableMapping, "表单尚未映射元数据:" + mainForm.getFormDef().getName());
        long tableId = formTableMapping.getTableId();
        QTable table = metadataClient.getTableModel(tableId);
        List<FormData> dataList = getFormData(mainForm.getFormDef(), mainForm.getElementList(), table, tableSuffix, mmList, idKey, dataId);
        AssertUtil.assertNotEmpty(dataList, "主表单数据不存在." + mainForm.getFormDef().getName() + " " + dataId);
        return dataList.get(0);
    }

    public List<FormData> listChildFormData(ChildForm childForm, long masterId) {

        return listChildFormData(childForm, masterId, "");
    }

    private List<FormData> listChildFormData(ChildForm childForm, long masterId, String tableSuffix) {

        String masterKey = "masterId";
        List<ElementFieldMapping> cmList = elementFieldMappingService.listByForm(childForm.getFormDef().getId());
        FormTableMapping formTableMapping = formTableMappingService.getByForm(childForm.getFormDef().getId());
        AssertUtil.assertNotNull(formTableMapping, "表单尚未映射元数据:" + childForm.getFormDef().getName());
        long tableId = formTableMapping.getTableId();
        QTable table = metadataClient.getTableModel(tableId);
        List<FormData> dataList = getFormData(childForm.getFormDef(), childForm.getElementList(), table, tableSuffix, cmList, masterKey, masterId);
        return dataList;
    }

    private List<FormData> getFormData(FormDef formDef, List<ElementDef> elementList, QTable table, String tableSuffix, List<ElementFieldMapping> list, String masterKey, Object value) {

        ElementDef elementDef = getElement(elementList, masterKey);
        AssertUtil.assertNotNull(elementDef, "元素未定义:" + masterKey);
        QueryParam queryParam = new QueryParam();
        ElementFieldMapping mapping = getElementFieldMapping(list, elementDef);
        AssertUtil.assertNotNull(mapping, "表单" + formDef.getName() + " 元素" + elementDef.getName() + " 没有映射.");
        QField field = metadataClient.getFieldModel(mapping.getFieldId());
        AssertUtil.assertNotNull(field, "字段定义不存在." + mapping.getFieldId());
        queryParam.addParam(field.getName(), value);
        QDataView dataView = metadataClient.select(table.getName() + tableSuffix, queryParam);
        List<FormData> dataList = new ArrayList<FormData>();
        List<QDataObject> dataObjList = dataView.select();
        for (QDataObject dataObject : dataObjList) {
            FormData data = new FormData(elementList);
            for (ElementDef element : elementList) {
                if (ElementType.PARAMETER.getKey() != element.getType() && element.getType() > 0) {
//                    logger.info(element.getName());
                    ElementFieldMapping elementFieldMapping = getElementFieldMapping(list, element);
                    AssertUtil.assertNotNull(elementFieldMapping, "表单" + formDef.getName() + " 元素" + element.getName() + " 没有映射.");
                    QField qf = getField(table, elementFieldMapping.getFieldId());
                    AssertUtil.assertNotNull(qf, "字段定义不存在." + elementFieldMapping.getFieldId());
                    data.put(element, dataObject.getObjectAttr(qf.getName()));
                }
            }
            dataList.add(data);
        }
        return dataList;
    }

    // *************************************************************************************************************************
    //
    @Override
    public MainForm getForm(Long formId) {

        FormDef main = formDefService.get(formId);
        AssertUtil.assertNotNull(main, "表单定义不存在" + formId);
        List<ElementDef> mainElementList = elementDefService.listByForm(formId);
        MainForm mainForm = new MainForm();
        mainForm.setFormDef(main);
        mainForm.setElementList(mainElementList);
        List<FormDef> childFormList = formDefService.listChildren(formId);
        List<ChildForm> children = new ArrayList<ChildForm>();
        for (FormDef formDef : childFormList) {
            ChildForm childForm = new ChildForm(mainForm);
            childForm.setFormDef(formDef);
            List<ElementDef> clList = elementDefService.listByForm(formDef.getId());
            childForm.setElementList(clList);
            children.add(childForm);
        }
        mainForm.setChildren(children);
        Xml xml = XmlFactory.get("qi-cloud-FormViewPageUrlMapping");
        if (xml != null) {
            List<XmlItem> list = xml.getItemList();
            for (XmlItem xmlItem : list) {
                if (mainForm.getCode().equals(xmlItem.getAttrMap().get("formCode"))) {
                    mainForm.setPcApplyViewUrl(xmlItem.getAttrMap().get("pcApply"));
                    mainForm.setPcTaskingViewUrl(xmlItem.getAttrMap().get("pcTasking"));
                    mainForm.setPcTaskedViewUrl(xmlItem.getAttrMap().get("pcTasked"));
                    mainForm.setMobileApplyViewUrl(xmlItem.getAttrMap().get("mobileApply"));
                    mainForm.setMobileTaskingViewUrl(xmlItem.getAttrMap().get("mobileTasking"));
                    mainForm.setMobileTaskedViewUrl(xmlItem.getAttrMap().get("mobileTasked"));
                }
            }
        }
        return mainForm;
    }

    private QField getField(QTable table, long fieldId) {

        QField qf = null;
        List<QField> fieldList = table.getFieldList();
        for (QField field : fieldList) {
            if (field.getId() == fieldId) {
                qf = field;
            }
        }
        return qf;
    }

    private ElementFieldMapping getElementFieldMapping(List<ElementFieldMapping> list, ElementDef element) {

        ElementFieldMapping mapping = null;
        for (ElementFieldMapping elementFieldMapping : list) {
            if (elementFieldMapping.getElementId() == element.getId()) {
                mapping = elementFieldMapping;
                break;
            }
        }
        return mapping;
    }

    private ElementDef getElement(List<ElementDef> elementList, String elementCode) {

        ElementDef ele = null;
        for (ElementDef elementDef : elementList) {
            if (elementDef.getCode().equals(elementCode)) {
                ele = elementDef;
                break;
            }
        }
        return ele;
    }

    private ElementDef getPrimaryElement(List<ElementDef> elementList) {

        ElementDef idEle = null;
        for (ElementDef elementDef : elementList) {
            if ("id".equals(elementDef.getCode())) {
                idEle = elementDef;
                break;
            }
        }
        return idEle;
    }
}
