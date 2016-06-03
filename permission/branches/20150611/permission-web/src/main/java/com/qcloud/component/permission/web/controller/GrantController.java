package com.qcloud.component.permission.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qcloud.component.parameter.ParameterClient;
import com.qcloud.component.permission.PermissionClient;
import com.qcloud.component.permission.model.Account;
import com.qcloud.component.permission.model.AccountRole;
import com.qcloud.component.permission.model.Role;
import com.qcloud.component.permission.service.AccountRoleService;
import com.qcloud.component.permission.service.AccountService;
import com.qcloud.component.permission.service.AuthenticationService;
import com.qcloud.component.permission.service.RoleService;
import com.qcloud.component.permission.web.handler.AccountHandler;
import com.qcloud.component.permission.web.handler.RoleHandler;
import com.qcloud.component.permission.web.vo.AccountVO;
import com.qcloud.component.permission.web.vo.RoleVO;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.mvc.AceAjaxView;
import com.qcloud.pirates.mvc.PagingView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.NumberUtil;
import com.qcloud.pirates.util.RequestUtil;
import com.qcloud.pirates.web.filter.permission.PermissionFilterService;

@Controller
@RequestMapping(value = GrantController.DIR)
public class GrantController {

	public static final String DIR = "/grant";
	@Autowired
	private AccountService accountService;
	@Autowired
	private AccountHandler accountHandler;
	@Autowired
	private PermissionFilterService permissionFilterService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private RoleHandler roleHandler;
	@Autowired
	private AuthenticationService authenticationService;
	@Autowired
	private AccountRoleService accountRoleService;
	@Autowired
	private ParameterClient parameterClient;

	private Log logger = LogFactory.getLog(getClass());

	@RequestMapping
	public ModelAndView list(HttpServletRequest request, Integer pageNum) {
		String[] accounts = permissionFilterService
				.getPermissionAccountCodes(request);
		String str = parameterClient
				.get(PermissionClient.NO_GRANT_ACCOUNT_CODES_KEY);
		if (str != null) {
			String[] filterAccounts = str
					.split(PermissionClient.NO_GRANT_ACCOUNT_CODES_KEY_SPLIT);
			List<String> list = new ArrayList<String>();
			for (String string : filterAccounts) {
				list.add(string);
			}
			if (accounts != null) {
				for (String string : accounts) {
					list.add(string);
				}
			}
			accounts = list.toArray(new String[list.size()]);
		}
			
		int pageSize = Integer.MAX_VALUE;
		pageNum = RequestUtil.getPageid(pageNum);
		int start = NumberUtil.getPageStart(pageNum, pageSize);

		Page<Account> page = accountService.page(accounts, start, pageSize);
		List<AccountVO> list = accountHandler.toVOList(page.getData());

		PagingView model = new PagingView("permission/grant-list", pageNum, pageSize);

		model.addObject("accountList", list);
		model.setTotalCount(page.getCount());

		return model;
	}

	@RequestMapping
	public ModelAndView toGrant(HttpServletRequest request, Long accountId) {
		AssertUtil.assertNotNull(accountId, "ID不能为空.");
		Account account = accountService.get(accountId);
		AssertUtil.assertNotNull(account, "账号不存在.");
		List<Role> list = roleService.list();
		String[] accountStrs = permissionFilterService
				.getPermissionAccountCodes(request);
		Long[] accounts = null;
		if (accountStrs != null) {
			accounts = new Long[accountStrs.length];
			for (int index = 0; index < accountStrs.length; index++) {
				String str = accountStrs[index];
				Account ac = accountService.getByCode(str);
				if (ac == null) {
					logger.info("role " + str + " not fount");
					continue;
				}
				accounts[index] = ac.getId();
			}
		}
		List<RoleVO> voList = roleHandler.toVOList(list, accountId, accounts);

		ModelAndView modelAndView = new ModelAndView("permission/grant");
		modelAndView.addObject("roleList", voList);
		modelAndView.addObject("account", account);

		return modelAndView;
	}

	@RequestMapping
	public AceAjaxView grant(Long accountId, Long roleId, Integer value) {
		AssertUtil.assertNotNull(accountId, "AccountID不能为空.");
		AssertUtil.assertNotNull(roleId, "RoleID不能为空.");
		AssertUtil.assertNotNull(value, "Value开关不能为空.");
		AccountRole accountRole = accountRoleService.get(accountId, roleId);
		if (value == 1) {
			if (accountRole == null) {
				authenticationService.grant(accountId, roleId);
			}
		} else {
			if (accountRole != null) {
				accountRoleService.delete(accountRole.getId());
			}
		}

		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("授权成功.");
		aceAjaxView.setUrl("grant/list");
		return aceAjaxView;
	}
}
