package com.qcloud.project.macaovehicle.web.handler.url;

import java.util.ArrayList;
import java.util.List;

import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class ApprovalOutsideUriHandlerImpl extends AbstractUriHandler {

	@Override
	public List<String> adminUris() {
		List<String> list = new ArrayList<String>();
		list.add("/admin/approvalOutside/list.do");
		list.add("/admin/approvalOutside/toAdd.do");
		list.add("/admin/approvalOutside/toEdit.do");
		list.add("/admin/approvalOutside/add.do");
		list.add("/admin/approvalOutside/edit.do");
		
		return list;
	}

	@Override
	public List<String> permissionUris() {
		List<String> list = new ArrayList<String>();
		list.add("/admin/approvalOutside/list.do");
		return list;
	}
}
