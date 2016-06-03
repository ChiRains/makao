package com.qcloud.component.organization.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.qcloud.pirates.core.json.Json;
import com.qcloud.component.organization.web.handler.UsergroupHandler;
import com.qcloud.component.organization.model.Usergroup;
import com.qcloud.component.organization.web.vo.UsergroupVO;
import com.qcloud.component.organization.web.vo.admin.AdminUsergroupVO;

@Component
public class UsergroupHandlerImpl implements UsergroupHandler {

	@Override
	public List<UsergroupVO> toVOList(List<Usergroup> list){
		List<UsergroupVO> voList = new ArrayList<UsergroupVO>();
		for (Usergroup usergroup : list) {
			voList.add(toVO(usergroup));
		}
		return voList;
	}

	@Override
	public UsergroupVO toVO(Usergroup usergroup){
		String json = Json.toJson(usergroup);
		return Json.toObject(json, UsergroupVO.class, true);

	}

	@Override
	public List<AdminUsergroupVO> toVOList4Admin(List<Usergroup> list){
		List<AdminUsergroupVO> voList = new ArrayList<AdminUsergroupVO>();
		for (Usergroup adminUsergroup : list) {
			voList.add(toVO4Admin(adminUsergroup));
		}
		return voList;
	}

	@Override
	public AdminUsergroupVO toVO4Admin(Usergroup usergroup){
		String json = Json.toJson(usergroup);
		return Json.toObject(json, AdminUsergroupVO.class, true);
	}
}
