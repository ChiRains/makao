package com.qcloud.component.snakerext.web.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.qcloud.component.organization.OrganizationClient;
import com.qcloud.component.organization.model.query.ClerkQuery;
import com.qcloud.component.snakerext.SnakerExtClient;
import com.qcloud.component.snakerext.model.ProcessExecutor;
import com.qcloud.component.snakerext.model.ProcessGroup;
import com.qcloud.component.snakerext.model.key.TypeEnum.ExecutorType;
import com.qcloud.component.snakerext.model.query.ProcessExecutorQuery;
import com.qcloud.component.snakerext.service.ProcessExecutorInterfaceService;
import com.qcloud.component.snakerext.service.ProcessExecutorService;
import com.qcloud.component.snakerext.service.ProcessFormService;
import com.qcloud.component.snakerext.service.ProcessGroupService;
import com.qcloud.component.snakerext.web.form.ProcessExecutorForm;
import com.qcloud.component.snakerext.web.handler.ProcessExecutorHandler;
import com.qcloud.component.snakerext.web.vo.admin.AdminProcessExecutorVO;
import com.qcloud.pirates.core.reflect.BeanUtils;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.mvc.AceAjaxView;
import com.qcloud.pirates.mvc.AcePagingView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.NumberUtil;
import com.qcloud.pirates.util.RequestUtil;
import com.qcloud.pirates.web.security.annotation.NoReferer;

@Controller
@RequestMapping(value = "/" + AdminProcessExecutorController.DIR)
public class AdminProcessExecutorController {

    public static final String              DIR = "admin/processExecutor";

    @Autowired
    private ProcessExecutorHandler          processExecutorHandler;

    @Autowired
    private OrganizationClient              organizationClient;

    @Autowired
    private ProcessFormService              processFormService;

    @Autowired
    private ProcessExecutorService          processExecutorService;

    @Autowired
    private ProcessExecutorInterfaceService processExecutorInterfaceService;

    @Autowired
    private ProcessGroupService             processGroupService;

    @RequestMapping
    @NoReferer
    public ModelAndView list(Integer pageNum, ProcessExecutorQuery query) {

        final int PAGE_SIZE = 10;
        pageNum = RequestUtil.getPageid(pageNum);
        int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
        Page<ProcessExecutor> page = processExecutorService.page(query, start, PAGE_SIZE);
        List<AdminProcessExecutorVO> list = processExecutorHandler.toVOList4Admin(page.getData());
        AcePagingView pagingView = new AcePagingView("/admin/snakerext-ProcessExecutor-list", DIR + "/list", pageNum, PAGE_SIZE, page.getCount());
        pagingView.addObject("result", list);
        return pagingView;
    }

    @RequestMapping
    public ModelAndView toAdd() {

        ModelAndView model = new ModelAndView("/admin/snakerext-ProcessExecutor-add");
        return model;
    }

    @RequestMapping
    public AceAjaxView add(ProcessExecutor processExecutor) {

        processExecutorService.add(processExecutor);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("添加成功");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }

    @RequestMapping
    public ModelAndView toEdit(Long id) {

        AssertUtil.assertNotNull(id, "ID不能为空");
        ProcessExecutor processExecutor = processExecutorService.get(id);
        AdminProcessExecutorVO adminProcessExecutorVO = processExecutorHandler.toVO4Admin(processExecutor);
        ModelAndView model = new ModelAndView("/admin/snakerext-ProcessExecutor-edit");
        model.addObject("processExecutor", adminProcessExecutorVO);
        return model;
    }

    @RequestMapping
    public AceAjaxView edit(ProcessExecutorForm processExecutorForm) {

        ProcessExecutor processExecutor = new ProcessExecutor();
        processExecutor.setProcessId(processExecutorForm.getProcessId());
        processExecutor.setTaskName(processExecutorForm.getTaskName());
        processExecutor.setType(processExecutorForm.getType());
        processExecutor.setMemberId(processExecutorForm.getMemberId());
        if (processExecutorForm.getIsSelected()) {
            processExecutorService.add(processExecutor);
        } else {
            processExecutorService.delete(BeanUtils.transBean2Map(processExecutor));
        }
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("编辑成功");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }

    @RequestMapping
    public AceAjaxView delete(Long id) {

        AssertUtil.assertNotNull(id, "ID不能为空");
        processExecutorService.delete(id);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("删除成功");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }

    @RequestMapping
    public ModelAndView selectMember(ProcessExecutorQuery query) {

        ModelAndView model = new ModelAndView("/admin/snakerext-ProcessExecutor-selectMember");
        model.addObject("executorType", ExecutorType.values());
        ClerkQuery clerkQuery = new ClerkQuery();
        String name = "";
        Map<String, Object> map = new HashMap<String, Object>();
        if (!StringUtils.isEmpty(query.getName())) {
            if (ExecutorType.INTERFACE.getKey() == query.getType()) {
                map.put("method", query.getName());
            } else if (ExecutorType.CHARACTER.getKey() == query.getType()) {
                name = query.getName();
            } else {
                clerkQuery.setName(query.getName());
            }
        }
        model.addObject("clerkIdList", processExecutorService.listByProcessIdAndTaskName(query.getProcessId(), query.getTaskName()));
        model.addObject("clerkMap", organizationClient.mapClerkAll(clerkQuery));
        model.addObject("departmentMap", organizationClient.mapDepartmentAll());
        model.addObject("departmentClerkList", processGroupService.listByName(name));
        System.out.println(processGroupService.listByName(name));
        model.addObject("interfaceList", processExecutorInterfaceService.listAll(map));
        model.addObject("query", query);
        return model;
    }
}
