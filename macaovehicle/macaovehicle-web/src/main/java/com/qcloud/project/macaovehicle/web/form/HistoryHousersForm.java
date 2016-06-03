package com.qcloud.project.macaovehicle.web.form;

public class HistoryHousersForm {

    // 房屋性质
    private String property;

    // 规划用途
    private String application;

    // 共有情况
    private String situation;

    // 房屋编号
    private String code;

    // 登记时间
    private String time;

    // 房屋坐落
    private String located;

    // 房屋结构
    private String structure;

    // 层数
    private int    floor;

    // 建筑面积(㎡)
    private double buildArea;

    // 套内建筑面积(㎡)
    private double totalArea;

    // 房产证编号
    private String licenseNo;

    // 房产证图片
    private String licenseUrl;

    // 房屋所有权获取方式
    private String method;

    public String getMethod() {

        return method;
    }

    public void setMethod(String method) {

        this.method = method;
    }

    public void setProperty(String property) {

        this.property = property;
    }

    public String getProperty() {

        return property;
    }

    public void setApplication(String application) {

        this.application = application;
    }

    public String getApplication() {

        return application;
    }

    public void setSituation(String situation) {

        this.situation = situation;
    }

    public String getSituation() {

        return situation;
    }

    public void setCode(String code) {

        this.code = code;
    }

    public String getCode() {

        return code;
    }

    public void setTime(String time) {

        this.time = time;
    }

    public String getTime() {

        return time;
    }

    public void setLocated(String located) {

        this.located = located;
    }

    public String getLocated() {

        return located;
    }

    public void setStructure(String structure) {

        this.structure = structure;
    }

    public String getStructure() {

        return structure;
    }

    public void setFloor(int floor) {

        this.floor = floor;
    }

    public int getFloor() {

        return floor;
    }

    public void setBuildArea(double buildArea) {

        this.buildArea = buildArea;
    }

    public double getBuildArea() {

        return buildArea;
    }

    public void setTotalArea(double totalArea) {

        this.totalArea = totalArea;
    }

    public double getTotalArea() {

        return totalArea;
    }

    public void setLicenseNo(String licenseNo) {

        this.licenseNo = licenseNo;
    }

    public String getLicenseNo() {

        return licenseNo;
    }

    public void setLicenseUrl(String licenseUrl) {

        this.licenseUrl = licenseUrl;
    }

    public String getLicenseUrl() {

        return licenseUrl;
    }
}
