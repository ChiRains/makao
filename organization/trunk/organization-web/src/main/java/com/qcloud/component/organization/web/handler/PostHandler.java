package com.qcloud.component.organization.web.handler;

import java.util.List;

import com.qcloud.component.organization.model.Post;
import com.qcloud.component.organization.web.vo.PostVO;
import com.qcloud.component.organization.web.vo.admin.AdminPostVO;

public interface PostHandler {

	List<PostVO> toVOList(List<Post> list);

	PostVO toVO(Post post);

	List<AdminPostVO> toVOList4Admin(List<Post> list);

	AdminPostVO toVO4Admin(Post post);
}
