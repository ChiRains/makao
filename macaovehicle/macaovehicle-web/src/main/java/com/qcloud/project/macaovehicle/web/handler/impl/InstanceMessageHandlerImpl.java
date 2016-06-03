package com.qcloud.project.macaovehicle.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.organization.OrganizationClient;
import com.qcloud.component.organization.model.key.TypeEnum;
import com.qcloud.component.publicservice.MessageClient;
import com.qcloud.component.publicservice.QMessage;
import com.qcloud.pirates.core.json.Json;
import com.qcloud.project.macaovehicle.web.handler.InstanceMessageHandler;
import com.qcloud.project.macaovehicle.model.InstanceMessage;
import com.qcloud.project.macaovehicle.web.vo.InstanceMessageVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminInstanceMessageVO;

@Component
public class InstanceMessageHandlerImpl implements InstanceMessageHandler {

    @Autowired
    MessageClient messageClient;

    @Override
    public List<InstanceMessageVO> toVOList(List<InstanceMessage> list) {

        List<InstanceMessageVO> voList = new ArrayList<InstanceMessageVO>();
        for (InstanceMessage instanceMessage : list) {
            voList.add(toVO(instanceMessage));
        }
        return voList;
    }

    @Override
    public InstanceMessageVO toVO(InstanceMessage instanceMessage) {

        String json = Json.toJson(instanceMessage);
        InstanceMessageVO vo = Json.toObject(json, InstanceMessageVO.class, true);
        QMessage qMessage = messageClient.get(TypeEnum.CLERK_MESSAGE_CODE, instanceMessage.getClerkId(), instanceMessage.getMessageClerkId());
        vo.setqMessage(qMessage);
        return vo;
    }

    @Override
    public List<AdminInstanceMessageVO> toVOList4Admin(List<InstanceMessage> list) {

        List<AdminInstanceMessageVO> voList = new ArrayList<AdminInstanceMessageVO>();
        for (InstanceMessage adminInstanceMessage : list) {
            voList.add(toVO4Admin(adminInstanceMessage));
        }
        return voList;
    }

    @Override
    public AdminInstanceMessageVO toVO4Admin(InstanceMessage instanceMessage) {

        String json = Json.toJson(instanceMessage);
        return Json.toObject(json, AdminInstanceMessageVO.class, true);
    }
}
