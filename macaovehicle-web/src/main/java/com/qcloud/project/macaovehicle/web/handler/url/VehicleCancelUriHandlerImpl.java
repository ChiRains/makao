package com.qcloud.project.macaovehicle.web.handler.url;

import java.util.ArrayList;
import java.util.List;

import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class VehicleCancelUriHandlerImpl extends AbstractUriHandler {

	@Override
	public List<String> adminUris() {
		List<String> list = new ArrayList<String>();
		list.add("/admin/vehicleCancel/list.do");
		list.add("/admin/vehicleCancel/toAdd.do");
		list.add("/admin/vehicleCancel/toEdit.do");
		list.add("/admin/vehicleCancel/add.do");
		list.add("/admin/vehicleCancel/edit.do");
		list.add("/vehicleCancel/list.do");
		list.add("/vehicleCancel/changeState.do");
		return list;
	}

	@Override
	public List<String> permissionUris() {
		List<String> list = new ArrayList<String>();
		list.add("/admin/vehicleCancel/list.do");
		return list;
	}
}
