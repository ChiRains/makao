package com.qcloud.component.organization.web.handler;

import java.util.List;

import com.qcloud.component.organization.model.ClerkPost;
import com.qcloud.component.organization.web.vo.ClerkPostVO;
import com.qcloud.component.organization.web.vo.admin.AdminClerkPostVO;

public interface ClerkPostHandler {

	List<ClerkPostVO> toVOList(List<ClerkPost> list);

	ClerkPostVO toVO(ClerkPost clerkPost);

	List<AdminClerkPostVO> toVOList4Admin(List<ClerkPost> list);

	AdminClerkPostVO toVO4Admin(ClerkPost clerkPost);
}
