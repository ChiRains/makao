package com.qcloud.component.organization.web.handler;

import java.util.List;

import com.qcloud.component.organization.QContacts;
import com.qcloud.component.organization.web.vo.ContactsVO;
import com.qcloud.component.organization.web.vo.ExportContactsVO;

public interface ContactsHandler {

	List<ContactsVO> toVOList(List<QContacts> data);

	List<ExportContactsVO> toVOList4Export(List<QContacts> data);
	

}
