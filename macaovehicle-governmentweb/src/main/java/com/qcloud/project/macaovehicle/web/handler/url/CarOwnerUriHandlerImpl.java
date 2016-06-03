package com.qcloud.project.macaovehicle.web.handler.url;

import java.util.ArrayList;
import java.util.List;

import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class CarOwnerUriHandlerImpl extends AbstractUriHandler {

	@Override
	public List<String> adminUris() {
		List<String> list = new ArrayList<String>();
		list.add("/admin/carOwner/list.do");
		list.add("/admin/carOwner/toAdd.do");
		list.add("/admin/carOwner/toEdit.do");
		list.add("/admin/carOwner/add.do");
		list.add("/admin/carOwner/edit.do");
		
		return list;
	}

	@Override
	public List<String> permissionUris() {
		List<String> list = new ArrayList<String>();
		list.add("/admin/carOwner/list.do");
		return list;
	}
}
