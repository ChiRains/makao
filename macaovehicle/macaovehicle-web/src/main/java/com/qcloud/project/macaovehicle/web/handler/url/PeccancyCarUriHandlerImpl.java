package com.qcloud.project.macaovehicle.web.handler.url;

import java.util.ArrayList;
import java.util.List;

import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class PeccancyCarUriHandlerImpl extends AbstractUriHandler {

	@Override
	public List<String> adminUris() {
		List<String> list = new ArrayList<String>();
		list.add("/admin/peccancyCar/list.do");
		list.add("/admin/peccancyCar/toAdd.do");
		list.add("/admin/peccancyCar/toEdit.do");
		list.add("/admin/peccancyCar/add.do");
		list.add("/admin/peccancyCar/edit.do");
		list.add("/peccancyCar/edit.do");
		list.add("/peccancyCar/add.do");
		list.add("/peccancyCar/delete.do");
		list.add("/peccancyCar/myList.do");
		return list;
	}

	@Override
	public List<String> permissionUris() {
		List<String> list = new ArrayList<String>();
		list.add("/admin/peccancyCar/list.do");
		return list;
	}
	
	@Override
	public List<String> whiteNameUris() {
		List<String> list = new ArrayList<String>();
		list.add("/peccancyCar/get.do");
		list.add("/peccancyCar/list.do");
		return list;
	}
}
