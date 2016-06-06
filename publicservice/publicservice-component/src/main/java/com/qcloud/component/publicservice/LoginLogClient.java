package com.qcloud.component.publicservice;

import java.util.List;
import com.qcloud.component.publicservice.model.key.TypeEnum.LoginLogOperateType;

public interface LoginLogClient {

    public boolean loginInLog(long consumerId, int consumerType, String ip);

    public boolean loginOutLog(long consumerId, int consumerType, String ip);

    public List<QLoginLog> list(long consumerId, int consumerType, LoginLogOperateType logOperateType);
}
