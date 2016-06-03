package com.qcloud.component.publicservice.web.handler;

import java.util.List;

import com.qcloud.component.publicservice.model.MessageType;
import com.qcloud.component.publicservice.web.vo.MessageTypeVO;
import com.qcloud.component.publicservice.web.vo.admin.AdminMessageTypeVO;

public interface MessageTypeHandler {

	List<MessageTypeVO> toVOList(List<MessageType> list);

	MessageTypeVO toVO(MessageType messageType);

	List<AdminMessageTypeVO> toVOList4Admin(List<MessageType> list);

	AdminMessageTypeVO toVO4Admin(MessageType messageType);
}
