package com.qcloud.project.macaovehicle.web.handler.url;

import java.util.ArrayList;
import java.util.List;

import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class CarCardUriHandlerImpl extends AbstractUriHandler {

	@Override
	public List<String> adminUris() {
		List<String> list = new ArrayList<String>();
		list.add("/admin/carCard/list.do");
		list.add("/admin/carCard/toAdd.do");
		list.add("/admin/carCard/toEdit.do");
		list.add("/admin/carCard/add.do");
		list.add("/admin/carCard/edit.do");
		
		return list;
	}

	@Override
	public List<String> permissionUris() {
		List<String> list = new ArrayList<String>();
		list.add("/admin/carCard/list.do");
		return list;
	}
}
