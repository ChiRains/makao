package com.qcloud.project.macaovehicle.web.form;

import java.util.Date;

public class HistoryCarOwnerForm {

    // 身份证号码
    private String idcardNumber;

    // 居住地址
    private String address;

    // 户口所在地
    private String residence;

    // 身份证反面
    private String idcardBack;

    // 身份证正面
    private String idcardFace;

    private String birthday;

    // 电话
    private String mobile;

    // 邮箱
    private String email;

    // 名称
    private String name;

    // 证件类型（1护照 2：回乡证）
    private int    certificateType;

    // 证件号码
    private String certificateNo;

    // 其他证件有效期
    private Date   certificateDate;

    // 证件图片
    private String certificateUrl;

    // 性别(0,女；1，男)
    private int    sex;

    // 身份证有效期
    private String idCardValidTime;

    // 回乡证有效期
    private String hvpsValidTime;

    // 回乡证编号
    private String hvps;

    // 回乡证拍照
    private String hvpsImage;

    // 护照有效期
    private String passportValidTime;

    // 护照
    private String passport;

    // 护照图片
    private String passportImage;

    public void setIdcardNumber(String idcardNumber) {

        this.idcardNumber = idcardNumber;
    }

    public String getIdcardNumber() {

        return idcardNumber;
    }

    public void setAddress(String address) {

        this.address = address;
    }

    public String getAddress() {

        return address;
    }

    public void setResidence(String residence) {

        this.residence = residence;
    }

    public String getResidence() {

        return residence;
    }

    public void setIdcardBack(String idcardBack) {

        this.idcardBack = idcardBack;
    }

    public String getIdcardBack() {

        return idcardBack;
    }

    public void setIdcardFace(String idcardFace) {

        this.idcardFace = idcardFace;
    }

    public String getIdcardFace() {

        return idcardFace;
    }

    public void setBirthday(String birthday) {

        this.birthday = birthday;
    }

    public String getBirthday() {

        return birthday;
    }

    public void setMobile(String mobile) {

        this.mobile = mobile;
    }

    public String getMobile() {

        return mobile;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public String getEmail() {

        return email;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getName() {

        return name;
    }

    public void setCertificateType(int certificateType) {

        this.certificateType = certificateType;
    }

    public int getCertificateType() {

        return certificateType;
    }

    public void setCertificateNo(String certificateNo) {

        this.certificateNo = certificateNo;
    }

    public String getCertificateNo() {

        return certificateNo;
    }

    public void setCertificateDate(Date certificateDate) {

        this.certificateDate = certificateDate;
    }

    public Date getCertificateDate() {

        return certificateDate;
    }

    public void setCertificateUrl(String certificateUrl) {

        this.certificateUrl = certificateUrl;
    }

    public String getCertificateUrl() {

        return certificateUrl;
    }

    public void setSex(int sex) {

        this.sex = sex;
    }

    public int getSex() {

        return sex;
    }

    public void setIdCardValidTime(String idCardValidTime) {

        this.idCardValidTime = idCardValidTime;
    }

    public String getIdCardValidTime() {

        return idCardValidTime;
    }

    public void setHvpsValidTime(String hvpsValidTime) {

        this.hvpsValidTime = hvpsValidTime;
    }

    public String getHvpsValidTime() {

        return hvpsValidTime;
    }

    public void setHvps(String hvps) {

        this.hvps = hvps;
    }

    public String getHvps() {

        return hvps;
    }

    public void setHvpsImage(String hvpsImage) {

        this.hvpsImage = hvpsImage;
    }

    public String getHvpsImage() {

        return hvpsImage;
    }

    public void setPassportValidTime(String passportValidTime) {

        this.passportValidTime = passportValidTime;
    }

    public String getPassportValidTime() {

        return passportValidTime;
    }

    public void setPassport(String passport) {

        this.passport = passport;
    }

    public String getPassport() {

        return passport;
    }

    public void setPassportImage(String passportImage) {

        this.passportImage = passportImage;
    }

    public String getPassportImage() {

        return passportImage;
    }
}
