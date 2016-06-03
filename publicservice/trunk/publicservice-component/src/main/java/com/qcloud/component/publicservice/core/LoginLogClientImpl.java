package com.qcloud.component.publicservice.core;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.publicservice.LoginLogClient;
import com.qcloud.component.publicservice.QLoginLog;
import com.qcloud.component.publicservice.entity.LoginLogEntity;
import com.qcloud.component.publicservice.model.LoginLog;
import com.qcloud.component.publicservice.model.key.TypeEnum.LoginLogOperateType;
import com.qcloud.component.publicservice.service.LoginLogService;

@Component
public class LoginLogClientImpl implements LoginLogClient {

    @Autowired
    private LoginLogService loginLogService;

    @Override
    public boolean loginInLog(long consumerId, int consumerType, String ip) {

        LoginLog loginLog = new LoginLog();
        loginLog.setConsumerId(consumerId);
        loginLog.setConsumerType(consumerType);
        loginLog.setIp(ip);
        loginLog.setOperate(LoginLogOperateType.LOGIN_IN.getKey());
        loginLog.setTime(new Date());
        return loginLogService.add(loginLog);
    }

    @Override
    public boolean loginOutLog(long consumerId, int consumerType, String ip) {

        LoginLog loginLog = new LoginLog();
        loginLog.setConsumerId(consumerId);
        loginLog.setConsumerType(consumerType);
        loginLog.setIp(ip);
        loginLog.setOperate(LoginLogOperateType.LOGIN_OUT.getKey());
        loginLog.setTime(new Date());
        return loginLogService.add(loginLog);
    }

    @Override
    public List<QLoginLog> list(long consumerId, int consumerType, LoginLogOperateType logOperateType) {

        List<LoginLog> list = loginLogService.list(consumerId, consumerType, logOperateType.getKey());
        List<QLoginLog> logList = new ArrayList<QLoginLog>();
        for (LoginLog loginLog : list) {
            logList.add(new LoginLogEntity(loginLog));
        }
        return logList;
    }
}
