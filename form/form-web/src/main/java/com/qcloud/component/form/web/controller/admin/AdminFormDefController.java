package com.qcloud.component.form.web.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.qcloud.component.form.exception.FormException;
import com.qcloud.component.form.model.FormDef;
import com.qcloud.component.form.model.key.TypeEnum;
import com.qcloud.component.form.model.query.FormDefQuery;
import com.qcloud.component.form.service.ElementDefService;
import com.qcloud.component.form.service.FormDefService;
import com.qcloud.component.form.web.handler.FormDefHandler;
import com.qcloud.component.form.web.vo.admin.AdminFormDefVO;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.mvc.AceAjaxView;
import com.qcloud.pirates.mvc.AcePagingView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.NumberUtil;
import com.qcloud.pirates.util.RequestUtil;
import com.qcloud.pirates.util.StringUtil;
import com.qcloud.pirates.web.security.annotation.NoReferer;

@Controller
@RequestMapping(value = "/" + AdminFormDefController.DIR)
public class AdminFormDefController {

    public static final String DIR = "admin/formDef";

    @Autowired
    private FormDefService     formDefService;

    @Autowired
    private ElementDefService  elementDefService;

    @Autowired
    private FormDefHandler     formDefHandler;

    @RequestMapping
    @NoReferer
    public ModelAndView list(Integer pageNum, FormDefQuery query) {

        long mainFormId = Long.valueOf(-1);
        final int PAGE_SIZE = 10;
        pageNum = RequestUtil.getPageid(pageNum);
        int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
        query.setMainFormId(mainFormId);
        Page<FormDef> page = formDefService.page(query, start, PAGE_SIZE);
        List<AdminFormDefVO> list = formDefHandler.toVOList4Admin(page.getData());
        String param = "name=" + StringUtil.nullToEmpty(query.getName());
        AcePagingView pagingView = new AcePagingView("/admin/form-FormDef-list", DIR + "/list?" + param, pageNum, PAGE_SIZE, page.getCount());
        pagingView.addObject("result", list);
        return pagingView;
    }

    @RequestMapping
    @NoReferer
    public ModelAndView childrenList(Integer pageNum, FormDefQuery query) {

        final int PAGE_SIZE = 10;
        pageNum = RequestUtil.getPageid(pageNum);
        int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
        Page<FormDef> page = formDefService.page(query, start, PAGE_SIZE);
        List<AdminFormDefVO> list = formDefHandler.toVOList4Admin(page.getData());
        String param = "mainFormId=" + query.getMainFormId();
        AcePagingView pagingView = new AcePagingView("/admin/form-FormDefChildren-list", DIR + "/childrenList?" + param, pageNum, PAGE_SIZE, page.getCount());
        pagingView.addObject("result", list);
        pagingView.addObject("query", query);
        pagingView.addObject("formDef", formDefService.get(query.getMainFormId()));
        pagingView.addObject(COMMON, COMMON);
        pagingView.addObject(NOTION, NOTION);
        return pagingView;
    }

    @RequestMapping
    public ModelAndView toAdd() {

        ModelAndView model = new ModelAndView("/admin/form-FormDef-add");
        return model;
    }

    @RequestMapping
    public ModelAndView toChildrenAdd(Long mainFormId, String type) {

        AssertUtil.assertNotNull(type, "子表类型不能为空");
        AssertUtil.assertNotNull(mainFormId, "mainFormId不能为空");
        ModelAndView model = new ModelAndView("/admin/form-FormDefChildren-add");
        model.addObject("mainFormId", mainFormId);
        model.addObject("type", type);
        String typeStr = COMMON.equals(type) ? "普通子表单" : (NOTION.equals(type) ? "意见子表单" : "");
        AssertUtil.assertNotEmpty(typeStr, "子表单类型不支持." + type);
        model.addObject("typeStr", typeStr);
        return model;
    }

    private static final String COMMON = "common";

    private static final String NOTION = "notion";

    @RequestMapping
    public AceAjaxView add(FormDef formDef) {

        formDef.setMainFormId(Long.valueOf(-1));
        formDefService.add(formDef);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("添加成功");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }

    @RequestMapping
    public AceAjaxView childrenAdd(FormDef formDef, String type) {

        AssertUtil.assertNotNull(type, "子表类型不能为空");
        if (NOTION.equals(type)) {
            AssertUtil.assertNotEmpty(formDef.getCode(), "表单编码不能为空.");
            AssertUtil.assertTrue(formDef.getCode().startsWith(TypeEnum.QC_NOTION_), "意见子单编码开头不正确." + formDef.getCode() + "(" + TypeEnum.QC_NOTION_ + ")");
            // 在这里处理意见子表单
            formDefService.addNotionFormDef(formDef);
            AceAjaxView aceAjaxView = new AceAjaxView();
            aceAjaxView.setMessage("添加成功");
            aceAjaxView.setUrl(DIR + "/childrenList?mainFormId=" + formDef.getMainFormId());
            return aceAjaxView;
        } else if (COMMON.equals(type)) {
            formDefService.add(formDef);
            AceAjaxView aceAjaxView = new AceAjaxView();
            aceAjaxView.setMessage("添加成功");
            aceAjaxView.setUrl(DIR + "/childrenList?mainFormId=" + formDef.getMainFormId());
            return aceAjaxView;
        } else {
            throw new FormException("子表单类型不支持." + type);
        }
    }

    @RequestMapping
    public ModelAndView toEdit(Long id) {

        AssertUtil.assertNotNull(id, "ID不能为空");
        FormDef formDef = formDefService.get(id);
        AdminFormDefVO adminFormDefVO = formDefHandler.toVO4Admin(formDef);
        ModelAndView model = new ModelAndView("/admin/form-FormDef-edit");
        model.addObject("formDef", adminFormDefVO);
        return model;
    }

    @RequestMapping
    public ModelAndView childrenToEdit(Long id) {

        AssertUtil.assertNotNull(id, "ID不能为空");
        FormDef formDef = formDefService.get(id);
        AdminFormDefVO adminFormDefVO = formDefHandler.toVO4Admin(formDef);
        ModelAndView model = new ModelAndView("/admin/form-FormDefChildren-edit");
        model.addObject("formDef", adminFormDefVO);
        return model;
    }

    @RequestMapping
    public AceAjaxView edit(FormDef formDef) {

        // 防止修改mainFormId
        FormDef fd = formDefService.get(formDef.getId());
        fd.setName(formDef.getName());
        fd.setCode(formDef.getCode());
        fd.setRemark(formDef.getRemark());
        formDefService.update(fd);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("编辑成功");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }

    @RequestMapping
    public AceAjaxView childrenEdit(FormDef formDef) {

        // 防止修改mainFormId
        FormDef fd = formDefService.get(formDef.getId());
        fd.setName(formDef.getName());
        fd.setCode(formDef.getCode());
        fd.setRemark(formDef.getRemark());
        formDefService.update(fd);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("编辑成功");
        aceAjaxView.setUrl(DIR + "/childrenList?mainFormId=" + fd.getMainFormId());
        return aceAjaxView;
    }

    @RequestMapping
    public AceAjaxView delete(Long id) {

        AssertUtil.assertNotNull(id, "ID不能为空");
        Map<String, Object> map = new HashMap<String, Object>();
        FormDef formDef = formDefService.get(id);
        formDefService.delete(id);
        map.put("formId", formDef.getId());
        elementDefService.delete(map);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("删除成功");
        return aceAjaxView;
    }
}
