package com.qcloud.component.admin.web.handler.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.qcloud.component.admin.model.Admin;
import com.qcloud.component.admin.web.handler.AdminHandler;
import com.qcloud.component.admin.web.vo.AdminVO;

@Component
public class AdminHandlerImpl implements AdminHandler {

	@Override
	public List<AdminVO> toVOList(List<Admin> adminList) {
		List<AdminVO> voList = new ArrayList<AdminVO>();
		for (Admin admin : adminList) {
			AdminVO vo = toVO(admin);
			voList.add(vo);
		}
		return voList;
	}

	@Override
	public AdminVO toVO(Admin admin) {
		AdminVO vo = new AdminVO();
		vo.setId(admin.getId());
		vo.setName(admin.getName());
		vo.setAccount(admin.getAccount());
		vo.setEnable(admin.getEnable());
		return vo;
	}
}
