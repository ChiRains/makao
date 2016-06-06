package com.qcloud.component.account;

import java.util.Date;

public interface QAccount {

    String getGroup();

    String getAccount();

    String getCode();

    String getName();

    Date getRegistTime();
}
