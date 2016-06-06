package com.qcloud.component.organization.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.qcloud.pirates.core.json.Json;
import com.qcloud.component.organization.web.handler.PostRoleHandler;
import com.qcloud.component.organization.model.PostRole;
import com.qcloud.component.organization.web.vo.PostRoleVO;
import com.qcloud.component.organization.web.vo.admin.AdminPostRoleVO;

@Component
public class PostRoleHandlerImpl implements PostRoleHandler {

	@Override
	public List<PostRoleVO> toVOList(List<PostRole> list){
		List<PostRoleVO> voList = new ArrayList<PostRoleVO>();
		for (PostRole postRole : list) {
			voList.add(toVO(postRole));
		}
		return voList;
	}

	@Override
	public PostRoleVO toVO(PostRole postRole){
		String json = Json.toJson(postRole);
		return Json.toObject(json, PostRoleVO.class, true);

	}

	@Override
	public List<AdminPostRoleVO> toVOList4Admin(List<PostRole> list){
		List<AdminPostRoleVO> voList = new ArrayList<AdminPostRoleVO>();
		for (PostRole adminPostRole : list) {
			voList.add(toVO4Admin(adminPostRole));
		}
		return voList;
	}

	@Override
	public AdminPostRoleVO toVO4Admin(PostRole postRole){
		String json = Json.toJson(postRole);
		return Json.toObject(json, AdminPostRoleVO.class, true);
	}
}
