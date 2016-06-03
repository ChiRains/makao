package com.qcloud.project.macaovehicle.web.handler.url;

import java.util.ArrayList;
import java.util.List;

import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class PersonnelWarehouseUriHandlerImpl extends AbstractUriHandler {

	@Override
	public List<String> adminUris() {
		List<String> list = new ArrayList<String>();
		list.add("/admin/personnelWarehouse/list.do");
		list.add("/admin/personnelWarehouse/toAdd.do");
		list.add("/admin/personnelWarehouse/toEdit.do");
		list.add("/admin/personnelWarehouse/add.do");
		list.add("/admin/personnelWarehouse/edit.do");
		
		return list;
	}

	@Override
	public List<String> permissionUris() {
		List<String> list = new ArrayList<String>();
		list.add("/admin/personnelWarehouse/list.do");
		return list;
	}
}
