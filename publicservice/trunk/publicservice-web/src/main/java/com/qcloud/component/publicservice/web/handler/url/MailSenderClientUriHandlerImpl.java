package com.qcloud.component.publicservice.web.handler.url;

import java.util.ArrayList;
import java.util.List;
import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class MailSenderClientUriHandlerImpl extends AbstractUriHandler {

	@Override
	public List<String> whiteNameUris() {

		List<String> list = new ArrayList<String>();
		list.add("/mailSender/sendMail.do");
		return list;
	}
}
