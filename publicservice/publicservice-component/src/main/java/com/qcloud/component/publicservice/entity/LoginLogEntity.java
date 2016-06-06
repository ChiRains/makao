package com.qcloud.component.publicservice.entity;

import com.qcloud.component.publicservice.QLoginLog;
import com.qcloud.component.publicservice.model.LoginLog;
import com.qcloud.component.publicservice.model.key.TypeEnum.LoginLogConsumerType;
import com.qcloud.component.publicservice.model.key.TypeEnum.LoginLogOperateType;
import com.qcloud.pirates.util.DateUtil;

public class LoginLogEntity implements QLoginLog {

    private LoginLog loginLog;

    public LoginLogEntity() {

    }

    public LoginLogEntity(LoginLog loginLog) {

        this.loginLog = loginLog;
    }

    @Override
    public String getTime() {

        return DateUtil.date2String(loginLog.getTime(), "yyyy-MM-dd HH:mm:ss");
    }

    @Override
    public String getIp() {

        return loginLog.getIp();
    }

    @Override
    public LoginLogOperateType getOperateType() {

        return LoginLogOperateType.getByKey(loginLog.getOperate());
    }

    @Override
    public LoginLogConsumerType getConsumerType() {

        return LoginLogConsumerType.getByKey(loginLog.getConsumerType());
    }

    @Override
    public Long getConsumerId() {

        return loginLog.getConsumerId();
    }

    @Override
    public String getOperateTypeStr() {

        if (getOperateType() == null) {
            return "";
        } else {
            return getOperateType().getName();
        }
    }
}
