package com.qcloud.component.publicservice;

import com.qcloud.component.publicservice.model.key.TypeEnum.LoginLogConsumerType;
import com.qcloud.component.publicservice.model.key.TypeEnum.LoginLogOperateType;

public interface QLoginLog {

    String getTime();

    String getIp();

    LoginLogOperateType getOperateType();

    LoginLogConsumerType getConsumerType();

    String getOperateTypeStr();

    Long getConsumerId();
}
