package com.qcloud.project.macaovehicle.web.controller;

import java.util.Date;
import java.util.List;
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
import com.qcloud.component.permission.ResourcesClient;
import com.qcloud.component.permission.RoleClient;
import com.qcloud.pirates.mvc.FrontAjaxView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.project.macaovehicle.model.DepartmentRole;
import com.qcloud.project.macaovehicle.model.key.RoleTypeEnum;
import com.qcloud.project.macaovehicle.service.DepartmentRoleService;
import com.qcloud.project.macaovehicle.web.form.DepartmentRoleForm;
import com.qcloud.project.macaovehicle.web.handler.DepartmentRoleHandler;

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
        // Clerk clerk = clerkHelper.getClerk(request);
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
        departmentRole.setCreator(Long.valueOf("1010012000014401"));
        // departmentRole.setCreator(clerk.getId());
        departmentRole.setCreateDate(new Date());
        departmentRoleService.add(departmentRole);
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("添加成功.");
        return view;
    }
}
