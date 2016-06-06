package com.qcloud.component.snakerext.web.controller.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.snaker.engine.entity.Process;
import org.snaker.engine.model.TaskModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.qcloud.component.form.FormClient;
import com.qcloud.component.form.model.ElementDef;
import com.qcloud.component.form.model.FormDef;
import com.qcloud.component.form.model.query.ElementDefQuery;
import com.qcloud.component.form.model.query.FormDefQuery;
import com.qcloud.component.snaker.ISnakerClient;
import com.qcloud.component.snakerext.SnakerExtClient;
import com.qcloud.component.snakerext.model.ProcessForm;
import com.qcloud.component.snakerext.model.TaskFormAccess;
import com.qcloud.component.snakerext.model.query.ProcessFormQuery;
import com.qcloud.component.snakerext.model.query.TaskFormAccessQuery;
import com.qcloud.component.snakerext.service.ProcessFormService;
import com.qcloud.component.snakerext.service.TaskFormAccessService;
import com.qcloud.component.snakerext.web.form.TaskFormAccessForm;
import com.qcloud.component.snakerext.web.handler.TaskFormAccessHandler;
import com.qcloud.pirates.core.reflect.BeanUtils;
import com.qcloud.pirates.mvc.AceAjaxView;
import com.qcloud.pirates.mvc.AcePagingView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.NumberUtil;
import com.qcloud.pirates.util.RequestUtil;
import com.qcloud.pirates.web.security.annotation.NoReferer;

@Controller
@RequestMapping(value = "/" + AdminTaskFormAccessController.DIR)
public class AdminTaskFormAccessController {

    public static final String    DIR = "admin/taskFormAccess";

    @Autowired
    private TaskFormAccessService taskFormAccessService;

    @Autowired
    private ISnakerClient         snakerClient;

    @Autowired
    private FormClient            formClient;

    @Autowired
    private ProcessFormService    processFormService;

    @RequestMapping
    @NoReferer
    public ModelAndView list(Integer pageNum, TaskFormAccessQuery query) {

        AssertUtil.notNull(query.getProcessId(), "流程标志不能为空!");
        final int PAGE_SIZE = Integer.MAX_VALUE;
        pageNum = RequestUtil.getPageid(pageNum);
        int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
        // Page<TaskFormAccess> page = taskFormAccessService.page(query, start, PAGE_SIZE);
        // List<AdminTaskFormAccessVO> list = taskFormAccessHandler.toVOList4Admin(page.getData());
        Process process = snakerClient.process().getProcessById(query.getProcessId());
        List<TaskModel> list = process.getModel().getTaskModels();
        AcePagingView pagingView = new AcePagingView("/admin/snakerext-TaskFormAccess-list", DIR + "/list", pageNum, PAGE_SIZE, list.size());
        pagingView.addObject("result", list);
        pagingView.addObject("query", query);
        return pagingView;
    }

    @RequestMapping
    public ModelAndView toAdd() {

        ModelAndView model = new ModelAndView("/admin/snakerext-TaskFormAccess-add");
        return model;
    }

    @RequestMapping
    public AceAjaxView add(TaskFormAccess taskFormAccess) {

        taskFormAccessService.add(taskFormAccess);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("添加成功");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }

    @RequestMapping
    public ModelAndView toEdit(String processId) {

        ModelAndView model = new ModelAndView("/admin/snakerext-TaskFormAccess-edit");
        AssertUtil.assertNotNull(processId, "ID不能为空");
        // // TaskFormAccess taskFormAccess = taskFormAccessService.get(id);
        // AdminTaskFormAccessVO adminTaskFormAccessVO = taskFormAccessHandler.toVO4Admin(taskFormAccess);
        // model.addObject("taskFormAccess", adminTaskFormAccessVO);
        return model;
    }

    @RequestMapping
    public AceAjaxView edit(TaskFormAccessForm taskFormAccessForm) {

        List<ElementDef> edList = new ArrayList<ElementDef>();
        List<FormDef> formDefList = new ArrayList<FormDef>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("processId", taskFormAccessForm.getProcessId());
        map.put("taskName", taskFormAccessForm.getTaskName());
        taskFormAccessService.delete(map);
        // 获取全部主表单元素和子表单
        setParam(edList, formDefList, taskFormAccessForm.getProcessId());
        List<TaskFormAccess> list = taskFormAccessForm.listTaskFormAccess();
        // 添加选中部分的可写状态
        for (TaskFormAccess taskFormAccess : list) {
            Iterator<ElementDef> elementDefIt = edList.iterator();
            while (elementDefIt.hasNext()) {
                ElementDef elementDef = elementDefIt.next();
                if (elementDef.getId() == taskFormAccess.getElementId() && taskFormAccess.getFormType() == TaskFormAccessForm.MAINFORM_TYPE) {
                    taskFormAccessService.add(taskFormAccess);
                    elementDefIt.remove();
                }
            }
            Iterator<FormDef> formDefIt = formDefList.iterator();
            while (formDefIt.hasNext()) {
                FormDef formDef = formDefIt.next();
                if (formDef.getId() == taskFormAccess.getElementId() && taskFormAccess.getFormType() == TaskFormAccessForm.CHILDFORM_TYPE) {
                    taskFormAccessService.add(taskFormAccess);
                    formDefIt.remove();
                }
            }
        }
        // 添加不可写的状态,主表单含有元素
        for (ElementDef elementDef : edList) {
            TaskFormAccess tf = new TaskFormAccess();
            tf.setProcessId(taskFormAccessForm.getProcessId());
            tf.setTaskName(taskFormAccessForm.getTaskName());
            tf.setFormId(elementDef.getFormId());
            tf.setElementId(elementDef.getId());
            tf.setFormType(TaskFormAccessForm.MAINFORM_TYPE);
            tf.setStatus(TaskFormAccessForm.ISREAD);
            taskFormAccessService.add(tf);
        }
        // 子表单
        for (FormDef formDef : formDefList) {
            TaskFormAccess tf = new TaskFormAccess();
            tf.setProcessId(taskFormAccessForm.getProcessId());
            tf.setTaskName(taskFormAccessForm.getTaskName());
            tf.setFormId(formDef.getMainFormId());
            tf.setElementId(formDef.getId());
            tf.setFormType(TaskFormAccessForm.CHILDFORM_TYPE);
            tf.setStatus(TaskFormAccessForm.ISREAD);
            taskFormAccessService.add(tf);
        }
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("操作成功!");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }

    @RequestMapping
    public AceAjaxView delete(Long id) {

        AssertUtil.assertNotNull(id, "ID不能为空");
        taskFormAccessService.delete(id);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("删除成功");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }

    @RequestMapping
    public ModelAndView selectElement(Integer pageNum, TaskFormAccessQuery query) {

        AssertUtil.notNull(query.getProcessId(), "流程标志不能为空!");
        final int PAGE_SIZE = Integer.MAX_VALUE;
        pageNum = RequestUtil.getPageid(pageNum);
        List<ElementDef> edList = new ArrayList<ElementDef>();
        List<FormDef> formDefList = new ArrayList<FormDef>();
        setParam(edList, formDefList, query.getProcessId());
        AcePagingView pagingView = new AcePagingView("/admin/snakerext-TaskFormAccess-selectElement", DIR + "/selectElement", pageNum, PAGE_SIZE, edList.size() + formDefList.size());
        // 主表单属性集合
        pagingView.addObject("elementDefList", edList);
        // 主表单下子表单集合
        pagingView.addObject("formDefList", formDefList);
        pagingView.addObject("elementMap", taskFormAccessService.mapAllElementStatus(query));
        pagingView.addObject("query", query);
        return pagingView;
    }

    private void setParam(List<ElementDef> edList, List<FormDef> formDefList, String processId) {

        ProcessFormQuery pfQquery = new ProcessFormQuery();
        pfQquery.setProcessId(processId);
        List<ProcessForm> processFormList = processFormService.list(BeanUtils.transBean2Map(pfQquery));
        if (processFormList.size() > 0) {
            Long mainFormId = processFormList.get(0).getMainFormId();
            ElementDefQuery edQuery = new ElementDefQuery();
            edQuery.setFormId(mainFormId);
            edList.addAll(formClient.listAllElementDef(edQuery));
            FormDefQuery fdQuery = new FormDefQuery();
            fdQuery.setMainFormId(mainFormId);
            formDefList.addAll(formClient.listAll(fdQuery));
        }
    }
}
