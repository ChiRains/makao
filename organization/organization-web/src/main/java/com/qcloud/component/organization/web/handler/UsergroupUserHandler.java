package com.qcloud.component.organization.web.handler;

import java.util.List;

import com.qcloud.component.organization.model.UsergroupUser;
import com.qcloud.component.organization.web.vo.UsergroupUserVO;
import com.qcloud.component.organization.web.vo.admin.AdminUsergroupUserVO;

public interface UsergroupUserHandler {

	List<UsergroupUserVO> toVOList(List<UsergroupUser> list);

	UsergroupUserVO toVO(UsergroupUser usergroupUser);

	List<AdminUsergroupUserVO> toVOList4Admin(List<UsergroupUser> list);

	AdminUsergroupUserVO toVO4Admin(UsergroupUser usergroupUser);
}
