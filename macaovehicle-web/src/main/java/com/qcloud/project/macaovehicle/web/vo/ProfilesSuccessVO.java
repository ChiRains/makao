package com.qcloud.project.macaovehicle.web.vo;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ProfilesSuccessVO {

    private long                id;

    // 表单实例id
    private long                formInstanceId;

    // 申请人id
    private long                carOwnerId;

    // 车辆id
    private long                vehicleId;

    // 驾驶员id
    private long                driverId;

    // 创建时间
    private Date                createDate;

    private Map<String, Object> returnMap = new HashMap<String, Object>();

    public ProfilesSuccessVO() {

    }

    public ProfilesSuccessVO(long id, long carOwnerId, long vehicleId, long driverId, Date createDate) {

        this.id = id;
        this.carOwnerId = carOwnerId;
        this.vehicleId = vehicleId;
        this.driverId = driverId;
        this.createDate = createDate;
    }

    public void setId(long id) {

        this.id = id;
    }

    public long getId() {

        return id;
    }

    public void setCarOwnerId(long carOwnerId) {

        this.carOwnerId = carOwnerId;
    }

    public long getCarOwnerId() {

        return carOwnerId;
    }

    public void setVehicleId(long vehicleId) {

        this.vehicleId = vehicleId;
    }

    public long getVehicleId() {

        return vehicleId;
    }

    public void setDriverId(long driverId) {

        this.driverId = driverId;
    }

    public long getDriverId() {

        return driverId;
    }

    public void setCreateDate(Date createDate) {

        this.createDate = createDate;
    }

    public Date getCreateDate() {

        return createDate;
    }

    public Map<String, Object> getReturnMap() {

        return returnMap;
    }

    public void setReturnMap(Map<String, Object> returnMap) {

        this.returnMap = returnMap;
    }

    public long getFormInstanceId() {

        return formInstanceId;
    }

    public void setFormInstanceId(long formInstanceId) {

        this.formInstanceId = formInstanceId;
    }
}
