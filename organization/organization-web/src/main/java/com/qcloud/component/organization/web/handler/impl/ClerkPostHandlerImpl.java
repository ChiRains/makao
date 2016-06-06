package com.qcloud.component.organization.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.qcloud.pirates.core.json.Json;
import com.qcloud.component.organization.web.handler.ClerkPostHandler;
import com.qcloud.component.organization.model.ClerkPost;
import com.qcloud.component.organization.web.vo.ClerkPostVO;
import com.qcloud.component.organization.web.vo.admin.AdminClerkPostVO;

@Component
public class ClerkPostHandlerImpl implements ClerkPostHandler {

	@Override
	public List<ClerkPostVO> toVOList(List<ClerkPost> list){
		List<ClerkPostVO> voList = new ArrayList<ClerkPostVO>();
		for (ClerkPost clerkPost : list) {
			voList.add(toVO(clerkPost));
		}
		return voList;
	}

	@Override
	public ClerkPostVO toVO(ClerkPost clerkPost){
		String json = Json.toJson(clerkPost);
		return Json.toObject(json, ClerkPostVO.class, true);

	}

	@Override
	public List<AdminClerkPostVO> toVOList4Admin(List<ClerkPost> list){
		List<AdminClerkPostVO> voList = new ArrayList<AdminClerkPostVO>();
		for (ClerkPost adminClerkPost : list) {
			voList.add(toVO4Admin(adminClerkPost));
		}
		return voList;
	}

	@Override
	public AdminClerkPostVO toVO4Admin(ClerkPost clerkPost){
		String json = Json.toJson(clerkPost);
		return Json.toObject(json, AdminClerkPostVO.class, true);
	}
}
