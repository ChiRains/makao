package com.qcloud.component.permission.web.handler;

import java.util.ArrayList;
import java.util.List;

import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class PermissionUriHandlerImpl extends AbstractUriHandler {

	@Override
	public List<String> adminUris() {
		List<String> list = new ArrayList<String>();
	
		list.add("/grant/toGrant.do");
		list.add("/grant/grant.do");
		list.add("/grant/list.do");
		          
		return list;
	}
}
