package com.qcloud.component.organization.web.controller.admin;

import org.apache.commons.collections.CollectionUtils;
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
import com.qcloud.pirates.util.StringUtil;
import com.qcloud.pirates.web.security.annotation.NoReferer;
import com.qcloud.component.organization.exception.OrganizationException;
import com.qcloud.component.organization.model.Department;
import com.qcloud.component.organization.model.DepartmentClerk;
import com.qcloud.component.organization.service.DepartmentClerkService;
import com.qcloud.component.organization.service.DepartmentService;
import com.qcloud.component.organization.web.handler.DepartmentHandler;
import com.qcloud.component.organization.model.query.DepartmentQuery;
import com.qcloud.component.organization.web.vo.admin.AdminDepartmentVO;

@Controller
@RequestMapping(value = "/" + AdminDepartmentController.DIR)
public class AdminDepartmentController {

    public static final String     DIR = "admin/department";

    @Autowired
    private DepartmentService      departmentService;

    @Autowired
    private DepartmentHandler      departmentHandler;

    @Autowired
    private DepartmentClerkService departmentClerkService;

    @RequestMapping
    @NoReferer
    public ModelAndView list(Integer pageNum, DepartmentQuery query) {

        final int PAGE_SIZE = 10;
        pageNum = RequestUtil.getPageid(pageNum);
        int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
        Page<Department> page = departmentService.page(query, start, PAGE_SIZE);
        List<AdminDepartmentVO> list = departmentHandler.toVOList4Admin(page.getData());
        String param = "displayName=" + StringUtil.nullToEmpty(query.getDisplayName());
        AcePagingView pagingView = new AcePagingView("/admin/organization-Department-list", DIR + "/list?" + param, pageNum, PAGE_SIZE, page.getCount());
        pagingView.addObject("result", list);
        pagingView.addObject("query", query);
        return pagingView;
    }

    @RequestMapping
    public ModelAndView toAdd() {

        ModelAndView model = new ModelAndView("/admin/organization-Department-add");
        model.addObject("departmentList", departmentService.listAll());
        return model;
    }

    @RequestMapping
    public AceAjaxView add(Department department) {

        department.setManager(Long.valueOf(-1));
        departmentService.add(department);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("添加成功");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }

    @RequestMapping
    public ModelAndView toEdit(Long id) {

        AssertUtil.assertNotNull(id, "ID不能为空");
        Department department = departmentService.get(id);
        AdminDepartmentVO adminDepartmentVO = departmentHandler.toVO4Admin(department);
        ModelAndView model = new ModelAndView("/admin/organization-Department-edit");
        model.addObject("department", adminDepartmentVO);
        return model;
    }

    @RequestMapping
    public AceAjaxView edit(Department department) {

        Department newDepartment = departmentService.get(department.getId());
        newDepartment.setName(department.getName());
        departmentService.update(newDepartment);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("编辑成功");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }

    @RequestMapping
    public AceAjaxView delete(Long id) {

        AceAjaxView aceAjaxView = new AceAjaxView();
        AssertUtil.assertNotNull(id, "ID不能为空");
        Department department = departmentService.get(id);
        AssertUtil.assertNotNull(department, "部门不存在.");
        List<Department> list = departmentService.listAll();
        for (Department temp : list) {
            if (temp.getParentId() == department.getId()) {
                aceAjaxView.setMessage("删除失败,部门:" + department.getName() + " 中存在子部门");
                aceAjaxView.setStatus(0);
                return aceAjaxView;
            }
        }
        List<DepartmentClerk> clerkList = departmentClerkService.listByDepartment(id);
        if (CollectionUtils.isNotEmpty(clerkList)) {
            aceAjaxView.setMessage("删除失败,部门:" + department.getName() + "中存在:" + clerkList.size() + "名员工.");
            aceAjaxView.setStatus(0);
            return aceAjaxView;
        }
        departmentService.delete(id);
        aceAjaxView.setMessage("删除成功");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }
}
