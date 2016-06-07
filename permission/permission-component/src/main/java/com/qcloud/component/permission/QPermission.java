package com.qcloud.component.permission;

public interface QPermission {

    public long getId();

    public String getName();

    public int getType();

    public long getTargetId();
}
