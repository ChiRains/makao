package com.qcloud.component.form.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.component.form.dao.ElementDefDao;
import com.qcloud.component.form.model.ElementDef;
import com.qcloud.component.form.model.FormDef;
import com.qcloud.component.form.model.key.TypeEnum;
import com.qcloud.component.form.model.key.TypeEnum.ElementType;
import com.qcloud.component.form.model.query.ElementDefQuery;
import com.qcloud.component.form.service.ElementDefService;
import com.qcloud.component.form.service.FormTableMappingService;
import com.qcloud.pirates.data.Page;

@Service
public class ElementDefServiceImpl implements ElementDefService {

    @Autowired
    private ElementDefDao       elementDefDao;

    @Autowired
    private AutoIdGenerator     autoIdGenerator;

    private static final String ID_KEY = "form_element_def";

    @Override
    public boolean add(ElementDef elementDef) {

        long id = autoIdGenerator.get(ID_KEY);
        elementDef.setId(id);
        return elementDefDao.add(elementDef);
    }

    @Override
    public ElementDef get(Long id) {

        return elementDefDao.get(id);
    }

    @Override
    public boolean delete(Long id) {

        return elementDefDao.delete(id);
    }

    @Override
    public boolean update(ElementDef elementDef) {

        return elementDefDao.update(elementDef);
    }

    @Override
    public Page<ElementDef> page(ElementDefQuery query, int start, int count) {

        return elementDefDao.page(query, start, count);
    }

    public List<ElementDef> listAll() {

        return elementDefDao.listAll();
    }

    @Override
    public List<ElementDef> listAll(Map<String, Object> map) {

        return elementDefDao.listAll(map);
    }

    @Override
    public List<ElementDef> listByForm(Long formId) {

        return elementDefDao.listByForm(formId);
    }

    @Override
    public boolean delete(Map<String, Object> map) {

        return elementDefDao.delete(map);
    }

    @Override
    public boolean initNotionElements(FormDef formDef) {

        // 系统默认
        ElementDef idEle = new ElementDef();
        idEle.setCode(TypeEnum.QC_MD_ID);
        idEle.setFormId(formDef.getId());
        idEle.setName(TypeEnum.QC_MD_ID);
        idEle.setType(ElementType.HEDDIN.getKey());
        ElementDef masterIdEle = new ElementDef();
        masterIdEle.setCode(TypeEnum.QC_MD_MASTERID);
        masterIdEle.setFormId(formDef.getId());
        masterIdEle.setName(TypeEnum.QC_MD_MASTERID);
        masterIdEle.setType(ElementType.HEDDIN.getKey());
        add(idEle);
        add(masterIdEle);
        // 审批人
        ElementDef qc_oc_clerkEle = new ElementDef();
        qc_oc_clerkEle.setCode(TypeEnum.QC_NOTION_CLERK_ID_);
        qc_oc_clerkEle.setFormId(formDef.getId());
        qc_oc_clerkEle.setName("审批人");
        qc_oc_clerkEle.setType(ElementType.HEDDIN.getKey());
        ElementDef name_qc_oc_clerkEle = new ElementDef();
        name_qc_oc_clerkEle.setCode(TypeEnum.QC_NOTION_CLERK_NAME_);
        name_qc_oc_clerkEle.setFormId(formDef.getId());
        name_qc_oc_clerkEle.setName("审批人姓名");
        name_qc_oc_clerkEle.setType(ElementType.TEXT.getKey());
        add(qc_oc_clerkEle);
        add(name_qc_oc_clerkEle);
        // 审批人部门
        ElementDef qc_od_departmentEle = new ElementDef();
        qc_od_departmentEle.setCode(TypeEnum.QC_NOTION_DEPARDMENT_ID_);
        qc_od_departmentEle.setFormId(formDef.getId());
        qc_od_departmentEle.setName("审批人部门");
        qc_od_departmentEle.setType(ElementType.HEDDIN.getKey());
        ElementDef name_qc_od_departmentEle = new ElementDef();
        name_qc_od_departmentEle.setCode(TypeEnum.QC_NOTION_DEPARDMENT_NAME_);
        name_qc_od_departmentEle.setFormId(formDef.getId());
        name_qc_od_departmentEle.setName("审批人部门名称");
        name_qc_od_departmentEle.setType(ElementType.TEXT.getKey());
        add(qc_od_departmentEle);
        add(name_qc_od_departmentEle);
        // 审批人岗位
        ElementDef qc_op_postEle = new ElementDef();
        qc_op_postEle.setCode(TypeEnum.QC_NOTION_POST_ID_);
        qc_op_postEle.setFormId(formDef.getId());
        qc_op_postEle.setName("审批人岗位");
        qc_op_postEle.setType(ElementType.HEDDIN.getKey());
        ElementDef name_qc_op_postEle = new ElementDef();
        name_qc_op_postEle.setCode(TypeEnum.QC_NOTION_POST_NAME_);
        name_qc_op_postEle.setFormId(formDef.getId());
        name_qc_op_postEle.setName("审批人岗位名称");
        name_qc_op_postEle.setType(ElementType.TEXT.getKey());
        add(qc_op_postEle);
        add(name_qc_op_postEle);
        // 审批时间
        ElementDef qc_ct_timeEle = new ElementDef();
        qc_ct_timeEle.setCode(TypeEnum.QC_NOTION_TIME_);
        qc_ct_timeEle.setFormId(formDef.getId());
        qc_ct_timeEle.setName("审批时间");
        qc_ct_timeEle.setType(ElementType.DATE.getKey());
        add(qc_ct_timeEle);
        // 流程任务
        ElementDef qc_sw_workitemEle = new ElementDef();
        qc_sw_workitemEle.setCode(TypeEnum.QC_NOTION_WORKITEM_ID_);
        qc_sw_workitemEle.setFormId(formDef.getId());
        qc_sw_workitemEle.setName("流程任务");
        qc_sw_workitemEle.setType(ElementType.HEDDIN.getKey());
        ElementDef name_qc_sw_workitemEle = new ElementDef();
        name_qc_sw_workitemEle.setCode(TypeEnum.QC_NOTION_WORKITEM_NAME_);
        name_qc_sw_workitemEle.setFormId(formDef.getId());
        name_qc_sw_workitemEle.setName("流程任务名称");
        name_qc_sw_workitemEle.setType(ElementType.TEXT.getKey());
        add(qc_sw_workitemEle);
        add(name_qc_sw_workitemEle);
        // 任务
        ElementDef qc_st_taskEle = new ElementDef();
        qc_st_taskEle.setCode(TypeEnum.QC_NOTION_TASK_);
        qc_st_taskEle.setFormId(formDef.getId());
        qc_st_taskEle.setName("任务");
        qc_st_taskEle.setType(ElementType.HEDDIN.getKey());
        add(qc_st_taskEle);
        // 审批内容
        ElementDef contentEle = new ElementDef();
        contentEle.setCode(TypeEnum.QC_NOTION_MD_CONTENT);
        contentEle.setFormId(formDef.getId());
        contentEle.setName("审批内容");
        contentEle.setType(ElementType.TEXTAREA.getKey());
        add(contentEle);
        // 审批结果
        ElementDef resultEle = new ElementDef();
        resultEle.setCode(TypeEnum.QC_NOTION_MD_RESULT);
        resultEle.setFormId(formDef.getId());
        resultEle.setName("审批结果");
        resultEle.setType(ElementType.SELECT.getKey());
        add(resultEle);
        return true;
    }
}
