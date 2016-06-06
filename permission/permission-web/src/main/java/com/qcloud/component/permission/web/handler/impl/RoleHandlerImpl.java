package com.qcloud.component.permission.web.handler.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qcloud.component.permission.model.AccountRole;
import com.qcloud.component.permission.model.Role;
import com.qcloud.component.permission.service.AccountRoleService;
import com.qcloud.component.permission.web.handler.RoleHandler;
import com.qcloud.component.permission.web.vo.RoleVO;

@Component
public class RoleHandlerImpl implements RoleHandler {
	@Autowired
	private AccountRoleService accountRoleService;

	@Override
	public List<RoleVO> toVOList(List<Role> list, Long accountId,
			Long[] currentAccountIds) {
		List<Long> currentRoleList = new ArrayList<Long>();
		if (currentAccountIds != null) {
			for (Long id : currentAccountIds) {
				List<AccountRole> arList = accountRoleService.list(id);
				for (AccountRole accountRole : arList) {
					currentRoleList.add(accountRole.getRoleId());
				}
			}
		}

		List<AccountRole> arList = accountRoleService.list(accountId);
		List<RoleVO> voList = new ArrayList<RoleVO>();

		for (Role role : list) {
			if (currentRoleList.contains(role.getParentGrantRoleId())) {
				RoleVO roleVO = new RoleVO();
				roleVO.setDesc(role.getDesc());
				roleVO.setId(role.getId());
				roleVO.setName(role.getName());

				String checked = "";
				for (AccountRole accountRole : arList) {
					if (accountRole.getRoleId() == role.getId()) {
						checked = "checked";
					}
				}
				roleVO.setChecked(checked);
				voList.add(roleVO);
			}
		}
		return voList;
	}
}
