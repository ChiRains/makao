package com.qcloud.component.organization.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.qcloud.pirates.core.json.Json;
import com.qcloud.component.organization.web.handler.UsergroupUserHandler;
import com.qcloud.component.organization.model.UsergroupUser;
import com.qcloud.component.organization.web.vo.UsergroupUserVO;
import com.qcloud.component.organization.web.vo.admin.AdminUsergroupUserVO;

@Component
public class UsergroupUserHandlerImpl implements UsergroupUserHandler {

	@Override
	public List<UsergroupUserVO> toVOList(List<UsergroupUser> list){
		List<UsergroupUserVO> voList = new ArrayList<UsergroupUserVO>();
		for (UsergroupUser usergroupUser : list) {
			voList.add(toVO(usergroupUser));
		}
		return voList;
	}

	@Override
	public UsergroupUserVO toVO(UsergroupUser usergroupUser){
		String json = Json.toJson(usergroupUser);
		return Json.toObject(json, UsergroupUserVO.class, true);

	}

	@Override
	public List<AdminUsergroupUserVO> toVOList4Admin(List<UsergroupUser> list){
		List<AdminUsergroupUserVO> voList = new ArrayList<AdminUsergroupUserVO>();
		for (UsergroupUser adminUsergroupUser : list) {
			voList.add(toVO4Admin(adminUsergroupUser));
		}
		return voList;
	}

	@Override
	public AdminUsergroupUserVO toVO4Admin(UsergroupUser usergroupUser){
		String json = Json.toJson(usergroupUser);
		return Json.toObject(json, AdminUsergroupUserVO.class, true);
	}
}
