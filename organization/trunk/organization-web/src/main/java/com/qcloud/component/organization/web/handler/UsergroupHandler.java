package com.qcloud.component.organization.web.handler;

import java.util.List;

import com.qcloud.component.organization.model.Usergroup;
import com.qcloud.component.organization.web.vo.UsergroupVO;
import com.qcloud.component.organization.web.vo.admin.AdminUsergroupVO;

public interface UsergroupHandler {

	List<UsergroupVO> toVOList(List<Usergroup> list);

	UsergroupVO toVO(Usergroup usergroup);

	List<AdminUsergroupVO> toVOList4Admin(List<Usergroup> list);

	AdminUsergroupVO toVO4Admin(Usergroup usergroup);
}
