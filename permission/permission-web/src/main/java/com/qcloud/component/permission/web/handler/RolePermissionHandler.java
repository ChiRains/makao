package com.qcloud.component.permission.web.handler;

import java.util.List;

import com.qcloud.component.permission.model.Permission;
import com.qcloud.component.permission.model.Role;
import com.qcloud.component.permission.web.vo.RolePermissionVo;

public interface RolePermissionHandler {

	List<RolePermissionVo> toVOList(List<Role> list,Permission permission);
	
	
}
