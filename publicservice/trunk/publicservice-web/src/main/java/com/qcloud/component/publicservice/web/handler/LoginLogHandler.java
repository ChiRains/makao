package com.qcloud.component.publicservice.web.handler;

import java.util.List;

import com.qcloud.component.publicservice.model.LoginLog;
import com.qcloud.component.publicservice.web.vo.LoginLogVO;
import com.qcloud.component.publicservice.web.vo.admin.AdminLoginLogVO;

public interface LoginLogHandler {

	List<LoginLogVO> toVOList(List<LoginLog> list);

	LoginLogVO toVO(LoginLog loginLog);

	List<AdminLoginLogVO> toVOList4Admin(List<LoginLog> list);

	AdminLoginLogVO toVO4Admin(LoginLog loginLog);
}
