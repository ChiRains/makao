package com.qcloud.project.macaovehicle.web.handler.url;

import java.util.ArrayList;
import java.util.List;

import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class CarOwnerAcquisitionUriHandlerImpl extends AbstractUriHandler {

	@Override
	public List<String> adminUris() {
		List<String> list = new ArrayList<String>();
		list.add("/admin/carOwnerAcquisition/list.do");
		list.add("/admin/carOwnerAcquisition/toAdd.do");
		list.add("/admin/carOwnerAcquisition/toEdit.do");
		list.add("/admin/carOwnerAcquisition/add.do");
		list.add("/admin/carOwnerAcquisition/edit.do");
		list.add("/carOwnerAcquisition/add.do");
	    list.add("/carOwnerAcquisition/edit.do");
	    list.add("/carOwnerAcquisition/get.do");
		return list;
	}

	@Override
	public List<String> permissionUris() {
		List<String> list = new ArrayList<String>();
		list.add("/admin/carOwnerAcquisition/list.do");
		return list;
	}
	
	@Override
	public List<String> userUris() {
		List<String> list = new ArrayList<String>();
		return list;
	}
}
