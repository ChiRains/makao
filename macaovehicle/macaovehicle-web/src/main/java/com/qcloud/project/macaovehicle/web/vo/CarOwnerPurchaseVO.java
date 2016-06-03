package com.qcloud.project.macaovehicle.web.vo;

import java.util.Date;
import java.math.BigDecimal;

public class CarOwnerPurchaseVO {

    private long   id;

    private long   carOwnerId;

    // 公司名称
    private String company;

    // 公司代码
    private String code;

    // 经营范围
    private String operate;

    // 企业规模
    private String scale;

    // 法人代表
    private String represent;

    // 联系电话
    private String phone;

    // 地址
    private String address;

    // 成立时间
    private String   time;

    // 营业执照(图片)
    private String license;

    private String licenseUid;

    private String tax;

    private String letter;

    private String contract;

    public CarOwnerPurchaseVO() {

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

    public void setCode(String code) {

        this.code = code;
    }

    public String getCode() {

        return code;
    }

    public void setOperate(String operate) {

        this.operate = operate;
    }

    public String getOperate() {

        return operate;
    }

    public void setScale(String scale) {

        this.scale = scale;
    }

    public String getScale() {

        return scale;
    }

    public void setRepresent(String represent) {

        this.represent = represent;
    }

    public String getRepresent() {

        return represent;
    }

    public void setPhone(String phone) {

        this.phone = phone;
    }

    public String getPhone() {

        return phone;
    }

    public void setAddress(String address) {

        this.address = address;
    }

    public String getAddress() {

        return address;
    }

    public void setLicense(String license) {

        this.license = license;
    }

    public String getLicense() {

        return license;
    }

    public void setTax(String tax) {

        this.tax = tax;
    }

    public String getTax() {

        return tax;
    }

    public void setLetter(String letter) {

        this.letter = letter;
    }

    public String getLetter() {

        return letter;
    }

    public void setContract(String contract) {

        this.contract = contract;
    }

    public String getContract() {

        return contract;
    }

    public String getLicenseUid() {

        return licenseUid;
    }

    public void setLicenseUid(String licenseUid) {

        this.licenseUid = licenseUid;
    }

    
    public String getTime() {
    
        return time;
    }

    
    public void setTime(String time) {
    
        this.time = time;
    }
}
