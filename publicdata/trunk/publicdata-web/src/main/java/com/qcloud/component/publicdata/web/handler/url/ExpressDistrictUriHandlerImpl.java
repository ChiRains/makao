package com.qcloud.component.publicdata.web.handler.url;

import java.util.ArrayList;
import java.util.List;

import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class ExpressDistrictUriHandlerImpl extends AbstractUriHandler {

	@Override
	public List<String> adminUris() {
		List<String> list = new ArrayList<String>();
		list.add("/admin/expressDistrict/list.do");
		list.add("/admin/expressDistrict/toAdd.do");
		list.add("/admin/expressDistrict/toEdit.do");
		list.add("/admin/expressDistrict/add.do");
		list.add("/admin/expressDistrict/edit.do");
		list.add("/admin/expressDistrict/delete.do");
		return list;
	}

	@Override
	public List<String> permissionUris() {
		List<String> list = new ArrayList<String>();
		list.add("/admin/expressDistrict/list.do");
		return list;
	}
}
