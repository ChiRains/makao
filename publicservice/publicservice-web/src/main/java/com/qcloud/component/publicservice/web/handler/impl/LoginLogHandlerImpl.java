package com.qcloud.component.publicservice.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.qcloud.pirates.core.json.Json;
import com.qcloud.component.publicservice.web.handler.LoginLogHandler;
import com.qcloud.component.publicservice.model.LoginLog;
import com.qcloud.component.publicservice.web.vo.LoginLogVO;
import com.qcloud.component.publicservice.web.vo.admin.AdminLoginLogVO;

@Component
public class LoginLogHandlerImpl implements LoginLogHandler {

	@Override
	public List<LoginLogVO> toVOList(List<LoginLog> list){
		List<LoginLogVO> voList = new ArrayList<LoginLogVO>();
		for (LoginLog loginLog : list) {
			voList.add(toVO(loginLog));
		}
		return voList;
	}

	@Override
	public LoginLogVO toVO(LoginLog loginLog){
		String json = Json.toJson(loginLog);
		return Json.toObject(json, LoginLogVO.class, true);

	}

	@Override
	public List<AdminLoginLogVO> toVOList4Admin(List<LoginLog> list){
		List<AdminLoginLogVO> voList = new ArrayList<AdminLoginLogVO>();
		for (LoginLog adminLoginLog : list) {
			voList.add(toVO4Admin(adminLoginLog));
		}
		return voList;
	}

	@Override
	public AdminLoginLogVO toVO4Admin(LoginLog loginLog){
		String json = Json.toJson(loginLog);
		return Json.toObject(json, AdminLoginLogVO.class, true);
	}
}
