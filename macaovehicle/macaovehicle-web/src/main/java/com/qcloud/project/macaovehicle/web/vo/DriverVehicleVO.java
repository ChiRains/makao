package com.qcloud.project.macaovehicle.web.vo;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DriverVehicleVO {

    private long                id;

    // 表单编码
    private String              formInstCode;

    // 车辆id
    private long                vehicleId;

    // 驾驶员id
    private long                driverId;

    // 电子车牌号（16位）
    private String              ric;

    // 司机IC识别卡号
    private String              driverIc;

    // 是否为主司机，（1是，0不是）
    private int                 isPrimary;

    // 创建者
    private long                carOwnerId;

    // 创建时间
    private Date                createDate;

    // 修改人
    private String              modifier;

    // 修改日期，格式"1989-11-12 00:00:00"
    private Date                modifyDate;

    // 状态
    private int                 state;

    // 申请类型
    private int                 type;

    private Map<String, Object> returnMap = new HashMap<String, Object>();
	//交警临时号牌
	private String temporaryPlate;		
	
	//指标号
	private String indicatorsNo;

    public DriverVehicleVO() {

    }

    public DriverVehicleVO(long id, String ric, String driverIc, int isPrimary, long carOwnerId, Date createDate, String modifier, Date modifyDate, int type) {

        this.id = id;
        this.ric = ric;
        this.driverIc = driverIc;
        this.isPrimary = isPrimary;
        this.carOwnerId = carOwnerId;
        this.createDate = createDate;
        this.modifier = modifier;
        this.modifyDate = modifyDate;
        this.type = type;
    }

    public void setId(long id) {

        this.id = id;
    }

    public long getId() {

        return id;
    }

    public void setRic(String ric) {

        this.ric = ric;
    }

    public String getRic() {

        return ric;
    }

    public void setDriverIc(String driverIc) {

        this.driverIc = driverIc;
    }

    public String getDriverIc() {

        return driverIc;
    }

    public void setIsPrimary(int isPrimary) {

        this.isPrimary = isPrimary;
    }

    public int getIsPrimary() {

        return isPrimary;
    }

    public void setCreateDate(Date createDate) {

        this.createDate = createDate;
    }

    public Date getCreateDate() {

        return createDate;
    }

    public void setModifier(String modifier) {

        this.modifier = modifier;
    }

    public String getModifier() {

        return modifier;
    }

    public void setModifyDate(Date modifyDate) {

        this.modifyDate = modifyDate;
    }

    public Date getModifyDate() {

        return modifyDate;
    }

    public int getState() {

        return state;
    }

    public void setState(int state) {

        this.state = state;
    }

    public long getCarOwnerId() {

        return carOwnerId;
    }

    public void setCarOwnerId(long carOwnerId) {

        this.carOwnerId = carOwnerId;
    }

    public int getType() {

        return type;
    }

    public void setType(int type) {

        this.type = type;
    }

    public Map<String, Object> getReturnMap() {

        return returnMap;
    }

    public void setReturnMap(Map<String, Object> returnMap) {

        this.returnMap = returnMap;
    }

    public long getVehicleId() {

        return vehicleId;
    }

    public long getDriverId() {

        return driverId;
    }

    public void setVehicleId(long vehicleId) {

        this.vehicleId = vehicleId;
    }

    public void setDriverId(long driverId) {

        this.driverId = driverId;
    }

    
    public String getFormInstCode() {
    
        return formInstCode;
    }

    
    public void setFormInstCode(String formInstCode) {
    
        this.formInstCode = formInstCode;
    }
}
