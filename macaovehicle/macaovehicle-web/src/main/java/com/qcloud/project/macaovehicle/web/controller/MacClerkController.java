package com.qcloud.project.macaovehicle.web.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qcloud.component.organization.OrganizationClient;
import com.qcloud.component.organization.common.ClerkConstant;
import com.qcloud.component.organization.model.Clerk;
import com.qcloud.component.permission.AccountClient;
import com.qcloud.component.permission.PermissionClient;
import com.qcloud.component.permission.model.Account;
import com.qcloud.component.permission.model.AccountRole;
import com.qcloud.pirates.mvc.FrontAjaxView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.project.macaovehicle.model.DepartmentRole;
import com.qcloud.project.macaovehicle.service.DepartmentRoleService;

@Controller
@RequestMapping(value = MacClerkController.DIR)
public class MacClerkController {

    public static final String DIR = "/macClerk";

    @Autowired
    public OrganizationClient  organizationClient;

    @Autowired
    public PermissionClient    permissionClient;

    @Autowired
    private AccountClient      accountClient;

    /**
     * 新增角色信息.
     * @param request
     * @param form
     * @return
     */
    @RequestMapping
    public FrontAjaxView addClerk(HttpServletRequest request, Clerk clerk, Long departmentId, Long roleId, String pwd1, String pwd2) {

        AssertUtil.assertNotNull(clerk.getMobile(), "电话不能为空.");
        AssertUtil.greatZero(departmentId, "部门不能为空.");
        AssertUtil.greatZero(roleId, "角色不能为空.");
        AssertUtil.assertTrue(pwd1 == pwd2, "密码不一致, 请重新输入.");
        // 新增用户
        Long clerkId = organizationClient.registClerk(clerk, departmentId, pwd1);
        // 新增用户角色关联
        String accountCode = ClerkConstant.CLERKPREFIXCODE + clerk.getMobile();
        Account account = accountClient.getAccount(accountCode);
        permissionClient.grant(account.getId(), roleId);
        FrontAjaxView view = new FrontAjaxView();
        return view;
    }
}
