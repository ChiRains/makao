package com.qcloud.component.form.web.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.qcloud.component.form.model.ElementDef;
import com.qcloud.component.form.model.ElementFieldMapping;
import com.qcloud.component.form.model.FormTableMapping;
import com.qcloud.component.form.model.query.FormTableMappingQuery;
import com.qcloud.component.form.service.ElementDefService;
import com.qcloud.component.form.service.ElementFieldMappingService;
import com.qcloud.component.form.service.FormDefService;
import com.qcloud.component.form.service.FormTableMappingService;
import com.qcloud.component.form.web.form.ElementFieldMappingForm;
import com.qcloud.component.form.web.form.FormTableMappingForm;
import com.qcloud.component.form.web.handler.FormTableMappingHandler;
import com.qcloud.component.form.web.vo.admin.AdminFormTableMappingVO;
import com.qcloud.component.metadata.MetadataClient;
import com.qcloud.component.metadata.model.query.FieldQuery;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.mvc.AceAjaxView;
import com.qcloud.pirates.mvc.AcePagingView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.NumberUtil;
import com.qcloud.pirates.util.RequestUtil;
import com.qcloud.pirates.web.security.annotation.NoReferer;

@Controller
@RequestMapping(value = "/" + AdminFormTableMappingController.DIR)
public class AdminFormTableMappingController {

    public static final String         DIR = "admin/formTableMapping";

    @Autowired
    private FormTableMappingService    formTableMappingService;

    @Autowired
    private FormTableMappingHandler    formTableMappingHandler;

    @Autowired
    private ElementFieldMappingService elementFieldMappingService;

    @Autowired
    private FormDefService             formDefService;

    @Autowired
    private ElementDefService          elementDefService;

    @Autowired
    private MetadataClient             metadataClient;

    @RequestMapping
    @NoReferer
    public ModelAndView list(Integer pageNum, FormTableMappingQuery query) {

        final int PAGE_SIZE = 10;
        pageNum = RequestUtil.getPageid(pageNum);
        int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
        Page<FormTableMapping> page = formTableMappingService.page(query, start, PAGE_SIZE);
        List<AdminFormTableMappingVO> list = formTableMappingHandler.toVOList4Admin(page.getData());
        AcePagingView pagingView = new AcePagingView("/admin/form-FormTableMapping-list", DIR + "/list", pageNum, PAGE_SIZE, page.getCount());
        pagingView.addObject("result", list);
        return pagingView;
    }

    @RequestMapping
    public ModelAndView toAdd() {

        ModelAndView model = new ModelAndView("/admin/form-FormTableMapping-add");
        return model;
    }

    @RequestMapping
    public AceAjaxView add(FormTableMapping formTableMapping) {

        formTableMappingService.add(formTableMapping);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("添加成功");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }

    @RequestMapping
    public ModelAndView toEdit(FormTableMappingForm formTableForm) {

        ModelAndView model = new ModelAndView("/admin/form-FormTableMapping-edit");
        FieldQuery fieldQuery = new FieldQuery();
        Long mainFormId = formTableForm.getMainFormId();
        AssertUtil.assertNotNull(mainFormId, "ID不能为空");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("formId", mainFormId);
        // 表单元素集合
        List<ElementDef> elementDeflist = elementDefService.listAll(map);
        // 当前表单对应数据库表名
        if (formTableForm.getTableId() == null) {
            map.clear();
            map.put("mainFormId", mainFormId);
            List<FormTableMapping> formTableMappingList = formTableMappingService.listAll(map);
            if (formTableMappingList.size() > 0) {
                Long tableId = formTableMappingList.get(0).getTableId();
                formTableForm.setTableId(tableId);
                fieldQuery.setTableId(tableId);
            }
        } else {
            fieldQuery.setTableId(formTableForm.getTableId());
        }
        // key=elementId,value=fieldId
        Map<Long, Long> elementFieldMappingMap = new HashMap<Long, Long>();
        for (ElementDef elementDef : elementDeflist) {
            map.clear();
            map.put("elementId", elementDef.getId());
            List<ElementFieldMapping> elementFieldMappingList = elementFieldMappingService.listAll(map);
            if (elementFieldMappingList.size() > 0) {
                elementFieldMappingMap.put(elementDef.getId(), elementFieldMappingList.get(0).getFieldId());
            }
        }
        model.addObject("formDef", formDefService.get(mainFormId));
        model.addObject("elementDeflist", elementDeflist);
        model.addObject("formTableForm", formTableForm);
        model.addObject("tableList", metadataClient.listTableAll());
        model.addObject("elementFieldMappingMap", elementFieldMappingMap);
        model.addObject("fieldMap", metadataClient.listFieldMap(fieldQuery));
        return model;
    }

    @RequestMapping
    public ModelAndView toChildrenEdit(FormTableMappingForm formTableForm) {

        ModelAndView model = new ModelAndView("/admin/form-FormTableMapping-childrenEdit");
        FieldQuery fieldQuery = new FieldQuery();
        Long mainFormId = formTableForm.getMainFormId();
        AssertUtil.assertNotNull(mainFormId, "ID不能为空");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("formId", mainFormId);
        // 表单元素集合
        List<ElementDef> elementDeflist = elementDefService.listAll(map);
        // 当前表单对应数据库表名
        if (formTableForm.getTableId() == null) {
            map.clear();
            map.put("mainFormId", mainFormId);
            List<FormTableMapping> formTableMappingList = formTableMappingService.listAll(map);
            if (formTableMappingList.size() > 0) {
                Long tableId = formTableMappingList.get(0).getTableId();
                formTableForm.setTableId(tableId);
                fieldQuery.setTableId(tableId);
            }
        } else {
            fieldQuery.setTableId(formTableForm.getTableId());
        }
        // key=elementId,value=fieldId
        Map<Long, Long> elementFieldMappingMap = new HashMap<Long, Long>();
        for (ElementDef elementDef : elementDeflist) {
            map.clear();
            map.put("elementId", elementDef.getId());
            List<ElementFieldMapping> elementFieldMappingList = elementFieldMappingService.listAll(map);
            if (elementFieldMappingList.size() > 0) {
                elementFieldMappingMap.put(elementDef.getId(), elementFieldMappingList.get(0).getFieldId());
            }
        }
        model.addObject("formDef", formDefService.get(mainFormId));
        model.addObject("elementDeflist", elementDeflist);
        model.addObject("formTableForm", formTableForm);
        model.addObject("tableList", metadataClient.listTableAll());
        model.addObject("elementFieldMappingMap", elementFieldMappingMap);
        model.addObject("fieldMap", metadataClient.listFieldMap(fieldQuery));
        return model;
    }

    @RequestMapping
    public AceAjaxView edit(ElementFieldMappingForm elementFieldform, FormTableMappingForm formTableForm) {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("mainFormId", formTableForm.getMainFormId());
        // 删除旧映射
        formTableMappingService.delete(map);
        for (Long elementId : elementFieldform.getElementIds()) {
            map.clear();
            map.put("elementId", elementId);
            elementFieldMappingService.delete(map);
        }
        // 新增映射
        FormTableMapping ftm = new FormTableMapping();
        ftm.setMainFormId(formTableForm.getMainFormId());
        ftm.setTableId(formTableForm.getTableId());
        formTableMappingService.add(ftm);
        Long[] elementIds = elementFieldform.getElementIds();
        Long[] fieldIds = elementFieldform.getFieldIds();
        for (int i = 0; i < elementFieldform.getElementIds().length; i++) {
            if (elementIds[i] == null || fieldIds[i] == null) {
                continue;
            }
            ElementFieldMapping efm = new ElementFieldMapping();
            efm.setElementId(elementIds[i]);
            efm.setFieldId(fieldIds[i]);
            elementFieldMappingService.add(efm);
        }
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("保存成功");
        aceAjaxView.setUrl(DIR + "/toEdit?mainFormId=" + formTableForm.getMainFormId());
        return aceAjaxView;
    }

    @RequestMapping
    public AceAjaxView delete(Long id) {

        AssertUtil.assertNotNull(id, "ID不能为空");
        formTableMappingService.delete(id);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("删除成功");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }
}
