package com.qcloud.component.organization.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import com.qcloud.component.organization.web.handler.ClerkMessageHandler;
import com.qcloud.component.organization.web.vo.ClerkMessageVO;
import com.qcloud.component.publicservice.QMessage;
import com.qcloud.pirates.util.DateUtil;

@Component
public class ClerkMessageHandlerImpl implements ClerkMessageHandler {

    @Override
    public List<ClerkMessageVO> toVOList(List<QMessage> list) {

        List<ClerkMessageVO> voList = new ArrayList<ClerkMessageVO>();
        for (QMessage message : list) {
            voList.add(toVO(message));
        }
        return voList;
    }

    @Override
    public ClerkMessageVO toVO(QMessage message) {

        ClerkMessageVO vo = new ClerkMessageVO();
        vo.setId(message.getId());
        vo.setTitle(message.getTitle());
        vo.setContent(message.getContent());
        vo.setTime(message.getTime());
        vo.setTimeStr(DateUtil.date2String(message.getTime()));
        vo.setRead(message.isRead());
        return vo;
    }
}
