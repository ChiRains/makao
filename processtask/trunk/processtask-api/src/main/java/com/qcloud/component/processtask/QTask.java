package com.qcloud.component.processtask;

import java.util.Date;

public interface QTask {

    String getName();

    Long getClerk();

    Long getFormInstance();

    String getWorkitem();

    boolean isTasking();

    boolean isPass();

    Date getDoneTime();
}
