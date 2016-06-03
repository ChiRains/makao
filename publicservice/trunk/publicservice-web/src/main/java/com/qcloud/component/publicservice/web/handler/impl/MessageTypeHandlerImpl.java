package com.qcloud.component.publicservice.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.qcloud.pirates.core.json.Json;
import com.qcloud.component.publicservice.web.handler.MessageTypeHandler;
import com.qcloud.component.publicservice.model.MessageType;
import com.qcloud.component.publicservice.web.vo.MessageTypeVO;
import com.qcloud.component.publicservice.web.vo.admin.AdminMessageTypeVO;

@Component
public class MessageTypeHandlerImpl implements MessageTypeHandler {

	@Override
	public List<MessageTypeVO> toVOList(List<MessageType> list){
		List<MessageTypeVO> voList = new ArrayList<MessageTypeVO>();
		for (MessageType messageType : list) {
			voList.add(toVO(messageType));
		}
		return voList;
	}

	@Override
	public MessageTypeVO toVO(MessageType messageType){
		String json = Json.toJson(messageType);
		return Json.toObject(json, MessageTypeVO.class, true);

	}

	@Override
	public List<AdminMessageTypeVO> toVOList4Admin(List<MessageType> list){
		List<AdminMessageTypeVO> voList = new ArrayList<AdminMessageTypeVO>();
		for (MessageType adminMessageType : list) {
			voList.add(toVO4Admin(adminMessageType));
		}
		return voList;
	}

	@Override
	public AdminMessageTypeVO toVO4Admin(MessageType messageType){
		String json = Json.toJson(messageType);
		return Json.toObject(json, AdminMessageTypeVO.class, true);
	}
}
