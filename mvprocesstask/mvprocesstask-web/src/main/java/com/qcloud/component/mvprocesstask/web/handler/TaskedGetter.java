package com.qcloud.component.mvprocesstask.web.handler;

public interface TaskedGetter {

    public int getBorderStatus(long formInstanceId);

    public int getCiqStatus(long formInstanceId);

    public int getCustomsStatus(long formInstanceId);
}
