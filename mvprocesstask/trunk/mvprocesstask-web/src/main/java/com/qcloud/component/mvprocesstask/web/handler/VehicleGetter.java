package com.qcloud.component.mvprocesstask.web.handler;

import java.util.Date;

public interface VehicleGetter {

    /**
     *  获取车辆入境有效期至
     * @param plateNumber
     * @return
     */
    public Date getValidDate(String plateNumber);
}
