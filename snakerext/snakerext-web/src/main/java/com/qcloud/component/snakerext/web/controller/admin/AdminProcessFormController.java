package com.qcloud.component.snakerext.web.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.qcloud.component.form.FormClient;
import com.qcloud.component.form.model.query.FormDefQuery;
import com.qcloud.component.organization.OrganizationClient;
import com.qcloud.component.organization.model.query.ClerkQuery;
import com.qcloud.component.snakerext.SnakerExtClient;
import com.qcloud.component.snakerext.model.ProcessForm;
import com.qcloud.component.snakerext.model.key.TypeEnum.ExecutorType;
import com.qcloud.component.snakerext.model.query.ProcessExecutorQuery;
import com.qcloud.component.snakerext.model.query.ProcessFormQuery;
import com.qcloud.component.snakerext.service.ProcessFormService;
import com.qcloud.component.snakerext.web.handler.ProcessFormHandler;
import com.qcloud.component.snakerext.web.vo.admin.AdminProcessFormVO;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.mvc.AceAjaxView;
import com.qcloud.pirates.mvc.AcePagingView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.NumberUtil;
import com.qcloud.pirates.util.RequestUtil;
import com.qcloud.pirates.web.security.annotation.NoReferer;

@Controller
@RequestMapping(value = "/" + AdminProcessFormController.DIR)
public class AdminProcessFormController {

    public static final String DIR = "admin/processForm";

    @Autowired
    private ProcessFormService processFormService;

    @Autowired
    private ProcessFormHandler processFormHandler;

    @Autowired
    private FormClient         formClient;

    @RequestMapping
    @NoReferer
    public ModelAndView list(Integer pageNum, ProcessFormQuery query) {

        final int PAGE_SIZE = 10;
        pageNum = RequestUtil.getPageid(pageNum);
        int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
        Page<ProcessForm> page = processFormService.page(query, start, PAGE_SIZE);
        List<AdminProcessFormVO> list = processFormHandler.toVOList4Admin(page.getData());
        AcePagingView pagingView = new AcePagingView("/admin/snakerext-ProcessForm-list", DIR + "/list", pageNum, PAGE_SIZE, page.getCount());
        pagingView.addObject("result", list);
        return pagingView;
    }

    @RequestMapping
    public ModelAndView toAdd() {

        ModelAndView model = new ModelAndView("/admin/snakerext-ProcessForm-add");
        return model;
    }

    @RequestMapping
    public AceAjaxView add(ProcessForm processForm) {

        processFormService.add(processForm);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("添加成功");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }

    @RequestMapping
    public ModelAndView toEdit(String processId) {

        AssertUtil.assertNotNull(processId, "流程ID不能为空");
        ModelAndView model = new ModelAndView("/admin/snakerext-ProcessForm-edit");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("processId", processId);
        List<ProcessForm> list = processFormService.list(map);
        if (list.size() > 0) {
            model.addObject("processForm", list.get(0));
        }
        FormDefQuery formDefQuery = new FormDefQuery();
        formDefQuery.setMainFormId(Long.valueOf(-1));
        model.addObject("processId", processId);
        model.addObject("formDefList", formClient.listAll(formDefQuery));
        return model;
    }

    @RequestMapping
    public AceAjaxView edit(ProcessForm processForm) {

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("processId", processForm.getProcessId());
        List<ProcessForm> list = processFormService.list(map);
        // 新增或更新操作
        if (list.size() > 0) {
            ProcessForm pf = list.get(0);
            pf.setMainFormId(processForm.getMainFormId());
            processFormService.update(pf);
        } else {
            ProcessForm pf = new ProcessForm();
            pf.setProcessId(processForm.getProcessId());
            pf.setMainFormId(processForm.getMainFormId());
            processFormService.add(pf);
        }
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("操作成功!");
        aceAjaxView.setUrl("admin/process/list");
        return aceAjaxView;
    }

    @RequestMapping
    public AceAjaxView delete(Long id) {

        AssertUtil.assertNotNull(id, "ID不能为空");
        processFormService.delete(id);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("删除成功");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }

    @RequestMapping
    public ModelAndView selectForm(ProcessFormQuery query) {

        AssertUtil.assertNotNull(query.getProcessId(), "流程ID不能为空");
        ModelAndView model = new ModelAndView("/admin/snakerext-ProcessForm-selectForm");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("processId", query.getProcessId());
        List<ProcessForm> list = processFormService.list(map);
        if (list.size() > 0) {
            model.addObject("processForm", list.get(0));
        }
        FormDefQuery formDefQuery = new FormDefQuery();
        formDefQuery.setMainFormId(Long.valueOf(-1));
        formDefQuery.setName(query.getName());
        model.addObject("query", query);
        model.addObject("formDefList", formClient.listAll(formDefQuery));
        return model;
    }

    @RequestMapping
    public AceAjaxView editForm(ProcessForm processForm) {

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("processId", processForm.getProcessId());
        List<ProcessForm> list = processFormService.list(map);
        // 新增或更新操作
        if (list.size() > 0) {
            ProcessForm pf = list.get(0);
            pf.setMainFormId(processForm.getMainFormId());
            processFormService.update(pf);
        } else {
            ProcessForm pf = new ProcessForm();
            pf.setProcessId(processForm.getProcessId());
            pf.setMainFormId(processForm.getMainFormId());
            processFormService.add(pf);
        }
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("操作成功!");
        return aceAjaxView;
    }
}
