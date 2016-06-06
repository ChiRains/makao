package com.qcloud.component.organization.web.handler;

import java.util.List;

import com.qcloud.component.organization.model.PostRole;
import com.qcloud.component.organization.web.vo.PostRoleVO;
import com.qcloud.component.organization.web.vo.admin.AdminPostRoleVO;

public interface PostRoleHandler {

	List<PostRoleVO> toVOList(List<PostRole> list);

	PostRoleVO toVO(PostRole postRole);

	List<AdminPostRoleVO> toVOList4Admin(List<PostRole> list);

	AdminPostRoleVO toVO4Admin(PostRole postRole);
}
