package com.qcloud.project.macaovehicle.model;

import java.util.Date;
import java.math.BigDecimal;

public class DriverLoss {

    // ID
    private long   id;

    // 表单编码(不涉及流程)
    private String formInstCode;

    // ID
    private long   carOwnerId;

    // 车辆id
    private long   driverId;

    // 旧电子司机卡号
    private String oldDriverIc;

    // 新电子司机卡号
    private String newDriverIc;

    // 挂失时间
    private Date   lossTime;

    // 已标记时间
    private Date   recordTime;

    // 类型（1 挂失 2补办 3已处理）
    private int    type;

    public DriverLoss() {

    }

    public DriverLoss(long id, String formInstCode, long carOwnerId, long driverId, String oldDriverIc, String newDriverIc, Date lossTime, Date recordTime, int type) {

        this.id = id;
        this.formInstCode = formInstCode;
        this.carOwnerId = carOwnerId;
        this.driverId = driverId;
        this.oldDriverIc = oldDriverIc;
        this.newDriverIc = newDriverIc;
        this.lossTime = lossTime;
        this.recordTime = recordTime;
        this.type = type;
    }

    public void setId(long id) {

        this.id = id;
    }

    public long getId() {

        return id;
    }

    public void setFormInstCode(String formInstCode) {

        this.formInstCode = formInstCode;
    }

    public String getFormInstCode() {

        return formInstCode;
    }

    public void setCarOwnerId(long carOwnerId) {

        this.carOwnerId = carOwnerId;
    }

    public long getCarOwnerId() {

        return carOwnerId;
    }

    public void setDriverId(long driverId) {

        this.driverId = driverId;
    }

    public long getDriverId() {

        return driverId;
    }

    public void setLossTime(Date lossTime) {

        this.lossTime = lossTime;
    }

    public Date getLossTime() {

        return lossTime;
    }

    public void setRecordTime(Date recordTime) {

        this.recordTime = recordTime;
    }

    public Date getRecordTime() {

        return recordTime;
    }

    public void setType(int type) {

        this.type = type;
    }

    public int getType() {

        return type;
    }

    public String getOldDriverIc() {

        return oldDriverIc;
    }

    public String getNewDriverIc() {

        return newDriverIc;
    }

    public void setOldDriverIc(String oldDriverIc) {

        this.oldDriverIc = oldDriverIc;
    }

    public void setNewDriverIc(String newDriverIc) {

        this.newDriverIc = newDriverIc;
    }
}
