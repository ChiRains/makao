package com.qcloud.project.macaovehicle.web.handler.url;

import java.util.ArrayList;
import java.util.List;

import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class DvrDetailUriHandlerImpl extends AbstractUriHandler {

	@Override
	public List<String> adminUris() {
		List<String> list = new ArrayList<String>();
		list.add("/admin/dvrDetail/list.do");
		list.add("/admin/dvrDetail/toAdd.do");
		list.add("/admin/dvrDetail/toEdit.do");
		list.add("/admin/dvrDetail/add.do");
		list.add("/admin/dvrDetail/edit.do");
		list.add("/dvrDetail/listDvr.do");
		list.add("/dvrDetail/listAllDvr.do");
		list.add("/dvrDetail/add.do");
		list.add("/dvrDetail/get.do");
		list.add("/dvrDetail/update.do");
		list.add("/dvrDetail/register.do");
		return list;
	}

	@Override
	public List<String> permissionUris() {
		List<String> list = new ArrayList<String>();
		list.add("/admin/dvrDetail/list.do");
		return list;
	}
}
