package com.qcloud.component.permission.handler;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.qcloud.component.permission.PermissionClient;
import com.qcloud.pirates.web.filter.PermissionHandler;

public class PermissionHandlerImpl implements PermissionHandler {

	Log logger = LogFactory.getLog(getClass());
	@Autowired
	PermissionClient permissionClient;

	@Override
	public boolean hasPermission(String account, String uri) {
		logger.info("check permission " + account + " " + uri);
		if (uri.startsWith("/") && uri.endsWith(".do")) {
			uri = uri.substring(1, uri.length() - 3);
		}
		return permissionClient.hasPermission(account, uri);
	}
}
