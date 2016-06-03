package com.qcloud.component.permission.web.handler.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qcloud.component.permission.model.Account;
import com.qcloud.component.permission.model.AccountRole;
import com.qcloud.component.permission.model.Role;
import com.qcloud.component.permission.service.AccountRoleService;
import com.qcloud.component.permission.service.RoleService;
import com.qcloud.component.permission.web.handler.AccountHandler;
import com.qcloud.component.permission.web.vo.AccountVO;

@Component
public class AccountHandlerImpl implements AccountHandler{

	@Autowired
	private AccountRoleService accountRoleService;
	
	@Autowired
	private RoleService roleService;
	
	@Override
	public List<AccountVO> toVOList(List<Account> list) {
		List<AccountVO> voList = new ArrayList<AccountVO>();
		for (Account account : list) {
			AccountVO accountVO = new AccountVO();
			accountVO.setCode(account.getCode());
			accountVO.setId(account.getId());
			
			List<AccountRole> arList = accountRoleService.list(account.getId());
			List<Long> keys = new ArrayList<Long>();
			for (AccountRole accountRole : arList) {
				keys.add(accountRole.getRoleId());
			}
			List<Role> roleList = roleService.list(keys);
			StringBuffer sb = new StringBuffer();
			for (Iterator<Role> iterator = roleList.iterator(); iterator
					.hasNext();) {
				Role role = (Role) iterator.next();
				sb.append(role.getName());
				if (iterator.hasNext()) {
					sb.append(";");
				}
			}
			accountVO.setRoleStr(sb.toString());
			
			voList.add(accountVO);
		}
		
		return voList;
	}

}
