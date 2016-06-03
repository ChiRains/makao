package com.qcloud.project.macaovehicle.web.handler.url;

import java.util.ArrayList;
import java.util.List;

import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class DriverUriHandlerImpl extends AbstractUriHandler {

	@Override
	public List<String> adminUris() {
		List<String> list = new ArrayList<String>();
		list.add("/admin/driver/list.do");
		list.add("/admin/driver/toAdd.do");
		list.add("/admin/driver/toEdit.do");
		list.add("/admin/driver/add.do");
		list.add("/admin/driver/edit.do");
		
		return list;
	}

	@Override
	public List<String> permissionUris() {
		List<String> list = new ArrayList<String>();
		list.add("/admin/driver/list.do");
		return list;
	}
}
