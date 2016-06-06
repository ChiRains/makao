package com.qcloud.component.publicservice.web.handler.url;

import java.util.ArrayList;
import java.util.List;

import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class LoginLogUriHandlerImpl extends AbstractUriHandler {

	@Override
	public List<String> adminUris() {
		List<String> list = new ArrayList<String>();
		list.add("/admin/loginLog/list.do");
		list.add("/admin/loginLog/toAdd.do");
		list.add("/admin/loginLog/toEdit.do");
		list.add("/admin/loginLog/add.do");
		list.add("/admin/loginLog/edit.do");
		
		return list;
	}

	@Override
	public List<String> permissionUris() {
		List<String> list = new ArrayList<String>();
		list.add("/admin/loginLog/list.do");
		return list;
	}
}
