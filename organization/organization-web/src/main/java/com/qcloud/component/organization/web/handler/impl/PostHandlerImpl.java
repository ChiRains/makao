package com.qcloud.component.organization.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.qcloud.pirates.core.json.Json;
import com.qcloud.component.organization.web.handler.PostHandler;
import com.qcloud.component.organization.model.Post;
import com.qcloud.component.organization.web.vo.PostVO;
import com.qcloud.component.organization.web.vo.admin.AdminPostVO;

@Component
public class PostHandlerImpl implements PostHandler {

	@Override
	public List<PostVO> toVOList(List<Post> list){
		List<PostVO> voList = new ArrayList<PostVO>();
		for (Post post : list) {
			voList.add(toVO(post));
		}
		return voList;
	}

	@Override
	public PostVO toVO(Post post){
		String json = Json.toJson(post);
		return Json.toObject(json, PostVO.class, true);

	}

	@Override
	public List<AdminPostVO> toVOList4Admin(List<Post> list){
		List<AdminPostVO> voList = new ArrayList<AdminPostVO>();
		for (Post adminPost : list) {
			voList.add(toVO4Admin(adminPost));
		}
		return voList;
	}

	@Override
	public AdminPostVO toVO4Admin(Post post){
		String json = Json.toJson(post);
		return Json.toObject(json, AdminPostVO.class, true);
	}
}
