package com.qcloud.component.form.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.component.form.dao.FormDefDao;
import com.qcloud.component.form.model.ElementDef;
import com.qcloud.component.form.model.ElementFieldMapping;
import com.qcloud.component.form.model.FormDef;
import com.qcloud.component.form.model.FormTableMapping;
import com.qcloud.component.form.model.key.TypeEnum;
import com.qcloud.component.form.model.query.FormDefQuery;
import com.qcloud.component.form.service.ElementDefService;
import com.qcloud.component.form.service.ElementFieldMappingService;
import com.qcloud.component.form.service.FormDefService;
import com.qcloud.component.form.service.FormTableMappingService;
import com.qcloud.component.metadata.MetadataClient;
import com.qcloud.component.metadata.QTable;
import com.qcloud.component.metadata.model.Field;
import com.qcloud.component.metadata.model.Table;
import com.qcloud.component.metadata.model.key.TypeEnum.FieldType;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.util.AssertUtil;

@Service
public class FormDefServiceImpl implements FormDefService {

    @Autowired
    private FormDefDao                 formDefDao;

    @Autowired
    private AutoIdGenerator            autoIdGenerator;

    @Autowired
    private MetadataClient             metadataClient;

    @Autowired
    private ElementFieldMappingService elementFieldMappingService;

    @Autowired
    private ElementDefService          elementDefService;

    @Autowired
    private FormTableMappingService    formTableMappingService;

    private static final String        ID_KEY = "form_form_def";

    @Override
    public boolean add(FormDef formDef) {

        long id = autoIdGenerator.get(ID_KEY);
        formDef.setId(id);
        return formDefDao.add(formDef);
    }

    @Override
    public FormDef get(Long id) {

        return formDefDao.get(id);
    }

    @Override
    public boolean delete(Long id) {

        return formDefDao.delete(id);
    }

    @Override
    public boolean update(FormDef formDef) {

        return formDefDao.update(formDef);
    }

    @Override
    public Page<FormDef> page(FormDefQuery query, int start, int count) {

        return formDefDao.page(query, start, count);
    }

    public List<FormDef> listAll() {

        return formDefDao.listAll();
    }

    @Override
    public List<FormDef> listAll(FormDefQuery query) {

        return formDefDao.listAll(query);
    }

    @Override
    public List<FormDef> listChildren(Long id) {

        return formDefDao.listChildren(id);
    }

    private boolean initNotionTableAndMapping(FormDef formDef) {

        String code = formDef.getCode();
        String suffixCode = code.substring(TypeEnum.QC_NOTION_.length(), code.length());
        AssertUtil.assertNotEmpty(suffixCode, "意见子表编码格式不正确." + code);
        suffixCode = suffixCode.toLowerCase();
        String notionTableStr = suffixCode + "_notion";
        String notionHistTableStr = suffixCode + "_notion_hist";
        QTable notionTable = metadataClient.getTableModel(notionTableStr);
        QTable notionHistTable = metadataClient.getTableModel(notionHistTableStr);
        AssertUtil.assertTrue(notionTable == null, "元数据表定义已经存在." + notionTableStr);
        AssertUtil.assertTrue(notionHistTable == null, "元数据表定义已经存在." + notionHistTableStr);
        Table table = new Table();
        table.setLabel(formDef.getName() + "-意见子表");
        table.setName(notionTableStr);
        table.setRemark(table.getLabel());
        Table histTable = new Table();
        histTable.setLabel(formDef.getName() + "-意见子表备份表");
        histTable.setName(notionHistTableStr);
        histTable.setRemark(histTable.getLabel());
        List<Field> fieldList = new ArrayList<Field>();
        // 系统
        Field idField = new Field();
        idField.setLabel(TypeEnum.QC_MD_ID);
        idField.setLength(11);
        idField.setName(TypeEnum.QC_MD_ID);
        idField.setPrecision(2);
        idField.setRemark(TypeEnum.QC_MD_ID);
        idField.setType(FieldType.BIGINT.getKey());
        fieldList.add(idField);
        Field masterIdField = new Field();
        masterIdField.setLabel(TypeEnum.QC_MD_MASTERID);
        masterIdField.setLength(11);
        masterIdField.setName(TypeEnum.QC_MD_MASTERID);
        masterIdField.setPrecision(2);
        masterIdField.setRemark(TypeEnum.QC_MD_MASTERID);
        masterIdField.setType(FieldType.BIGINT.getKey());
        fieldList.add(masterIdField);
        // 审批人
        Field clerkField = new Field();
        clerkField.setLabel("审批人");
        clerkField.setLength(11);
        clerkField.setName(TypeEnum.QC_NOTION_MD_CLERK);
        clerkField.setPrecision(2);
        clerkField.setRemark(clerkField.getLabel());
        clerkField.setType(FieldType.BIGINT.getKey());
        fieldList.add(clerkField);
        Field clerkNameField = new Field();
        clerkNameField.setLabel("审批人姓名");
        clerkNameField.setLength(100);
        clerkNameField.setName(TypeEnum.QC_NOTION_MD_CLERK_NAME);
        clerkNameField.setPrecision(2);
        clerkNameField.setRemark(clerkField.getLabel());
        clerkNameField.setType(FieldType.VARCHAR.getKey());
        fieldList.add(clerkNameField);
        // 审批人部门
        Field departmentField = new Field();
        departmentField.setLabel("审批人部门");
        departmentField.setLength(11);
        departmentField.setName(TypeEnum.QC_NOTION_MD_DEPARTMENT);
        departmentField.setPrecision(2);
        departmentField.setRemark(clerkField.getLabel());
        departmentField.setType(FieldType.BIGINT.getKey());
        fieldList.add(departmentField);
        Field departmentNameField = new Field();
        departmentNameField.setLabel("审批人部门名称");
        departmentNameField.setLength(100);
        departmentNameField.setName(TypeEnum.QC_NOTION_MD_DEPARTMENT_NAME);
        departmentNameField.setPrecision(2);
        departmentNameField.setRemark(clerkField.getLabel());
        departmentNameField.setType(FieldType.VARCHAR.getKey());
        fieldList.add(departmentNameField);
        // 审批人岗位
        Field postField = new Field();
        postField.setLabel("审批人岗位");
        postField.setLength(11);
        postField.setName(TypeEnum.QC_NOTION_MD_POST);
        postField.setPrecision(2);
        postField.setRemark(clerkField.getLabel());
        postField.setType(FieldType.BIGINT.getKey());
        fieldList.add(postField);
        Field postNameField = new Field();
        postNameField.setLabel("审批人岗位名称");
        postNameField.setLength(100);
        postNameField.setName(TypeEnum.QC_NOTION_MD_POST_NAME);
        postNameField.setPrecision(2);
        postNameField.setRemark(clerkField.getLabel());
        postNameField.setType(FieldType.VARCHAR.getKey());
        fieldList.add(postNameField);
        // 流程任务
        Field workitemField = new Field();
        workitemField.setLabel("流程任务");
        workitemField.setLength(100);
        workitemField.setName(TypeEnum.QC_NOTION_MD_WOEKITEM);
        workitemField.setPrecision(2);
        workitemField.setRemark(clerkField.getLabel());
        workitemField.setType(FieldType.VARCHAR.getKey());
        fieldList.add(workitemField);
        Field workitemNameField = new Field();
        workitemNameField.setLabel("流程任务名称");
        workitemNameField.setLength(100);
        workitemNameField.setName(TypeEnum.QC_NOTION_MD_WOEKITEM_NAME);
        workitemNameField.setPrecision(2);
        workitemNameField.setRemark(clerkField.getLabel());
        workitemNameField.setType(FieldType.VARCHAR.getKey());
        fieldList.add(workitemNameField);
        // 审批内容
        Field contentField = new Field();
        contentField.setLabel("审批内容");
        contentField.setLength(250);
        contentField.setName(TypeEnum.QC_NOTION_MD_CONTENT);
        contentField.setPrecision(2);
        contentField.setRemark(clerkField.getLabel());
        contentField.setType(FieldType.VARCHAR.getKey());
        fieldList.add(contentField);
        Field resultField = new Field();
        resultField.setLabel("审批结果");
        resultField.setLength(3);
        resultField.setName(TypeEnum.QC_NOTION_MD_RESULT);
        resultField.setPrecision(2);
        resultField.setRemark(clerkField.getLabel());
        resultField.setType(FieldType.INTEGER.getKey());
        fieldList.add(resultField);
        // 审批时间
        Field timeField = new Field();
        timeField.setLabel("审批时间");
        timeField.setLength(6);
        timeField.setName(TypeEnum.QC_NOTION_MD_TIME);
        timeField.setPrecision(2);
        timeField.setRemark(clerkField.getLabel());
        timeField.setType(FieldType.TIMESTAMP.getKey());
        fieldList.add(timeField);
        // 任务
        Field taskField = new Field();
        taskField.setLabel("任务");
        taskField.setLength(11);
        taskField.setName(TypeEnum.QC_NOTION_MD_TASK);
        taskField.setPrecision(2);
        taskField.setRemark(clerkField.getLabel());
        taskField.setType(FieldType.BIGINT.getKey());
        fieldList.add(taskField);
        // 先初始化备份表
        metadataClient.initTable(histTable, fieldList);
        // 再初始化主数据表:因为映射是映射主数据表,字段ID需要取主数据库字段ID
        metadataClient.initTable(table, fieldList);
        FormTableMapping formTableMapping = new FormTableMapping();
        formTableMapping.setMainFormId(formDef.getId());
        formTableMapping.setTableId(table.getId());
        formTableMappingService.add(formTableMapping);
        List<ElementDef> list = elementDefService.listByForm(formDef.getId());
        for (ElementDef elementDef : list) {
            ElementFieldMapping elementFieldMapping = new ElementFieldMapping();
            elementFieldMapping.setElementId(elementDef.getId());
            if (TypeEnum.QC_MD_ID.equals(elementDef.getCode())) {
                elementFieldMapping.setFieldId(idField.getId());
                elementFieldMappingService.add(elementFieldMapping);
            } else if (TypeEnum.QC_MD_MASTERID.equals(elementDef.getCode())) {
                elementFieldMapping.setFieldId(masterIdField.getId());
                elementFieldMappingService.add(elementFieldMapping);
            } else if (TypeEnum.QC_NOTION_CLERK_ID_.equals(elementDef.getCode())) {
                elementFieldMapping.setFieldId(clerkField.getId());
                elementFieldMappingService.add(elementFieldMapping);
            } else if (TypeEnum.QC_NOTION_CLERK_NAME_.equals(elementDef.getCode())) {
                elementFieldMapping.setFieldId(clerkNameField.getId());
                elementFieldMappingService.add(elementFieldMapping);
            } else if (TypeEnum.QC_NOTION_DEPARDMENT_ID_.equals(elementDef.getCode())) {
                elementFieldMapping.setFieldId(departmentField.getId());
                elementFieldMappingService.add(elementFieldMapping);
            } else if (TypeEnum.QC_NOTION_DEPARDMENT_NAME_.equals(elementDef.getCode())) {
                elementFieldMapping.setFieldId(departmentNameField.getId());
                elementFieldMappingService.add(elementFieldMapping);
            } else if (TypeEnum.QC_NOTION_POST_ID_.equals(elementDef.getCode())) {
                elementFieldMapping.setFieldId(postField.getId());
                elementFieldMappingService.add(elementFieldMapping);
            } else if (TypeEnum.QC_NOTION_POST_NAME_.equals(elementDef.getCode())) {
                elementFieldMapping.setFieldId(postNameField.getId());
                elementFieldMappingService.add(elementFieldMapping);
            } else if (TypeEnum.QC_NOTION_WORKITEM_ID_.equals(elementDef.getCode())) {
                elementFieldMapping.setFieldId(workitemField.getId());
                elementFieldMappingService.add(elementFieldMapping);
            } else if (TypeEnum.QC_NOTION_WORKITEM_NAME_.equals(elementDef.getCode())) {
                elementFieldMapping.setFieldId(workitemNameField.getId());
                elementFieldMappingService.add(elementFieldMapping);
            } else if (TypeEnum.QC_NOTION_TIME_.equals(elementDef.getCode())) {
                elementFieldMapping.setFieldId(timeField.getId());
                elementFieldMappingService.add(elementFieldMapping);
            } else if (TypeEnum.QC_NOTION_TASK_.equals(elementDef.getCode())) {
                elementFieldMapping.setFieldId(taskField.getId());
                elementFieldMappingService.add(elementFieldMapping);
            } else if (TypeEnum.QC_NOTION_MD_CONTENT.equals(elementDef.getCode())) {
                elementFieldMapping.setFieldId(contentField.getId());
                elementFieldMappingService.add(elementFieldMapping);
            } else if (TypeEnum.QC_NOTION_MD_RESULT.equals(elementDef.getCode())) {
                elementFieldMapping.setFieldId(resultField.getId());
                elementFieldMappingService.add(elementFieldMapping);
            }
        }
        return true;
    }

    @Transactional
    @Override
    public boolean addNotionFormDef(FormDef formDef) {

        add(formDef);
        elementDefService.initNotionElements(formDef);
        initNotionTableAndMapping(formDef);
        return true;
    }
}
