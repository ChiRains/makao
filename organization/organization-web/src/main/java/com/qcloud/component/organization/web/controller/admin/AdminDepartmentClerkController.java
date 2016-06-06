package com.qcloud.component.organization.web.controller.admin;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.qcloud.component.organization.OrganizationClient;
import com.qcloud.component.organization.QClerk;
import com.qcloud.component.organization.exception.OrganizationException;
import com.qcloud.component.organization.model.Clerk;
import com.qcloud.component.organization.model.Department;
import com.qcloud.component.organization.model.DepartmentClerk;
import com.qcloud.component.organization.model.query.DepartmentClerkQuery;
import com.qcloud.component.organization.service.ClerkService;
import com.qcloud.component.organization.service.DepartmentClerkService;
import com.qcloud.component.organization.service.DepartmentService;
import com.qcloud.component.organization.web.form.DepartmentClerkForm;
import com.qcloud.component.organization.web.handler.ClerkHandler;
import com.qcloud.component.organization.web.handler.DepartmentClerkHandler;
import com.qcloud.component.organization.web.vo.admin.AdminClerkVO;
import com.qcloud.component.organization.web.vo.admin.AdminDepartmentClerkVO;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.mvc.AceAjaxView;
import com.qcloud.pirates.mvc.AcePagingView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.NumberUtil;
import com.qcloud.pirates.util.RequestUtil;
import com.qcloud.pirates.web.security.annotation.NoReferer;

@Controller
@RequestMapping(value = "/" + AdminDepartmentClerkController.DIR)
public class AdminDepartmentClerkController {

    public static final String     DIR = "admin/departmentClerk";

    @Autowired
    private DepartmentClerkService departmentClerkService;

    @Autowired
    private DepartmentClerkHandler departmentClerkHandler;

    @Autowired
    private ClerkService           clerkService;

    @Autowired
    private DepartmentService      departmentService;

    @Autowired
    private OrganizationClient     organizationClient;

    @Autowired
    private ClerkHandler           clerkHandler;

    @RequestMapping
    @NoReferer
    public ModelAndView list(Integer pageNum, DepartmentClerkQuery query) {

        final int PAGE_SIZE = 10;
        pageNum = RequestUtil.getPageid(pageNum);
        int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
        Page<DepartmentClerk> page = departmentClerkService.page(query, start, PAGE_SIZE);
        List<AdminDepartmentClerkVO> list = departmentClerkHandler.toVOList4Admin(page.getData());
        AcePagingView pagingView = new AcePagingView("/admin/organization-DepartmentClerk-list", DIR + "/list", pageNum, PAGE_SIZE, page.getCount());
        pagingView.addObject("result", list);
        return pagingView;
    }

    @RequestMapping
    public ModelAndView toAdd() {

        ModelAndView model = new ModelAndView("/admin/organization-DepartmentClerk-add");
        return model;
    }

    @RequestMapping
    public AceAjaxView add(DepartmentClerk departmentClerk) {

        departmentClerkService.add(departmentClerk);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("添加成功");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }

    @RequestMapping
    public ModelAndView toEdit(Long id) {

        AssertUtil.assertNotNull(id, "ID不能为空");
        DepartmentClerk departmentClerk = departmentClerkService.get(id);
        AdminDepartmentClerkVO adminDepartmentClerkVO = departmentClerkHandler.toVO4Admin(departmentClerk);
        ModelAndView model = new ModelAndView("/admin/organization-DepartmentClerk-edit");
        model.addObject("departmentClerk", adminDepartmentClerkVO);
        return model;
    }

    @RequestMapping
    public AceAjaxView edit(DepartmentClerkForm departmentClerkForm) {

        AceAjaxView aceAjaxView = new AceAjaxView();
        departmentClerkForm.setType(Integer.valueOf(1));
        if (departmentClerkForm.getIsSelected()) {
            // 先删除
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("clerkId", departmentClerkForm.getClerkId());
            departmentClerkService.delete(map);
            // 后添加
            DepartmentClerk d = new DepartmentClerk();
            d.setType(departmentClerkForm.getType());
            d.setClerkId(departmentClerkForm.getClerkId());
            d.setDepartmentId(departmentClerkForm.getDepartmentId());
            departmentClerkService.add(d);
            aceAjaxView.setMessage("编辑成功");
        } else {
            // Map<String, Object> map = new HashMap<String, Object>();
            // map.put("clerkId", departmentClerkForm.getClerkId());
            // map.put("departmentId", departmentClerkForm.getDepartmentId());
            // departmentClerkService.delete(map);
            aceAjaxView.setStatus(-1);
            aceAjaxView.setMessage("编辑失败,职员必须属于一个部门");
        }
        return aceAjaxView;
    }

    @RequestMapping
    public AceAjaxView editManager(DepartmentClerkForm departmentClerkForm) {

        departmentClerkForm.setType(Integer.valueOf(1));
        if (departmentClerkForm.getIsSelected()) {
            Department department = departmentService.get(departmentClerkForm.getDepartmentId());
            department.setManager(departmentClerkForm.getClerkId());
            departmentService.update(department);
        }
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("编辑成功");
        return aceAjaxView;
    }

    @RequestMapping
    public AceAjaxView delete(Long id) {

        AssertUtil.assertNotNull(id, "ID不能为空");
        departmentClerkService.delete(id);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("删除成功");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }

    @RequestMapping
    public ModelAndView selectMember(Integer pageNum, DepartmentClerkQuery query) {

        final int PAGE_SIZE = Integer.MAX_VALUE;
        pageNum = RequestUtil.getPageid(pageNum);
        int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
        Page<DepartmentClerk> page = departmentClerkService.page(query, start, PAGE_SIZE);
        List<AdminDepartmentClerkVO> list = departmentClerkHandler.toVOList4Admin(page.getData());
        AcePagingView pagingView = new AcePagingView("/admin/organization-DepartmentClerk-selectMember", DIR + "/selectMember", pageNum, PAGE_SIZE, page.getCount());
        pagingView.addObject("result", list);
        pagingView.addObject("query", query);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", query.getName());
        List<Clerk> clerkList = clerkService.listAll(map);
        List<AdminClerkVO> clerkVoList = clerkHandler.toVOList4Admin(clerkList);
        Collections.sort(clerkVoList, new Comparator<AdminClerkVO>() {

            @Override
            public int compare(AdminClerkVO o1, AdminClerkVO o2) {

                return String.valueOf(o1.getDepartmentId()).compareTo(String.valueOf(o2.getDepartmentId()));
            }
        });
        pagingView.addObject("clerkList", clerkVoList);
        return pagingView;
    }

    @RequestMapping
    public ModelAndView selectManager(Integer pageNum, DepartmentClerkQuery query) {

        final int PAGE_SIZE = Integer.MAX_VALUE;
        pageNum = RequestUtil.getPageid(pageNum);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", query.getName());
        List<Clerk> clerkList = clerkService.listAll(map);
        AcePagingView pagingView = new AcePagingView("/admin/organization-DepartmentClerk-selectManager", DIR + "/selectManager", pageNum, PAGE_SIZE, clerkList.size());
        pagingView.addObject("department", departmentService.get(query.getDepartmentId()));
        pagingView.addObject("query", query);
        List<AdminClerkVO> clerkVoList = clerkHandler.toVOList4Admin(clerkList);
        Collections.sort(clerkVoList, new Comparator<AdminClerkVO>() {

            @Override
            public int compare(AdminClerkVO o1, AdminClerkVO o2) {

                return String.valueOf(o1.getDepartmentId()).compareTo(String.valueOf(o2.getDepartmentId()));
            }
        });
        pagingView.addObject("clerkList", clerkVoList);
        return pagingView;
    }
}
