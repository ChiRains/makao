package com.qcloud.project.macaovehicle.web.vo.admin;

import java.util.Date;
import java.math.BigDecimal;

public class AdminCarOwnerWorkersVO {

    private long   id;

    // 车主ID
    private long   carOwnerId;

    // 单位名称
    private String company;

    // 单位电话
    private String fixedLine;

    // 单位地址
    private String address;

    // 联系电话
    private String phone;

    // 联系人
    private String consignee;

    // 职务
    private String position;

    // 工作证明（图片）
    private String workCertificate;

    private String code;

    private String time;

    private String entryTime;

    public AdminCarOwnerWorkersVO() {

    }

    public AdminCarOwnerWorkersVO(long id, long carOwnerId, String company, String fixedLine, String address, String phone, String consignee, String position, String workCertificate) {

        this.id = id;
        this.carOwnerId = carOwnerId;
        this.company = company;
        this.fixedLine = fixedLine;
        this.address = address;
        this.phone = phone;
        this.consignee = consignee;
        this.position = position;
        this.workCertificate = workCertificate;
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

    public void setCompany(String company) {

        this.company = company;
    }

    public String getCompany() {

        return company;
    }

    public void setFixedLine(String fixedLine) {

        this.fixedLine = fixedLine;
    }

    public String getFixedLine() {

        return fixedLine;
    }

    public void setAddress(String address) {

        this.address = address;
    }

    public String getAddress() {

        return address;
    }

    public void setPhone(String phone) {

        this.phone = phone;
    }

    public String getPhone() {

        return phone;
    }

    public void setConsignee(String consignee) {

        this.consignee = consignee;
    }

    public String getConsignee() {

        return consignee;
    }

    public void setPosition(String position) {

        this.position = position;
    }

    public String getPosition() {

        return position;
    }

    public void setWorkCertificate(String workCertificate) {

        this.workCertificate = workCertificate;
    }

    public String getWorkCertificate() {

        return workCertificate;
    }

    public String getCode() {

        return code;
    }

    public void setCode(String code) {

        this.code = code;
    }

    
    public String getTime() {
    
        return time;
    }

    
    public void setTime(String time) {
    
        this.time = time;
    }

    
    public String getEntryTime() {
    
        return entryTime;
    }

    
    public void setEntryTime(String entryTime) {
    
        this.entryTime = entryTime;
    }
}
