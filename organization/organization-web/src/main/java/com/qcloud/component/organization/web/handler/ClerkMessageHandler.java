package com.qcloud.component.organization.web.handler;

import java.util.List;
import com.qcloud.component.organization.web.vo.ClerkMessageVO;
import com.qcloud.component.publicservice.QMessage;

public interface ClerkMessageHandler {

    List<ClerkMessageVO> toVOList(List<QMessage> list);

    ClerkMessageVO toVO(QMessage QMessage);
}
