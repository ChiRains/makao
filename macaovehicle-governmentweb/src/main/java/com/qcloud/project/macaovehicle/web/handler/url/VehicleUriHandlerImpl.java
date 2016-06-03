package com.qcloud.project.macaovehicle.web.handler.url;

import java.util.ArrayList;
import java.util.List;

import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class VehicleUriHandlerImpl extends AbstractUriHandler {

	@Override
	public List<String> adminUris() {
		List<String> list = new ArrayList<String>();
		list.add("/admin/vehicle/list.do");
		list.add("/admin/vehicle/toAdd.do");
		list.add("/admin/vehicle/toEdit.do");
		list.add("/admin/vehicle/add.do");
		list.add("/admin/vehicle/edit.do");
		
		return list;
	}

	@Override
	public List<String> permissionUris() {
		List<String> list = new ArrayList<String>();
		list.add("/admin/vehicle/list.do");
		return list;
	}
}
