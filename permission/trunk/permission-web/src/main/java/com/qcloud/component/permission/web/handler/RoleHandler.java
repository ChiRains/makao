package com.qcloud.component.permission.web.handler;

import java.util.List;

import com.qcloud.component.permission.model.Role;
import com.qcloud.component.permission.web.vo.RoleVO;

public interface RoleHandler {

	List<RoleVO> toVOList(List<Role> list, Long accountId,
			Long[] currentAccountIds);
	
	
}
