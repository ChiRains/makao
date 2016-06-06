package com.qcloud.component.publicdata.web.handler.url;

import java.util.ArrayList;
import java.util.List;

import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class QuestionUriHandlerImpl extends AbstractUriHandler {

	@Override
	public List<String> adminUris() {
		List<String> list = new ArrayList<String>();
		list.add("/admin/question/list.do");
		list.add("/admin/question/toAdd.do");
		list.add("/admin/question/toEdit.do");
		list.add("/admin/question/add.do");
		list.add("/admin/question/edit.do");
		list.add("/admin/question/delete.do");
		return list;
	}

	@Override
	public List<String> permissionUris() {
		List<String> list = new ArrayList<String>();
		list.add("/admin/question/list.do");
		return list;
	}
}
