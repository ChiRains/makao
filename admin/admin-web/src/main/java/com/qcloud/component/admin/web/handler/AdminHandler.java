package com.qcloud.component.admin.web.handler;

import java.util.List;

import com.qcloud.component.admin.model.Admin;
import com.qcloud.component.admin.web.vo.AdminVO;

public interface AdminHandler {

	List<AdminVO> toVOList(List<Admin> adminList);

	AdminVO toVO(Admin admin);
}
