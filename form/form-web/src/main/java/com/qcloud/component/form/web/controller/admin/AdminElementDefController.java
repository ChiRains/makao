package com.qcloud.component.form.web.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.mvc.AceAjaxView;
import com.qcloud.pirates.mvc.AcePagingView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.NumberUtil;
import com.qcloud.pirates.util.RequestUtil;
import com.qcloud.pirates.web.security.annotation.NoReferer;
import com.qcloud.component.form.model.ElementDef;
import com.qcloud.component.form.service.ElementDefService;
import com.qcloud.component.form.service.FormDefService;
import com.qcloud.component.form.web.handler.ElementDefHandler;
import com.qcloud.component.form.model.key.TypeEnum;
import com.qcloud.component.form.model.query.ElementDefQuery;
import com.qcloud.component.form.web.vo.admin.AdminElementDefVO;

@Controller
@RequestMapping(value = "/" + AdminElementDefController.DIR)
public class AdminElementDefController {

    public static final String DIR = "admin/elementDef";

    @Autowired
    private ElementDefService  elementDefService;

    @Autowired
    private ElementDefHandler  elementDefHandler;

    @Autowired
    private FormDefService     formDefService;

    @RequestMapping
    @NoReferer
    public ModelAndView list(Integer pageNum, ElementDefQuery query) {

        final int PAGE_SIZE = Integer.MAX_VALUE;
        pageNum = RequestUtil.getPageid(pageNum);
        int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
        Page<ElementDef> page = elementDefService.page(query, start, PAGE_SIZE);
        List<AdminElementDefVO> list = elementDefHandler.toVOList4Admin(page.getData());
        AcePagingView pagingView = new AcePagingView("/admin/form-ElementDef-list", DIR + "/list", pageNum, PAGE_SIZE, page.getCount());
        pagingView.addObject("result", list);
        pagingView.addObject("elementType", TypeEnum.ElementType.values());
        pagingView.addObject("query", query);
        pagingView.addObject("formDef", formDefService.get(query.getFormId()));
        return pagingView;
    }

    @RequestMapping
    public ModelAndView toAdd(Long formId) {

        AssertUtil.assertNotNull(formId, "formId不能为空");
        ModelAndView model = new ModelAndView("/admin/form-ElementDef-add");
        model.addObject("formId", formId);
        model.addObject("elementType", TypeEnum.ElementType.values());
        return model;
    }

    @RequestMapping
    public AceAjaxView add(ElementDef elementDef) {

        elementDefService.add(elementDef);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("添加成功");
        aceAjaxView.setUrl(DIR + "/list?formId=" + elementDef.getFormId());
        return aceAjaxView;
    }

    @RequestMapping
    public ModelAndView toEdit(Long id) {

        AssertUtil.assertNotNull(id, "ID不能为空");
        ElementDef elementDef = elementDefService.get(id);
        AdminElementDefVO adminElementDefVO = elementDefHandler.toVO4Admin(elementDef);
        ModelAndView model = new ModelAndView("/admin/form-ElementDef-edit");
        model.addObject("elementDef", adminElementDefVO);
        model.addObject("elementType", TypeEnum.ElementType.values());
        return model;
    }

    @RequestMapping
    public AceAjaxView edit(ElementDef elementDef) {

        // 防止修改formId
        ElementDef edf = elementDefService.get(elementDef.getId());
        edf.setName(elementDef.getName());
        edf.setCode(elementDef.getCode());
        edf.setType(elementDef.getType());
        elementDefService.update(edf);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("编辑成功");
        aceAjaxView.setUrl(DIR + "/list?formId=" + edf.getFormId());
        return aceAjaxView;
    }

    @RequestMapping
    public AceAjaxView delete(Long id) {

        AssertUtil.assertNotNull(id, "ID不能为空");
        elementDefService.delete(id);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("删除成功");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }

    @RequestMapping
    @NoReferer
    public ModelAndView childrenList(Integer pageNum, ElementDefQuery query) {

        final int PAGE_SIZE = Integer.MAX_VALUE;
        pageNum = RequestUtil.getPageid(pageNum);
        int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
        Page<ElementDef> page = elementDefService.page(query, start, PAGE_SIZE);
        List<AdminElementDefVO> list = elementDefHandler.toVOList4Admin(page.getData());
        String param = "formId=" + query.getFormId();
        AcePagingView pagingView = new AcePagingView("/admin/form-ElementDef-childrenList", DIR + "/childrenList?" + param, pageNum, PAGE_SIZE, page.getCount());
        pagingView.addObject("result", list);
        pagingView.addObject("elementType", TypeEnum.ElementType.values());
        pagingView.addObject("query", query);
        pagingView.addObject("formDef", formDefService.get(query.getFormId()));
        return pagingView;
    }
}
