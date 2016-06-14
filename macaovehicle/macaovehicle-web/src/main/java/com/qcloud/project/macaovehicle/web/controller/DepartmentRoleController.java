package com.qcloud.project.macaovehicle.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qcloud.component.organization.model.Clerk;
import com.qcloud.component.organization.web.helper.ClerkHelper;
import com.qcloud.component.permission.PermissionClient;
import com.qcloud.component.permission.QPermission;
import com.qcloud.component.permission.QResources;
import com.qcloud.component.permission.QRole;
import com.qcloud.component.permission.ResourcesClient;
import com.qcloud.component.permission.RoleClient;
import com.qcloud.component.permission.model.key.TypeEnum.RoleEnableType;
import com.qcloud.component.publicdata.QClassify;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.mvc.FrontAjaxView;
import com.qcloud.pirates.mvc.FrontPagingView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.NumberUtil;
import com.qcloud.pirates.util.RequestUtil;
import com.qcloud.project.macaovehicle.model.DepartmentRole;
import com.qcloud.project.macaovehicle.model.key.RoleTypeEnum;
import com.qcloud.project.macaovehicle.model.key.RoleTypeEnum.StatusType;
import com.qcloud.project.macaovehicle.model.query.DepartmentRoleQuery;
import com.qcloud.project.macaovehicle.service.DepartmentRoleService;
import com.qcloud.project.macaovehicle.web.form.DepartmentRoleForm;
import com.qcloud.project.macaovehicle.web.handler.DepartmentRoleHandler;
import com.qcloud.project.macaovehicle.web.helper.MacRoleHelper;
import com.qcloud.project.macaovehicle.web.vo.DepartmentRoleVO;

@Controller
@RequestMapping(value = DepartmentRoleController.DIR)
public class DepartmentRoleController {

    public static final String    DIR = "/departmentRole";

    @Autowired
    private DepartmentRoleService departmentRoleService;

    @Autowired
    private DepartmentRoleHandler departmentRoleHandler;

    @Autowired
    private ClerkHelper           clerkHelper;

    @Autowired
    private RoleClient            roleClient;

    @Value("${pirates.superman.adminRoleId}")
    private long                  parentGrantRoleId;

    @Autowired
    private ResourcesClient       resourcesClient;

    @Autowired
    private PermissionClient      permissionClient;

    @Autowired
    private MacRoleHelper         macRoleHelper;

    /**
     * 新增角色信息.
     * @param request
     * @param form
     * @return
     */
    @RequestMapping
    public FrontAjaxView add(HttpServletRequest request, DepartmentRoleForm form) {

        AssertUtil.assertNotNull(form.getRoleName(), "角色名称不能为空.");
        AssertUtil.greatZero(form.getDepartmentId(), "部门id不能为空.");
        Clerk clerk = clerkHelper.getClerk(request);
        // 添加角色
        Long roleId = roleClient.registerRole(form.getRoleName(), form.getDesc(), parentGrantRoleId);
        // 资源树
        List<Long> classifyIds = form.getClassifyIds();
        for (Long classifyId : classifyIds) {
            QResources qResources = resourcesClient.getByClassifyId(classifyId);
            QPermission qPermission = permissionClient.getPermission(RoleTypeEnum.PermissionType.RESOURCES.getKey(), qResources.getId());
            // 角色授权
            roleClient.grantRolePermission(qPermission.getId(), roleId);
        }
        // 部门角色关系表
        DepartmentRole departmentRole = new DepartmentRole();
        departmentRole.setRoleId(roleId);
        departmentRole.setDepartmentId(form.getDepartmentId());
        departmentRole.setDesc(form.getDesc());
        departmentRole.setStatus(RoleTypeEnum.StatusType.ENABLE.getKey());
        // departmentRole.setCreator(Long.valueOf("1010012000014401"));
        departmentRole.setCreator(clerk.getId());
        departmentRole.setCreateDate(new Date());
        departmentRoleService.add(departmentRole);
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("添加成功.");
        return view;
    }

    @RequestMapping
    public FrontPagingView list(HttpServletRequest request, Integer pageSize, Integer pageNum, DepartmentRoleQuery query) {

        final int PAGE_SIZE = pageSize == null || pageSize <= 0 ? 10 : pageSize;
        pageNum = RequestUtil.getPageid(pageNum);
        int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
        Page<DepartmentRole> page = departmentRoleService.page(query, start, PAGE_SIZE);
        List<DepartmentRoleVO> voList = departmentRoleHandler.toVOList(page.getData());
        FrontPagingView view = new FrontPagingView(pageNum, PAGE_SIZE, page.getCount());
        view.setMessage("查询成功");
        view.addObject("result", voList);
        return view;
    }

    /**
     * 获取角色信息
     * @param request
     * @param id
     * @return
     */
    @RequestMapping
    public FrontAjaxView get(HttpServletRequest request, Long id) {

        AssertUtil.greatZero(id, "id不能为空.");
        FrontAjaxView view = new FrontAjaxView();
        DepartmentRole departmentRole = departmentRoleService.get(id);
        AssertUtil.assertNotNull(departmentRole, "角色部门不存在." + id);
        view.addObject("classifyList", macRoleHelper.listClassify(departmentRole.getRoleId()));
        view.addObject("departmentRole", departmentRoleHandler.toVO(departmentRole));
        return view;
    }

    /**
     * 更新角色信息
     * @param request
     * @param form
     * @return
     */
    @RequestMapping
    public FrontAjaxView update(HttpServletRequest request, DepartmentRoleForm form) {

        AssertUtil.greatZero(form.getId(), "id不能为空.");
        Clerk clerk = clerkHelper.getClerk(request);
        DepartmentRole departmentRole = departmentRoleService.get(form.getId());
        departmentRole.setDesc(form.getDesc());
        departmentRole.setCreator(clerk.getId());
        departmentRole.setCreateDate(new Date());
        departmentRoleService.update(departmentRole);
        // 删除旧资源树
        List<QClassify> qClassifys = macRoleHelper.listClassify(departmentRole.getRoleId());
        for (QClassify qClassify : qClassifys) {
            QResources qResources = resourcesClient.getByClassifyId(qClassify.getId());
            QPermission qPermission = permissionClient.getPermission(RoleTypeEnum.PermissionType.RESOURCES.getKey(), qResources.getId());
            // 角色授权
            roleClient.unbindRolePermission(qPermission.getId(), departmentRole.getRoleId());
        }
        // 新增资源树
        List<Long> classifyIds = form.getClassifyIds();
        for (Long classifyId : classifyIds) {
            if (classifyId == null) {
                continue;
            }
            QResources qResources = resourcesClient.getByClassifyId(classifyId);
            QPermission qPermission = permissionClient.getPermission(RoleTypeEnum.PermissionType.RESOURCES.getKey(), qResources.getId());
            // 角色授权
            roleClient.grantRolePermission(qPermission.getId(), departmentRole.getRoleId());
        }
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("更新成功.");
        return view;
    }

    /**
     * 角色列表
     * @param request
     * @param departmentId
     * @return
     */
    @RequestMapping
    public FrontAjaxView roleList(HttpServletRequest request, Long departmentId) {

        AssertUtil.greatZero(departmentId, "部门id不能为空.");
        List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
        List<DepartmentRole> list = departmentRoleService.listByDepartmentId(departmentId);
        for (DepartmentRole departmentRole : list) {
            Map<String, Object> map = new HashMap<String, Object>();
            QRole qRole = permissionClient.getRole(departmentRole.getRoleId());
            map.put("id", qRole.getId());
            map.put("name", qRole.getName());
            mapList.add(map);
        }
        FrontAjaxView view = new FrontAjaxView();
        view.addObject("roleList", mapList);
        view.setMessage("查询成功");
        return view;
    }

    /**
     * 更新角色信息
     * @param request
     * @param form
     * @return
     */
    @RequestMapping
    public FrontAjaxView changeRole(HttpServletRequest request, Long id, Integer status) {

        AssertUtil.greatZero(id, "id不能为空.");
        AssertUtil.assertTrue(status == StatusType.ENABLE.getKey() || status == StatusType.DISABLE.getKey(), "状态非法.");
        DepartmentRole departmentRole = departmentRoleService.get(id);
        AssertUtil.assertNotNull(departmentRole, "角色部门不存在." + id);
        departmentRole.setStatus(status);
        departmentRoleService.update(departmentRole);
        // 角色状态修改
        roleClient.setEnable(departmentRole.getRoleId(), status == StatusType.ENABLE.getKey() ? RoleEnableType.ENABLE : RoleEnableType.DISABLE);
        FrontAjaxView view = new FrontAjaxView();
        view.addObject("status", status);
        view.setMessage("状态更新成功." + status);
        return view;
    }
}
