package com.qcloud.project.macaovehicle.web.controller;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qcloud.component.account.UnifiedAccountClient;
import com.qcloud.component.organization.OrganizationClient;
import com.qcloud.component.organization.QClerk;
import com.qcloud.component.organization.common.ClerkConstant;
import com.qcloud.component.organization.form.ClerkForm;
import com.qcloud.component.organization.model.Clerk;
import com.qcloud.component.organization.model.key.TypeEnum.ClerkType;
import com.qcloud.component.organization.model.key.TypeEnum.EnableType;
import com.qcloud.component.organization.model.query.ClerkQuery;
import com.qcloud.component.organization.web.helper.ClerkHelper;
import com.qcloud.component.permission.AccountClient;
import com.qcloud.component.permission.PermissionClient;
import com.qcloud.component.permission.model.Account;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.mvc.FrontAjaxView;
import com.qcloud.pirates.mvc.FrontPagingView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.NumberUtil;
import com.qcloud.pirates.util.RequestUtil;
import com.qcloud.project.macaovehicle.model.query.MacClerkQuery;
import com.qcloud.project.macaovehicle.web.helper.MacRoleHelper;

@Controller
@RequestMapping(value = MacClerkController.DIR)
public class MacClerkController {

    public static final String   DIR = "/macClerk";

    @Autowired
    public OrganizationClient    organizationClient;

    @Autowired
    public PermissionClient      permissionClient;

    @Autowired
    private AccountClient        accountClient;

    @Autowired
    private ClerkHelper          clerkHelper;

    @Autowired
    private UnifiedAccountClient unifiedAccountClient;

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
        AssertUtil.assertTrue(pwd1.equals(pwd2), "密码不一致, 请重新输入.");
        Clerk curClerk = clerkHelper.getClerk(request);
        // 新增用户
        clerk.setType(ClerkType.SHENPI.getKey());
        clerk.setCreator(curClerk.getId());
        clerk.setUpdateTime(new Date());
        organizationClient.registClerk(clerk, departmentId, pwd1);
        // 新增用户角色授权
        String accountCode = ClerkConstant.CLERKPREFIXCODE + clerk.getMobile();
        Account account = accountClient.getAccount(accountCode);
        permissionClient.grant(account.getId(), roleId);
        FrontAjaxView view = new FrontAjaxView();
        return view;
    }

    /**
     * 用户列表
     * @param request
     * @param pageNum
     * @param pageSize
     * @param query
     * @return
     */
    @RequestMapping
    public FrontPagingView list(HttpServletRequest request, Integer pageNum, Integer pageSize, MacClerkQuery query) {

        final int PAGE_SIZE = pageSize == null || pageSize <= 0 ? 10 : pageSize;
        pageNum = RequestUtil.getPageid(pageNum);
        int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
        ClerkQuery clerkQuery = new ClerkQuery();
        clerkQuery.setType(ClerkType.SHENPI.getKey());
        Page<QClerk> page = organizationClient.page(clerkQuery, start, PAGE_SIZE);
        FrontPagingView view = new FrontPagingView(pageNum, PAGE_SIZE, page.getCount());
        view.setList(page.getData());
        return view;
    }

    /**
     * 查看某个用户
     * @param request
     * @param id
     * @return
     */
    @RequestMapping
    public FrontAjaxView getClerk(HttpServletRequest request, Long id) {

        AssertUtil.greatZero(id, "id不能为空.");
        QClerk qClerk = organizationClient.getClerk(id);
        FrontAjaxView view = new FrontAjaxView();
        view.addObject("qClerk", qClerk);
        return view;
    }

    /**
     * 
     * 更新用户信息
     * @param request
     * @param clerkForm
     * @param roleId
     * @return
     */
    @RequestMapping
    public FrontAjaxView updateClerk(HttpServletRequest request, ClerkForm clerkForm, Long roleId) {

        AssertUtil.greatZero(clerkForm.getId(), "id不能为空.");
        AssertUtil.greatZero(roleId, "角色id不能为空.");
        Clerk curClerk = clerkHelper.getClerk(request);
        clerkForm.setEnable(EnableType.ENABLE.getKey());
        clerkForm.setCreator(curClerk.getId());
        clerkForm.setUpdateTime(new Date());
        // 更新用户
        organizationClient.updateClerk(clerkForm, clerkForm.getDepartmentId());
        QClerk qClerk = organizationClient.getClerk(clerkForm.getId());
        String accountCode = ClerkConstant.CLERKPREFIXCODE + qClerk.getMobile();
        Account account = accountClient.getAccount(accountCode);
        // 删除授权
        permissionClient.unbindAccountGrant(account.getId());
        // 更新授权
        permissionClient.grant(account.getId(), roleId);
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("更新成功.");
        return view;
    }

    /**
     * 禁用、停用职工
     * @param request
     * @param id
     * @param state
     * @return
     */
    @RequestMapping
    public FrontAjaxView changeClerk(HttpServletRequest request, Long id, int state) {

        AssertUtil.greatZero(id, "id不能为空.");
        AssertUtil.assertTrue(state == 0 || state == 1, "状态不符合规则." + state);
        QClerk qClerk = organizationClient.getClerk(id);
        if (state == 0) {
            unifiedAccountClient.disableAccount(qClerk.getMobile());
        } else if (state == 1) {
            unifiedAccountClient.enableAccount(qClerk.getMobile());
        }
        // 0禁用 1启用
        organizationClient.setEnable(id, state);
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("更新成功.");
        return view;
    }

    /**
     * 用户权限菜单
     * @param request
     * @return
     */
    @RequestMapping
    public FrontAjaxView menuList(HttpServletRequest request) {

        Clerk clerk = clerkHelper.getClerk(request);
        FrontAjaxView view = new FrontAjaxView();
        MacRoleHelper macRoleHelper = new MacRoleHelper();
        view.addObject("classifyList", macRoleHelper.listClassify(clerk.getMobile()));
        view.setMessage("获取分类成功");
        return view;
    }
}
