package com.qcloud.component.organization.web.handler;

import java.util.List;

import com.qcloud.component.organization.model.Clerk;
import com.qcloud.component.organization.web.vo.ClerkVO;
import com.qcloud.component.organization.web.vo.admin.AdminClerkVO;

public interface ClerkHandler {

	List<ClerkVO> toVOList(List<Clerk> list);

	ClerkVO toVO(Clerk clerk);

	List<AdminClerkVO> toVOList4Admin(List<Clerk> list);

	AdminClerkVO toVO4Admin(Clerk clerk);
}
